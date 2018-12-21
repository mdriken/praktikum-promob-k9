package com.example.riken.etic.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.riken.etic.models.Tanggal;
import com.example.riken.etic.storage.SharedPrefManager;
import com.luseen.datelibrary.DateHelper;

import java.util.Date;
import java.util.List;

public class TanggalAdater extends RecyclerView.Adapter<TanggalAdater.MyViewHolder> {
    private Context context;
    private List <Tanggal> myTanggal;
    Date currentDate;
    int year;
    int row_index;
    SharedPrefManager sp;

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
        sp = new SharedPrefManager(context);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TanggalAdater.MyViewHolder myViewHolder, final int position) {
        myViewHolder.tv_film_tgl.setText(myTanggal.get(position).getTanggal());

        myViewHolder.tv_film_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate = new Date();
                row_index = position;
                notifyDataSetChanged();
                DateHelper dateHelper = new DateHelper(currentDate);
                year = dateHelper.getIntYear();
                Intent intent = new Intent("tgl_selected");
                intent.putExtra("tgl",myTanggal.get(position).getTanggal());
                intent.putExtra("thn",year);
                sp.setIiJadwal(SharedPrefManager.ID_JADWAL,year+" "+myTanggal.get(position).getTanggal());

                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

            }
        });
        if(row_index==position){
            myViewHolder.tv_film_tgl.setTextColor(Color.parseColor("#ffffff"));
            myViewHolder.mycard.setCardBackgroundColor(Color.parseColor("#567845"));
        }else{
            myViewHolder.mycard.setCardBackgroundColor(Color.parseColor("#ffffff"));
            myViewHolder.tv_film_tgl.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return myTanggal.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_film_tgl;
        CardView mycard;



        public MyViewHolder(View itemView) {
            super(itemView);

            tv_film_tgl = itemView.findViewById(R.id.tv_tgl_tgl);
            mycard = itemView.findViewById(R.id.cv_tgl_book);


        }
    }
}
