package com.niceapp.view.user.message;

public class MessageWinDialog {
    int select;
    Double token;
    Double eth;

    public int getSelect() {
        return select;
    }

    public void setSelect(int select) {
        this.select = select;
    }

    public Double getToken() {
        return token;
    }

    public void setToken(Double token) {
        this.token = token;
    }

    public Double getEth() {
        return eth;
    }

    public void setEth(Double eth) {
        this.eth = eth;
    }

    public MessageWinDialog(int select, Double token, Double eth) {
        this.select = select;
        this.token = token;
        this.eth = eth;
    }

}
