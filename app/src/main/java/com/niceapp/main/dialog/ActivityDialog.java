package com.niceapp.main.dialog;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.niceapp.R;
import com.niceapp.view.pop.PopMgr;


public class ActivityDialog extends DialogFragment implements View.OnClickListener {
    String url = "";
    com.tencent.smtt.sdk.WebView webView;
    ImageView imageClose;


    public ActivityDialog() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置dialog进出动画
        getDialog().getWindow().setWindowAnimations(R.style.animate_dialog);

        View view = inflater.inflate(R.layout.dialog_base, container, false);


        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
        PopMgr.getInstance().nextTask();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
