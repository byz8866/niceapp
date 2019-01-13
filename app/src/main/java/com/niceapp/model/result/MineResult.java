package com.niceapp.model.result;

import java.util.List;

public class MineResult {


    /**
     * email : mm@163.com
     * balance : 800ETH
     */

    private String email;
    private String balance;
    private String tokenBalance;
    private int bonus;
    private String hpcBalance;
    private String eosBalance;
    private double rewardBalance;
    private String bonusAmount;
    private int level;
    private String nextLevelRule;
    private float progress;
    private double ethBettAmount;
    private String nickname;
    private List<BanlancesBean> banlances;

    public List<BanlancesBean> getBanlances() {
        return banlances;
    }

    public void setBanlances(List<BanlancesBean> banlances) {
        this.banlances = banlances;
    }

    public String getTokenBalance() {
        return tokenBalance;
    }

    public void setTokenBalance(String tokenBalance) {
        this.tokenBalance = tokenBalance;
    }

    public String getEosBalance() {
        return eosBalance;
    }

    public void setEosBalance(String eosBalance) {
        this.eosBalance = eosBalance;
    }

    public double getRewardBalance() {
        return rewardBalance;
    }

    public void setRewardBalance(double rewardBalance) {
        this.rewardBalance = rewardBalance;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNextLevelRule() {
        return nextLevelRule;
    }

    public void setNextLevelRule(String nextLevelRule) {
        this.nextLevelRule = nextLevelRule;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public double getEthBettAmount() {
        return ethBettAmount;
    }

    public void setEthBettAmount(double ethBettAmount) {
        this.ethBettAmount = ethBettAmount;
    }

    public String getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getHpcBalance() {
        return hpcBalance;
    }

    public void setHpcBalance(String hpcBalance) {
        this.hpcBalance = hpcBalance;
    }

    public String getBalance_token() {
        return tokenBalance;
    }

    public void setBalance_token(String balance_token) {
        this.tokenBalance = balance_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }


    public static class BanlancesBean {
        /**
         * coinName : ETH
         * banlance : 1022.12720
         */

        private String coinName;
        private String banlance;

        public String getCoinName() {
            return coinName;
        }

        public void setCoinName(String coinName) {
            this.coinName = coinName;
        }

        public String getBanlance() {
            return banlance;
        }

        public void setBanlance(String banlance) {
            this.banlance = banlance;
        }
    }
}
