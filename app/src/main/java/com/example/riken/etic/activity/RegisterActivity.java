package com.example.riken.etic.activity;

import android.content.SharedPreferences;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.riken.etic.R;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final TextInputEditText userName = (TextInputEditText) findViewById(R.id.tvUsernameNew);
        final TextInputEditText password = (TextInputEditText) findViewById(R.id.tv_passwordNew);
        final TextInputEditText email = (TextInputEditText) findViewById(R.id.tv_emailNew);
        MaterialButton btnRegister = (MaterialButton) findViewById(R.id.btn_signup);
        TextView backLogin = (TextView) findViewById(R.id.btn_intent_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
                String newUser  = userName.getText().toString();
                String newPassword = password.getText().toString();
                String newEmail = email.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newPassword, newPassword);
                editor.commit();
                editor.putString(newUser + newPassword + "data", newUser + "\n" + newEmail);
                editor.commit();
            }
        });

    }

}
