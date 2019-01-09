package com.example.riken.etic.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.riken.etic.models.NewLoginResponse;
import com.example.riken.etic.models.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "credential";
    public static final String ID_FILM    = "id_film";
    public static final String ID_BIOSKOP = "id_bioskop";
    public static final String ID_JADWAL  = "id_jadwal";
    public static final String TANGGAL    = "tanggal";
    public static final String JAM        = "jam";

    private static SharedPrefManager mInstance;
    private Context mContext;

    private static SharedPreferences sharedPreferences;

    public SharedPrefManager(Context mContext){
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getmInstance(Context mContext){
        if(mInstance == null){
            mInstance = new SharedPrefManager(mContext);
        }
        return mInstance;
    }

    public void setIdFilm(String key, int val){
        sharedPreferences.edit().putInt(key,val).apply();
    }
    public void setIdBioskop(String key, int val){
        sharedPreferences.edit().putInt(key,val).apply();
    }
    public String setIiJadwal(String key, String valb){
        sharedPreferences.edit().putString(key,valb).apply();
        return valb;
    }

    public String setStringJam(String key, String value){
        sharedPreferences.edit().putString(key,value).apply();
        return value;
    }

    public  String getStringJam(String key) {
        return sharedPreferences.getString(key,"");
    }

    public String setTanggal(String key, String value){
        sharedPreferences.edit().putString(key,value).apply();
        return value;
    }

    public  String getTanggal(String key) {
        return sharedPreferences.getString(key,"");
    }




    public  int getIdFilm(String key) {
        return sharedPreferences.getInt(key,0);
    }

    public  int getIdBioskop(String key) {
        return sharedPreferences.getInt(key,0);
    }

    public  String getIdJadwal(String key) {
        return sharedPreferences.getString(key,"");
    }

    public void saveToken(NewLoginResponse newLoginResponse){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("access_token",newLoginResponse.getAccessToken());
        editor.apply();
    }

    public void clear(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean isLoggin(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString("access_token",null) != null;
    }

    public NewLoginResponse getToken(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new NewLoginResponse(
                sharedPreferences.getString("access_token",null)
        );
    }

    public String getMyToken(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString("access_token","");
    }

    public User getUser(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString("token",null)
        );
    }


}
