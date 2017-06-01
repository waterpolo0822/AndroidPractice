package com.example.george.driver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        et=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);

    }
    public void driver(View v)
    {
        int age=Integer.parseInt(et.getText().toString());
        String can="You can drive a car.";
        String cant="You can't drive a car";
        if(age>=20)
        {
            tv2.setText(can);
        }
        else
        {
            tv2.setText(cant);
        }
    }
}
