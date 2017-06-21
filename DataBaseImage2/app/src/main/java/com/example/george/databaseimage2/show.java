package com.example.george.databaseimage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class show extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        img = (ImageView)findViewById(R.id.img);
        DataBase helper = new DataBase(this);
        helper.show(img);
    }
}
