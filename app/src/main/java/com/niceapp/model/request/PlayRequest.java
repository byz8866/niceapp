package com.niceapp.model.request;

public class PlayRequest extends BaseRequest{

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayRequest(int id) {
        this.id = id;
    }
}
