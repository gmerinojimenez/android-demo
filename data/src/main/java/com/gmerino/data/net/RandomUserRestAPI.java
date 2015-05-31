package com.gmerino.data.net;


import retrofit.http.GET;
import retrofit.http.Query;

public interface RandomUserRestAPI {

    String SERVER_URL = "http://api.randomuser.me/";

    @GET("/")
    UserResponse getList(@Query("results") Integer results);
}

