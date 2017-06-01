package com.example.george.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    EditText et1,et2;
    Button btn1,btn2,btn3,btn4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView4);
        tv2=(TextView)findViewById(R.id.textView5);
        tv3=(TextView)findViewById(R.id.textView6);
        et1=(EditText)findViewById(R.id.editText6);
        et2=(EditText)findViewById(R.id.editText7);
        btn1=(Button)findViewById(R.id.button10);
        btn2=(Button)findViewById(R.id.button11);
        btn3=(Button)findViewById(R.id.button12);
        btn4=(Button)findViewById(R.id.button13);
    }
    int a=Integer.parseInt(et1.getText().toString());
    int b=Integer.parseInt(et2.getText().toString());

    public void add(View v)
    {
        String c=String.valueOf(a+b);
        tv3.setText("aaaa");
       // tv3.setText(c);

    }
    public void sub(View v)
    {
        String d=String.valueOf(a-b);
        tv3.setText("bbb");
       // tv3.setText(d);
    }
    public void man(View v)
    {
        String e=String.valueOf(a*b);
        tv3.setText("cccc");
       // tv3.setText(e);
    }
    public void div(View v)
    {
        String f=String.valueOf(a/b);
        tv3.setText("dddd");
       // tv3.setText(f);
    }
}
