package com.niceapp.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class ImageView_jian extends android.support.v7.widget.AppCompatImageView {
    public ImageView_jian(Context context) {
        super(context);
    }

    public ImageView_jian(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageView_jian(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
