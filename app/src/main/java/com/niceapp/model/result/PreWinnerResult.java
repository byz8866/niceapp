package com.niceapp.model.result;

import java.util.List;

public class PreWinnerResult {


    private List<PreviousWinnersBean> previousWinners;

    public List<PreviousWinnersBean> getPreviousWinners() {
        return previousWinners;
    }

    public void setPreviousWinners(List<PreviousWinnersBean> previousWinners) {
        this.previousWinners = previousWinners;
    }

    public static class PreviousWinnersBean {


        /**
         * luckyNumber : 100000077
         * mobile : 176101905022
         * id:22222222222
         * count : 0
         * issue : 201809050003
         * openTime : 2018-09-05 17:20:15
         * title : 以太坊（ETH）1枚
         * id : 2333232323
         * "nickname": "孟孟孟"
         * currency
         * rewardAmount
         */

        private int luckyNumber;
        private String mobile;
        private int count;
        private String issue;
        private String openTime;
        private String title;
        private long id;
        private String nickname;
        private String currency;
        private String rewardAmount;

        public String getRewardAmount() {
            return rewardAmount;
        }

        public void setRewardAmount(String rewardAmount) {
            this.rewardAmount = rewardAmount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getLuckyNumber() {
            return luckyNumber;
        }

        public void setLuckyNumber(int luckyNumber) {
            this.luckyNumber = luckyNumber;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
}
