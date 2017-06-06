package com.example.george.calculator3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button bt1,bt2,bt3,bt4;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText4);
        bt1=(Button)findViewById(R.id.add);
        bt2=(Button)findViewById(R.id.sub);
        bt3=(Button)findViewById(R.id.man);
        bt4=(Button)findViewById(R.id.div);
        tv1=(TextView)findViewById(R.id.out);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        switch (v.getId())
        {
            case R.id.add :{
                Toast.makeText(MainActivity.this,String.valueOf(a+b),Toast.LENGTH_LONG).show();}break;
            case  R.id.sub:{
                Toast.makeText(MainActivity.this,String.valueOf(a-b),Toast.LENGTH_LONG).show();}break;
            case R.id.man:{
                Toast.makeText(MainActivity.this,String.valueOf(a*b),Toast.LENGTH_LONG).show();}break;
            case R.id.div:{
                Toast.makeText(MainActivity.this,String.valueOf(a/b),Toast.LENGTH_LONG).show();}break;
            }
            }


    }



