package com.example.george.intent3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class out extends AppCompatActivity {
    TextView tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);
        tv0=(TextView)findViewById(R.id.name);
        tv1=(TextView)findViewById(R.id.phone);
        tv2=(TextView)findViewById(R.id.email);
        tv3=(TextView)findViewById(R.id.music);
        tv4=(TextView)findViewById(R.id.pass);
        tv5=(TextView)findViewById(R.id.country);
        tv6=(TextView)findViewById(R.id.father);
        tv7=(TextView)findViewById(R.id.mother);
        tv8=(TextView)findViewById(R.id.sports);
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String music = getIntent().getStringExtra("music");
        String pass =getIntent().getStringExtra("pass");
        String country= getIntent().getStringExtra("country");
        String father = getIntent().getStringExtra("father");
        String mother = getIntent().getStringExtra("mother");
        String sports = getIntent().getStringExtra("sports");
        tv0.append(name);
        tv1.append(phone);
        tv2.append(email);
        tv3.append(music);
        tv4.append(pass);
        tv5.append(country);
        tv6.append(father);
        tv7.append(mother);
        tv8.append(sports);
    }

}
