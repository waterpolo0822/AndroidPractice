package com.example.george.memo2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class create extends AppCompatActivity {
    Toolbar tool;
    EditText title,content;
    Button see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        tool = (Toolbar)findViewById(R.id.toolbar2);
        title = (EditText)findViewById(R.id.title);
        content = (EditText)findViewById(R.id.content);
        see = (Button)findViewById(R.id.show);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(create.this,showall.class);
                startActivity(m);
            }
        });
        setSupportActionBar(tool);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.check,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.check:
                Toast.makeText(this,"llll",Toast.LENGTH_LONG).show();
                String title1 = title.getText().toString();
                String content1 = content.getText().toString();
                if (title1.matches(""))
                {
                    title.setHintTextColor(Color.RED);
                    title.setHint("Title should be put");
                }
                else {
                    DataBase helper = new DataBase(getApplicationContext());
                    helper.insert(title1, content1);
                }
        }
        return true;
    }
}
