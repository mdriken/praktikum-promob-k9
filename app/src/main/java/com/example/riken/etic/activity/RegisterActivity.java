package com.example.riken.etic.activity;

import android.app.DatePickerDialog;
import android.content.Intent;


import android.os.Build;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riken.etic.ApiClient;
import com.example.riken.etic.R;
import com.example.riken.etic.models.NewLoginResponse;
import com.example.riken.etic.storage.SharedPrefManager;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public String tanggalLahir;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    public static TextInputEditText tanggal_lahir;
    private retrofit2.Call<NewLoginResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final TextInputEditText userName = (TextInputEditText) findViewById(R.id.tvUsernameNew);
        final TextInputEditText password = (TextInputEditText) findViewById(R.id.tv_passwordNew);
        final TextInputEditText password_confirm = (TextInputEditText) findViewById(R.id.tv_passwordNewConfirmed);
        final TextInputEditText email = (TextInputEditText) findViewById(R.id.tv_emailNew);
        tanggal_lahir = (TextInputEditText) findViewById(R.id.tv_date);
        MaterialButton btnRegister = (MaterialButton) findViewById(R.id.btn_signup);
        TextView backLogin = (TextView) findViewById(R.id.btn_intent_login);


        tanggal_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepick = new DatePickerFrag();
                datepick.show(getSupportFragmentManager(), "Tanggal Lahir");
                Toast.makeText(RegisterActivity.this, ""+tanggalLahir, Toast.LENGTH_SHORT).show();
                tanggal_lahir.setText(tanggalLahir);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String tl = tanggal_lahir.getText().toString();
            String name_param = userName.getText().toString();
            String email_param = email.getText().toString();
            String password_param = password.getText().toString();
            String password_confirm_param = password_confirm.getText().toString() ;
            String tanggal_lahir_param = tanggal_lahir.getText().toString();
//                try {
//                    tanggal_lahir_param = df.parse(tl);
//                    Log.d("berhasil",""+tanggal_lahir_param+" "+tl);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    Log.e("error","error parse data",e);
//                }




                call = ApiClient.getApiService()
                    .register(name_param,
                            email_param,
                            password_param,
                            password_confirm_param,
                            tanggal_lahir_param);

                call.enqueue(new Callback<NewLoginResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<NewLoginResponse> call, Response<NewLoginResponse> response) {
                        NewLoginResponse newLoginResponse = response.body();

                        if(response.isSuccessful()){
                            if (response.body().isStatus()){
                                Log.d("sukses","mau anjeng");
                                SharedPrefManager.getmInstance(RegisterActivity.this).saveToken(newLoginResponse);
                                Intent displayScreen = new Intent(RegisterActivity  .this, MainActivity.class);
                                startActivity(displayScreen);
                            }
                        }else{
                            Log.d("gagal","ga mau anjeng");
                            Log.d("ferguso", "onResponse: True"+new Gson().toJson(response));
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<NewLoginResponse> call, Throwable t) {
                        Log.e("koneksi","mohon cek koneksi anda");
                    }
                });




            }
        });

        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayScreen = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(displayScreen);
            }
        });




    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = format.format(c.getTime());
        tanggal_lahir.setText(strDate);




    }
}
