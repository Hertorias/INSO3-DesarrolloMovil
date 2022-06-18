package com.example.trabajofinaljuniov2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.trabajofinaljuniov2.utils.Datos;
import com.example.trabajofinaljuniov2.utils.Juego;

import java.util.ArrayList;

public class GameHelper extends SQLiteOpenHelper {

    public GameHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE GAMES ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "PRICE REAL, "
                + "IMAGE INTEGER, "
                + "PLATFORM TEXT); ");

        sqLiteDatabase.execSQL("CREATE TABLE SHOPPINGCART ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "PRICE REAL, "
                + "IMAGE INTEGER, "
                + "PLATFORM TEXT,"
                + "USER TEXT); ");

        sqLiteDatabase.execSQL("CREATE TABLE USERS ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "USERNAME TEXT NOT NULL UNIQUE, "
                + "EMAIL TEXT, "
                + "PASSWORD TEXT); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

}
