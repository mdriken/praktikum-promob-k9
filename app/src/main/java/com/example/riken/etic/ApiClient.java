package com.example.riken.etic;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static JsonPlaceHolderApi INSTANCE;
    //private static final String URL = "http://192.168.43.113:8000/api/auth/"; connect to android
    private static final String URL =  "http://172.17.100.2:8000/api/auth/";

    public static JsonPlaceHolderApi getApiService(){
        if(INSTANCE==null){
            OkHttpClient.Builder ok = new OkHttpClient.Builder();
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            ok.addInterceptor(logging);
            Retrofit ret = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
            INSTANCE = ret.create(JsonPlaceHolderApi.class);
        }
        return INSTANCE;
    }







}

