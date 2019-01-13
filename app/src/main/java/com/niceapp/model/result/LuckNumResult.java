package com.niceapp.model.result;

import java.util.List;

public class LuckNumResult {


    private List<LuckyNumberListBean> luckyNumberList;

    public List<LuckyNumberListBean> getLuckyNumberList() {
        return luckyNumberList;
    }

    public void setLuckyNumberList(List<LuckyNumberListBean> luckyNumberList) {
        this.luckyNumberList = luckyNumberList;
    }

    public static class LuckyNumberListBean {
        /**
         * luckyNumber : 100000068
         * issue:"3434343434"
         */

        private String luckyNumber;
        private String issue;

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getLuckyNumber() {
            return luckyNumber;
        }

        public void setLuckyNumber(String luckyNumber) {
            this.luckyNumber = luckyNumber;
        }
    }
}
