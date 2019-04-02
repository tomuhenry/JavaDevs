package com.andela.tomusange.javadevsnairobi.view.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllUserResponse {

    @SerializedName("items")
    @Expose
    private List<UserDetail> userDetails;

    public AllUserResponse(){

        userDetails = new ArrayList<UserDetail>();
    }

    public List<UserDetail> getUserDetails(){
        return userDetails;
    }
}
