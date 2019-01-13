package com.niceapp.model.result;

import java.io.Serializable;

/**
 * 登录返回信息
 */
public class LoginResult implements Serializable {

    private String token;
    private boolean firstLogin;//首次登陆返回true
    private String reward;//注册奖励金额

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}