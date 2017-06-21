package com.example.george.camera;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button go;
    static final int camera = 1;
    int b=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image);
        go = (Button)findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,camera);
            }
        });
    }
    private File getfile(){
        File folder = new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();
        }
        File imagefile = new File(folder,b+"joji.image.jpg");
        return imagefile;
    }
    @Override
    protected void onActivityResult(int requestConde,int resultCode,Intent data){
        String path = "sdcard/camera_app/"+b+"joji.image.jpg";
        image.setImageDrawable(Drawable.createFromPath(path));
        b++;
    }
}
