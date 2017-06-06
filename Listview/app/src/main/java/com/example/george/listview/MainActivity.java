package com.example.george.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn1,btn2;
    ArrayList<String> list= new ArrayList <String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.name);
        btn1=(Button)findViewById(R.id.reg);
        btn2=(Button)findViewById(R.id.show);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(et1.getText().toString());
                et1.setText(null);
                Toast.makeText(MainActivity.this,"Complete",Toast.LENGTH_SHORT).show();
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this, show.class);
                m.putStringArrayListExtra("list",list);
                startActivity(m);
            }
        });
    }
}
