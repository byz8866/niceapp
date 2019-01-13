package com.niceapp.model.result;

import java.util.List;

public class TradingRecordResult {


    private List<BalanceRecordEntityListBean> balanceRecordEntityList;
    private List<TokenRecordEntitiesBean> tokenRecordEntities;

    public List<BalanceRecordEntityListBean> getBalanceRecordEntityList() {
        return balanceRecordEntityList;
    }

    public void setBalanceRecordEntityList(List<BalanceRecordEntityListBean> balanceRecordEntityList) {
        this.balanceRecordEntityList = balanceRecordEntityList;
    }

    public List<TokenRecordEntitiesBean> getTokenRecordEntities() {
        return tokenRecordEntities;
    }

    public void setTokenRecordEntities(List<TokenRecordEntitiesBean> tokenRecordEntities) {
        this.tokenRecordEntities = tokenRecordEntities;
    }

    public static class BalanceRecordEntityListBean {
        /**
         * amount : 1000000000000000000
         * createTime : 2018-08-02T11:10:03.000+0000
         * type : 1
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

    public static class TokenRecordEntitiesBean {
        /**
         * amount : 1000
         * type : 1
         * createTime : 2018-08-06T02:47:00.000+0000
         * status : 2
         */

        private double amount;
        private int type;
        private String createTime;
        private int status;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
