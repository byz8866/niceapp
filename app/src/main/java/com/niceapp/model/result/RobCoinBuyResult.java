package com.niceapp.model.result;

public class RobCoinBuyResult {

    /**
     * id : 1
     * progress : 0
     * title : 以太坊（ETH）10枚
     * amount : 0.1
     */

    private long id;
    private double progress;
    private String title;
    private double amount;

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
}
