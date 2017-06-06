package com.example.george.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bear extends AppCompatActivity implements View.OnClickListener {
    Button bear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bear);
        bear=(Button)findViewById(R.id.bear);
        bear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent g=new Intent(bear.this,Tiger.class);
        startActivity(g);


    }
}
