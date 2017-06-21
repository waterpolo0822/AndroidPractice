package com.example.george.spinner2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText first,second;
    Spinner spinner;
    Button go;
    int c,a,b;
    String select;
    String array[] = {"select","add","sub","man","div"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (EditText)findViewById(R.id.first);
        second = (EditText)findViewById(R.id.second);
        spinner = (Spinner)findViewById(R.id.spinner);
        go = (Button)findViewById(R.id.go);
        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        select = String.valueOf(parent.getItemAtPosition(position));
        try {if (select.equals("add")) {
                 a = Integer.parseInt(first.getText().toString());
                 b = Integer.parseInt(second.getText().toString());
                c = a + b;
            } else if (select.equals("sub")) {
                 a = Integer.parseInt(first.getText().toString());
                 b = Integer.parseInt(second.getText().toString());
                c = a - b;
            } else if (select.equals("man")) {
                 a = Integer.parseInt(first.getText().toString());
                 b = Integer.parseInt(second.getText().toString());
                c = a * b;
            } else if (select.equals("div")) {
                 a = Integer.parseInt(first.getText().toString());
                 b = Integer.parseInt(second.getText().toString());
                c = a / b;
            }}
        catch (Exception e){
//            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
            go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (select.equals("add")){
                    String answer = "sum is ";
                    Intent m = new Intent(getApplicationContext(),Result.class);
                    m.putExtra("answer",answer);
                    m.putExtra("value",c);
                    startActivity(m);
                }
                if (select.equals("sub")){
                    String answer = "sub is ";
                    Intent m = new Intent(getApplicationContext(),Result.class);
                    m.putExtra("answer",answer);
                    m.putExtra("value",c);
                    startActivity(m);
                }
                if (select.equals("man")){
                    String answer = "man is ";
                    Intent m = new Intent(getApplicationContext(),Result.class);
                    m.putExtra("answer",answer);
                    m.putExtra("value",c);
                    startActivity(m);
                }
                if (select.equals("div")){
                    String answer = "div is ";
                    Intent m = new Intent(getApplicationContext(),Result.class);
                    m.putExtra("answer",answer);
                    m.putExtra("value",c);
                    startActivity(m);
                }
            }
        });


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
