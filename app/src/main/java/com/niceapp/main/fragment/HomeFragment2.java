package com.niceapp.main.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.niceapp.R;
import com.niceapp.base.BaseFragment;
import com.niceapp.base.actionbar.ActionBar;
import com.cheddd.nqd.base.actionbar.ActionBarStyle;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HomeFragment2 extends BaseFragment {


    public HomeFragment2() {
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onCreated(@Nullable Bundle savedInstanceState) {
        super.onCreated(savedInstanceState);
        setContentView(R.layout.fragment_home);

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @NotNull
    @Override
    public ActionBarStyle setActionBarStyle() {
        setTitle("CoinPlay");
        return ActionBarStyle.GENERIC_BAR_NOT_DIVIDING;
    }

    @NotNull
    @Override
    public ActionBar setActionBar(@NotNull ActionBarStyle style) {
        ActionBar actionBar = super.setActionBar(style);
        return actionBar;
    }
}
