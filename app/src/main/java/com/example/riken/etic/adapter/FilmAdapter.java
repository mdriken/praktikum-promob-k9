package com.example.riken.etic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.models.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {

    private Context context;
    private List<Film> films;

    public FilmAdapter (Context context, List<Film> films) {
        this.context = context;
        this.films = films;
    }

    @NonNull
    @Override
    public FilmAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.shapeview_film, viewGroup ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.iv_film_bg.setImageResource(films.get(position).getThumbnails());
        myViewHolder.tv_film_genre.setText(films.get(position).getGenre());
        myViewHolder.tv_film.setText(films.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return films.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_film_bg;
        TextView tv_film;
        TextView tv_film_genre;


        public MyViewHolder(View itemView){
            super(itemView);

            iv_film_bg = itemView.findViewById(R.id.iv_fim_bg_next);
            tv_film = itemView.findViewById(R.id.tv_film_name_next);
            tv_film_genre = itemView.findViewById(R.id.tv_film_genre);

        }
    }
}