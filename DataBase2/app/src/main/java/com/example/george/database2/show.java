package com.example.george.database2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView = (TextView)findViewById(R.id.text);
        DataBase helper = new DataBase(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from student",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            textView.append(c.getString(0));
            mov = c.moveToNext();
        }
        c.close();
        db.close();
//        helper.show(textView);

    }
}