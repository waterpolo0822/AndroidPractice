package com.example.george.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class joji extends AppCompatActivity implements View.OnClickListener {
    Button btnj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joji);
        btnj=(Button)findViewById(R.id.button);
        btnj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent t=new Intent(joji.this,bear.class);
        startActivity(t);

    }
}
