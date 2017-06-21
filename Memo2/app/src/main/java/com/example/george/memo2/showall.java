package com.example.george.memo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showall extends AppCompatActivity {
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        show = (TextView)findViewById(R.id.showall);
        DataBase helper = new DataBase(this);
        helper.show(show);
    }
}
