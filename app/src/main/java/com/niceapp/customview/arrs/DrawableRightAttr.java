package com.niceapp.customview.arrs;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class DrawableRightAttr extends SkinAttr {
    @Override
    public void apply(View view) {
        if (view instanceof TextView) {
            Drawable drawable = null;
            if ("drawableRight".equals(attrName)) {
                //使用SkinResourcesUtils设置资源
                drawable = SkinResourcesUtils.getDrawable(attrValueRefId);
                //调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((TextView) view).setCompoundDrawables(null, null, drawable, null); //设置右侧图标
            }
        }
    }

}