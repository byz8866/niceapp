package com.niceapp;

public class AppValue {

    //分享
    public static String UM_APP_KEY = "5c0faefdb465f50e6c00014b";
    public static String UM_MESSAGE_SECRET = "f5e2e535d44bf7442d328bb208106f0b";
    public static String WEIXIN_APP_ID = "wx81943135068d4e03";
    public static String WEIXIN_APP_SECRET = "4f47a716262b483b42c25ea702a0cd92";
    public static String QQ_APP_ID = "1107387917";
    public static String QQ_APP_KEY = "MSzp6YzuY7Fnx237";


    //bugly升级
    public static String BUGLY_APP_ID = BuildConfig.DEBUG ? "2691c3707d" : "075098f4cb";

    //首页公告
//    public static int ANIM_DELAYED_TIME = 3 * 1000;  //公告停留时间
//    public static int ANIM_DURATION_TIME = 1 * 1000;  //公告向上翻滚时间
//    public static int ANIM_TEXT_SIZE = 14;  //公告字体大小

    //网络加载
    public static String SOCKET_IP = "47.75.52.2";//正式服务器
    public static int SOCKET_PORT = 9123;
    public static int CONNECT_TIME_OUT = 30;

    // HTTP请求
    public static String SERVER_URL = "http://47.75.52.2:8089/";

    //币种相关SQlite版本号
    public static int dbVersion = 1;
}
