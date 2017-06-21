package com.example.george.spinner3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Show extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.list);
        DataBase helper = new DataBase(this);
        Cursor c = helper.song();

        Adapter adapter = new Adapter(this,R.layout.list_item,c,0);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = ((TextView)view.findViewById(R.id.naming)).getText().toString();
                Intent intent = new Intent(Show.this,Info.class);
                intent.putExtra("song",c);
                startActivity(intent);
            }
        });

//        listView.setTextFilterEnabled(true);
//        searchView = (SearchView)findViewById(R.id.search);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search,menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        searchView = (SearchView) menuItem.getActionView();

        return true;
    }

}
