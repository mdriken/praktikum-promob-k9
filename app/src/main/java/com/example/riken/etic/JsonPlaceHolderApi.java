package com.example.riken.etic;


import com.example.riken.etic.models.NewLoginResponse;
import com.example.riken.etic.models.SedangTayangResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


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

    @GET("sedang-tayang")
    Call<SedangTayangResponse> sedangtayang(
            @Query("token") String token
    );


    @GET("akan-tayang")
    Call<SedangTayangResponse> akantayang(
      @Query("token") String token
    );
}

