package com.niceapp.model.result;

import java.util.List;

public class InviteRewardResult {


    /**
     * bannerEntities : [{"id":4,"type":2,"url":"/images/89584128f42dffd.jpg"}]
     * inviteCount : 0
     * inviteUrl : http://47.75.52.8:8545
     * inviteCode : 118920
     * rewardLists : [{"amount":0,"count":0,"email":"mm@163.com"},{"amount":0,"count":0,"email":"yy@163.com"}]
     * inviteAmount : 0
     */

    private int inviteCount;
    private String inviteUrl;
    private String inviteCode;
    private int inviteAmount;
    private List<BannerEntitiesBean> bannerEntities;
    private List<RewardListsBean> rewardLists;

    public int getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(int inviteCount) {
        this.inviteCount = inviteCount;
    }

    public String getInviteUrl() {
        return inviteUrl;
    }

    public void setInviteUrl(String inviteUrl) {
        this.inviteUrl = inviteUrl;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public int getInviteAmount() {
        return inviteAmount;
    }

    public void setInviteAmount(int inviteAmount) {
        this.inviteAmount = inviteAmount;
    }

    public List<BannerEntitiesBean> getBannerEntities() {
        return bannerEntities;
    }

    public void setBannerEntities(List<BannerEntitiesBean> bannerEntities) {
        this.bannerEntities = bannerEntities;
    }

    public List<RewardListsBean> getRewardLists() {
        return rewardLists;
    }

    public void setRewardLists(List<RewardListsBean> rewardLists) {
        this.rewardLists = rewardLists;
    }

    public static class BannerEntitiesBean {
        /**
         * id : 4
         * type : 2
         * url : /images/89584128f42dffd.jpg
         */

        private int id;
        private int type;
        private String url;
        private String jumpUrl;

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class RewardListsBean {
        /**
         * amount : 0
         * count : 0
         * email : mm@163.com
         * "nickname": "333"
         */

        private Double amount;
        private Double count;
        private String email;
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public Double getCount() {
            return count;
        }

        public void setCount(Double count) {
            this.count = count;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @Override
    public String toString() {
        return "InviteRewardResult{" +
                "inviteCount=" + inviteCount +
                ", inviteUrl='" + inviteUrl + '\'' +
                ", inviteCode='" + inviteCode + '\'' +
                ", inviteAmount=" + inviteAmount +
                ", bannerEntities=" + bannerEntities +
                ", rewardLists=" + rewardLists +
                '}';
    }
}
