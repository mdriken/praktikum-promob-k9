package com.example.riken.etic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.riken.etic.models.Jam;

import java.util.List;

public class JamAdapter extends RecyclerView.Adapter<JamAdapter.MyViewHolder> {
    private Context context;
    private List<Jam> myJam;

    public JamAdapter (Context context, List<Jam> myJam) {
        this.context = context;
        this.myJam = myJam;
    }

    @NonNull
    @Override
    public JamAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_jam, viewGroup ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JamAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.tv_film_jam.setText(myJam.get(position).getJam());

    }

    @Override
    public int getItemCount() {
        return myJam.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_film_jam;




        public MyViewHolder(View itemView) {
            super(itemView);

            tv_film_jam = itemView.findViewById(R.id.tv_jam_tyg);



        }
    }
}
