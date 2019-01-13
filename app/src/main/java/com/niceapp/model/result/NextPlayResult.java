package com.niceapp.model.result;

import android.os.Parcel;
import android.os.Parcelable;

public class NextPlayResult implements Parcelable {
     int id;
     int issue;
     double openPrice;
     String currency;
     int status;
     int playTotalTime;

    protected NextPlayResult(Parcel in) {
        id = in.readInt();
        issue = in.readInt();
        openPrice = in.readDouble();
        currency = in.readString();
        status = in.readInt();
        playTotalTime = in.readInt();
    }

    public static final Creator<NextPlayResult> CREATOR = new Creator<NextPlayResult>() {
        @Override
        public NextPlayResult createFromParcel(Parcel in) {
            return new NextPlayResult(in);
        }

        @Override
        public NextPlayResult[] newArray(int size) {
            return new NextPlayResult[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(issue);
        parcel.writeDouble(openPrice);
        parcel.writeString(currency);
        parcel.writeInt(status);
        parcel.writeInt(playTotalTime);
    }
}
