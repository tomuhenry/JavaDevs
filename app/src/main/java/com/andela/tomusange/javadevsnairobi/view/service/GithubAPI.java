package com.andela.tomusange.javadevsnairobi.view.service;

import com.andela.tomusange.javadevsnairobi.view.model.AllUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubAPI {
    @GET("search/users?q=location:Nairobi+language:Java")
    Call<AllUserResponse> getItems();
}
