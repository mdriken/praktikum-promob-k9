package com.example.riken.etic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.riken.etic.R;
import com.example.riken.etic.activity.DetailFilmActivity;
import com.example.riken.etic.models.DataItem;
import com.example.riken.etic.models.Film;

import java.util.List;

public class FilmTabLayoutAdapter extends RecyclerView.Adapter<FilmTabLayoutAdapter.MyViewHolder> {

    private Context context;
    private List<Film> films ;
    private List<DataItem> dataItems;
    public final String Url = "http://172.17.100.2:8000/img/";
//    public final String Url = "http://192.168.43.160:8000/img/";
    public FilmTabLayoutAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public FilmTabLayoutAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_tab_selengkapnya, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmTabLayoutAdapter.MyViewHolder myViewHolder, final int position) {
        final DataItem dataItem = dataItems.get(position);
        Glide.with(myViewHolder.itemView).load(Url+dataItems.get(position).getFotoFilm()).into(myViewHolder.iv_film_bg);
//        myViewHolder.iv_film_bg.setImageResource(R.drawable.searhing);
        myViewHolder.tv_film_genre.setText(dataItem.getNamaGenre());
        myViewHolder.tv_film.setText(dataItem.getNamaFilm());
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intent = new Intent(context, DetailFilmActivity.class);
                //parsing data to detail
                Intent intent = new Intent(context,DetailFilmActivity.class);
                intent.putExtra("Id film",dataItems.get(position).getId());
                intent.putExtra("Title",dataItems.get(position).getNamaFilm());
                intent.putExtra("Genre",dataItems.get(position).getNamaGenre());
                intent.putExtra("Duration",dataItems.get(position).getDurasi());
                intent.putExtra("Thumbnail", R.drawable.searhing);
                intent.putExtra("Judul",dataItems.get(position).getNamaFilm());
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                context.startActivity(intent);

            }
        });

//        Intent intent = new Intent(context, TestView.class);
//        intent.p


    }


    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_film_bg;
        TextView tv_film;
        TextView tv_duration;
        TextView tv_film_genre;
        CardView cardView;


        public MyViewHolder(View itemView) {
            super(itemView);

            iv_film_bg = itemView.findViewById(R.id.iv_detail_film_gambar_tab);
            tv_film = itemView.findViewById(R.id.tv_detail_film_title_tab);
            tv_film_genre = itemView.findViewById(R.id.tv_detail_film_genre_tab);
            tv_duration = itemView.findViewById(R.id.tv_detail_film_duration_tab);
            cardView = itemView.findViewById(R.id.cv_layout_sedang);


        }
    }
}

