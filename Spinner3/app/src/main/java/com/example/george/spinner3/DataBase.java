package com.example.george.spinner3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by george on 2017/06/19.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){
        super(context,"Data",null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table music (_id integer primary key autoincrement,song text not null,singer text not null," +
                "gender text,genre text,memo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion==1&&newVersion==2){
            db.execSQL("create table student(_id integer primary key autoincrement,name text not null,place text not null," +
                    "gender text,course text,memo text,image blob)");
        }
    }
    public void add (String song,String singer,String gender,String genre,String memo,byte[] image) throws SQLiteException
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",song);
        content.put("place",singer);
        content.put("gender",gender);
        content.put("course",genre);
        content.put("memo",memo);
        content.put("image",image);
        db.insert("student",null,content);
    }
    public void show (TextView textView,ImageView imageView){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from student where name = ?",new String[]{"Test"});
        boolean m=c.moveToFirst();
        while (m)
        {
            textView.append(c.getString(1)+c.getString(2)+c.getString(3)+c.getString(4)+c.getString(5));
            byte[] blob = c.getBlob(6);
            Bitmap bitmap = BitmapFactory.decodeByteArray(blob,0,blob.length);
            imageView.setImageBitmap(bitmap);
            m = c.moveToNext();
        }
        c.close();
        db.close();
    }
    public Cursor song(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select _id,name from student",null);
        return c;
    }
    public void info (String song, TextView textView,ImageView imageView){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from student where name = ?",new String[]{song});
        boolean mov = cursor.moveToFirst();
        while (mov){
            textView.append(cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5));
            byte[] blob = cursor.getBlob(6);
            Bitmap bitmap = BitmapFactory.decodeByteArray(blob,0,blob.length);
            imageView.setImageBitmap(bitmap);
            mov=cursor.moveToNext();
        }
    }
    public void update(String song,String singer,String gender,String genre,String memo,String song2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",song);
        contentValues.put("place",singer);
        contentValues.put("gender",gender);
        contentValues.put("course",genre);
        contentValues.put("memo",memo);
        db.update("student",contentValues,"name = ?",new String[]{song2});
    }
}
