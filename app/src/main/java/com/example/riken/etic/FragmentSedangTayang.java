package com.example.riken.etic;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.riken.etic.adapter.FilmAdapter;
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


public class FragmentSedangTayang extends Fragment {

    public List<DataItem> mydataItem;
    private Call<SedangTayangResponse> call_sedang_tayang;
    public String my_token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sedang_tayang, container, false);
        my_token = SharedPrefManager.getmInstance(getContext()).getMyToken();
        sedangTayang(my_token);
        return view;
    }

    public void setMyFilmSedang () {
        RecyclerView recyclerViewOn;
        FilmTabLayoutAdapter filmTabLayoutAdapter;



        recyclerViewOn = getActivity().findViewById(R.id.rc_sedang);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        filmTabLayoutAdapter = new FilmTabLayoutAdapter(getContext(), mydataItem);
        recyclerViewOn.setLayoutManager(layoutManager);
        recyclerViewOn.setAdapter(filmTabLayoutAdapter);

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
    public void sedangTayang(String token){

        call_sedang_tayang = ApiClient.getApiService().sedangtayang(token);
        call_sedang_tayang.enqueue(new Callback<SedangTayangResponse>() {
            @Override
            public void onResponse(Call<SedangTayangResponse> call, Response<SedangTayangResponse> response) {
                Toast.makeText(getContext(), ""+response.code(), Toast.LENGTH_SHORT).show();
                if(response.code()==200){
                    mydataItem = response.body().getData();
                    setMyFilmSedang();
                    Toast.makeText(getContext(), "masuk", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "masuk tp gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SedangTayangResponse> call, Throwable t) {
                Toast.makeText(getContext(), "ga mau bgst", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
