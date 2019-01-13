package com.niceapp.model.result;

import java.util.List;

public class RechargeResult {

    /**
     * walletAddress : 0x4a2ae73c0c37b575594c653a12edb533af706ec8
     * rechargeList : [{"amount":3,"createTime":"2018-07-13 10:13:06.0","hash":"0x18b24ef420ed3d999b2530f8208ada5878d075d09b5c83792d372ddbba5ccc95"}]
     */

    private String walletAddress;
    private List<RechargeListBean> rechargeList;

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public List<RechargeListBean> getRechargeList() {
        return rechargeList;
    }

    public void setRechargeList(List<RechargeListBean> rechargeList) {
        this.rechargeList = rechargeList;
    }

    public static class RechargeListBean {
        /**
         * amount : 3
         * createTime : 2018-07-13 10:13:06.0
         * hash : 0x18b24ef420ed3d999b2530f8208ada5878d075d09b5c83792d372ddbba5ccc95
         */

        private Double amount;
        private String createTime;
        private String hash;

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

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }

    @Override
    public String toString() {
        return "RechargeResult{" +
                "walletAddress='" + walletAddress + '\'' +
                ", rechargeList=" + rechargeList +
                '}';
    }
}
