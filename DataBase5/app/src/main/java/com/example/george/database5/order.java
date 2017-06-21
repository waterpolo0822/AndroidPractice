package com.example.george.database5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class order extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        text = (TextView)findViewById(R.id.text2);
        DataBase helper = new DataBase(this);
        helper.order(text);
    }
}
