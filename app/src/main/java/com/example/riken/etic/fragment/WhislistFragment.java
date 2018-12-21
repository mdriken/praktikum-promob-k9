package com.example.riken.etic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.riken.etic.R;
import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.adapter.WishlistAdapter;
import com.example.riken.etic.models.DataItem;
import com.example.riken.etic.models.Film;
import com.example.riken.etic.sqllite.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class WhislistFragment extends Fragment {

    DatabaseHelper mydb;
    private List<DataItem> dataItems = new ArrayList<>();


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mydb =new DatabaseHelper(getActivity());

        loadSqlLite();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {






        View view = inflater.inflate(R.layout.fragment_whislist,container,false);
        return view;
    }



    private void loadSqlLite(){
        dataItems = mydb.selectFav();
        Log.d("dataitem",""+dataItems);
        int jmlh = dataItems.size();
        setData();
    }

    public void setData(){
        RecyclerView recyclerViewUp;
        WishlistAdapter wishlistAdapter;

        recyclerViewUp = getActivity().findViewById(R.id.rc_favorite);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        Log.d("data items di set data",""+dataItems);
        wishlistAdapter = new WishlistAdapter(getContext(),dataItems);
        recyclerViewUp.setLayoutManager(layoutManager);
        recyclerViewUp.setAdapter(wishlistAdapter);
    }

}
