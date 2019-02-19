package com.polyakov.recyclerviewexample;

import android.os.Parcel;
import android.os.Parcelable;

class EmailItem implements Parcelable {
    private String title;
    private String subTitle;
    private String content;
    private String date;
    private String userImg;



    public EmailItem(String userImg, String title,String subTitle, String content, String date) {
        this.userImg = userImg;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.date = date;
    }

    protected EmailItem(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
        content = in.readString();
        date = in.readString();
        userImg = in.readString();
    }

    public static final Creator<EmailItem> CREATOR = new Creator<EmailItem>() {
        @Override
        public EmailItem createFromParcel(Parcel in) {
            return new EmailItem(in);
        }

        @Override
        public EmailItem[] newArray(int size) {
            return new EmailItem[size];
        }
    };


    public String getUserImg() {
        return userImg;
    }
    String getTitle() { return title; }

    String getSubTitle() {
        return subTitle;
    }

    String getContent() {
        return content;
    }

    String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userImg);
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(content);
        dest.writeString(date);
    }
}