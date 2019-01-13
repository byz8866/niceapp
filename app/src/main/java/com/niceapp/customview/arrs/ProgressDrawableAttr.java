package com.niceapp.customview.arrs;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class ProgressDrawableAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof ProgressBar) {
            Drawable drawable = null;
            if ("progressDrawable".equals(attrName)) {
                //使用SkinResourcesUtils设置资源
                drawable = SkinResourcesUtils.getDrawable(attrValueRefId);
                ((ProgressBar) view).setProgressDrawable(drawable);
            }
        }
    }

}