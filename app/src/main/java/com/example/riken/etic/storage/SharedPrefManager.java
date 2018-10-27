package com.example.riken.etic.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.riken.etic.models.LoginResponse;
import com.example.riken.etic.models.User;

public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "credential";

    private static SharedPrefManager mInstance;
    private Context mContext;

    private SharedPrefManager (Context mContext){
        this.mContext = mContext;

    }

    public static synchronized SharedPrefManager getmInstance(Context mContext){
        if(mInstance == null){
            mInstance = new SharedPrefManager(mContext);
        }
        return mInstance;
    }

    public void saveToken(LoginResponse loginResponse){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();

        editor.putBoolean("status",loginResponse.isStatus());
        editor.putString("access_token",loginResponse.getAccess_token());
        editor.putString("token_type",loginResponse.getToken_type());
        editor.putInt("expires_in",loginResponse.getExpires_in());

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
        return sharedPreferences.getString("token_type",null) != null;
    }

    public LoginResponse getToken(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new LoginResponse(
                sharedPreferences.getBoolean("status",false),
                sharedPreferences.getString("access_token",null),
                sharedPreferences.getString("token_type",null),
                sharedPreferences.getInt("expires_in",0)
        );
    }

    public User getUser(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString("token",null)
        );
    }


}
