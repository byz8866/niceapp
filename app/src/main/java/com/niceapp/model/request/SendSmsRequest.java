package com.niceapp.model.request;

public class SendSmsRequest extends BaseRequest {


    /**
     * type : 1
     * phoneNo : 1030934i934
     */
//    type 验证码类型
//              1.注册
//              2.忘记密码
//              3.提现
    private String verifyCode;
    private int type;
    private String phoneNo;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
