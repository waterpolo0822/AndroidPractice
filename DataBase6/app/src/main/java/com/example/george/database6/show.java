package com.example.george.database6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        show = (TextView)findViewById(R.id.show);
        DataBase helper = new DataBase(this);
        helper.show(show);
    }
}
