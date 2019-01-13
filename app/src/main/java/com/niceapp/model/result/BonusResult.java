package com.niceapp.model.result;

import java.util.List;

public class BonusResult {

    /**
     * totalAmount : 65.84
     * bonusDetailsList : [{"mobile":"176****0509","nickname":"孟孟孟","type":1,"amount":"15.37"}]
     */

    private String totalAmount;
    private List<BonusDetailsListBean> bonusDetailsList;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<BonusDetailsListBean> getBonusDetailsList() {
        return bonusDetailsList;
    }

    public void setBonusDetailsList(List<BonusDetailsListBean> bonusDetailsList) {
        this.bonusDetailsList = bonusDetailsList;
    }

    public static class BonusDetailsListBean {
        /**
         * mobile : 176****0509
         * nickname : 孟孟孟
         * type : 1
         * amount : 15.37
         */

        private String mobile;
        private String nickname;
        private int type;
        private String amount;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
