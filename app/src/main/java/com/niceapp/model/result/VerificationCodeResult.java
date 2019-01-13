package com.niceapp.model.result;

import java.util.List;

public class VerificationCodeResult {

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    @Override
    public String toString() {
        return "VerificationCodeResult{" +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
