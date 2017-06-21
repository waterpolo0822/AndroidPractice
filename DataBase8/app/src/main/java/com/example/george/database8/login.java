package com.example.george.database8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button login,create;
    EditText name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.log);
        create = (Button)findViewById(R.id.create);
        name = (EditText)findViewById(R.id.name);
        pass = (EditText)findViewById(R.id.pass);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(login.this,create.class);
                startActivity(m);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String namae = name.getText().toString();
                String word = pass.getText().toString();
                boolean m = helper.login(namae,word);
                if (m)
                {
                    Intent i = new Intent(login.this,result.class);
                    startActivity(i);
                }
            }
        });
    }
}
