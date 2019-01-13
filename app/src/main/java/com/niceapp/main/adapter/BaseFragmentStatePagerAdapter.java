package com.niceapp.main.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

public class BaseFragmentStatePagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
    List<Fragment> fragments;
    FragmentManager fm;

    public BaseFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fm = fm;
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

    /**
     * 页面宽度所占ViewPager测量宽度的权重比例，默认为1
     */

    @Override
    public float getPageWidth(int position) {
        //占屏幕宽度比例
        float w = 0.48f;
        if (fragments.size() == 2) {
            w = 0.5f;
        }
        return w;
    }
}
