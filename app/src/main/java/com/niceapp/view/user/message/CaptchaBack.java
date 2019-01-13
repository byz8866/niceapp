package com.niceapp.view.user.message;

public class CaptchaBack {
    String back;
    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CaptchaBack(String back, String token) {
        this.back = back;
        this.token = token;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
