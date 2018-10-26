package com.example.riken.etic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextInputEditText etName = (TextInputEditText) findViewById(R.id.tvUsername);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.tvPassword);
        MaterialButton btnLogin = (MaterialButton) findViewById(R.id.btnLogin);
        TextView btnRegister = (TextView) findViewById(R.id.btn_intent_signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

//                String savedPassword = preferences.getString(password, "");
//                String savedUserName = preferences.getString(user, "");

                String userDetails = preferences.getString(user + password + "data","No information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent displayScreen = new Intent(Login.this, MainActivity.class);
                startActivity(displayScreen);
            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerScreen = new Intent(Login.this, Register.class);
                startActivity(registerScreen);
            }
        });
    }



}
