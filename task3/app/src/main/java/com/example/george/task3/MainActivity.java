package com.example.george.task3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    EditText et1,et2,et3,et4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv4=(TextView)findViewById(R.id.textView5);
        tv5=(TextView)findViewById(R.id.textView7);
        tv6=(TextView)findViewById(R.id.textView8);
        tv7=(TextView)findViewById(R.id.textView9);
        tv8=(TextView)findViewById(R.id.textView10);
        tv9=(TextView)findViewById(R.id.textView11);
        tv10=(TextView)findViewById(R.id.textView12);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        btn=(Button)findViewById(R.id.button2);
    }
    public void output(View v)
    {
        String name,phone,email,pass;
        name=et1.getText().toString();
        phone=et2.getText().toString();
        email=et3.getText().toString();
        pass=et4.getText().toString();
        tv6.setText(name);
        tv7.setText(phone);
        tv8.setText(email);
        tv9.setText(pass);


    }

}
