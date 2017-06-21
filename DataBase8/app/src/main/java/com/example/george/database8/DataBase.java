package com.example.george.database8;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by george on 2017/06/14.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){super(context,"Misao",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info(_id integer primary key autoincrement,name text not null," +
                "phone integer not null,email text not null,pass text not null,country text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void insert(String name,int phone,String email,String pass,String country)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("pass",pass);
        content.put("country",country);
        db.insert("info",null,content);
    }
    public boolean login (String name,String pass)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select name,pass from info where name = ? and pass = ?",new String[]{name,pass});
        if (c.getCount()<=0)
        {
            c.close();
            return false;
        }
        c.close();
        return true;
    }
    public void delete()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete("info",null,null);
    }
}
