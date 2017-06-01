package com.example.george.calculation2;

import android.os.StrictMode;
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
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView4);
        et1=(EditText)findViewById(R.id.editText3);
        et2=(EditText)findViewById(R.id.editText4);
        btn1=(Button)findViewById(R.id.button9);
        btn2=(Button)findViewById(R.id.button10);
        btn3=(Button)findViewById(R.id.button11);
        btn4=(Button)findViewById(R.id.button12);

    }


    public void add(View v)
    {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        int c=a+b;
        tv3.setText(String.valueOf(c));
    }
    public void sub(View v)
    {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        int c=a-b;
        tv3.setText(String.valueOf(c));

    }
    public void man(View v)
    {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        int c=a*b;
        tv3.setText(String.valueOf(c));
    }
    public void div(View v)
    {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        int c=a/b;
        tv3.setText(String.valueOf(c));
    }
}
