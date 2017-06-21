package com.example.george.video;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    MediaController controller;
    VideoView videoView;
    Button go;
    static final int video = 2;
    int b =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.video);
        go = (Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                File file = getfile();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(intent,200 );
            }
        });
    }
    public File getfile(){
        File folder = new File("sdcard/video_app");
        if (!folder.exists()){
            folder.mkdir();
        }
        File videofile = new File(folder,b+"misao.mp4");
        return videofile;
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        String path = "sdcard/video_app/"+b+"misao.mp4";
        videoView.setVisibility(View.VISIBLE);
        videoView.setVideoPath(path);
        videoView.start();
        b++;
    }
}
