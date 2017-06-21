package com.example.george.memo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class note extends AppCompatActivity {
    EditText title2,content2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        title2 = (EditText)findViewById(R.id.title3);
        content2 = (EditText)findViewById(R.id.content3);
        String a = getIntent().getStringExtra("title");
        DataBase helper = new DataBase(this);
        helper.name(title2,content2,a);
        toolbar = (Toolbar)findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.check:
                String titile = title2.getText().toString();
                String content = content2.getText().toString();
                String title2 = getIntent().getStringExtra("title");
                DataBase helper = new DataBase(this);
                helper.update(titile,content,title2);
        }
        return true;
    }
}
