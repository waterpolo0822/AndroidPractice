package com.example.george.imagefromdevice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent,1001);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent resultdata){
        if (requestCode==1001&&resultCode== Activity.RESULT_OK){
            Uri uri = null;
            if (resultdata != null){
                uri = resultdata.getData();
                try {
                    Bitmap bitmap = getBitmap(uri);
                    image.setImageBitmap(bitmap);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public Bitmap getBitmap(Uri uri)throws IOException{
        ParcelFileDescriptor parcelFileDescriptor =getContentResolver().openFileDescriptor(uri,"r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}
