package com.example.riken.etic;

import android.content.Context;
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


public class AkanTayangFragment extends Fragment  {

    List<Film> myFilm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_akan_tayang, container, false);
        setMyFilmSedang(view);
        return view;
    }

    public void setMyFilmSedang (View v) {
        RecyclerView recyclerViewAkan;
        FilmTabLayoutAdapter filmTabLayoutAdapter;

        myFilm = new ArrayList<>();

        for (int i=0; i<3; i++){
            myFilm.add(new Film("Searching", "Drama", R.drawable.searhing, "2 Jam 10 Menit", "Wayan Koplar", "Searching"));
            myFilm.add(new Film("Spider-Man", "Action, Animation", R.drawable.spiderman, "2 Jam 10 Menit", "Mr. Gondrong", "Spider-Man"));
            myFilm.add(new Film("Wreck-It Ralph 2", "Animation", R.drawable.wreck, "2 Jam 10 Menit", "Tukang Coding","Wreck-It Ralph"));

        }

        recyclerViewAkan = v.findViewById(R.id.rc_akan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        filmTabLayoutAdapter = new FilmTabLayoutAdapter(getContext(), myFilm);
        recyclerViewAkan.setLayoutManager(layoutManager);
        recyclerViewAkan.setAdapter(filmTabLayoutAdapter);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
