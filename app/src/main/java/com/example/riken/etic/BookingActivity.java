package com.example.riken.etic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.adapter.TanggalAdater;
import com.example.riken.etic.models.Jam;
import com.example.riken.etic.models.Tanggal;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity implements OnSeatSelected{

//    private static final int COLUMNS = 5;
    private static final int COLUMNS = 11;
    private TextView txtSeatSelected;
    List<Tanggal> myTanggal;
    List<Jam> myJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        setTanggal();
        setJam();

        txtSeatSelected = (TextView)findViewById(R.id.txt_seat_selected);

        List<AbstractItem> items = new ArrayList<>();
//        for (int i=0; i<30; i++) {
//
//            if (i%COLUMNS==0 || i%COLUMNS==4) {
//                items.add(new EdgeItem(String.valueOf(i)));
//            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
//                items.add(new CenterItem(String.valueOf(i)));
//            } else {
//                items.add(new EmptyItem(String.valueOf(i)));
//            }
//        }
        for (int i = 0; i<44; i++){
            if (i%COLUMNS==0 || i%COLUMNS==11) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==5) {

                items.add(new EmptyItem(String.valueOf(i)));
            } else {
                items.add(new CenterItem(String.valueOf(i)));
            }

        }



        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_items);
        recyclerView.setLayoutManager(manager);

        SeatAdapter adapter = new SeatAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSeatSelected(int count) {

        txtSeatSelected.setText("Book "+count+" seats");
    }

    public void setTanggal () {
        RecyclerView recyclerViewTgl;
        TanggalAdater tanggalAdater;

        myTanggal = new ArrayList<>();
        for (int i=0; i<7; i++){
            myTanggal.add(new Tanggal("14 DES"));
        }

        recyclerViewTgl = findViewById(R.id.rc_tgl);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        tanggalAdater = new TanggalAdater(this, myTanggal);
        recyclerViewTgl.setLayoutManager(layoutManager);
        recyclerViewTgl.setAdapter(tanggalAdater);

    }

    public void setJam() {
        RecyclerView recyclerViewJam;
        JamAdapter jamAdapter;

        myJam = new ArrayList<>();

        for (int i=0; i<7; i++) {
            myJamadd.add(new Jam("12:00"));
        }

        recyclerViewJam = findViewById(R.id.rc_jam);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        jamAdapter = new JamAdapter(this, myJam);
        recyclerViewJam.setLayoutManager(layoutManager);
        recyclerViewJam.setAdapter(jamAdapter);
    }

}
