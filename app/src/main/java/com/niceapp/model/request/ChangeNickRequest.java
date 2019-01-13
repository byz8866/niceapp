package com.niceapp.model.request;

public class ChangeNickRequest extends BaseRequest{
    String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
