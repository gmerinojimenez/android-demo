package com.gmerino.data.net;


import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RandomUserRestAPI {

    static final String SERVER_URL = "http://api.randomuser.me/";

    @GET("/")
    void getList(@Query("results") Integer results, Callback<UserResponse> callback);
}

