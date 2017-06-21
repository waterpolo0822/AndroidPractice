package com.example.george.database3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by george on 2017/06/13.
 */

public class DataBase extends SQLiteOpenHelper{
    public DataBase (Context context){ super(context,"Misao",null,2);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (name text,id integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==1&&newVersion==2){
            db.execSQL("create table waseda (_id int primary key,name text,id integer)");
        }
    }
    public void insert (String name,int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("id",id);
        db.insert("waseda",null,content);
    }
    public void selectall (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from waseda",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(c.getString(1)+String.valueOf(c.getInt(2))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
}
