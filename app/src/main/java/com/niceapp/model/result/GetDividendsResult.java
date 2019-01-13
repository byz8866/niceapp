package com.niceapp.model.result;

import java.io.Serializable;
import java.util.List;

public class GetDividendsResult implements Serializable {


    /**
     * totalBonus : 0.0027877
     * totalEosBonus : 0.0027877
     * totalXrpBonus : 0.0
     * totalXlmBonus : 0.0
     * todayBonus : null
     * bonusRecords : [{"date":"2018-10-18","amount":"0.0001","status":2,"xrpAmount":"0.00","xlmAmount":"0.00","eosAmount":"0.01"}]
     */

    private String totalBonus;
    private String totalEosBonus;
    private String totalXrpBonus;
    private String totalXlmBonus;
    private Object todayBonus;
    private List<BonusRecordsBean> bonusRecords;

    public String getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(String totalBonus) {
        this.totalBonus = totalBonus;
    }

    public String getTotalEosBonus() {
        return totalEosBonus;
    }

    public void setTotalEosBonus(String totalEosBonus) {
        this.totalEosBonus = totalEosBonus;
    }

    public String getTotalXrpBonus() {
        return totalXrpBonus;
    }

    public void setTotalXrpBonus(String totalXrpBonus) {
        this.totalXrpBonus = totalXrpBonus;
    }

    public String getTotalXlmBonus() {
        return totalXlmBonus;
    }

    public void setTotalXlmBonus(String totalXlmBonus) {
        this.totalXlmBonus = totalXlmBonus;
    }

    public Object getTodayBonus() {
        return todayBonus;
    }

    public void setTodayBonus(Object todayBonus) {
        this.todayBonus = todayBonus;
    }

    public List<BonusRecordsBean> getBonusRecords() {
        return bonusRecords;
    }

    public void setBonusRecords(List<BonusRecordsBean> bonusRecords) {
        this.bonusRecords = bonusRecords;
    }

    public static class BonusRecordsBean {
        /**
         * date : 2018-10-18
         * amount : 0.0001
         * status : 2
         * xrpAmount : 0.00
         * xlmAmount : 0.00
         * eosAmount : 0.01
         */

        private String date;
        private String amount;
        private int status;
        private String xrpAmount;
        private String xlmAmount;
        private String eosAmount;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getXrpAmount() {
            return xrpAmount;
        }

        public void setXrpAmount(String xrpAmount) {
            this.xrpAmount = xrpAmount;
        }

        public String getXlmAmount() {
            return xlmAmount;
        }

        public void setXlmAmount(String xlmAmount) {
            this.xlmAmount = xlmAmount;
        }

        public String getEosAmount() {
            return eosAmount;
        }

        public void setEosAmount(String eosAmount) {
            this.eosAmount = eosAmount;
        }
    }
}
