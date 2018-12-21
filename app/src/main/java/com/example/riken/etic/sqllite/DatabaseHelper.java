package com.example.riken.etic.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.riken.etic.models.DataItem;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "tix_tiket.db";


    // tabel films favorit
    public static final String ID_FILM = "Id_film";
    public static final String TABLE_NAME_FILM = "film";
    public static final String NAMA_FILM = "nama_film";
    public static final String STATUS_TAYANG = "status_tayang";
    public static final String DESKRIPSI = "deskripsi";
    public static final String GENRE = "genre";
    public static final String DURASI = "durasi";
    public static final String TANGGAL_TAYANG = "tanggal_tayang";
    public static final String TANGGAL_SELESAI = "tanggal_selesai";
    public static final String FOTO_FILM = "foto_film";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
//        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table " + TABLE_NAME_KATEGORI + "(id integer primary key autoincrement, kategori text);");
//        db.execSQL("create table " + TABLE_NAME_FILM + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,film VARCHAR,durasi TIME,genre VARCHAR)");

        db.execSQL("create table " + TABLE_NAME_FILM + "(" +
                "id integer primary key autoincrement," +
                ID_FILM+" integer,"+
                NAMA_FILM+" text," +
                STATUS_TAYANG+" text," +
                DESKRIPSI+" text," +
                GENRE+" text," +
                DURASI+" text," +
                TANGGAL_TAYANG+" text," +
                TANGGAL_SELESAI+" text," +
                FOTO_FILM+" text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FILM);

    }


    public boolean isFavorited(int id_par){
        SQLiteDatabase sqlLite = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME_FILM+" where Id_film = "+id_par;
        Cursor cursor = sqlLite.rawQuery(query,null);

        if(cursor.getCount()==0){
            return true;
        }else {
            return false;
        }
    }

    public boolean insertWishlistFilm(  int id,
                                        String nama_film,
                                        String status_tayang,
                                        String deskripsi,
                                        String genre,
                                        String durasi,
                                        String tanggal_tayang,
                                        String tanggal_selesai,
                                        String foto_film){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FILM,id);
        contentValues.put(NAMA_FILM,nama_film);
        contentValues.put(STATUS_TAYANG,status_tayang);
        contentValues.put(DESKRIPSI,deskripsi);
        contentValues.put(GENRE,genre);
        contentValues.put(DURASI,durasi);
        contentValues.put(TANGGAL_TAYANG,tanggal_tayang);
        contentValues.put(TANGGAL_SELESAI,tanggal_selesai);
        contentValues.put(FOTO_FILM,foto_film);
        long result = db.insert(TABLE_NAME_FILM,null,contentValues);

        if (result == -1){
            return false;
        }else{
            return true;
        }



    }

    public void deleteFav(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_FILM,ID_FILM+"="+id,null);
    }


    public List<DataItem> selectFav(){

        List<DataItem> dataFav = new ArrayList<>();

        SQLiteDatabase sqlLite = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME_FILM;
        Cursor cursor = sqlLite.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(ID_FILM));
                String nama_film = cursor.getString(cursor.getColumnIndex(NAMA_FILM));
                String status_tayang = cursor.getString(cursor.getColumnIndex(STATUS_TAYANG));
                String deskripsi = cursor.getString(cursor.getColumnIndex(DESKRIPSI));
                String genre = cursor.getString(cursor.getColumnIndex(GENRE));
                String durasi = cursor.getString(cursor.getColumnIndex(DURASI));
                String tgl_tayang = cursor.getString(cursor.getColumnIndex(TANGGAL_TAYANG));
                String tgl_selesai = cursor.getString(cursor.getColumnIndex(TANGGAL_SELESAI));
                String foto = cursor.getString(cursor.getColumnIndex(FOTO_FILM));

                DataItem temp = new DataItem(foto,status_tayang,tgl_selesai,tgl_tayang,id,deskripsi,genre,durasi,nama_film);
                dataFav.add(temp);

            }while(cursor.moveToNext());
        }
        cursor.close();
        sqlLite.close();
        return dataFav;



    }
}