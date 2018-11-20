package com.example.riken.etic.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.riken.etic.R;
import com.example.riken.etic.fragment.TiketFragment;
import com.example.riken.etic.fragment.WhislistFragment;
import com.example.riken.etic.fragment.FragmentHome;
import com.example.riken.etic.sqllite.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    BottomNavigationView btn_navView;
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_navView = findViewById(R.id.btn_navView);
        btn_navView.setOnNavigationItemSelectedListener(navListener);
        fragment = new FragmentHome();
        db = new DatabaseHelper(this);
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
                        case R.id.nav_fav:
                            fragment = new WhislistFragment();
                            break;
                        case R.id.nav_tiket:
                            fragment = new TiketFragment();
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