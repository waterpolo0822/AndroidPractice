package com.example.george.memo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by george on 2017/06/15.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){super(context,"Data",null,1);}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table memo (_id integer primary key autoincrement,title text,content text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }
    public void insert(String title,String content)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("title",title);
        c.put("content",content);
        db.insert("memo",null,c);
    }
    public void show(TextView textView)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from memo",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(c.getString(1));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public Cursor title()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor p = db.rawQuery("select _id,title from memo",null);
        return p;
    }
   public void name (EditText titel,EditText content,String title)
   {
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("select * from memo where title = ?",new String[]{title});
       boolean mov = cursor.moveToFirst();
       while(mov)
       {
           titel.setText(cursor.getString(1));
           content.setText(cursor.getString(2));
           mov = cursor.moveToNext();
       }
       cursor.close();
       db.close();
   }
   public void update(String title,String content,String title2)
   {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put("title",title);
       contentValues.put("content",content);
       db.update("memo",contentValues,"title = ?",new String[]{title2});
   }
}
