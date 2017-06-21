package com.example.george.database5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        text = (TextView)findViewById(R.id.text);
        DataBase helper = new DataBase(this);
        helper.show(text);
    }
}
