package com.example.george.databaseimage2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by george on 2017/06/20.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context){
        super(context,"Photo",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table image(_id integer primary key autoincrement,name text,ima blob)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void add (String name,byte[] image) throws SQLiteException{
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("name",name);
        c.put("ima",image);
        db.insert("image",null,c);
    }
    public void show(ImageView imageView){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from image",null);
        boolean mov = cursor.moveToFirst();
        while (mov){
            byte[] blob = cursor.getBlob(2);
            Bitmap bitmap = BitmapFactory.decodeByteArray(blob,0,blob.length);
            imageView.setImageBitmap(bitmap);
            mov = cursor.moveToNext();
        }
    }

}
