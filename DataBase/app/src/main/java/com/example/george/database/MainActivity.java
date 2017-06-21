package com.example.george.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView name,email,phone,pass;
    EditText etname,etphone,etmail,etpass;
    Button btn, btn2;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView)findViewById(R.id.name);
        email = (TextView)findViewById(R.id.email);
        phone = (TextView)findViewById(R.id.phone);
        pass = (TextView)findViewById(R.id.password);

        etname = (EditText)findViewById(R.id.etname);
        etphone = (EditText)findViewById(R.id.etphone);
        etmail = (EditText)findViewById(R.id.etemail);
        etpass = (EditText)findViewById(R.id.etpassword);

        btn = (Button)findViewById(R.id.ok);
        btn.setOnClickListener(this);

        btn2 = (Button)findViewById(R.id.next);
        btn2.setOnClickListener(this);



        helper = new DatabaseHelper(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
       // Toast.makeText(MainActivity.this,"Try Again",Toast.LENGTH_LONG);
        switch (v.getId())
        {
            case R.id.ok :
            {

                String name = etname.getText().toString();
                String phone = etphone.getText().toString();
                String email = etmail.getText().toString();
                String pass = etpass.getText().toString();

                if (name.equals("") && phone.equals("") && email.equals("") && pass.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Try Again",Toast.LENGTH_LONG).show();
                }
                else
                {
                   // helper.jojiinsert(name,phone,email,pass);
                    Toast.makeText(MainActivity.this,"Insert success",Toast.LENGTH_LONG).show();

                }

                break;

            }
            case R.id.next :
            {
                Intent m = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(m);

                break;
            }
        }


    }
}
