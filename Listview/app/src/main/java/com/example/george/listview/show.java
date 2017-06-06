package com.example.george.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class show extends AppCompatActivity {
    ListView list;
    ArrayList <String> stock = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        list=(ListView)findViewById(R.id.list);

        stock = getIntent().getStringArrayListExtra("list");
        ArrayAdapter array=new ArrayAdapter(this,android.R.layout.simple_list_item_1,stock);
        list.setAdapter(array);

    }
}
