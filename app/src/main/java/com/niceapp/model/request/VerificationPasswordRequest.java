package com.niceapp.model.request;

public class VerificationPasswordRequest extends BaseRequest{

   private int type;
   private String phoneNo;

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
