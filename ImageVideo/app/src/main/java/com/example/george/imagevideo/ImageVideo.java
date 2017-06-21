package com.example.george.imagevideo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;

public class ImageVideo extends AppCompatActivity {
    VideoView videoView;
    ImageView imageView;
    Button image,video;
    static final int photo=1;
    int b =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_video);

        videoView = (VideoView)findViewById(R.id.video);
        imageView = (ImageView)findViewById(R.id.image);
        image = (Button)findViewById(R.id.btimage);
        video = (Button)findViewById(R.id.btvideo);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,photo);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                File file = getvideo();
                intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(intent,2);
            }
        });
    }
    private File getFile(){
        File folder = new File("sdcard/image_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        File image = new File(folder,b+"misao1.image.jpg");
        return image;
    }
    private File getvideo(){
        File folder = new File("sdcard/video2_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        File video = new File(folder,b+"misao2.mp4");
        return video;
    }
    @Override
    public  void onActivityResult(int reQuestCode,int resultCode,Intent data){
        String path = "sdcard/image_app/"+b+"misao1.image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));

        String path2 = "sdcard/video2_app/"+b+"misao2.mp4";
        videoView.setVideoPath(path2);
        videoView.start();

        b++;
    }
}
