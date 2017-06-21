package com.example.george.database3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        tv = (TextView)findViewById(R.id.text);

        DataBase helper = new DataBase(getApplicationContext());
        helper.selectall(tv);
//        SQLiteDatabase db = helper.getReadableDatabase();
//        Cursor c = db.rawQuery("select * from student",null);
//        boolean mov = c.moveToFirst();
//        while(mov)
//        {
//            tv.append(c.getString(0)+String.valueOf(c.getInt(1)));
//            mov = c.moveToNext();
//        }
//        c.close();
//        db.close();


    }
}
