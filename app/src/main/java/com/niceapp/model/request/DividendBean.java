package com.niceapp.model.request;

public class DividendBean {
    private String currency;
    private String totalBonus;
    private String yestodayBonus;
    private int status;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(String totalBonus) {
        this.totalBonus = totalBonus;
    }

    public String getYestodayBonus() {
        return yestodayBonus;
    }

    public void setYestodayBonus(String yestodayBonus) {
        this.yestodayBonus = yestodayBonus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
