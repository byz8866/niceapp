package com.niceapp.model.request;

import com.google.gson.Gson;
import com.niceapp.BuildConfig;
import com.niceapp.BaseApp;
import com.niceapp.utils.IdDevice;
import com.niceapp.utils.SignUtils;
import com.niceapp.view.user.manager.AccountManager;

/**
 * Created by MaTeng on 16/12/5.
 */

public class SendMessage<T> {

    /**
     * version : 1.0
     * platform : android
     * action : sendSms
     * data : {}
     */
    private String apiVersion = "3.0";
    private String platformVersion = BuildConfig.VERSION_NAME;
    private String platform = "android";
    private String action;
    private String token = AccountManager.INSTANCE.getToken();
    private T data;
    private String deviceId = IdDevice.getDeviceID(BaseApp.getApp()); //客户端唯一标识
    private String sign;



    public SendMessage() {

    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        sign = SignUtils.sign(data);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return "SendMessage{" +
                "apiVersion='" + apiVersion + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", platform='" + platform + '\'' +
                ", action='" + action + '\'' +
                ", token='" + token + '\'' +
                ", data=" + data +
                ", deviceId='" + deviceId + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
