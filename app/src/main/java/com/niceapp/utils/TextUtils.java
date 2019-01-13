package com.niceapp.utils;

import android.graphics.Paint;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class TextUtils {

    /**
     * 隐藏邮箱名
     */
    public static String hideEmail(String str) {
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int a = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (i < 2) {
                    stringBuffer.append(c);
                } else if (c != '@' && c != '.') {
                    if (a == 1) {
                        stringBuffer.append(c);
                    }
                    continue;
                } else if (c == '@') {
                    stringBuffer.append("***" + c);
                } else if (c == '.') {
                    stringBuffer.append("***.");
                    a = 1;
                }
            }
            return stringBuffer.toString();
        } else {
            return "";
        }
    }

    /**
     * TextView 换行缩进
     */

    public static void indentLine(TextView textView) {
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                final String newText = autoSplitText(textView, "1. ");
                if (!android.text.TextUtils.isEmpty(newText)) {
                    textView.setText(newText);
                }
            }
        });
    }

    /**
     * 文本在indent 之后的字符对齐
     * * 此方法必须在view绘制完成后调用才生效
     * * getViewTreeObserver().addOnGlobalLayoutListener()
     * *
     * * @param tv TextView控件
     * * @param indent 标题,如 1.  或  一.
     * * @return 新的带换行的字符串
     */
    public static String autoSplitText(final TextView tv, final String indent) {
        final String rawText = tv.getText().toString(); //原始文本
        final Paint tvPaint = tv.getPaint(); //paint，包含字体等信息
        final float tvWidth = tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight(); //控件可用宽度
//        将缩进处理成空格
        String indentSpace = "";
        float indentWidth = 0;
        if (!android.text.TextUtils.isEmpty(indent)) {
            float rawIndentWidth = tvPaint.measureText(indent);
            if (rawIndentWidth < tvWidth) {
                while ((indentWidth = tvPaint.measureText(indentSpace)) < rawIndentWidth) {
                    indentSpace += " ";
                }
            }
        }
//        将原始文本按行拆分
        String[] rawTextLines = rawText.replaceAll("\r", "").split("\n");
        StringBuilder sbNewText = new StringBuilder();
        for (String rawTextLine : rawTextLines) {
            if (tvPaint.measureText(rawTextLine) <= tvWidth) {
//                如果整行宽度在控件可用宽度之内，就不处理了
                sbNewText.append(rawTextLine);
            } else {
//                如果整行宽度超过控件可用宽度，则按字符测量，在超过可用宽度的前一个字符处手动换行
                char[] splitWord = rawTextLine.toCharArray();
                float lineWidth = 0;
                for (int cnt = 0; cnt != splitWord.length; ++cnt) {
                    char ch = splitWord[cnt];
//                    从手动换行的第二行开始，加上悬挂缩进
                    if (lineWidth < 0.1f && cnt != 0) {
                        sbNewText.append(indentSpace);
                        lineWidth += indentWidth;
                    }
                    lineWidth += tvPaint.measureText(String.valueOf(ch));
                    if (lineWidth <= tvWidth) {
                        sbNewText.append(ch);
                    } else {
                        sbNewText.append("\n");
                        lineWidth = 0;
                        --cnt;
                    }
                }
            }
            sbNewText.append("\n");
        }
//        把结尾多余的\n去掉
        if (!rawText.endsWith("\n")) {
            sbNewText.deleteCharAt(sbNewText.length() - 1);
        }
        return sbNewText.toString();
    }
}
