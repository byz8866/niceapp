package com.niceapp.model.result;

import java.util.List;

public class RobCoinListResult {

    private List<RobCoinRecordListBean> robCoinRecordList;

    public List<RobCoinRecordListBean> getRobCoinRecordList() {
        return robCoinRecordList;
    }

    public void setRobCoinRecordList(List<RobCoinRecordListBean> robCoinRecordList) {
        this.robCoinRecordList = robCoinRecordList;
    }

    public static class RobCoinRecordListBean {
        /**
         * id : 158
         * progress : 0
         * title : 以太坊（Eos）10枚
         * amount : 0.01
         * issue : 88
         * currency : EOS
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
}
