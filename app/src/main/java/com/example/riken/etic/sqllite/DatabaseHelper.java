package com.example.riken.etic.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tix_tiket.db";
    public static final String ID = "Id";
    public static final String TABLE_NAME ="film";
    public static final String NAMA_FILM = "nama_film";
    public static final String DURASI = "durasi";
    public static final String GENRE ="genre";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,film VARCHAR,DURASI TIME,genre VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
}
