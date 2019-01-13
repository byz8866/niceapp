package com.niceapp.base;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.niceapp.AppValue;
import com.niceapp.BuildConfig;
import com.niceapp.R;
import com.niceapp.utils.RxCountDown;

import rx.Subscriber;

/**
 * Created by mateng on 2017/7/14.
 * 网络加载进度弹窗
 */

public class ProgressDialog extends DialogFragment {

    private static final int CONNECT_TIME_OUT = AppValue.CONNECT_TIME_OUT;

    private OnCancelListener onCancelListener;

    private Subscriber<Integer> subscriber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        FrameLayout layout = new FrameLayout(getContext());
        layout.setPadding(0, 0, 0, 500);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.mipmap.ic_net_progress);
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360);
        animator.setDuration(500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.start();
        layout.addView(imageView);

        return layout;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.onCancelListener = onCancelListener;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (onCancelListener != null) {
            onCancelListener.onCancel();
        }
    }

    public interface OnCancelListener {
        void onCancel();
    }


    @Override
    public void show(FragmentManager manager, String tag) {
        if (manager.findFragmentByTag(tag) == this) {
            return;
        }
        subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                dismissAllowingStateLoss();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                if (BuildConfig.DEBUG) Log.d("ProgressDialog", ("自动取消倒计时：" + integer));

                if (integer == 0) {
                    Toast.makeText(getContext(), "网络连接超时", Toast.LENGTH_SHORT).show();
                }
            }
        };

        RxCountDown.INSTANCE.countdown(CONNECT_TIME_OUT).subscribe(subscriber);
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }
    }

    @Override
    public void dismiss() {
        dismissAllowingStateLoss();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(getView(), "alpha", 1f, 0f);
//        animator.setDuration(500);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.start();
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                if (getDialog() == null)
//                    return;
//                WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
//                lp.dimAmount = (float) animation.getAnimatedValue();
//                getDialog().getWindow().setAttributes(lp);
//            }
//        });
//
//
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//                dismissAllowingStateLoss();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
    }
}
