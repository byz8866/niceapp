package com.niceapp.model.result;

import android.os.Parcel;
import android.os.Parcelable;

public class VerificationEntity implements Parcelable {
   String type;
   String phoneNo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "VerificationEntity{" +
                "type='" + type + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.phoneNo);
    }

    protected VerificationEntity(Parcel in) {
        this.type = in.readString();
        this.phoneNo = in.readString();
    }

    public static final Creator<VerificationEntity> CREATOR = new Creator<VerificationEntity>() {
        @Override
        public VerificationEntity createFromParcel(Parcel source) {
            return new VerificationEntity(source);
        }

        @Override
        public VerificationEntity[] newArray(int size) {
            return new VerificationEntity[size];
        }
    };
}