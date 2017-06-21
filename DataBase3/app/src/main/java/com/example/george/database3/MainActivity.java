package com.example.george.database3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,id;
    Button reg,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        id = (EditText)findViewById(R.id.id);
        reg = (Button)findViewById(R.id.reg);
        show = (Button)findViewById(R.id.show);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                int number = Integer.parseInt(id.getText().toString());
                helper.insert(namae,number);
//                SQLiteDatabase db = helper.getWritableDatabase();
//                ContentValues content = new ContentValues();
//                content.put("name",namae);
//                content.put("id",number);
//                db.insert("student",null,content);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,show.class);
                startActivity(m);
            }
        });

    }
}
