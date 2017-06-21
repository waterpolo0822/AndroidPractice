package com.example.george.database5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,email,city;
    Button add,show,order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        city = (EditText)findViewById(R.id.city);
        add = (Button)findViewById(R.id.add);
        show = (Button)findViewById(R.id.show);
        order = (Button)findViewById(R.id.order);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                String mail = email.getText().toString();
                String tosi = city.getText().toString();

                helper.add(namae,number,mail,tosi);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,show.class);
                startActivity(m);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,order.class);
                startActivity(m);
            }
        });

    }
}
