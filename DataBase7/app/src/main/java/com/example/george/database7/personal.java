package com.example.george.database7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class personal extends AppCompatActivity {
    TextView tv;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv = (TextView) findViewById(R.id.tv);
        String name = getIntent().getStringExtra("name");
        DataBase helper = new DataBase(this);
        helper.person(name, tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.change:
                String name = getIntent().getStringExtra("name");
                Intent intent = new Intent(personal.this, update.class);
                intent.putExtra("name",name);
                startActivity(intent);
        }
        return true;
    }
}
