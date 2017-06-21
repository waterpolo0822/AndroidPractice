package com.example.george.database5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.DrawableRes;
import android.widget.TextView;

/**
 * Created by george on 2017/06/13.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){super(context,"Register",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info (_id integer primary key autoincrement,name text,phone integer,email text,city text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void  add (String name,int phone,String email,String city)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("city",city);
        db.insert("info",null,content);
    }
    public void show (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from info",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(String.valueOf(c.getInt(0))+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+c.getString(3)+"\n"+c.getString(4)+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public void order (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor r = db.rawQuery("select * from info order by _id desc",null);
        boolean bov = r.moveToFirst();
        while (bov)
        {
            textView.append(String.valueOf(r.getInt(0))+"\n"+r.getString(1)+"\n"+r.getString(2)+"\n"+r.getString(3)+"\n"+r.getString(4)+"\n");
            bov = r.moveToNext();
        }
        r.close();
        db.close();
    }
}
