package com.niceapp.model.request;

public class RobCoinRequest extends BaseRequest{
    String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
