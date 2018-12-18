package com.example.riken.etic.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riken.etic.ApiClient;
import com.example.riken.etic.R;
import com.example.riken.etic.models.NewLoginResponse;
import com.example.riken.etic.storage.SharedPrefManager;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private Call<NewLoginResponse> call;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextInputEditText etName = (TextInputEditText) findViewById(R.id.tvEmail);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.tvPassword);
        MaterialButton btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        TextView btnRegister = (TextView) findViewById(R.id.btn_intent_signup);
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setMessage("Email atau password salah !");


        if (SharedPrefManager.getmInstance(this).isLoggin()){
            Toast.makeText(LoginActivity.this,"logged in",Toast.LENGTH_LONG).show();
            Intent displayScreen = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(displayScreen);
            finish();

        }else{
            Toast.makeText(LoginActivity.this,"not logged in",Toast.LENGTH_LONG).show();
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etName.getText().toString();
                String password = etPassword.getText().toString();
                call = ApiClient.getApiService().newlogin(email,password);
                call.enqueue(new Callback<NewLoginResponse>() {
                    @Override
                    public void onResponse(Call<NewLoginResponse> call, Response<NewLoginResponse> response) {
                        NewLoginResponse newLoginResponse = response.body();

                        if (response.isSuccessful()){
                            if(response.body().isStatus()){
                                Log.d("ferguso", "onResponse: True"+new Gson().toJson(response));
                                SharedPrefManager.getmInstance(LoginActivity.this).saveToken(newLoginResponse);
                                Intent displayScreen = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(displayScreen);

                                Toast.makeText(LoginActivity.this, ""+response.body().getAccessToken(), Toast.LENGTH_SHORT).show();
                                finish();

                            }else{
                                Log.d("ferguso", "onResponse: True"+new Gson().toJson(response));
                            }
                        }else{
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    etPassword.getText().clear();
                                }
                            });
                            alertDialog = builder.create();
                            alertDialog.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewLoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "periksa jaringan internet anda", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerScreen);
            }
        });
    }



}
