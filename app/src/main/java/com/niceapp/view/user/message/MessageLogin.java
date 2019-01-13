package com.niceapp.view.user.message;

public class MessageLogin {
    Boolean isLogin;
    private boolean firstLogin;//首次登陆返回true
    private Double reward;//注册奖励金额

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public MessageLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }
}
