package com.andela.tomusange.javadevsnairobi.view.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UserDetail implements Parcelable {
    public static final Creator<UserDetail> CREATOR = new Creator<UserDetail>() {
        @Override
        public UserDetail createFromParcel(Parcel source) {
            return new UserDetail(source);
        }

        @Override
        public UserDetail[] newArray(int size) {
            return new UserDetail[size];
        }
    };

    @SerializedName("login")
    String userName;

    @SerializedName("avatar_url")
    String imageUrl;

    @SerializedName("html_url")
    String githubUrl;


    protected UserDetail(Parcel source) {
        imageUrl = source.readString();
        userName = source.readString();
        githubUrl = source.readString();
    }


    public String getUserName() {
        return userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(imageUrl);
        destination.writeString(userName);
        destination.writeString(githubUrl);
    }
}
