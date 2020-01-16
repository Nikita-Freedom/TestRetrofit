package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ARIInterface {
    String BASE_URL = "http://ios.pixli.site/";
    @GET("get.php")
    Call<String> getString();
    @Headers("Content-Type: application/json")
    @POST("send.php")
    Call myMetod(@Body Request body);


}
