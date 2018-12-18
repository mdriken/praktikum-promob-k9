package com.example.riken.etic.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.riken.etic.ApiClient;
import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmTabLayoutAdapter;
import com.example.riken.etic.models.DataItem;
import com.example.riken.etic.models.Film;
import com.example.riken.etic.models.SedangTayangResponse;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AkanTayangFragment extends Fragment  {

    List<DataItem> mydataItem;
    List<DataItem> mydataItemUp;
    private Call<SedangTayangResponse> call_sedang_tayang;
    private Call<SedangTayangResponse> call_akan_tayang;
    public String my_token;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        my_token = SharedPrefManager.getmInstance(getContext()).getMyToken();
        Toast.makeText(getContext(),my_token, Toast.LENGTH_SHORT).show();
        Log.d("api_code",my_token);

        setAkantayang(my_token);


    }

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


//        myFilm = new ArrayList<>();
//
//        for (int i=0; i<3; i++){
//            myFilm.add(new Film("Searching", "Drama", R.drawable.searhing, "2 Jam 10 Menit", "Wayan Koplar", "Searching"));
//            myFilm.add(new Film("Spider-Man", "Action, Animation", R.drawable.spiderman, "2 Jam 10 Menit", "Mr. Gondrong", "Spider-Man"));
//            myFilm.add(new Film("Wreck-It Ralph 2", "Animation", R.drawable.wreck, "2 Jam 10 Menit", "Tukang Coding","Wreck-It Ralph"));
//
//        }

        recyclerViewAkan = v.findViewById(R.id.rc_akan);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        filmTabLayoutAdapter = new FilmTabLayoutAdapter(getContext(), mydataItemUp);
        recyclerViewAkan.setLayoutManager(layoutManager);
        recyclerViewAkan.setAdapter(filmTabLayoutAdapter);
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }



    public void setAkantayang(String token){

        call_akan_tayang = ApiClient.getApiService().akantayang(token);
        call_akan_tayang.enqueue(new Callback<SedangTayangResponse>() {
            @Override
            public void onResponse(Call<SedangTayangResponse> call, Response<SedangTayangResponse> response) {
                if(response.code()==200){
                    mydataItemUp = response.body().getData();
                }
            }

            @Override
            public void onFailure(Call<SedangTayangResponse> call, Throwable t) {

            }
        });


    }
}
