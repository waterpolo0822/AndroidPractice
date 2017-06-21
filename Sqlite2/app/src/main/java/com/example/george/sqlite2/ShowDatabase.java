package com.example.george.sqlite2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDatabase extends AppCompatActivity {
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);

        show = (TextView)findViewById(R.id.show);
        OpenHelper helper = new OpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

//        Cursor c = db.query("register",new String[]{"name","age"},null,null,null,null,null);
        Cursor c = db.rawQuery("select * from misao",null);
        boolean mov = c.moveToFirst();
        while (mov)
        {
            show.append(c.getString(0)+String.valueOf(c.getInt(1))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();
    }
}
