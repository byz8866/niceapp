package com.niceapp.utils;

import android.content.Context;
import android.content.res.Resources;

import com.niceapp.R;

/**
 * Created by BrainWang on 05/01/2016.
 * 过滤广告
 */
public class ADFilterTool {
    public static boolean hasAd(Context context, String url) {
        Resources res = context.getResources();
        String[] adUrls = res.getStringArray(R.array.adBlockUrl);
        for (String adUrl : adUrls) {
            if (url.contains(adUrl)) {
                return true;
            }
        }
        return false;
    }
}