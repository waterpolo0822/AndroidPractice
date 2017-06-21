package com.example.george.databaseimage2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;
    Button go,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.image);
        editText = (EditText)findViewById(R.id.name);
        go = (Button)findViewById(R.id.go);

        //imageview to bitmap
        BitmapDrawable drawable = (BitmapDrawable)imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        //bitmap to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
        final byte[] img = bos.toByteArray();
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                String name = editText.getText().toString();
                helper.add(name,img);
            }
        });
        show = (Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,show.class);
                startActivity(intent);
            }
        });

    }
}
