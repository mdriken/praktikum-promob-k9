package com.example.riken.etic.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.ApiClient;
import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmTabLayoutAdapter;
import com.example.riken.etic.adapter.JadwalAdapter;
import com.example.riken.etic.models.Film;
import com.example.riken.etic.models.Jadwal;
import com.example.riken.etic.models.ListBioskopResponse;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


public class TabJadwalFragment extends Fragment {

    public String my_token;
//    public List<ListBioskopResponse> bioskop = new ArrayList<>();
    private retrofit2.Call<List<ListBioskopResponse>> call_list_bioskop;
//    public List<ListBioskopResponse> listBioskopResponses = new ArrayList<>();
    public List<ListBioskopResponse> listbioskop = new ArrayList<>();

    public TabJadwalFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        my_token = SharedPrefManager.getmInstance(getContext()).getMyToken();
        View view = inflater.inflate(R.layout.fragment_tab_jadwal, container, false);
        reponseListBioskop(my_token);
        return view;
    }

    public void setMyJadwal () {
        RecyclerView recyclerViewJadwal;
        JadwalAdapter jadwalAdapter;

        

        recyclerViewJadwal = getActivity().findViewById(R.id.rc_bioskop);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        jadwalAdapter = new JadwalAdapter(getContext(), listbioskop);
        recyclerViewJadwal.setLayoutManager(layoutManager);
        recyclerViewJadwal.setAdapter(jadwalAdapter);
    }
    
    
    public void reponseListBioskop(String token){
        Intent intent = getActivity().getIntent();
        int id_film = intent.getExtras().getInt("Id film");
        call_list_bioskop = ApiClient.getApiService().listBioskopTersedia(id_film,token);
        call_list_bioskop.enqueue(new Callback<List<ListBioskopResponse>>() {
            @Override
            public void onResponse(retrofit2.Call<List<ListBioskopResponse>> call, Response<List<ListBioskopResponse>> response) {
                if (response.isSuccessful()){
                    listbioskop = response.body();
                    setMyJadwal();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<ListBioskopResponse>> call, Throwable t) {

            }
        });
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
