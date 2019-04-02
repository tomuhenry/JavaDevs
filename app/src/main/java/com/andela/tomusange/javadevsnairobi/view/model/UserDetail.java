package com.andela.tomusange.javadevsnairobi.view.model;

import com.google.gson.annotations.SerializedName;

public class UserDetail {

    @SerializedName("login")
    String userName;

    @SerializedName("avatar_url")
    String imageUrl;

    @SerializedName("html_url")
    String githubUrl;


    public String getUserName() {
        return userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }
}
