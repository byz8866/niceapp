package com.niceapp.model.request;

public class WinPrizeRequest extends BaseRequest{

    private int id;

    public WinPrizeRequest() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WinPrizeRequest(int id) {
        this.id = id;
    }
}
