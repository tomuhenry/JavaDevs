package com.andela.tomusange.javadevsnairobi.view.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GithubService {

    public static final String BASE_URL = "https://api.github.com/";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public GithubAPI getAPI(){
        return retrofit.create(GithubAPI.class);
    }
}
