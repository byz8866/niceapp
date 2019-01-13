package com.niceapp.view.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.niceapp.R;
import com.niceapp.base.ProgressDialog;
import com.niceapp.model.request.ConnectRequest;
import com.niceapp.model.result.ConnectResult;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BaseDialog extends DialogFragment {

    private LinearLayout linearLayout;
    private View tvReconnect;
    private ProgressDialog progressDialog;
    private TextView tvTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

        EventBus.getDefault().register(this);

        progressDialog = new ProgressDialog();
        progressDialog.setCancelable(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.dialog_socket_disconnect, container, false);
        tvReconnect = view.findViewById(R.id.tv_reconnect);
        linearLayout = view.findViewById(R.id.ll_content);
        tvTitle = view.findViewById(R.id.tv_title);
        tvReconnect.setOnClickListener(v -> {
            progressDialog.show(getFragmentManager(), "PROGRESS");
            EventBus.getDefault().post(new ConnectRequest());
        });

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.dialog_enter);
        linearLayout.startAnimation(animation);
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receivedEvent(ConnectResult result) {

        progressDialog.dismissAllowingStateLoss();

        if (result.isSuccess()) {
            dismissAllowingStateLoss();
        } else {
            tvTitle.setText(result.getMessage());
        }
    }

    @Override
    public void onDestroyView() {
        linearLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.dialog_exit));
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
