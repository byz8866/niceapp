package com.niceapp.model.result;

import java.util.List;

public class EosDepositRecordResult {


    /**
     * todayDepositAmount : 0
     * depositBeanList : [{"hash":"111","amount":2,"createTime":"1542792288000","fee":1,"status":1}]
     */

    private double todayDepositAmount;
    private double unDepositAmount;//unDepositAmount

    public double getUnDepositAmount() {
        return unDepositAmount;
    }

    public void setUnDepositAmount(int unDepositAmount) {
        this.unDepositAmount = unDepositAmount;
    }

    private List<DepositBeanListBean> depositBeanList;

    public double getTodayDepositAmount() {
        return todayDepositAmount;
    }

    public void setTodayDepositAmount(int todayDepositAmount) {
        this.todayDepositAmount = todayDepositAmount;
    }

    public List<DepositBeanListBean> getDepositBeanList() {
        return depositBeanList;
    }

    public void setDepositBeanList(List<DepositBeanListBean> depositBeanList) {
        this.depositBeanList = depositBeanList;
    }

    public static class DepositBeanListBean {
        /**
         * hash : 111
         * amount : 2
         * createTime : 1542792288000
         * fee : 1
         * status : 1
         */

        private String hash;
        private double amount;
        private String createTime;
        private double fee;
        private int status;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
