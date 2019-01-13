package com.niceapp.model.result;

import java.util.List;

public class DepositRecordResult {
    private double todayDepositAmount; //已提现金额
    private double unDepositAmount; //已提现金额
    private List<depositBeanListBean> depositBeanList;

    public List<depositBeanListBean> getDepositList() {
        return depositBeanList;
    }

    public double getUnDepositAmount() {
        return unDepositAmount;
    }

    public void setUnDepositAmount(double unDepositAmount) {
        this.unDepositAmount = unDepositAmount;
    }

    public void setDepositList(List<depositBeanListBean> rechargeList) {
        this.depositBeanList = rechargeList;
    }

    public double getTodayDepositAmount() {
        return todayDepositAmount;
    }

    public void setTodayDepositAmount(double todayDepositAmount) {
        this.todayDepositAmount = todayDepositAmount;
    }

    public static class depositBeanListBean {

        private Double amount;//金额
        private String createTime;//创建时间
        private String hash;//哈希值
        private Double fee;//手续费
        private int status;//提现状态



        public int getStutas() {
            return status;
        }

        public void setStutas(int stutas) {
            this.status = stutas;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Double getFee() {
            return fee;
        }

        public void setFee(Double fee) {
            this.fee = fee;
        }
    }

    @Override
    public String toString() {
        return "DepositRecordResult{" +
                "depositList=" + depositBeanList +
                '}';
    }
}
