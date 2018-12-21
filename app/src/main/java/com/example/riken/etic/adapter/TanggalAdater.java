package com.example.riken.etic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.models.Tanggal;

import java.util.List;

public class TanggalAdater extends RecyclerView.Adapter<TanggalAdater.MyViewHolder> {
    private Context context;
    private List <Tanggal> myTanggal;

    public TanggalAdater (Context context, List<Tanggal> myTanggal) {
        this.context = context;
        this.myTanggal = myTanggal;
    }

    @NonNull
    @Override
    public TanggalAdater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_tanggal, viewGroup ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TanggalAdater.MyViewHolder myViewHolder, final int position) {
        myViewHolder.tv_film_tgl.setText(myTanggal.get(position).getTanggal());

    }

    @Override
    public int getItemCount() {
        return myTanggal.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_film_tgl;




        public MyViewHolder(View itemView) {
            super(itemView);

            tv_film_tgl = itemView.findViewById(R.id.tv_tgl_tgl);



        }
    }
}
