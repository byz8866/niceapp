package com.niceapp.model.result;

import java.util.List;

public class HpcDepositRecordResult {

    private double todayDepositAmount;
    private double unDepositAmount;

    public double getUnDepositAmount() {
        return unDepositAmount;
    }

    public void setUnDepositAmount(double unDepositAmount) {
        this.unDepositAmount = unDepositAmount;
    }

    private List<DepositRecordResult.depositBeanListBean> depositBeanList;

    public double getTodayDepositAmount() {
        return todayDepositAmount;
    }

    public void setTodayDepositAmount(double todayDepositAmount) {
        this.todayDepositAmount = todayDepositAmount;
    }


    public List<DepositRecordResult.depositBeanListBean> getDepositBeanList() {
        return depositBeanList;
    }

    public void setDepositBeanList(List<DepositRecordResult.depositBeanListBean> depositBeanList) {
        this.depositBeanList = depositBeanList;
    }

    public static class DepositBeanListBean {
        /**
         * amount : 3
         * createTime : 2018-07-13 10:13:06.0
         * hash : 0x18b24ef420ed3d999b2530f8208ada5878d075d09b5c83792d372ddbba5ccc95
         * fee : 0.01
         */

        private double amount;
        private String createTime;
        private String hash;
        private String fee;
        private int status;//提现状态

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }
    }
}
