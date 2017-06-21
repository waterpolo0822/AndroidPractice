package com.example.george.grid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView)findViewById(R.id.grid);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent m = new Intent(MainActivity.this,SingleViewActivity.class);
                m.putExtra("id",position);
                startActivity(m);
            }
        });


    }
}
