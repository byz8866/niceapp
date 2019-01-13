package com.niceapp.model.result;

import java.util.List;

public class EthRecordResult {

    private List<BalanceRecordEntityListBean> balanceRecordEntityList;

    public List<BalanceRecordEntityListBean> getBalanceRecordEntityList() {
        return balanceRecordEntityList;
    }

    public void setBalanceRecordEntityList(List<BalanceRecordEntityListBean> balanceRecordEntityList) {
        this.balanceRecordEntityList = balanceRecordEntityList;
    }

    public static class BalanceRecordEntityListBean {
        /**
         * amount : 1.0E-4
         * createTime : 2018-11-19 18:14:52
         * type : 5
         * status : 2
         */

        private double amount;
        private String createTime;
        private int type;
        private int status;

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

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
