package com.niceapp.model.result;

public class PlayBettResult {

    private String bonusETH;
    private String bonusToken;
    private int type; //  1:中奖  2：没中奖

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBonusETH() {
        return bonusETH;
    }

    public void setBonusETH(String bonusETH) {
        this.bonusETH = bonusETH;
    }

    public String getBonusToken() {
        return bonusToken;
    }

    public void setBonusToken(String bonusToken) {
        this.bonusToken = bonusToken;
    }
}
