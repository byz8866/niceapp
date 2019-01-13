package com.niceapp.main.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {


    List<Fragment> fragments;

    public FragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (fragments == null)
            return 0;
        return fragments.size();
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
