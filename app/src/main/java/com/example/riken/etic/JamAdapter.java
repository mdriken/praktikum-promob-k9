package com.example.riken.etic;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.riken.etic.models.Jam;
import com.example.riken.etic.models.JamTersediaResponse;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class JamAdapter extends RecyclerView.Adapter<JamAdapter.MyViewHolder> {
    private Context context;
    private List<JamTersediaResponse> jamTersediaResponses = new ArrayList<>();
    private List<Jam> myJam;
    public int row_index;
    SharedPrefManager sp;

    public JamAdapter (Context context,List<Jam> myJam) {
        this.context = context;
        this.myJam = myJam;
    }

    @NonNull
    @Override
    public JamAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        sp = new SharedPrefManager(this.context);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_jam, viewGroup ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JamAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.tv_film_jam.setText(myJam.get(position).getJam());


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sp.setIdFilm(SharedPrefManager.ID_FILM,dataItems.get(position).getId());
                sp.setStringJam(SharedPrefManager.JAM,myJam.get(position).getJam());
                row_index = position;
                notifyDataSetChanged();
            }
        });
        if(row_index==position){
            myViewHolder.cardView.setCardBackgroundColor(Color.parseColor("#567845"));
            myViewHolder.tv_film_jam.setTextColor(Color.parseColor("#ffffff"));
        }else
        {
            myViewHolder.cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
            myViewHolder.tv_film_jam.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return myJam.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_film_jam;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_film_jam = itemView.findViewById(R.id.tv_jam_tyg);
            cardView = itemView.findViewById(R.id.cv_jam);
        }
    }
}
