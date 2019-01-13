package com.niceapp;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.niceapp.customview.arrs.DrawableLeftAttr;
import com.niceapp.customview.arrs.DrawableRightAttr;
import com.niceapp.customview.arrs.DrawableTopAttr;
import com.niceapp.customview.arrs.LinearLayoutBackgroudAttr;
import com.niceapp.customview.arrs.ProgressDrawableAttr;
import com.niceapp.utils.Device;
import com.niceapp.view.pop.PopMgr;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import solid.ren.skinlibrary.SkinConfig;
import solid.ren.skinlibrary.base.SkinBaseApplication;

import static com.niceapp.AppValue.BUGLY_APP_ID;
import static com.niceapp.AppValue.QQ_APP_KEY;
import static com.niceapp.AppValue.WEIXIN_APP_ID;
import static com.niceapp.AppValue.WEIXIN_APP_SECRET;

public class BaseApp extends SkinBaseApplication {
    private static BaseApp app;
    private static String mydeviceToken;
    public static PushAgent mPushAgent;

    public static PushAgent getmPushAgent() {
        return mPushAgent;
    }

    public String getMydeviceToken() {
        return mydeviceToken;
    }

    public void setMydeviceToken(String mydeviceToken) {
        BaseApp.mydeviceToken = mydeviceToken;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        SkinConfig.enableGlobalSkinApply();
        //切换皮肤添加自定义更换属性
        SkinConfig.addSupportAttr("drawableTop", new DrawableTopAttr());
        SkinConfig.addSupportAttr("drawableRight", new DrawableRightAttr());
        SkinConfig.addSupportAttr("drawableLeft", new DrawableLeftAttr());
        SkinConfig.addSupportAttr("background", new LinearLayoutBackgroudAttr());
        SkinConfig.addSupportAttr("progressDrawable", new ProgressDrawableAttr());
        //跟上面LinearLayout 设置的冲突了
//        SkinConfig.addSupportAttr("background", new TextBackGroundAttr());

        Fresco.initialize(this);
        app = this;
        //腾讯X5
        initTbs();
        //获取手机相关信息
        Device.init(this);
        // 扫描
        ZXingLibrary.initDisplayOpinion(this);
        //友盟
        UMConfigure.setLogEnabled(true);
        UMConfigure.init(this, AppValue.UM_APP_KEY, "umeng", UMConfigure.DEVICE_TYPE_PHONE, AppValue.UM_MESSAGE_SECRET);
        PlatformConfig.setWeixin(WEIXIN_APP_ID, WEIXIN_APP_SECRET);
        PlatformConfig.setQQZone(AppValue.QQ_APP_ID, QQ_APP_KEY);

        //注册推送服务，每次调用register方法都会回调该接口\
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("deviceToken", "onCreate: " + deviceToken);
                mydeviceToken = deviceToken;
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });

        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);


        //bugly升級
        initBugly();

    }

    private void initBugly() {
        //自动初始化
        Beta.autoInit = true;
        //在app启动后1s初始化bugly更新
        Beta.initDelay = 1000;
        //显示通知栏提示
        Beta.enableNotification = true;
        //不自动更新.手动检测
        Beta.autoCheckUpgrade = false;
        //通知栏大图标
        Beta.largeIconId = R.mipmap.icon_logo;
        //使用外部存储来存下载下来的包
        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        //是否显示弹窗apk信息（默认弹窗）
        Beta.canShowApkInfo = false;
        //wifi下自动下载
        Beta.autoDownloadOnWifi = true;

        Beta.upgradeListener = (ret, strategy, isManual, isSilence) -> {//更新回调，触发自定义更新弹窗
            if (strategy != null) {
                PopMgr.getInstance().startUpgrade(strategy, isManual);
            }
        };

        Bugly.init(getApplicationContext(), BUGLY_APP_ID, false);
    }


    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        MultiLanguageUtil.getInstance().setConfiguration();
    }

    public static BaseApp getApp() {
        return app;
    }

    private void initTbs() {

        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {

            }

            @Override
            public void onCoreInitFinished() {

            }
        };

        QbSdk.setTbsListener(new TbsListener() {
            @Override
            public void onDownloadFinish(int i) {

            }

            @Override
            public void onInstallFinish(int i) {

            }

            @Override
            public void onDownloadProgress(int i) {

            }

        });

        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
