package com.example.george.gridview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Siglephoto extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siglephoto);
        imageView = (ImageView)findViewById(R.id.image);

        int position = getIntent().getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(this);
        imageView.setImageResource(adapter.photos[position]);


    }
}
