package com.niceapp.model.request;

public class BuyRequest extends BaseRequest{


    /**
     * id : 22
     * type : 1
     * amount : 10000000000
     */

    private long id;
    private int type;
    private String amount;
    private int currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
