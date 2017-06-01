package com.example.george.chage3;

import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    EditText et1,et2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        et1=(EditText)findViewById(R.id.editText);

        tv3=(TextView)findViewById(R.id.textView3);
        et2=(EditText)findViewById(R.id.et2);
        btn=(Button)findViewById(R.id.button);
    }
    public void change(View v)
    {
        String a,b;
        a=et1.getText().toString();

        b=et2.getText().toString();
        tv2.setText(a);
        tv2.append(" /n" +
                ""+b);

    }
}
