package com.niceapp.model.result;

import java.util.List;

public class InviteNumResult {


    private List<InviteNumberResultsBean> inviteNumberResults;

    public List<InviteNumberResultsBean> getInviteNumberResults() {
        return inviteNumberResults;
    }

    public void setInviteNumberResults(List<InviteNumberResultsBean> inviteNumberResults) {
        this.inviteNumberResults = inviteNumberResults;
    }

    public static class InviteNumberResultsBean {
        /**
         * mobile : 138****0089
         * email : 673055765@qq.com
         * status : 1
         * registerTime : 2018-09-12 18:10:52
         * "nickname": "wewew"
         */

        private String mobile;
        private String email;
        private int status;
        private String registerTime;
        private String nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }
    }
}
