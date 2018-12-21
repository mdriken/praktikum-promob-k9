package com.example.riken.etic.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.riken.etic.ApiClient;
import com.example.riken.etic.JsonPlaceHolderApi;
import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.models.DataItem;
import com.example.riken.etic.models.Film;
import com.example.riken.etic.models.SedangTayangResponse;
import com.example.riken.etic.storage.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    public List<DataItem> mydataItem  = new ArrayList<>();
    public List<DataItem> mydataItemUp = new ArrayList<>();
    private JsonPlaceHolderApi call_sedang_tayang;
    private Call<SedangTayangResponse> call_akan_tayang;
    public String my_token;
    ImageView nextlayout, akantayang;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        my_token = SharedPrefManager.getmInstance(getContext()).getMyToken();
        Toast.makeText(getContext(),my_token, Toast.LENGTH_SHORT).show();
        sedangTayang(my_token);
        setAkantayang(my_token);
        Log.d("api_code",my_token);
        Log.d("data",""+mydataItem);
        Log.d("data1",""+mydataItemUp);
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        Log.d("create","ini on  create view");
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



//        setMyFilmOn(view);
//        setMyFilmUp(view);

        return view;



    }

    public void setMyFilmOn () {
        RecyclerView recyclerViewOn;
        FilmAdapter filmAdapter;


        recyclerViewOn = getActivity().findViewById(R.id.rc_ongoing);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
        LinearLayoutManager.HORIZONTAL, false);
        Log.d("mydataitem",""+mydataItem);
        filmAdapter = new FilmAdapter(getContext(), mydataItem);
        recyclerViewOn.setLayoutManager(layoutManager);
        recyclerViewOn.setAdapter(filmAdapter);

    }

    public void setMyFilmUp () {
        RecyclerView recyclerViewUp;
        FilmAdapter filmAdapter;

        recyclerViewUp = getActivity().findViewById(R.id.rc_upcoming);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        Log.d("mydataitemup",""+mydataItemUp);
        filmAdapter = new FilmAdapter(getContext(), mydataItemUp);

        recyclerViewUp.setLayoutManager(layoutManager);
        recyclerViewUp.setAdapter(filmAdapter);
    }



    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("create","ini on Activity create");
        // get the button view
        nextlayout = getView().findViewById(R.id.next_sedangtayang);
        akantayang = getView().findViewById(R.id.next_akantayang);
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

    public void sedangTayang(String token){
        Log.d("masuk sedang tayang","masuk fungsi sedang tayang"+token);
        call_sedang_tayang = ApiClient.getApiService();
        call_sedang_tayang.sedangtayang(token).enqueue(new Callback<SedangTayangResponse>() {
            @Override
            public void onResponse(Call<SedangTayangResponse> call, Response<SedangTayangResponse> response) {
                mydataItem = response.body().getData();
                setMyFilmOn();
                Log.d("sukses",""+response.body().getData());
                Log.d("sukses mydataItem",""+mydataItem );
            }
            @Override
            public void onFailure(Call<SedangTayangResponse> call, Throwable t) {
                Log.d("sukses",""+t.getMessage());
            }


        });
//        call_sedang_tayang.enqueue(new Callback<SedangTayangResponse>() {
//            @SuppressLint("LongLogTag")
//            @Override
//            public void onResponse(Call<SedangTayangResponse> call, Response<SedangTayangResponse> response) {
//                SedangTayangResponse sedangTayangResponse = response.body();
////
//                Log.d("response code","respon code "+response.body());
//                if (response.isSuccessful()){
//                    mydataItem = response.body().getData();
//                    Log.d("mydataitem",""+mydataItem);
//                }else{
//                    Log.d("gagal","error 400");
//                }
////                if(response.code()==200){
////                    mydataItem = response.body().getData();
////                    Log.d("mydataitem",""+mydataItem);
////                    Toast.makeText(getContext(), "masuk", Toast.LENGTH_SHORT).show();
////                }else{
////                    Log.d("response ditolak kayak abhi","gagal");
////                    Toast.makeText(getContext(), "masuk tp gagal", Toast.LENGTH_SHORT).show();
////                }
//            }
//
//            @Override
//            public void onFailure(Call<SedangTayangResponse> call, Throwable t) {
//                Toast.makeText(getContext(), "ga mau bgst", Toast.LENGTH_SHORT).show();
//                Log.d("gagal","respon code 500");
//            }
//        });
//

    }

    public void setAkantayang(String token){

        call_akan_tayang = ApiClient.getApiService().akantayang(token);
        call_akan_tayang.enqueue(new Callback<SedangTayangResponse>() {
            @Override
            public void onResponse(Call<SedangTayangResponse> call, Response<SedangTayangResponse> response) {
                if(response.code()==200){
                    mydataItemUp = response.body().getData();
                    setMyFilmUp();
                    Log.d("masuk","masuk ke api dan benar");
                }

            }

            @Override
            public void onFailure(Call<SedangTayangResponse> call, Throwable t) {
                Log.d("error","tidak masuk");
            }
        });


    }




}
