package com.niceapp.model.result;

import android.os.Parcel;
import android.os.Parcelable;

public class RebateEntity implements Parcelable {

    private String id;
    private String issue;
    private String openPrice;
    private String currency;
    private String closePrice = "0";
    private int status; //1投注中  2.开奖中  3.已结束
    private int playTotalTime;


    public RebateEntity() {
    }


    public int getPlayTotalTime() {
        return playTotalTime;
    }

    public void setPlayTotalTime(int playTotalTime) {
        this.playTotalTime = playTotalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "RecordEntity{" +
                "id='" + id + '\'' +
                ", issue='" + issue + '\'' +
                ", openPrice='" + openPrice + '\'' +
                ", currency='" + currency + '\'' +
                ", closePrice='" + closePrice + '\'' +
                ", status=" + status +
                ", playTotalTime=" + playTotalTime +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.issue);
        dest.writeString(this.openPrice);
        dest.writeString(this.currency);
        dest.writeString(this.closePrice);
        dest.writeInt(this.status);
        dest.writeInt(this.playTotalTime);
    }

    protected RebateEntity(Parcel in) {
        this.id = in.readString();
        this.issue = in.readString();
        this.openPrice = in.readString();
        this.currency = in.readString();
        this.closePrice = in.readString();
        this.status = in.readInt();
        this.playTotalTime = in.readInt();
    }

    public static final Creator<RebateEntity> CREATOR = new Creator<RebateEntity>() {
        @Override
        public RebateEntity createFromParcel(Parcel source) {
            return new RebateEntity(source);
        }

        @Override
        public RebateEntity[] newArray(int size) {
            return new RebateEntity[size];
        }
    };
}