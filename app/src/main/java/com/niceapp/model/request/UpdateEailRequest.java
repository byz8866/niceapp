package com.niceapp.model.request;

public class UpdateEailRequest extends BaseRequest{

    /**
     * password : eeeeeeeeeeeeee
     * email : qq@qq.com
     * newEmail : ee@qq.com
     */

    private String password;
    private String email;
    private String newEmail;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
