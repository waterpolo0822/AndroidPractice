package com.example.george.task2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    EditText et1,et2,et3,et4;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView12);
        tv2=(TextView)findViewById(R.id.textView13);
        tv3=(TextView)findViewById(R.id.textView14);
        tv4=(TextView)findViewById(R.id.textView15);
        tv5=(TextView)findViewById(R.id.textView16);
        tv6=(TextView)findViewById(R.id.textView17);
        tv7=(TextView)findViewById(R.id.textView18);
        tv8=(TextView)findViewById(R.id.textView19);
        et1=(EditText)findViewById(R.id.editText12);
        et2=(EditText)findViewById(R.id.editText13);
        et3=(EditText)findViewById(R.id.editText14);
        et4=(EditText)findViewById(R.id.editText15);
        btn=(Button)findViewById(R.id.button);
    }
    public void output(View v)
    {
        String name,number,email,pass;
        name=et1.getText().toString();
        number=et2.getText().toString();
        email=et3.getText().toString();
        pass=et4.getText().toString();
        String a,b,c,d;
        a="My name is "+name;
        b="My phone number is "+number;
        c="My e-mail is "+email;
        d="My password is "+pass;
        tv5.setText(a);
        tv6.setText(b);
        tv7.setText(c);
        tv8.setText(d);
    }


}
