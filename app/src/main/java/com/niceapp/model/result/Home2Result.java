package com.niceapp.model.result;

import java.util.List;

public class Home2Result {

    /**
     * bannerList : [{"id":1,"url":"www","jumpUrl":null,"type":1}]
     * homeRecodeList : null
     * noticeList : [{"id":1,"notice":"1111","jumpUrl":null}]
     * registerCount : 5
     * prizePool : 0.00601
     * eosPrizePool
     * robCoinRecords : [{"id":1,"progress":0,"title":"以太坊（ETH）10枚","amount":0.1},{"id":2,"progress":1,"title":"以太坊（ETH）1枚","amount":0.01}]
     * playRecordEntity : {"id":5463,"issue":"050009","openPrice":"7381.03000000","currency":"BTC","closePrice":null,"status":2,"playTotalTime":120}
     */

    private Object homeRecodeList;
    private int registerCount;
    private String prizePool;
    private String eosPrizePool;
    private String xrpPrizePool;
    private String xlmPrizePool;
    private RecordEntity playRecordEntity;
    private List<BannerListBean> bannerList;
    private List<NoticeListBean> noticeList;
    private List<EosRobCoinRecordsBean> eosRobCoinRecords;
    private List<RobCoinRecordsBean> robCoinRecords;
    private int ethStatus;
    private int tokenStatus;
    private ActivityBannerEntity activityBanner;

    public String getXrpPrizePool() {
        return xrpPrizePool;
    }

    public void setXrpPrizePool(String xrpPrizePool) {
        this.xrpPrizePool = xrpPrizePool;
    }

    public String getXlmPrizePool() {
        return xlmPrizePool;
    }

    public void setXlmPrizePool(String xlmPrizePool) {
        this.xlmPrizePool = xlmPrizePool;
    }

    public String getEosPrizePool() {
        return eosPrizePool;
    }

    public void setEosPrizePool(String eosPrizePool) {
        this.eosPrizePool = eosPrizePool;
    }

    public ActivityBannerEntity getActivityBanner() {
        return activityBanner;
    }

    public void setActivityBanner(ActivityBannerEntity activityBanner) {
        this.activityBanner = activityBanner;
    }

    public int getEthStatus() {
        return ethStatus;
    }

    public void setEthStatus(int ethStatus) {
        this.ethStatus = ethStatus;
    }

    public int getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(int tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Object getHomeRecodeList() {
        return homeRecodeList;
    }

    public void setHomeRecodeList(Object homeRecodeList) {
        this.homeRecodeList = homeRecodeList;
    }

    public int getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(int registerCount) {
        this.registerCount = registerCount;
    }

    public String getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    public RecordEntity getPlayRecordEntity() {
        return playRecordEntity;
    }

    public void setPlayRecordEntity(RecordEntity playRecordEntity) {
        this.playRecordEntity = playRecordEntity;
    }

    public List<BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public List<NoticeListBean> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<NoticeListBean> noticeList) {
        this.noticeList = noticeList;
    }

    public List<RobCoinRecordsBean> getRobCoinRecords() {
        return robCoinRecords;
    }

    public void setRobCoinRecords(List<RobCoinRecordsBean> robCoinRecords) {
        this.robCoinRecords = robCoinRecords;
    }

    public static class PlayRecordEntityBean {
        /**
         * id : 5463
         * issue : 050009
         * openPrice : 7381.03000000
         * currency : BTC
         * closePrice : null
         * status : 2
         * playTotalTime : 120
         */

        private int id;
        private String issue;
        private String openPrice;
        private String currency;
        private Object closePrice;
        private int status;
        private int playTotalTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Object getClosePrice() {
            return closePrice;
        }

        public void setClosePrice(Object closePrice) {
            this.closePrice = closePrice;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPlayTotalTime() {
            return playTotalTime;
        }

        public void setPlayTotalTime(int playTotalTime) {
            this.playTotalTime = playTotalTime;
        }
    }

    public static class BannerListBean {
        /**
         * id : 1
         * url : www
         * jumpUrl : null
         * type : 1
         */

        private int id;
        private String url;
        private String jumpUrl;
        private int type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    public static class NoticeListBean {
        /**
         * id : 1
         * notice : 1111
         * jumpUrl : null
         */

        private int id;
        private String notice;
        private String jumpUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }
    }

    public static class RobCoinRecordsBean {
        /**
         * id : 1
         * progress : 0
         * title : 以太坊（ETH）10枚
         * amount : 0.1
         */

        private int id;
        private Double progress;
        private String title;
        private double amount;
        private long issue;
        private String currency;

        public long getIssue() {
            return issue;
        }

        public void setIssue(long issue) {
            this.issue = issue;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Double getProgress() {
            return progress;
        }

        public void setProgress(Double progress) {
            this.progress = progress;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    public static class EosRobCoinRecordsBean {

        /**
         * id : 158
         * progress : 0
         * title : 以太坊（ETH）1枚
         * amount : 0.01
         * issue : 88
         */

        private int id;
        private int progress;
        private String title;
        private double amount;
        private int issue;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public int getIssue() {
            return issue;
        }

        public void setIssue(int issue) {
            this.issue = issue;
        }
    }

    public static class ActivityBannerEntity {

        /**
         * id : 1
         * url : www.baidu.com
         * jumpUrl : null
         * type : 3
         * createTime : null
         */

        private int id;
        private String url;
        private Object jumpUrl;
        private int type;
        private Object createTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(Object jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }
    }
}
