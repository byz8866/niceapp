package com.niceapp.view.user.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.niceapp.BuildConfig;
import com.niceapp.R;
import com.niceapp.base.BaseActivity;
import com.niceapp.main.activity.SplashActivity;
import com.niceapp.main.adapter.ViewPagerAdatper;
import com.niceapp.utils.RxCountDown;
import com.niceapp.utils.ToastUtils;
import com.niceapp.view.user.manager.AccountManager;
import com.cheddd.nqd.base.actionbar.ActionBarStyle;
import com.youth.banner.transformer.DepthPageTransformer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class GuideActivity extends BaseActivity {
    private ViewPager mIn_vp;
    private LinearLayout mIn_ll;
    private List<View> mViewList;
    private ImageView mLight_dots;
    private int mDistance;
    private ImageView mOne_dot;
    private ImageView mTwo_dot;
    private ImageView mThree_dot;
    private Button btnExperience, btnLogin;
    private LinearLayout llGuide;
    private RelativeLayout rlDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        SharedPreferences sp2 = getSharedPreferences("coinplay-guide2", MODE_PRIVATE);
        String update = sp2.getString(String.valueOf(BuildConfig.VERSION_CODE), null);
        if (TextUtils.isEmpty(update)) {
            //避免更新后弹出别处登录问题
            AccountManager.INSTANCE.logout();
            SharedPreferences.Editor editor2 = sp2.edit();
            editor2.putString(String.valueOf(BuildConfig.VERSION_CODE), String.valueOf(BuildConfig.VERSION_CODE));
            editor2.apply();

        }


        //大的版本变化时启动引导页
        SharedPreferences sp = getSharedPreferences("coinplay-guide", MODE_PRIVATE);
        String once = sp.getString(String.valueOf(BuildConfig.VERSION_CODE / 100), null);
        if (TextUtils.isEmpty(once)) {
            initView();
            initData();
            mIn_vp.setAdapter(new ViewPagerAdatper(mViewList));
            addDots();
            moveDots();
            mIn_vp.setPageTransformer(true, new DepthPageTransformer());

            SharedPreferences.Editor editor = sp.edit();
            editor.putString(String.valueOf(BuildConfig.VERSION_CODE / 100), String.valueOf(BuildConfig.VERSION_CODE / 100));
            editor.apply();

        } else {
            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void moveDots() {
        mLight_dots.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //获得两个圆点之间的距离
                mDistance = mIn_ll.getChildAt(1).getLeft() - mIn_ll.getChildAt(0).getLeft();
                mLight_dots.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
            }
        });
        mIn_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //页面滚动时小白点移动的距离，并通过setLayoutParams(params)不断更新其位置
                float leftMargin = mDistance * (position + positionOffset);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
                if (position == 2) {
                    llGuide.setVisibility(View.VISIBLE);
                    rlDot.setVisibility(View.GONE);

                }
                if (position != 2 && btnExperience.getVisibility() == View.VISIBLE) {
                    llGuide.setVisibility(View.GONE);
                    rlDot.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {
                //页面跳转时，设置小圆点的margin
                float leftMargin = mDistance * position;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mLight_dots.getLayoutParams();
                params.leftMargin = (int) leftMargin;
                mLight_dots.setLayoutParams(params);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addDots() {
        mOne_dot = new ImageView(this);
        mOne_dot.setImageResource(R.drawable.dot_gray);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 40, 0);
        mIn_ll.addView(mOne_dot, layoutParams);
        mTwo_dot = new ImageView(this);
        mTwo_dot.setImageResource(R.drawable.dot_gray);
        mIn_ll.addView(mTwo_dot, layoutParams);
        mThree_dot = new ImageView(this);
        mThree_dot.setImageResource(R.drawable.dot_gray);
        mIn_ll.addView(mThree_dot, layoutParams);
        setClickListener();

    }

    private void setClickListener() {
        mOne_dot.setOnClickListener(view -> mIn_vp.setCurrentItem(0));
        mTwo_dot.setOnClickListener(view -> mIn_vp.setCurrentItem(1));
        mThree_dot.setOnClickListener(view -> mIn_vp.setCurrentItem(2));
    }

    private void initData() {
        mViewList = new ArrayList<View>();
        LayoutInflater lf = getLayoutInflater().from(GuideActivity.this);
        View view1 = lf.inflate(R.layout.we_indicator1, null);
        View view2 = lf.inflate(R.layout.we_indicator2, null);
        View view3 = lf.inflate(R.layout.we_indicator3, null);
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
    }

    private void initView() {
        mIn_vp = findViewById(R.id.in_viewpager);
        mIn_ll = findViewById(R.id.in_ll);
        mLight_dots = findViewById(R.id.iv_light_dots);
        btnExperience = findViewById(R.id.btn_experience);
        btnLogin = findViewById(R.id.btn_login);
        llGuide = findViewById(R.id.ll_guide);
        rlDot = findViewById(R.id.rl_dots);
        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(GuideActivity.this, SplashActivity.class);
            startActivity(intent);
            finish();
        });
        btnExperience.setOnClickListener(view -> {
            Intent intent = new Intent(GuideActivity.this, SplashActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @NotNull
    @Override
    public ActionBarStyle setActionBarStyle() {
        return ActionBarStyle.NONE;
    }
}
