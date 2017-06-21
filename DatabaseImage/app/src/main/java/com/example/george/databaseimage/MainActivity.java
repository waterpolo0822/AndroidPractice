package com.example.george.databaseimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);

        String path = "image_app/1misao1.image,jpg";
        File file = new File(path);
        DataBase helper = new DataBase(this);
        try {
            helper.add("Name",file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.get(imageView);

    }
}
