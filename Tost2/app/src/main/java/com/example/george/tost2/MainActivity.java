package com.example.george.tost2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button bt1,bt2,bt3,bt4;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        bt1=(Button)findViewById(R.id.btn1);
        bt2=(Button)findViewById(R.id.btn2);
        bt3=(Button)findViewById(R.id.btn3);
        bt4=(Button)findViewById(R.id.btn4);
        tv1=(TextView)findViewById(R.id.result);
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
            case R.id.btn1:{tv1.setText(String.valueOf(a+b));}break;
            case R.id.btn2:{tv1.setText(String.valueOf(a-b));}break;
            case R.id.btn3:{tv1.setText(String.valueOf(a*b));}break;
            case R.id.btn4:{tv1.setText(String.valueOf(a/b));}break;
        }

    }
}
