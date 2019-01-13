package com.niceapp.model.request;

public class VerificationCodeRequest extends BaseRequest {

   private String type;
   private String phoneNo;

    public VerificationCodeRequest(String type) {
        this.type = type;
        this.phoneNo = phoneNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

}
