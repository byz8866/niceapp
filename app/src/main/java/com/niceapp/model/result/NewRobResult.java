package com.niceapp.model.result;

public class NewRobResult {

    /**
     * id : 153
     * progress : 0.13
     * title : 以太坊（ETH）10枚
     * amount : 0.1
     * issue : 44
     * currency : ETH
     */

    private long id;
    private double progress;
    private String title;
    private double amount;
    private int issue;
    private String currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
