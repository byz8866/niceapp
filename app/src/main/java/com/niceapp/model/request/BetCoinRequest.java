package com.niceapp.model.request;

public class BetCoinRequest extends BaseRequest{

    /**
     * id : 7
     * count : 30
     */

    private String id;
    private String count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
