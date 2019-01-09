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
import com.example.riken.etic.models.DataItem;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.MyViewHolder> {

    private Context context;

    private List<DataItem> dataItems= new ArrayList<>();



    public WishlistAdapter(Context context,List<DataItem> dataitems){
        this.context = context;
        this.dataItems = dataitems;



    }


    @NonNull
    @Override
    public WishlistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.list_whislist,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        final DataItem dataItem = dataItems.get(i);
        viewHolder.iv_detail_film_gambar_fav.setImageResource(R.drawable.searhing);
        viewHolder.tv_genre.setText(dataItem.getNamaGenre());
        viewHolder.tv_durasi.setText(dataItem.getDurasi());
        viewHolder.tv_detail_film_title_fav.setText(dataItem.getNamaFilm());

    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_detail_film_gambar_fav;
        TextView tv_detail_film_title_fav;
        TextView tv_genre;
        TextView tv_durasi;


        public MyViewHolder(View itemView){
            super(itemView);

            iv_detail_film_gambar_fav = itemView.findViewById(R.id.iv_detail_film_gambar_fav);
            tv_detail_film_title_fav =itemView.findViewById(R.id.tv_detail_film_title_fav);
            tv_genre = itemView.findViewById(R.id.tv_detail_film_genre_fav);
            tv_durasi = itemView.findViewById(R.id.tv_detail_film_duration_fav);


        }
    }

}
