package com.example.riken.etic.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.riken.etic.models.LoginResponse;
import com.example.riken.etic.models.NewLoginResponse;
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

    public User getUser(){
        SharedPreferences sharedPreferences =mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getString("token",null)
        );
    }


}
