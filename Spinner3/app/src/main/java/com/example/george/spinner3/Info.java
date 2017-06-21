package com.example.george.spinner3;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Info extends AppCompatActivity {
    TextView tv;
    Toolbar toolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv = (TextView)findViewById(R.id.songss);
        imageView = (ImageView)findViewById(R.id.picture);
        String song = getIntent().getStringExtra("song");
        DataBase helper = new DataBase(this);
        helper.info(song,tv,imageView);

        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chanfe,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.change:
                Intent m = new Intent(getApplicationContext(),Show.class);
                startActivity(m);
                break;
        }
        return true;
    }
}
