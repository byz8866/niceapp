package com.niceapp.model.request;

public class LoginRequest extends BaseRequest{

    /**
     * username : mm@163.com
     * password : 12348588
     */


    private String username;
    private String password;
    private String deviceToken;

    public LoginRequest(String username, String password,String deviceToken) {
        this.username = username;
        this.password = password;
        this.deviceToken=deviceToken;
    }


    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
