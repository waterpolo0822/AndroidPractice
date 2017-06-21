package com.example.george.database2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by george on 2017/06/12.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context)
    {
        super(context,"Misao",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(name text not null,phone integer,email text" +
                "city text,country text,course text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);

    }
    public void insert(String name,int phone,String email,String city,String country,String course)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("phone",phone);
        content.put("email",email);
        content.put("city",city);
        content.put("country",country);
        content.put("course",course);
        db.insert("student",null,content);
    }
    public void show (TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from student",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(c.getString(0)+"\n"+String.valueOf(c.getInt(1))+"\n"+c.getString(2)+"\n"+c.getString(3)
            +"\n"+c.getString(4)+"\n"+c.getString(5)+"\n"+"\n"+"\n");
            mov = c.moveToNext();
        }

        c.close();
        db.close();
    }

}
