package com.example.george.sqllite1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by george on 2017/06/07.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private static  String database_name = "RegisterManager";
    private  static  int database_version = 1;
    private static final String table_name="Register";
    private static final String Name="name";
    private static final String Age="age";
    public MyOpenHelper(Context context){
        super(context,"RegisterManger",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table register(" + "name TEXT not null,"+"age INTEGER"+");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + table_name);
        onCreate(db);

    }
}
