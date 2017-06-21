package com.example.george.database4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,email,country,city,pass;
    Button add,show;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.email);
        country = (EditText)findViewById(R.id.country);
        city = (EditText)findViewById(R.id.city);
        pass = (EditText)findViewById(R.id.pass);

        add = (Button)findViewById(R.id.add);
        show = (Button)findViewById(R.id.show);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                String mail = email.getText().toString();
                String kuni = country.getText().toString();
                String tosi = city.getText().toString();
                String word= pass.getText().toString();
                helper.add(namae,number,mail,kuni,tosi,word);
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
