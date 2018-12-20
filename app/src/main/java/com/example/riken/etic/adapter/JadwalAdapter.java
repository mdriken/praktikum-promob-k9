package com.example.riken.etic.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.riken.etic.BookingActivity;
import com.example.riken.etic.R;
import com.example.riken.etic.models.Jadwal;

import java.util.List;

    public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyViewHolder> {

        private Context context;
        private List<Jadwal> jadwal;

        public JadwalAdapter (Context context, List<Jadwal> jadwal) {
            this.context = context;
            this.jadwal = jadwal;
        }

        @NonNull
        @Override
        public JadwalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.cardiview_bioskop, viewGroup ,false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull JadwalAdapter.MyViewHolder myViewHolder, final int position) {
            myViewHolder.tv_bioskop.setText(jadwal.get(position).getBioskopNamre());
            myViewHolder.tv_harga.setText(jadwal.get(position).getHarga());
            myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BookingActivity.class);
                    context.startActivity(intent);
                }
            });



        }


        @Override
        public int getItemCount() {
            return jadwal.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder{

            TextView tv_bioskop;
            TextView tv_harga;
            CardView cardView;


            public MyViewHolder(View itemView){
                super(itemView);

                tv_bioskop = itemView.findViewById(R.id.tv_nama_bioskop);
                tv_harga = itemView.findViewById(R.id.tv_harga);
                cardView = itemView.findViewById(R.id.cv_list);


            }
        }
    }
