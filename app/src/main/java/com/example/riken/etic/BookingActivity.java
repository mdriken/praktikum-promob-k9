package com.example.riken.etic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.riken.etic.adapter.CustomAdapter;
import com.example.riken.etic.adapter.FilmAdapter;
import com.example.riken.etic.adapter.TanggalAdater;
import com.example.riken.etic.models.Jam;
import com.example.riken.etic.models.JamTersediaResponse;
import com.example.riken.etic.models.KursiTersediaResponse;
import com.example.riken.etic.models.Tanggal;
import com.example.riken.etic.storage.SharedPrefManager;
import com.luseen.datelibrary.DateHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity
//        implements OnSeatSelected
{

    SharedPrefManager sp;
//    private static final int COLUMNS = 5;

//    private static final int COLUMNS = 11;
//    private TextView txtSeatSelected;
    List<KursiTersediaResponse>  myKursi = new ArrayList<>();
    ArrayList<String> listbooked = new ArrayList<String>();

    ArrayList<String> mylist = new ArrayList<String>();


    List<Jam> myJam;
    Button cari_btn;
    int id_bioskops;
    int id_films;
    String jadwal;
    public String[] names;

  private Call<List<KursiTersediaResponse>> call_kursi;

    public List<JamTersediaResponse> jamTersediaResponses = new ArrayList<>();
    String my_token = SharedPrefManager.getmInstance(getBaseContext()).getMyToken();

    List<Tanggal> myTanggal;

//    List<Jam> myJam;
    String Tanggal;
    Spinner spinner;
    CustomAdapter adapters;
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

        sp = new SharedPrefManager(this);
        setTanggal();
        setJam();
//        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver,new IntentFilter("my-event"));
        id_bioskops = sp.getIdBioskop(SharedPrefManager.ID_BIOSKOP);
        id_films = sp.getIdFilm(SharedPrefManager.ID_FILM);



        Toast.makeText(this, ""+id_bioskops+" "+id_films, Toast.LENGTH_SHORT).show();

        spinner = (Spinner)findViewById(R.id.spinner);



        findViewById(R.id.btn_cari_kursi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tgl = sp.getIdJadwal(SharedPrefManager.ID_JADWAL);
                String jam = sp.getTanggal(SharedPrefManager.JAM);

                cariKursi(id_bioskops,id_films,tgl,jam,my_token);


                Toast.makeText(BookingActivity.this, "clicked", Toast.LENGTH_SHORT).show();

            }
        });

        spinner.post(new Runnable() {
            @Override
            public void run() {
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        listbooked.add(mylist.get(i));
                        Toast.makeText(getApplicationContext(),""+listbooked, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }
        });


    }


//    @Override
//    public void onSeatSelected(int count) {
//
//        txtSeatSelected.setText("Book "+count+" seats");
//    }
//    public BroadcastReceiver messageReceiver = new BroadcastReceiver() {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String tgl = intent.getStringExtra("tgl");
//        String thn = ""+2018;
//        Log.d("msg_receive",""+thn+" "+tgl);
//        int id_film = intent.getExtras().getInt("Id film");
//
//        String concat_date = thn+" "+tgl;
////        responGetJam(concat_date,)
//    }
//    };

    public void setTanggal () {
        RecyclerView recyclerViewTgl;
        TanggalAdater tanggalAdater;
        Date currentDate = new Date();
        DateHelper dateHelper = new DateHelper(currentDate);

        myTanggal = new ArrayList<>();
        for (int i=0; i<7; i++){
            myTanggal.add(new Tanggal((dateHelper.getMonthShortName()+" "+(dateHelper.getIntDay()+i))));

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


        myJam.add(new Jam("09:00"));
        myJam.add(new Jam("12:00"));
        myJam.add(new Jam("15:00"));
        myJam.add(new Jam("17:00"));
        myJam.add(new Jam("21:00"));
        myJam.add(new Jam("24:00"));


        recyclerViewJam = findViewById(R.id.rc_jam);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        jamAdapter = new JamAdapter(this, myJam);
        recyclerViewJam.setLayoutManager(layoutManager);
        recyclerViewJam.setAdapter(jamAdapter);
    }


    public void cariKursi(final int Bioskop, final int film, final String tgl, final String jam, String token){
        call_kursi = ApiClient.getApiService().kursiTersedia(Bioskop,film,"2018-12-22",jam,token);
        call_kursi.enqueue(new Callback<List<KursiTersediaResponse>>() {
            @Override
            public void onResponse(Call<List<KursiTersediaResponse>> call, Response<List<KursiTersediaResponse>> response) {
                if(response.code()==200){
                    myKursi = response.body();

                    for(int i = 0; i< myKursi.size();i++){

                        mylist.add(myKursi.get(i).getKodeKursi());
                    }
                    Log.d("test",""+Bioskop+" "+film+" "+tgl+" "+" "+jam);
                    adapters = new CustomAdapter(BookingActivity.this, mylist);

                    spinner.setSelection(0);
                    spinner.setAdapter(adapters);


                }
            }

            @Override
            public void onFailure(Call<List<KursiTersediaResponse>> call, Throwable t) {

            }
        });
    }
}
