package com.niceapp.model.request;

import java.io.Serializable;

public class GetDividendsRequest extends BaseRequest implements Serializable {

    String amount;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
