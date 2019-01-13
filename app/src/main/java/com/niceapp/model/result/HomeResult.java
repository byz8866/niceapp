package com.niceapp.model.result;

import java.io.Serializable;
import java.util.List;

public class HomeResult implements Serializable {


    private Double prizePool;
    private int registerCount;

    private List<Home2Result.BannerListBean> bannerList;

    private List<NoticeEntity> noticeList;

    private List<RecordEntity> homeRecodeList;

    private ActivityBannerEntity activityBanner;

    public ActivityBannerEntity getActivityBanner() {
        return activityBanner;
    }

    public void setActivityBanner(ActivityBannerEntity activityBanner) {
        this.activityBanner = activityBanner;
    }

    public Double getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(Double prizePool) {
        this.prizePool = prizePool;
    }

    public int getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(int registerCount) {
        this.registerCount = registerCount;
    }

    public List<Home2Result.BannerListBean> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Home2Result.BannerListBean> bannerList) {
        this.bannerList = bannerList;
    }

    public List<NoticeEntity> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<NoticeEntity> noticeList) {
        this.noticeList = noticeList;
    }

    public List<RecordEntity> getHomeRecodeList() {
        return homeRecodeList;
    }

    public void setHomeRecodeList(List<RecordEntity> homeRecodeList) {
        this.homeRecodeList = homeRecodeList;
    }

    public static class BannerEntity {
        private String url;
        private String jumpUrl;

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

        @Override
        public String toString() {
            return "BannerEntity{" +
                    "url='" + url + '\'' +
                    ", jumpUrl='" + jumpUrl + '\'' +
                    '}';
        }
    }

    public static class NoticeEntity {

        private int id;
        private String notice;
        private String jumpUrl;

        public NoticeEntity(int id, String notice, String jumpUrl) {
            this.id = id;
            this.notice = notice;
            this.jumpUrl = jumpUrl;
        }

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

        @Override
        public String toString() {
            return "NoticeEntity{" +
                    "id=" + id +
                    ", notice='" + notice + '\'' +
                    ", jumpUrl='" + jumpUrl + '\'' +
                    '}';
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

    @Override
    public String toString() {
        return "{" +
                "prizePool=" + prizePool +
                ", registerCount=" + registerCount +
                ", bannerList=" + bannerList +
                ", noticeList=" + noticeList +
                ", homeRecodeList=" + homeRecodeList +
                '}';
    }
}
