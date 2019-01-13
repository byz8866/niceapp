package com.niceapp.model.result;

import java.util.List;

public class RobResult {


    private List<RobCoinWinsBean> robCoinWins;

    public List<RobCoinWinsBean> getRobCoinWins() {
        return robCoinWins;
    }

    public void setRobCoinWins(List<RobCoinWinsBean> robCoinWins) {
        this.robCoinWins = robCoinWins;
    }

    public static class RobCoinWinsBean {
        /**
         * id : 2
         * issue : 201809050002
         * title : 以太坊（ETH）1枚
         * count : 50
         * amount :0.01
         * winMobile : 15552335555
         * "winNickname": "23232",
         *  currency ;
         */

        private long id;
        private String issue;
        private String title;
        private int count;
        private String winMobile;
        private String winNickname;
        private String currency;
        private Double amount;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getWinNickname() {
            return winNickname;
        }

        public void setWinNickname(String winNickname) {
            this.winNickname = winNickname;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
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
    }
}
