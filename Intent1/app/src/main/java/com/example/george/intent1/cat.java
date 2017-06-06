package com.example.george.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cat extends AppCompatActivity implements View.OnClickListener {
    Button cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        cat=(Button)findViewById(R.id.cat);
        cat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent x=new Intent(cat.this,MainActivity.class);
        startActivity(x);

    }
}
