package com.example.george.database6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by george on 2017/06/13.
 */

public class DataBase extends SQLiteOpenHelper
{
    public DataBase (Context context){super(context,"Register",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info (_id integer primary key autoincrement,name text not null,email text not null,phone integer not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void insert(String name,String email,int phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("email",email);
        content.put("phone",phone);
        db.insert("info",null,content);
    }
    public void show (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from info",null);
        boolean mov = c.moveToFirst();
        while(mov)
        {
            textView.append(String.valueOf(c.getInt(0))+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+String.valueOf(c.getInt(3))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public void search (int id,TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from info where _id = ?",new String[]{String.valueOf(id)});
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(String.valueOf(c.getInt(0))+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+String.valueOf(c.getInt(3))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public void order (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from info order by _id desc",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(String.valueOf(c.getInt(0))+"\n"+c.getString(1)+"\n"+c.getString(2)+"\n"+String.valueOf(c.getInt(3))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public void delete (int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete("info","_id=?",new String[]{String.valueOf(id)});
    }
    public void update(String name,String email,int phone,int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("email",email);
        content.put("phone",phone);
        db.update("info",content,"_id="+String.valueOf(id),null);
    }

}
