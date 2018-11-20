package com.example.riken.etic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.adapter.FilmTabLayoutAdapter;
import com.example.riken.etic.models.Film;

import java.util.ArrayList;
import java.util.List;


public class FragmentSedangTayang extends Fragment {

    List<Film> myFilm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sedang_tayang, container, false);

        setMyFilmSedang(view);
        return view;
    }

    public void setMyFilmSedang (View v) {
        RecyclerView recyclerViewOn;
        FilmTabLayoutAdapter filmTabLayoutAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Miles 22", "Action", R.drawable.mile22, "1 jam 20 menit", "Riken Indra","Miles 22"));
            myFilm.add(new Film("Ant Man", "Action", R.drawable.antman, "1 jam 25 menit", "Manusia Semut", "Ant Man"));
            myFilm.add(new Film("Incredibles 2", "Action, Comedy", R.drawable.incredibles, "2 jam 10 menit", "Manusia Karet", "Incredibles 2"));
        }

        recyclerViewOn = v.findViewById(R.id.rc_sedang);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        filmTabLayoutAdapter = new FilmTabLayoutAdapter(getContext(), myFilm);
        recyclerViewOn.setLayoutManager(layoutManager);
        recyclerViewOn.setAdapter(filmTabLayoutAdapter);

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
