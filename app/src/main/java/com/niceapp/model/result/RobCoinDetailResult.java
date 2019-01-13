package com.niceapp.model.result;

import java.util.List;

public class RobCoinDetailResult {

    /**
     * totalNumber : 130
     * residueNumber : 0
     * "ownCount": 33,
     * robRecords : [{"count":30,"date":"20180810 17:53:40","mobile":"17610190508"},{"count":30,"date":"20180810 17:53:40","mobile":"17610190508"},{"count":30,"date":"20180801 18:04:23","mobile":"15562573993"},{"count":30,"date":"20180801 18:04:23","mobile":"15562573993"},{"count":10,"date":"20180818 17:52:49","mobile":"176101905022"}]
     */

    private int totalNumber;
    private int residueNumber;
    private int ownCount;
    private List<RobRecordsBean> robRecords;

    public int getOwnCount() {
        return ownCount;
    }

    public void setOwnCount(int ownCount) {
        this.ownCount = ownCount;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getResidueNumber() {
        return residueNumber;
    }

    public void setResidueNumber(int residueNumber) {
        this.residueNumber = residueNumber;
    }

    public List<RobRecordsBean> getRobRecords() {
        return robRecords;
    }

    public void setRobRecords(List<RobRecordsBean> robRecords) {
        this.robRecords = robRecords;
    }

    public static class RobRecordsBean {
        /**
         * count : 30
         * date : 20180810 17:53:40
         * mobile : 17610190508
         *  "nickname": "333"

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
