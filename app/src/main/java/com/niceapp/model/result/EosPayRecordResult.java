package com.niceapp.model.result;

import java.util.List;

public class EosPayRecordResult {


    /**
     * walletAddress : coinplaydapp
     * remark : SB84iv
     * rechargeList : [{"hash":"11111","amount":22,"createTime":"2018-11-21 17:06:56.0"},{"hash":"11111","amount":22,"createTime":"2018-11-21 17:06:56.0"}]
     */

    private String walletAddress;
    private String remark;
    private List<RechargeListBean> rechargeList;

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RechargeListBean> getRechargeList() {
        return rechargeList;
    }

    public void setRechargeList(List<RechargeListBean> rechargeList) {
        this.rechargeList = rechargeList;
    }

    public static class RechargeListBean {
        /**
         * hash : 11111
         * amount : 22
         * createTime : 2018-11-21 17:06:56.0
         */

        private String hash;
        private double amount;
        private String createTime;

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
    }
}
