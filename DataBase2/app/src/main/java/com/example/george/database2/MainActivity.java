package com.example.george.database2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,email,city,coutry,course;
    Button reg,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DataBase helper = new DataBase(this);
        name = (EditText)findViewById(R.id.etname);
        phone = (EditText)findViewById(R.id.etphone);
        email = (EditText)findViewById(R.id.etemail);
        city = (EditText)findViewById(R.id.etcity);
        coutry = (EditText)findViewById(R.id.etcountry);
        course = (EditText)findViewById(R.id.etcourse);

        reg = (Button)findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                String namae = name.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                String mail = email.getText().toString();
                String tosi = city.getText().toString();
                String kuni = coutry.getText().toString();
                String jugyou = course.getText().toString();
//                helper.insert(namae,number,mail,tosi,kuni,jugyou);
                ContentValues content = new ContentValues();
                content.put("name",namae);
                content.put("phone",number);
                content.put("email",mail);
                content.put("city",tosi);
                content.put("country",kuni);
                content.put("course",jugyou);
                db.insert("student",null,content);
            }
        });
        show = (Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,show.class);
                startActivity(m);
            }
        });
    }
}
