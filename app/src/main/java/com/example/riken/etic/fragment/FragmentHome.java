package com.example.riken.etic.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
//        RecyclerView recyclerViewUp;
        FilmAdapter filmAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Miles 22", "Action", R.drawable.mile22));
        }

        recyclerViewOn = v.findViewById(R.id.rc_ongoing);
//        recyclerViewUp = v.findViewById(R.id.rc_upcoming);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        filmAdapter = new FilmAdapter(getContext(), myFilm);
        recyclerViewOn.setLayoutManager(layoutManager);
        recyclerViewOn.setAdapter(filmAdapter);
//        recyclerViewUp.setLayoutManager(layoutManager);
//        recyclerViewUp.setAdapter(filmAdapter);

    }

    public void setMyFilmUp (View v) {
        RecyclerView recyclerViewUp;
        FilmAdapter filmAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Searching", "Drama", R.drawable.searhing));
        }

        recyclerViewUp = v.findViewById(R.id.rc_upcoming);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        filmAdapter = new FilmAdapter(getContext(), myFilm);
        recyclerViewUp.setLayoutManager(layoutManager);
        recyclerViewUp.setAdapter(filmAdapter);
    }


}
