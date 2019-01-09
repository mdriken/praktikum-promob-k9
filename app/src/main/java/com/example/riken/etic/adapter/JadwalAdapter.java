package com.example.riken.etic.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.riken.etic.BookingActivity;
import com.example.riken.etic.R;
import com.example.riken.etic.models.Jadwal;
import com.example.riken.etic.models.ListBioskopResponse;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.List;

    public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.MyViewHolder> {

        private Context context;
        private List<Jadwal> jadwal;
        private List<ListBioskopResponse> listBioskopResponses;
        public int row_index;
        SharedPrefManager sp;


        public JadwalAdapter (Context context, List<ListBioskopResponse> listBioskopResponses) {
            this.context = context;
            this.listBioskopResponses = listBioskopResponses;
        }

        @NonNull
        @Override
        public JadwalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.cardiview_bioskop, viewGroup ,false);

            sp = new SharedPrefManager(context);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull JadwalAdapter.MyViewHolder myViewHolder, final int position) {
//            myViewHolder.tv_bioskop.setText(jadwal.get(position).getBioskopNamre());
//            myViewHolder.tv_harga.setText(jadwal.get(position).getHarga());
            myViewHolder.tv_bioskop.setText(listBioskopResponses.get(position).getNamaBioskop());
            myViewHolder.tv_harga.setText(String.valueOf(listBioskopResponses.get(position).getHarga()));
//            myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//
//                    Intent intent = new Intent(context, DetailFilmActivity.class);
//                    //parsing data to detail
//                    intent.putExtra("Title", films.get(position).getTitle());
//                    intent.putExtra("Genre", films.get(position).getGenre());
//                    intent.putExtra("Duration", films.get(position).getDuration());
////        intent.putExtra("Sutradara", films.get(position).getSutradara());
//                    intent.putExtra("Thumbnail", films.get(position).getThumbnails());
//                    intent.putExtra("Judul", films.get(position).getJudulTab());
//                    context.startActivity(intent);
//
//                }
//            });

//        Intent intent = new Intent(context, TestView.class);
//        intent.p

            myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id1 = listBioskopResponses.get(position).getIdBioskop();
                    int id2 = listBioskopResponses.get(position).getId();

                    Log.wtf("idnyaa", "Bioskop "+id1+ " ID" +  id2);
                    Intent intent = new Intent(context, BookingActivity.class);
                    sp.setIdBioskop(SharedPrefManager.ID_BIOSKOP, listBioskopResponses.get(position).getIdBioskop());
                    context.startActivity(intent);
                }
            });






        }


        @Override
        public int getItemCount() {
            return listBioskopResponses.size();
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
