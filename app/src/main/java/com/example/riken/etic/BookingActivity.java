package com.example.riken.etic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.riken.etic.adapter.TanggalAdater;
import com.example.riken.etic.models.Jam;
import com.example.riken.etic.models.Tanggal;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity
//        implements OnSeatSelected
{


//    private static final int COLUMNS = 5;

//    private static final int COLUMNS = 11;
//    private TextView txtSeatSelected;

    ArrayList<String> listbooked = new ArrayList<String>();

    List<Tanggal> myTanggal;
    List<Jam> myJam;
    ElegantNumberButton btnCount;

//    Spinner spinner;
//    CustomAdapter adapters;
//    String[] names = {
//            "A1", "A2","A3","A4","A5","A6","A7","A8","A9","A10",
//            "B1", "B2","B3","B4","B5","B6","B7","B8","B9","B10",
//            "C1", "C2","C3","C4","C5","C6","C7","C8","C9","C10",
//            "D1", "D2","D3","D4","D5","D6","D7","D8","D9","D10"
//    };

//    int[] images = {R.drawable.iv_seat_black};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


        setTanggal();
        setJam();

        btnCount = (ElegantNumberButton) findViewById(R.id.btnCount);
        btnCount.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=btnCount.getNumber();
                Log.e("NUM", num);
            }
        });
//        txtSeatSelected = (TextView)findViewById(R.id.txt_seat_selected);
//
//        List<AbstractItem> items = new ArrayList<>();

        //gakkdipakaek
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

        //ini yang dipakek
//        for (int i = 0; i<44; i++){
//            if (i%COLUMNS==0 || i%COLUMNS==11) {
//                items.add(new EdgeItem(String.valueOf(i)));
//            } else if (i%COLUMNS==5) {
//
//                items.add(new EmptyItem(String.valueOf(i)));
//            } else {
//                items.add(new CenterItem(String.valueOf(i)));
//            }
//
//        }
//
//
//
//        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_items);
//        recyclerView.setLayoutManager(manager);
//
//        SeatAdapter adapter = new SeatAdapter(this, items);
//        recyclerView.setAdapter(adapter);

//        spinner = (Spinner)findViewById(R.id.spinner);
//        adapters = new CustomAdapter(this, names);
//        spinner.setSelection(0);
//        spinner.setAdapter(adapters);
//        spinner.post(new Runnable() {
//            @Override
//            public void run() {
//                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                        listbooked.add(names[i]);
//                        Toast.makeText(getApplicationContext(),""+listbooked, Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> adapterView) {
//
//                    }
//                });
//
//            }
//        });

    }


//    @Override
//    public void onSeatSelected(int count) {
//
//        txtSeatSelected.setText("Book "+count+" seats");
//    }

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
            myJam.add(new Jam("12:00"));
        }

        recyclerViewJam = findViewById(R.id.rc_jam);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        jamAdapter = new JamAdapter(this, myJam);
        recyclerViewJam.setLayoutManager(layoutManager);
        recyclerViewJam.setAdapter(jamAdapter);
    }

}
