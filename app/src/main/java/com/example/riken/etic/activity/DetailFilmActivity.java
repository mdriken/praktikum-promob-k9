package com.example.riken.etic.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.PagerAdapter;
import com.example.riken.etic.fragment.TabJadwalFragment;
import com.example.riken.etic.fragment.TabSinopsisFragment;


public class DetailFilmActivity extends AppCompatActivity implements TabJadwalFragment.OnFragmentInteractionListener,TabSinopsisFragment.OnFragmentInteractionListener {

   private TextView tvTitle, tvGenre, tvDuration, tvSutradara;
   private ImageView ivDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvTitle = (TextView) findViewById(R.id.tv_detail_film_title);
        tvGenre = (TextView) findViewById(R.id.tv_detail_film_genre);
        tvDuration = (TextView) findViewById(R.id.tv_detail_film_duration);
        tvSutradara = (TextView) findViewById(R.id.tv_detail_film_sutradara);
        ivDetail = (ImageView) findViewById(R.id.iv_detail_film_gambar);

        //receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Genre = intent.getExtras().getString("Genre");
        String Duration = intent.getExtras().getString("Duration");
        String Sutradara = intent.getExtras().getString("Sutradara");
        int image = intent.getExtras().getInt("Thumbnail");

        //settingvalue
        tvTitle.setText(Title);
        tvGenre.setText(Genre);
        tvDuration.setText(Duration);
        tvSutradara.setText(Sutradara);
        ivDetail.setImageResource(image);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Jadwal"));
        tabLayout.addTab(tabLayout.newTab().setText("Sinopsis"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}


