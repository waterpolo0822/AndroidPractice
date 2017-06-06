package com.example.george.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tiger extends AppCompatActivity implements View.OnClickListener {
    Button tiger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiger);
        tiger = (Button)findViewById(R.id.tiger);
        tiger.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent h=new Intent(Tiger.this,cat.class);
        startActivity(h);

    }
}
