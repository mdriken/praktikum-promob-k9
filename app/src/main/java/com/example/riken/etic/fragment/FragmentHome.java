package com.example.riken.etic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.models.Film;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    List<Film> myFilm;
    ImageView nextlayout, akantayang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

//       ImageView imageView = (ImageView) view.findViewById(R.id.next_akantayang);
//       imageView.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//              AkanTayangFragment akanTayangFragment = new AkanTayangFragment();
//              FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//               fragmentManager.beginTransaction()
//                       .replace(R.id.frag_layout, akanTayangFragment)
//                       .commit();
//
//           }
//       });

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



    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // get the button view
        nextlayout = (ImageView) getView().findViewById(R.id.next_sedangtayang);
        akantayang = (ImageView) getView().findViewById(R.id.next_akantayang);
        // set a onclick listener for when the button gets clicked
        nextlayout.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(),
                      MainFilmTablayout.class);
                startActivity(mainIntent);
            }
        });

        akantayang.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(),
                        MainFilmTablayout.class);
                startActivity(mainIntent);
            }
        });
    }




}
