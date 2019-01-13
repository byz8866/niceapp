package com.niceapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.niceapp.BuildConfig;

/**
 * 设备相关 （系统版本号  手机屏幕 版本号）
 */
public class Device {
    private static boolean sInitialed;
    private static Context mContext;
    private static DisplayMetrics DISPLAYMETRICS = Resources.getSystem().getDisplayMetrics();
    private static RuntimeException exception = new RuntimeException("Context is null , pulese call Kits onCreate() in application onCreate()");

    private Device() {
    }


    public static void init(Context context) {
        if (sInitialed || context == null) {
            throw new IllegalArgumentException("context not allow null");
        }
        mContext = context;
        sInitialed = true;
    }


    /**
     * 屏幕高度
     *
     * @return px
     */
    public static int getScreenHeight() {
        return DISPLAYMETRICS.heightPixels;
    }

    /**
     * 屏幕宽度
     *
     * @return px
     */
    public static int getScreenWidth() {
        return DISPLAYMETRICS.widthPixels;
    }

    /**
     * dp to px
     *
     * @param dp dip
     * @return int
     */
    public static int dip2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

    /**
     * px to dip
     *
     * @param px px
     * @return float
     */
    public static float px2dip(int px) {
        return (px / DISPLAYMETRICS.density + 0.5f);
    }

    private static void checkIns() {
        if (mContext == null) {
            throw exception;
        }
    }

    // ViVo 手机无法获取
    private static PackageInfo getPackageInfo(int flag) {
        checkIns();
        PackageManager packageManager = mContext.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(mContext.getPackageName(), flag);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }

    /**
     * 得到 app 版本 号
     *
     * @return
     */
    public static int getAppVersionCode() {


        return BuildConfig.VERSION_CODE;
    }

    /**
     * app 版本 名字
     *
     * @return
     */
    public static String getAppVersionName() {


        return BuildConfig.VERSION_NAME;
    }

    /**
     * 系统版本名称
     *
     * @return
     */
    public static String getOsVersionName() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 系统版本号
     *
     * @return
     */
    public static int getOsVersionCode() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获得 设备 ID
     *
     * @return
     */
    public static String getAndroidId() {
        checkIns();
        String id = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
        return id;
    }

    /**
     * 设备 品牌
     *
     * @return
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;// 手机品牌
    }

    /**
     * 设备 型号
     *
     * @return
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 设备imei
     *
     * @return
     */
    public static String getIMEI() {
        checkIns();
        @SuppressLint("MissingPermission") String str = ((TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        return str;
    }

    /**
     * 设备 mac
     * request android.permission.ACCESS_WIFI_STATE
     *
     * @return
     */
    public static String getMac() {
        checkIns();
        WifiManager wifi = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        return info.getMacAddress().replaceAll(":", "");//MAC 地址
    }


    /**
     * 获取app metadata
     *
     * @return
     */
    public static Bundle getAppMetaData() {

        ApplicationInfo appInfo = null;
        try {
            appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        return appInfo != null ? appInfo.metaData : null;
    }

    public static boolean issInitialed() {
        return sInitialed;
    }

    public static void setsInitialed(boolean ss) {
        Device.sInitialed = ss;
    }
}
