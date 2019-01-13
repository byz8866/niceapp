package com.niceapp.model.result;

import java.io.Serializable;
import java.util.List;

public class GetDividendsResultFail implements Serializable {


    /**
     * todayBonus : null
     * bonusRecords : [{"date":"2018-10-18","amount":"0.0001","status":2},{"date":"2018-10-19","amount":"0.0001","status":2},{"date":"2018-10-20","amount":"0.0001","status":2},{"date":"2018-10-21","amount":"0.0001","status":2},{"date":"2018-10-22","amount":"0.0001","status":2},{"date":"2018-10-23","amount":"0.0001","status":2}]
     */

    private Object todayBonus;
    private List<BonusRecordsBean> bonusRecords;

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
         */

        private String date;
        private String amount;
        private int status;

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
    }
}
