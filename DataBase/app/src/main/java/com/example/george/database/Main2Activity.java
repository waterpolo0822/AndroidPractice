package com.example.george.database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button back,show;
    TextView tv1;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(this);
        show = (Button)findViewById(R.id.show);
        show.setOnClickListener(this);

        tv1 = (TextView)findViewById(R.id.contents);
        helper = new DatabaseHelper(this);
        Cursor c = helper.showjoj();
//        if(c.getCount() > 0)
//        {
//            Toast.makeText(Main2Activity.this,"kkkkk",Toast.LENGTH_LONG).show();
//        }
//        else
//        {
//            Toast.makeText(Main2Activity.this,"nnnn",Toast.LENGTH_LONG).show();
//        }

        c.moveToFirst();
        do
        {
            String name = c.getString(c.getColumnIndexOrThrow("name"));
           String phone = c.getString(c.getColumnIndexOrThrow("phone"));
            String email = c.getString(c.getColumnIndexOrThrow("email"));
            String pass = c.getString(c.getColumnIndexOrThrow("password"));
            tv1.append("name :- "+name+"\n phone :- "+phone+"\n email :- "+email+"\n password :- "+pass+"\n \n \n");
        }
        while (c.moveToNext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back:
            {
                Intent b = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(b);
            }break;

        }

    }
}
