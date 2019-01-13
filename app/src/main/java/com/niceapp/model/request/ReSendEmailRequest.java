package com.niceapp.model.request;

public class ReSendEmailRequest extends BaseRequest{
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
