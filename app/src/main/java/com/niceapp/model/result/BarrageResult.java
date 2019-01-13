package com.niceapp.model.result;

public class BarrageResult {

    /**
     * level : 1
     * message : 恭喜XXX用户在以太坊(ETH)1枚场夺币中奖获得1ETH
     */

    private int level;
    private String message;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
