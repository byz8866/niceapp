package com.niceapp.model.request;

public class ForgetPasswordRequest extends BaseRequest{

   private String phoneNo;
   private String smsCode;
   private String newPwd;

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

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public ForgetPasswordRequest(String phoneNo, String smsCode, String newPwd) {
        this.phoneNo = phoneNo;
        this.smsCode = smsCode;
        this.newPwd = newPwd;
    }
}
