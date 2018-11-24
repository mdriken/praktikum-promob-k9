package com.example.riken.etic;


import com.example.riken.etic.models.NewLoginResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @POST("login")
    Call<NewLoginResponse> newlogin(
            @Field("email") String email,
            @Field ("password") String password
    );


    @FormUrlEncoded
    @POST("register")
    Call <NewLoginResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirm,
            @Field("tanggal_lahir") String tanggal_lahir

    );
//    @GET("hello")Call<HelloResponse>


}

