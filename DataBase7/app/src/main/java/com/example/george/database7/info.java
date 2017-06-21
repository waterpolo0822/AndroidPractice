package com.example.george.database7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class info extends AppCompatActivity {
    EditText name,email,phone;
    Button ok,see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                String mail = email.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                helper.add(namae,mail,number);
                Intent h = new Intent(info.this,MainActivity.class);
                startActivity(h);
            }
        });

    }
}
