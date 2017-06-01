package com.example.george.image1;

import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    int a= 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView);
        btn=(Button)findViewById(R.id.button);
    }
    public void change(View v)
    {
                switch(a)
                {
                    case 3: {img.setImageResource(R.drawable.img3);}break;
                    case 4: {img.setImageResource(R.drawable.img4);}break;
                    case 5: {img.setImageResource(R.drawable.img5);}break;
                    case 6: {img.setImageResource(R.drawable.img6);}break;
                    case 7: {img.setImageResource(R.drawable.img7); a = 3;}break;
                }
                a++;
            






    }
}
