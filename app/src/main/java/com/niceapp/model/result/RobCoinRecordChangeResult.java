package com.niceapp.model.result;

public class RobCoinRecordChangeResult {

    /**
     * id : 1
     * progress : 0
     * title : 以太坊（ETH）10枚
     * amount : 0.1
     */

    private int id;
    private int progress;
    private String title;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
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
