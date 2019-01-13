package com.niceapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    public static int YEAR = 0;
    public static int MONTH = 1;
    public static int DAY = 2;
    public static int HOUR = 3;
    public static int MINUTE = 4;
    public static int SECEND = 5;

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }


    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 单独获取年月日时分秒
     */
    public static String getYmd_hms(int i, boolean is24Hour) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        String result = "";
        if (i == YEAR) {
            result = String.valueOf(cal.get(Calendar.YEAR));
        } else if (i == MONTH) {
            result = String.valueOf(cal.get(Calendar.MONTH)) + 1;
        } else if (i == DAY) {
            result = String.valueOf(cal.get(Calendar.DATE));
        } else if (i == HOUR) {
            if (is24Hour) {
                result = String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
            } else {
                result = String.valueOf(cal.get(Calendar.HOUR));
            }
        } else if (i == MINUTE) {
            result = String.valueOf(cal.get(Calendar.MINUTE));
        } else if (i == SECEND) {
            result = String.valueOf(cal.get(Calendar.SECOND));
        }
        return result;
    }
}

