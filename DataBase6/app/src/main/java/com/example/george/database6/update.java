package com.example.george.database6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update extends AppCompatActivity {
    EditText id,name,email,phone;
    Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        id = (EditText)findViewById(R.id.id);
        name = (EditText)findViewById(R.id.name);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                String mail = email.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                int a= Integer.parseInt(id.getText().toString());
                helper.update(namae,mail,number,a);
            }
        });
    }
}
