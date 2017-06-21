package com.example.george.database7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by george on 2017/06/14.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){super(context,"REG",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table info (_id integer primary key autoincrement,name text,email text not null,phone integer not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void add(String name,String email,int phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        c.put("email",email);
        c.put("phone",phone);
        db.insert("info",null,c);
    }
    public void show (EditText name,EditText email,EditText phone,String name2)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from info where name = ?",new String[]{name2});
        boolean mov = c.moveToFirst();
        while(mov)
        {
            name.setText(c.getString(1));
            email.setText(c.getString(2));
            phone.setText(c.getString(3));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public Cursor name()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select _id,name from info",null);
        return cursor;
    }
    public void person(String name,TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from info where name = ?",new String[]{name});
        boolean mov = cursor.moveToFirst();
        while (mov)
        {
            textView.append(cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+String.valueOf(cursor.getInt(3)));
            mov = cursor.moveToNext();
        }
    }
    public void update(String name,String email,int phone,String name2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues q = new ContentValues();
        q.put("name",name);
        q.put("email",email);
        q.put("phone",phone);
        db.update("info",q,"name = ?",new String[]{name2});
    }

}
