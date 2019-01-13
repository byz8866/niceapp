package com.niceapp.model.request;

public class ChangePasswordRequest extends BaseRequest{


    /**
     * oldPwd : 123123123
     * newPwd : padwnfg
     * token : AJFLNG949L84HHG114rLNGYbvh42N_
     */

    private String oldPwd;
    private String newPwd;
    private String token;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ChangePasswordRequest{" +
                "oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
