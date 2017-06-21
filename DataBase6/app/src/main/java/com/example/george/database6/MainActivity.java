package com.example.george.database6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button reg,all,search,desc,asc,update,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg = (Button)findViewById(R.id.reg);
        all = (Button)findViewById(R.id.all);
        search = (Button)findViewById(R.id.search);
        desc = (Button)findViewById(R.id.desc);
        asc = (Button)findViewById(R.id.asc);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,insert.class);
                startActivity(m);
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this,show.class);
                startActivity(k);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(MainActivity.this,search.class);
                startActivity(s);
            }
        });
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this,orderbydesc.class);
                startActivity(j);
            }
        });
        asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g = new Intent(MainActivity.this,show.class);
                startActivity(g);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(MainActivity.this,delete.class);
                startActivity(d);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(MainActivity.this,update.class);
                startActivity(u);
            }
        });
    }
}
