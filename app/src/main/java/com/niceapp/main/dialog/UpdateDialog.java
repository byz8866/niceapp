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
import android.widget.TextView;
import android.widget.Toast;

import com.niceapp.R;
import com.niceapp.view.pop.PopMgr;
import com.niceapp.view.pop.model.UpgradeModel;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;

public class UpdateDialog extends DialogFragment implements View.OnClickListener {
    TextView tvCancel, tvUpdate, tvVersion, tvInfo;
    View viewLine;

    public UpdateDialog() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view = inflater.inflate(R.layout.dialog_update, container, false);
        tvCancel = view.findViewById(R.id.tv_update_cancel);
        tvUpdate = view.findViewById(R.id.tv_update_ok);
        tvVersion = view.findViewById(R.id.tv_update_version);
        tvInfo = view.findViewById(R.id.tv_update_info);
        viewLine = view.findViewById(R.id.view_update);

        Bundle bundle = getArguments();
        if (bundle != null) {
            UpgradeModel upgradeModel = (UpgradeModel) bundle.getSerializable("update");
            if (upgradeModel != null) {
                if (upgradeModel.isForceUpgrade()) {
                    tvCancel.setVisibility(View.GONE);
                    viewLine.setVisibility(View.GONE);
                } else {
                    tvCancel.setVisibility(View.VISIBLE);
                    viewLine.setVisibility(View.VISIBLE);
                }
                tvVersion.setText(getResources().getString(R.string.newVersion) + upgradeModel.getVersionName());
                tvInfo.setText(upgradeModel.getUpgradeContent());
            }

        }
        tvCancel.setOnClickListener(view1 -> {
            PopMgr.getInstance().removeTask(PopMgr.POP_UPGRADE);
            dismissAllowingStateLoss();
        });
        tvUpdate.setOnClickListener(view12 -> {
            DownloadTask task = Beta.startDownload();
            updateBtn(task);
//            if (task.getStatus() == DownloadTask.DOWNLOADING) {
//                dismissAllowingStateLoss();
//            }
            PopMgr.getInstance().removeTask(PopMgr.POP_UPGRADE);
        });
        /*注册下载监听，监听下载事件*/
        Beta.registerDownloadListener(mDownloadListener);
        return view;
    }

    @Override
    public void dismissAllowingStateLoss() {
        super.dismissAllowingStateLoss();
        PopMgr.getInstance().nextTask();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Beta.unregisterDownloadListener();

    }

    @SuppressLint("SetTextI18n")
    public void updateBtn(DownloadTask task) {
        /*根据下载任务状态设置按钮*/
        switch (task.getStatus()) {
            case DownloadTask.DELETED: {
                Toast.makeText(getContext(), R.string.installation_package_deleted, Toast.LENGTH_SHORT).show();
            }
            case DownloadTask.INIT:
                break;
            case DownloadTask.FAILED: {
                tvUpdate.setText(getResources().getString(R.string.upgradeNow));
            }
            break;
            case DownloadTask.COMPLETE: {
                tvUpdate.setText(getResources().getString(R.string.install));
            }
            break;
            case DownloadTask.DOWNLOADING: {
                if (task.getTotalLength() > 0) {
                    float savedLength = task.getSavedLength();
                    float totalLength = task.getTotalLength();
                    tvUpdate.setText(getResources().getString(R.string.downloading)
                            + (int) ((savedLength / totalLength) * 100)
                            + "%");
                }
            }
            break;
        }
    }

    DownloadListener mDownloadListener = new DownloadListener() {
        @Override
        public void onReceive(DownloadTask task) {
            updateBtn(task);
        }

        @Override
        public void onCompleted(DownloadTask task) {
            tvUpdate.setEnabled(true);
            updateBtn(task);
        }

        @Override
        public void onFailed(DownloadTask task, int code, String extMsg) {
            Toast.makeText(getContext(), R.string.upgradeFail, Toast.LENGTH_SHORT).show();
            tvUpdate.setEnabled(true);
            updateBtn(task);
        }
    };
}
