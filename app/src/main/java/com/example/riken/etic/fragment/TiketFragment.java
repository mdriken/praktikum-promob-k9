package com.example.riken.etic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.R;
import com.example.riken.etic.models.FieldTiket;
import com.example.riken.etic.adapter.TiketAdapter;

import java.util.ArrayList;


public class TiketFragment extends Fragment {
    private RecyclerView recyclerView;
    private TiketAdapter adapter;
    ArrayList<FieldTiket> TiketFieldsArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tiket,container,false);
        super.onCreate(savedInstanceState);
;

        addData();

        recyclerView = view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new TiketAdapter(TiketFieldsArrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;

    }

    public void addData(){
        TiketFieldsArrayList =  new ArrayList<>();
        TiketFieldsArrayList.add(new FieldTiket("Mahasiswa dan Dosen", "Xnxx", "A1", "14:25", "25 Desember 2018", "Belum Lunas"));
        TiketFieldsArrayList.add(new FieldTiket("Mahasiswa dan Dosen", "Xnxx", "A2", "14:25", "25 Desember 2018", "Belum Lunas"));
        TiketFieldsArrayList.add(new FieldTiket("Maria Ozaawa", "TIx", "A2", "14:25", "25 Desember 2018", "Belum Lunas"));
    }



}




