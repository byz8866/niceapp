package com.niceapp.model.request;

public class RegisterRequest extends BaseRequest {
    /**
     * email : mm@163.com
     * password : 12348588
     * phoneNo : 1394939493
     * smsCode : 904023
     * inviteCode : 249939
     * "timestamp": 1540954065394,
     * "nonce":"166c80dedd524F67717589C"
     */

    private String email;
    private String password;
    private String phoneNo;
    private String smsCode;
    private String inviteCode;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
