package com.niceapp.customview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;


/**
 * drawableTop与文本一起居中显示
 * <p>
 * com.yjg.myapplication2.widget.DrawableCenterTextView
 */

public class DrawableCenterTextView extends android.support.v7.widget.AppCompatTextView {


    public DrawableCenterTextView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);

    }


    public DrawableCenterTextView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }


    public DrawableCenterTextView(Context context) {

        super(context);

    }


    @Override

    protected void onDraw(Canvas canvas) {

        Drawable[] drawables = getCompoundDrawables();

        if (drawables != null) {

            Drawable drawableTop = drawables[1];

            for (int i = 0; i < drawables.length; i++) {

                Drawable drawable = drawables[i];

                if (drawable != null) {

                    if (i == 0 || i == 3) {

                        //drawableLeft or drawableRight with singline text four word ()

//                        float textWidth = getPaint().measureText(getText().toString());

                        float textWidth = getPaint().measureText("正正正正");

                        int drawablePadding = getCompoundDrawablePadding();

                        int drawableWidth = 0;

                        drawableWidth = drawable.getIntrinsicWidth();

                        float bodyWidth = textWidth + drawableWidth + drawablePadding;

                        canvas.translate((getWidth() - bodyWidth) / 2, 0);

                    } else if (i == 1 || i == 4) {

                        //drawableTop or drawableBottom

                        float textHeight = getPaint().measureText("正");

                        int drawablePadding = getCompoundDrawablePadding();

                        int drawableHeight = drawableTop.getIntrinsicHeight();

                        float bodyWidth = textHeight + drawableHeight + drawablePadding;

                        canvas.translate(0, (getHeight() - bodyWidth) / 2);

                    }

                }

            }

        }

        super.onDraw(canvas);

    }

}