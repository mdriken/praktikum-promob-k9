package com.example.riken.etic.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.PagerAdapter;
import com.example.riken.etic.fragment.TabJadwalFragment;
import com.example.riken.etic.fragment.TabSinopsisFragment;
import com.example.riken.etic.sqllite.DatabaseHelper;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;


public class DetailFilmActivity extends AppCompatActivity implements TabJadwalFragment.OnFragmentInteractionListener,TabSinopsisFragment.OnFragmentInteractionListener {

   private TextView tvTitle, tvGenre, tvDuration, tvJudulTab;
   private ImageView ivDetail;
    DatabaseHelper myDb;
   public boolean isFavNull;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTitle = (TextView) findViewById(R.id.tv_detail_film_title);
        tvJudulTab = (TextView) findViewById(R.id.tabNamaFilm);
        tvGenre = (TextView) findViewById(R.id.tv_detail_film_genre);
        tvDuration = (TextView) findViewById(R.id.tv_detail_film_duration);
//        tvSutradara = (TextView) findViewById(R.id.tv_detail_film_sutradara);
        ivDetail = (ImageView) findViewById(R.id.iv_detail_film_gambar);

        //receive data
        Intent intent = getIntent();
        final int Id_film = intent.getExtras().getInt("Id film");
        final String Title = intent.getExtras().getString("Title");
        String Judul = intent.getExtras().getString("Title");
        final String Genre = intent.getExtras().getString("Genre");
        final String Duration = intent.getExtras().getString("Duration");
//        String Sutradara = intent.getExtras().getString("Sutradara");
        final int image = intent.getExtras().getInt("Thumbnail");

        //settingvalue
        tvTitle.setText(Title);
        tvGenre.setText(Genre);
        tvDuration.setText(Duration);
        tvJudulTab.setText(Judul);
//        tvSutradara.setText(Sutradara);
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
        myDb=new DatabaseHelper(this);
        isFavNull = myDb.isFavorited(Id_film);
        MaterialFavoriteButton materialFavoriteButtonNice =
                (MaterialFavoriteButton) findViewById(R.id.fav_btn);

        if(isFavNull){
            materialFavoriteButtonNice.setFavorite(false,true);
        }else{
            materialFavoriteButtonNice.setFavorite(true,false);
        }


        materialFavoriteButtonNice.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            myDb.insertWishlistFilm(Id_film,Title,null,Genre,Duration,null,null,null,"dummy");
                            Log.d("test","ini fav");
                        } else {
                            Log.d("test","ini tidak fav");
                            myDb.deleteFav(Id_film);
                        }
                    }
                });
        materialFavoriteButtonNice.setOnFavoriteAnimationEndListener(
                new MaterialFavoriteButton.OnFavoriteAnimationEndListener() {
                    @Override
                    public void onAnimationEnd(MaterialFavoriteButton buttonView, boolean favorite) {
//                        niceCounter.setText(String.valueOf(niceCounterValue));
                    }
                });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }




}


