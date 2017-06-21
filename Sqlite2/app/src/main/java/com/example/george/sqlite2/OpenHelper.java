package com.example.george.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by george on 2017/06/09.
 */

public class OpenHelper extends SQLiteOpenHelper{
    public OpenHelper(Context context){
        super(context,"RegisterManager",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table misao (_id int primary key autoincrement,name text not null,age int not null)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==1&&newVersion==2){
            db.execSQL("create table misao (_id int primary key autoincrement,name text not null,age int not null)");
        }

    }
}
