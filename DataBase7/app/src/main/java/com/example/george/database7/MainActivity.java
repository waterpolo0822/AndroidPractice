package com.example.george.database7;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    ListView list;
    ArrayList<String> l = new ArrayList<>();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        list = (ListView)findViewById(R.id.list);

        DataBase helper = new DataBase(this);
        Cursor c = helper.name();

        Adapter adapter = new Adapter(this,R.layout.list_item,c,0);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c = ((TextView)view.findViewById(R.id.naming)).getText().toString();
                Intent intent = new Intent(MainActivity.this,personal.class);
                intent.putExtra("name",c);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,c, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.create :
               Intent m = new Intent(MainActivity.this,info.class);
                startActivity(m);
        }
        return true;

    }
}
