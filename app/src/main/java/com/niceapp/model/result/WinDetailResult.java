package com.niceapp.model.result;

import java.util.List;

public class WinDetailResult {


    private int countDown;
    private int status;
    private long myAmount;

    private BettDetails ethDetails;
    private BettDetails tokenDetails;

    public BettDetails getEthDetails() {
        return ethDetails;
    }

    public void setEthDetails(BettDetails ethDetails) {
        this.ethDetails = ethDetails;
    }

    public BettDetails getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(BettDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
    }

    private List<LineChartResult> lineChartResultList;

    public List<LineChartResult> getLineChartResultList() {
        return lineChartResultList;
    }

    public void setLineChartResultList(List<LineChartResult> lineChartResultList) {
        this.lineChartResultList = lineChartResultList;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public long getMyAmount() {
        return myAmount;
    }

    public void setMyAmount(long myAmount) {
        this.myAmount = myAmount;
    }


    public static class BettDetails {
        private int currency;
        private double rise;//上涨
        private double fall;//下跌
        private double flat;//持平
        private double totalRise;//本期全部上涨
        private double totalFall;//本期全部下跌
        private double totalFlat;//本期全部持平
        private double winPrize;//中奖总额

        public double getWinPrize() {
            return winPrize;
        }

        public void setWinPrize(double winPrize) {
            this.winPrize = winPrize;
        }

        public double getRise() {
            return rise;
        }

        public void setRise(double rise) {
            this.rise = rise;
        }

        public double getFall() {
            return fall;
        }

        public void setFall(double fall) {
            this.fall = fall;
        }

        public double getFlat() {
            return flat;
        }

        public void setFlat(double flat) {
            this.flat = flat;
        }

        public double getTotalRise() {
            return totalRise;
        }

        public void setTotalRise(double totalRise) {
            this.totalRise = totalRise;
        }

        public double getTotalFall() {
            return totalFall;
        }

        public void setTotalFall(double totalFall) {
            this.totalFall = totalFall;
        }

        public double getTotalFlat() {
            return totalFlat;
        }

        public int getCurrency() {
            return currency;
        }

        public void setCurrency(int currency) {
            this.currency = currency;
        }

        public void setTotalFlat(double totalFlat) {
            this.totalFlat = totalFlat;
        }

        @Override
        public String toString() {
            return "BettDetails{" +
                    "currency=" + currency +
                    ", rise=" + rise +
                    ", fall=" + fall +
                    ", flat=" + flat +
                    ", totalRise=" + totalRise +
                    ", totalFall=" + totalFall +
                    ", totalFlat=" + totalFlat +
                    ", winPrize=" + winPrize +
                    '}';
        }

        public BettDetails() {
        }
    }

}
