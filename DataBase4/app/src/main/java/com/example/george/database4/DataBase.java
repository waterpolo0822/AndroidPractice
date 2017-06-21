package com.example.george.database4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by george on 2017/06/13.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){super(context,"Register",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table nam (name text,phone integer,email text,country text,city text,pass text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void add(String name,int phone,String email,String country,String city,String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("country",country);
        content.put("city",city);
        content.put("pass",pass);
        db.insert("nam",null,content);
    }
    public void show(TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from nam",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(c.getString(0)+"\n"+String.valueOf(c.getInt(1))+"\n"+c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4)+"\n"
            +c.getString(5));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
}
