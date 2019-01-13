package com.niceapp.model.result;

import java.util.List;

public class CalculateResult {


    /**
     * timeTotal : 43929838868
     * times : [{"date":"20180912 18:29:30","timeStamp":"182930319","mobile":"138****0089"},{"date":"20180912 18:29:30","timeStamp":"182930003","mobile":"138****0089"},{"date":"20180912 18:29:30","timeStamp":"182929798","mobile":"138****0089"},{"date":"20180912 18:29:30","timeStamp":"182929702","mobile":"138****0089"},{"date":"20180912 18:29:30","timeStamp":"182929519","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182929319","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182929145","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182929004","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182928855","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182928706","mobile":"138****0089"},{"date":"20180912 18:29:29","timeStamp":"182928566","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182928414","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182928247","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182928046","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182927909","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182927798","mobile":"138****0089"},{"date":"20180912 18:29:28","timeStamp":"182927593","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182927483","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182927352","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182927146","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182927043","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182926896","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182926682","mobile":"138****0089"},{"date":"20180912 18:29:27","timeStamp":"182926624","mobile":"138****0089"},{"date":"20180912 18:29:26","timeStamp":"182926465","mobile":"138****0089"},{"date":"20180912 18:29:26","timeStamp":"182926243","mobile":"138****0089"},{"date":"20180912 18:29:26","timeStamp":"182926075","mobile":"138****0089"},{"date":"20180912 18:29:26","timeStamp":"182925912","mobile":"138****0089"},{"date":"20180912 18:29:21","timeStamp":"182921259","mobile":"138****0089"},{"date":"20180912 18:29:21","timeStamp":"182921150","mobile":"138****0089"},{"date":"20180912 18:29:21","timeStamp":"182920959","mobile":"138****0089"},{"date":"20180912 18:29:21","timeStamp":"182920772","mobile":"138****0089"},{"date":"20180912 18:29:21","timeStamp":"182920589","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182920497","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182920489","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182920125","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182919927","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182919726","mobile":"138****0089"},{"date":"20180912 18:29:20","timeStamp":"182919630","mobile":"138****0089"},{"date":"20180912 18:29:19","timeStamp":"182919433","mobile":"138****0089"},{"date":"20180912 18:29:19","timeStamp":"182919230","mobile":"138****0089"},{"date":"20180912 18:29:19","timeStamp":"182918990","mobile":"138****0089"},{"date":"20180912 18:29:19","timeStamp":"182918793","mobile":"138****0089"},{"date":"20180912 18:29:19","timeStamp":"182918609","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182918428","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182918300","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182918176","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182917980","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182917763","mobile":"138****0089"},{"date":"20180912 18:29:18","timeStamp":"182917627","mobile":"138****0089"}]
     * totalCount : 130
     * sscNumber : 20180912074
     * luckyNumber : 100000059
     */

    private String timeTotal;
    private String totalCount;
    private String sscNumber;
    private String luckyNumber;

    private List<TimesBean> times;


    public String getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(String timeTotal) {
        this.timeTotal = timeTotal;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getSscNumber() {
        return sscNumber;
    }

    public void setSscNumber(String sscNumber) {
        this.sscNumber = sscNumber;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public List<TimesBean> getTimes() {
        return times;
    }

    public void setTimes(List<TimesBean> times) {
        this.times = times;
    }

    public static class TimesBean {
        /**
         * date : 20180912 18:29:30
         * timeStamp : 182930319
         * mobile : 138****0089
         */

        private String date;
        private String timeStamp;
        private String mobile;
        private String nickname;

        public String getNickName() {
            return nickname;
        }

        public void setNickName(String nickName) {
            this.nickname = nickName;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}

