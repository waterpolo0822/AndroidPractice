package com.example.george.database8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create extends AppCompatActivity {
    EditText name,phone,email,pass,pass2,country;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        name = (EditText)findViewById(R.id.namae);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.mail);
        pass = (EditText)findViewById(R.id.password);
        pass2 = (EditText)findViewById(R.id.confirm);
        country = (EditText)findViewById(R.id.country);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namae = name.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                String mail = email.getText().toString();
                String word = pass.getText().toString();
                String kuni = country.getText().toString();
                DataBase helper = new DataBase(getApplicationContext());
                helper.insert(namae,number,mail,word,kuni);
            }
        });
    }
}
