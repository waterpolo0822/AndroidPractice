package com.example.george.sqllite1;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataBase extends Activity {
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_base);
        show = (TextView)findViewById(R.id.show);

        MyOpenHelper helper = new MyOpenHelper(getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("register",new String[] {"name","age"},null,null,null,null,null);
        boolean mov = c.moveToFirst();
        while (mov){
            show.append(c.getString(0)+String.valueOf(c.getInt(1))+"\n");
            mov = c.moveToNext();
        }
        c.close();
        db.close();


    }
}
