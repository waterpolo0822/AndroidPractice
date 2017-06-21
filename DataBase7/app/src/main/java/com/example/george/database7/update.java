package com.example.george.database7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class update extends AppCompatActivity {
    EditText name,email,phone;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        name = (EditText)findViewById(R.id.name2);
        email = (EditText)findViewById(R.id.email2);
        phone = (EditText)findViewById(R.id.phone2);
        change = (Button)findViewById(R.id.ok2);
        String name2 = getIntent().getStringExtra("name");
        DataBase helper = new DataBase(this);
        helper.show(name,email,phone,name2);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namae = name.getText().toString();
                String mail = email.getText().toString();
                int number = Integer.parseInt(phone.getText().toString());
                String name3 = getIntent().getStringExtra("name");
                DataBase helper = new DataBase(getApplicationContext());
                helper.update(namae,mail,number,name3);
                Intent o = new Intent(update.this,MainActivity.class);
                startActivity(o);
            }
        });
    }
}
