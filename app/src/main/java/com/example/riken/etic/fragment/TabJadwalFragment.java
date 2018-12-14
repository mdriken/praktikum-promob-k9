package com.example.riken.etic.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmTabLayoutAdapter;
import com.example.riken.etic.adapter.JadwalAdapter;
import com.example.riken.etic.models.Film;
import com.example.riken.etic.models.Jadwal;

import java.util.ArrayList;
import java.util.List;


public class TabJadwalFragment extends Fragment {

    List<Jadwal> myJadwal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_jadwal, container, false);
        setMyJadwal(view);
        return view;
    }

    public void setMyJadwal (View v) {
        RecyclerView recyclerViewJadwal;
        JadwalAdapter jadwalAdapter;

        myJadwal = new ArrayList<>();

        for (int i=0; i<3; i++){
            myJadwal.add(new Jadwal("Level 21", "Rp40.000/orang"));

        }

        recyclerViewJadwal = v.findViewById(R.id.rc_bioskop);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        jadwalAdapter = new JadwalAdapter(getContext(), myJadwal);
        recyclerViewJadwal.setLayoutManager(layoutManager);
        recyclerViewJadwal.setAdapter(jadwalAdapter);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
