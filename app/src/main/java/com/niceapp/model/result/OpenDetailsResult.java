package com.niceapp.model.result;

import java.util.List;

public class OpenDetailsResult {

    /**
     * luckyCount : 60
     * count : 10
     * issue : 201809030002
     * openTime : 2018-09-03 17:39:38
     * luckyNumber : 100000063
     * mobile : 15562573993
     * robRecords : [{"count":30,"date":"20180810 17:53:40","mobile":"17610190508"},{"count":30,"date":"20180810 17:53:40","mobile":"17610190508"},{"count":30,"date":"20180801 18:04:23","mobile":"15562573993"},{"count":30,"date":"20180801 18:04:23","mobile":"15562573993"},{"count":10,"date":"20180818 17:52:49","mobile":"176101905022"}]
     */

    private int luckyCount;
    private int count;
    private String issue;
    private String openTime;
    private int luckyNumber;
    private String mobile;
    private List<RobCoinDetailResult.RobRecordsBean> robRecords;

    public int getLuckyCount() {
        return luckyCount;
    }

    public void setLuckyCount(int luckyCount) {
        this.luckyCount = luckyCount;
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

    public List<RobCoinDetailResult.RobRecordsBean> getRobRecords() {
        return robRecords;
    }

    public void setRobRecords(List<RobCoinDetailResult.RobRecordsBean> robRecords) {
        this.robRecords = robRecords;
    }

    public static class RobRecordsBean {
        /**
         * count : 30
         * date : 20180810 17:53:40
         * mobile : 17610190508
         * "nickname": "333"

         */

        private int count;
        private String date;
        private String mobile;
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
