package com.example.george.databaseimage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by george on 2017/06/20.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase (Context context){
        super(context,"Image",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table image (_id integer primary key autoincrement,name text,image blob)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void add(String name, File file) throws IOException {
        SQLiteDatabase db = this.getWritableDatabase();
        FileInputStream fis = new FileInputStream(file);
        byte[] image = new byte[fis.available()];
        fis.read(image);
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("image",image);
        db.insert("image",null,contentValues);
    }
    public void get (ImageView imageView){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from image",null);
        boolean mov = c.moveToFirst();
        while (mov){
            byte[] image = c.getBlob(2);
            Bitmap bmp = BitmapFactory.decodeByteArray(image,0,image.length);
            imageView.setImageBitmap(bmp);
            mov = c.moveToNext();
        }
    }


}
