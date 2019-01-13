package com.niceapp.model.request;

public class MineRequest extends BaseRequest{

    public MineRequest(String token) {
        this.token = token;
    }

    /**
     * token : AJFLNG949L84HHG114rLNGYbvh42N_
     */

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
