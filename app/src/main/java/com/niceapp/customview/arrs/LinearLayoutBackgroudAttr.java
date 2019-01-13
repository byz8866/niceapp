package com.niceapp.customview.arrs;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class LinearLayoutBackgroudAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof LinearLayout) {
            Drawable drawable = null;
            if ("background".equals(attrName)) {
                //使用SkinResourcesUtils设置资源
                drawable = SkinResourcesUtils.getDrawable(attrValueRefId);
                view.setBackground(drawable);
            }
        }
    }
}