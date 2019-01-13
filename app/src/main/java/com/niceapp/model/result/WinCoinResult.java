package com.niceapp.model.result;

import java.util.List;

public class WinCoinResult {

    private List<RobCoinWinsBean> robCoinWins;

    public List<RobCoinWinsBean> getRobCoinWins() {
        return robCoinWins;
    }

    public void setRobCoinWins(List<RobCoinWinsBean> robCoinWins) {
        this.robCoinWins = robCoinWins;
    }

    public static class RobCoinWinsBean {
        /**
         * id : 3
         * issue : 201809050003
         * title : 以太坊（ETH）1枚
         * count : 50
         * winMobile : 176101905022
         * total : 130
         * luckyNumber : 100000077
         * openTime : 2018-09-05 17:20:15
         */

        private int id;
        private String issue;
        private String title;
        private int count;
        private String winMobile;
        private int total;
        private String luckyNumber;
        private String openTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getWinMobile() {
            return winMobile;
        }

        public void setWinMobile(String winMobile) {
            this.winMobile = winMobile;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getLuckyNumber() {
            return luckyNumber;
        }

        public void setLuckyNumber(String luckyNumber) {
            this.luckyNumber = luckyNumber;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }
    }
}
