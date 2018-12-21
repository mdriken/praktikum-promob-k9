package com.example.riken.etic.adapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.riken.etic.R;
import com.example.riken.etic.models.FieldTiket;

import java.util.ArrayList;


public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.TiketViewHolder>{

    private  ArrayList<FieldTiket> dataList;

    public TiketAdapter(ArrayList<FieldTiket> dataList) {
        this.setDataList(dataList);
    }

    @Override
    public TiketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_ticket, parent, false);
        return new TiketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TiketViewHolder holder, int position) {
        holder.label_film1.setText(getDataList().get(position).getNama_film());
        holder.label_bioskop1.setText(getDataList().get(position).getBioskop());
        holder.label_seat1.setText(getDataList().get(position).getSeat());
        holder.label_jam1.setText(getDataList().get(position).getJam());
        holder.label_tanggal1.setText(getDataList().get(position).getTanggal());
        holder.label_status1.setText(getDataList().get(position).getStatus());

    }

    @Override
    public int getItemCount () {
        return (getDataList() != null) ? getDataList().size() : 0;
    }

    public  ArrayList<FieldTiket> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<FieldTiket> dataList) {
        this.dataList = dataList;
    }

    public class TiketViewHolder extends RecyclerView.ViewHolder {
        private TextView label_film1, label_bioskop1, label_seat1, label_jam1, label_tanggal1, label_status1;


        public TiketViewHolder(View itemView) {
            super(itemView);
            label_film1 = (TextView) itemView.findViewById(R.id.label_film);
            label_bioskop1 = (TextView) itemView.findViewById(R.id.label_bioskop);
            label_seat1 = (TextView) itemView.findViewById(R.id.label_seat);
            label_jam1 = (TextView) itemView.findViewById(R.id.label_jam);
            label_tanggal1 = (TextView) itemView.findViewById(R.id.label_tanggal);
            label_jam1 = (TextView) itemView.findViewById(R.id.label_jam);
            label_status1 = (TextView) itemView.findViewById(R.id.label_status);
        }


    }


}
