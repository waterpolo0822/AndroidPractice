package com.example.george.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by george on 2017/06/12.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    public static String DBNAME = "misao";
    public DatabaseHelper(Context context) {
        super(context, DBNAME,null,1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table misao(name varchar(40),phone varchar(20),email varchar(20),password varchar(30))");
        this.sqLiteDatabase = sqLiteDatabase;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        this.onCreate(sqLiteDatabase);

    }
    public void jojiinsert (String name,String phone,String email,String pass)
    {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("phone",phone);
        cv.put("email",email);
        cv.put("password",pass);
        sqLiteDatabase.insert("misao",null,cv);
    }
    public Cursor showjoj()
    {
        sqLiteDatabase = this.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("Select * from misao",null);
        return c;
    }

}
