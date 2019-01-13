package com.niceapp.model.request;

public class WithdrawalCashRequest extends BaseRequest{


    /**
     * toAddress : 0x4a2ae73c0c37b575594c653a12edb533af706ec8
     * amount : 10
     * validCode : 452396
     */

    private String toAddress;
    private double amount;
    private String validCode;

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }
}
