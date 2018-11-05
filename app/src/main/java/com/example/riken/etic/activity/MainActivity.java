package com.example.riken.etic.activity;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btn_navView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_navView = findViewById(R.id.btn_navView);
        btn_navView.setOnNavigationItemSelectedListener(navListener);
        fragment = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_layout, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    fragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            fragment = new FragmentHome();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_layout, fragment).commit();
                    return true;
//
////        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
////        String display = preferences.getString("display", "");
////
////        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
////        displayInfo.setText(display);
//
                }
            };

}