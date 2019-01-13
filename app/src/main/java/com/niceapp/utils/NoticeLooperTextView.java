package com.niceapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.niceapp.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class NoticeLooperTextView extends FrameLayout implements View.OnClickListener {
    private List<String> tipList;
    private int curTipIndex = 0;
    private long lastTimeMillis;
    private static final int ANIM_DELAYED_MILLIONS = 3 * 1000;
    /**
     * 动画持续时长
     */
    private static final int ANIM_DURATION = 1 * 1000;
    //  private static final String DEFAULT_TEXT_COLOR = "#2F4F4F";
    private static final int DEFAULT_TEXT_SIZE = 14;
    private TextView tv_tip_out, tv_tip_in;
    private static final String TIP_PREFIX = "";
    private Animation anim_out, anim_in;
    private Integer textColor = R.color.color_a4d4fd;


    public void setTextColor(Integer textColor) {
        this.textColor = textColor;

        //先关动画，默认颜色的公告不会出现
        tv_tip_in.clearAnimation();
        tv_tip_out.clearAnimation();

        removeView(tv_tip_out);
        removeView(tv_tip_in);

        //替换之后显示
        tv_tip_out = newTextView();
        tv_tip_in = newTextView();

        addView(tv_tip_in);
        addView(tv_tip_out);

        tv_tip_out.startAnimation(anim_out);
        tv_tip_in.startAnimation(anim_in);
        setOnClickListener(this);
    }

    public NoticeLooperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTipFrame();
        initAnimation();
    }

    public NoticeLooperTextView(Context context) {
        this(context, null);
    }

    private void initTipFrame() {
        tv_tip_out = newTextView();
        tv_tip_in = newTextView();
        addView(tv_tip_in);
        addView(tv_tip_out);
        setOnClickListener(this);

    }

    private TextView newTextView() {
        TextView textView = new TextView(getContext());
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL);
        textView.setLayoutParams(lp);
        textView.setCompoundDrawablePadding(10);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(getResources().getColor(textColor));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, DEFAULT_TEXT_SIZE);
        return textView;
    }

    private void initAnimation() {
        anim_out = newAnimation(0, -1);
        anim_in = newAnimation(1, 0);
        anim_in.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                updateTipAndPlayAnimationWithCheck();
            }
        });
        anim_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private Animation newAnimation(float fromYValue, float toYValue) {
        Animation anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, fromYValue, Animation.RELATIVE_TO_SELF, toYValue);
        anim.setDuration(ANIM_DURATION);
        anim.setStartOffset(ANIM_DELAYED_MILLIONS);
        anim.setInterpolator(new DecelerateInterpolator());
        return anim;
    }

    private void updateTipAndPlayAnimationWithCheck() {
        if (System.currentTimeMillis() - lastTimeMillis < 1000) {
            return;
        }
        lastTimeMillis = System.currentTimeMillis();
        updateTipAndPlayAnimation();
    }

    private void updateTipAndPlayAnimation() {
        if (curTipIndex % 2 == 0) {
            updateTip(tv_tip_out);
            tv_tip_in.startAnimation(anim_out);
            tv_tip_out.startAnimation(anim_in);
            this.bringChildToFront(tv_tip_in);
        } else {
            updateTip(tv_tip_in);
            tv_tip_out.startAnimation(anim_out);
            tv_tip_in.startAnimation(anim_in);
            this.bringChildToFront(tv_tip_out);
        }
    }

    private void updateTip(TextView tipView) {
        String tip = getNextTip();
        if (!TextUtils.isEmpty(tip)) {
            tipView.setText(Html.fromHtml(tip + TIP_PREFIX));
        }
    }

    /**
     * 获取下一条消息
     *
     * @return
     */
    private String getNextTip() {
        if (isListEmpty(tipList)) return null;
        return tipList.get(curTipIndex++ % tipList.size());
    }

    public static boolean isListEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public void setTipList(@NonNull List<String> tipList) {
        this.tipList = tipList;
        curTipIndex = 0;
        updateTip(tv_tip_out);
        updateTipAndPlayAnimation();
        //curTipIndex到这里已经是2了
    }

    public int getCurrentIndex() {
        if (curTipIndex >= 2) {
            return (curTipIndex - 2) % tipList.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null && tipList != null && tipList.size() > 0) {
            mListener.onItemClick(tipList.get(getCurrentIndex()), getCurrentIndex());
        }
    }

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(String title, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }
}
