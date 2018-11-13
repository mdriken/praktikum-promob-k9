package com.example.riken.etic.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.models.Film;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    List<Film> myFilm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        setMyFilmOn(view);
        setMyFilmUp(view);
        return view;

    }



    public void setMyFilmOn (View v) {
        RecyclerView recyclerViewOn;
        FilmAdapter filmAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Miles 22", "Action", R.drawable.mile22, "1 jam 20 menit", "Riken Indra","Miles 22"));
            myFilm.add(new Film("Ant Man", "Action", R.drawable.antman, "1 jam 25 menit", "Manusia Semut", "Ant Man"));
            myFilm.add(new Film("Incredibles 2", "Action, Comedy", R.drawable.incredibles, "2 jam 10 menit", "Manusia Karet", "Incredibles 2"));
        }

        recyclerViewOn = v.findViewById(R.id.rc_ongoing);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        filmAdapter = new FilmAdapter(getContext(), myFilm);
        recyclerViewOn.setLayoutManager(layoutManager);
        recyclerViewOn.setAdapter(filmAdapter);

    }

    public void setMyFilmUp (View v) {
        RecyclerView recyclerViewUp;
        FilmAdapter filmAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Searching", "Drama", R.drawable.searhing, "2 Jam 10 Menit", "Wayan Koplar", "Searching"));
            myFilm.add(new Film("Spider-Man", "Action, Animation", R.drawable.spiderman, "2 Jam 10 Menit", "Mr. Gondrong", "Spider-Man"));
            myFilm.add(new Film("Wreck-It Ralph 2", "Animation", R.drawable.wreck, "2 Jam 10 Menit", "Tukang Coding","Wreck-It Ralph"));

        }

        recyclerViewUp = v.findViewById(R.id.rc_upcoming);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        filmAdapter = new FilmAdapter(getContext(), myFilm);
        recyclerViewUp.setLayoutManager(layoutManager);
        recyclerViewUp.setAdapter(filmAdapter);
    }


}
