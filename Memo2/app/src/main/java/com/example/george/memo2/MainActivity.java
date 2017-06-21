package com.example.george.memo2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar tool;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tool = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        list = (ListView)findViewById(R.id.list);
        DataBase helper = new DataBase(this);
        Cursor cursor = helper.title();
        Adapter adapter = new Adapter(this,R.layout.item_list,cursor,0);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = ((TextView)view.findViewById(R.id.title1)).getText().toString();
                Intent m = new Intent(MainActivity.this,note.class);
                m.putExtra("title",t);
                startActivity(m);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.add:
                Intent m = new Intent(MainActivity.this,create.class);
                startActivity(m);
        }
        return true;
    }

}
