package com.example.george.grid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SingleViewActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        image = (ImageView)findViewById(R.id.image);

        Intent m = getIntent();
        int position = m.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        image.setImageResource(imageAdapter.mThumbIds[position]);

    }
}
