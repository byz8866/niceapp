package com.niceapp.model.result;

import com.niceapp.model.request.SendMessage;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class WinPrizeResult {

    private List<WinPrizeResultBean> winPrizeResultList;

    public List<WinPrizeResultBean> getWinPrizeResultList() {
        return winPrizeResultList;
    }

    public void setWinPrizeResultList(List<WinPrizeResultBean> winPrizeResultList) {
        winPrizeResultList = winPrizeResultList;
    }

    public static class WinPrizeResultBean implements Serializable {
        private int playRecordId;
        private String issue;
        private String openPrice;
        private String closePrice;
        private Timestamp createTime;

        public int getPlayRecordId() {
            return playRecordId;
        }

        public void setPlayRecordId(int playRecordId) {
            this.playRecordId = playRecordId;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public String getOpenPrice() {
            return openPrice;
        }

        public void setOpenPrice(String openPrice) {
            this.openPrice = openPrice;
        }

        public String getClosePrice() {
            return closePrice;
        }

        public void setClosePrice(String closePrice) {
            this.closePrice = closePrice;
        }

        public Timestamp getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Timestamp createTime) {
            this.createTime = createTime;
        }
    }

    @Override
    public String toString() {
        return "WinPrizeResult{" +
                "WinPrizeResultList=" + winPrizeResultList +
                '}';
    }
}
