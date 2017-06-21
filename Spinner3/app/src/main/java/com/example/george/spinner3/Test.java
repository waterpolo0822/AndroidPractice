package com.example.george.spinner3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Test extends AppCompatActivity {
    TextView test;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        test = (TextView)findViewById(R.id.test);
        imageView = (ImageView)findViewById(R.id.testimage);
        DataBase helper = new DataBase(this);
        helper.show(test,imageView);
    }
}
