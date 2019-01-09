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

import com.example.riken.etic.R;
import com.example.riken.etic.activity.DetailFilmActivity;
import com.example.riken.etic.models.DataItem;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {

    private Context context;
//    private List<Film> films;
    private List<DataItem> dataItems = new ArrayList<>();
    SharedPrefManager sp;



    public FilmAdapter (Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @NonNull
    @Override
    public FilmAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        sp = new SharedPrefManager(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.shapeview_film, viewGroup ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        final DataItem dataItem = dataItems.get(position);
        myViewHolder.tv_film_genre.setText(dataItem.getNamaGenre());
        myViewHolder.tv_film.setText(dataItem.getNamaFilm());
        myViewHolder.iv_film_bg.setImageResource(R.drawable.searhing);

        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,DetailFilmActivity.class);
                sp.setIdFilm(SharedPrefManager.ID_FILM,dataItems.get(position).getId());
                intent.putExtra("Id film",dataItems.get(position).getId());
                intent.putExtra("Title",dataItems.get(position).getNamaFilm());
                intent.putExtra("Genre",dataItems.get(position).getNamaGenre());
                intent.putExtra("Duration",dataItems.get(position).getDurasi());
                intent.putExtra("Thumbnail", R.drawable.searhing);
                intent.putExtra("Judul",dataItems.get(position).getNamaFilm());

                context.startActivity(intent);
            }
        });




    }


    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_film_bg;
        TextView tv_film;
        TextView tv_film_genre;
        CardView cardView;


        public MyViewHolder(View itemView){
            super(itemView);

            iv_film_bg = itemView.findViewById(R.id.iv_fim_bg_next);
            tv_film = itemView.findViewById(R.id.tv_film_name_next);
            tv_film_genre = itemView.findViewById(R.id.tv_film_genre);
            cardView = itemView.findViewById(R.id.cv_film_bg_next);


        }
    }
}