package com.example.george.task1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12;
    EditText et1,et2,et3,et4,et5,et6;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView7);
        tv2=(TextView)findViewById(R.id.textView8);
        tv3=(TextView)findViewById(R.id.textView9);
        tv4=(TextView)findViewById(R.id.textView10);
        tv5=(TextView)findViewById(R.id.textView11);
        tv6=(TextView)findViewById(R.id.textView12);
        tv7=(TextView)findViewById(R.id.textView13);
        tv8=(TextView)findViewById(R.id.textView);
        tv9=(TextView)findViewById(R.id.textView2);
        tv10=(TextView)findViewById(R.id.textView3);
        tv11=(TextView)findViewById(R.id.textView4);
        tv12=(TextView)findViewById(R.id.textView5);
        et1=(EditText)findViewById(R.id.editText7);
        et2=(EditText)findViewById(R.id.editText8);
        et3=(EditText)findViewById(R.id.editText9);
        et4=(EditText)findViewById(R.id.editText10);
        et5=(EditText)findViewById(R.id.editText11);
        et6=(EditText)findViewById(R.id.editText12);
        btn=(Button)findViewById(R.id.button2);
    }
    public void output(View v)
    {
        String name,phone,city,email,pass,music;
        name=et1.getText().toString();
        phone=et2.getText().toString();
        city=et3.getText().toString();
        email=et4.getText().toString();
        pass=et5.getText().toString();
        music=et6.getText().toString();
        String AllName="my name is "+name;
        String AllPhone="my phone number is "+phone;
        String AllCity="I live in "+city;
        String AllEmail="My e-mail is "+email;
        String AllPass="My pass is "+pass;
        String AllMusic="My favorite music is "+music;

        tv7.setText(AllName);
        tv8.setText(AllPhone);
        tv9.setText(AllCity);
        tv10.setText(AllEmail);
        tv11.setText(AllPass);
        tv12.setText(AllMusic);

    }
}
