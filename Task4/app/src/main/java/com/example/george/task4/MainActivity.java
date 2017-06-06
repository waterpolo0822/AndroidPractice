package com.example.george.task4;

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
        tv3=(TextView)findViewById(R.id.output);
        et1=(EditText)findViewById(R.id.number);
        et2=(EditText)findViewById(R.id.firure);
    }
    public void loop(View v)
    {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        for(int c=1;c<=b;c++)
        {
            for(int d=1;d<=a;d++)
            {
                for(int e=1;e<=d;e++)
                {
                    tv3.append("*");

                }
                tv3.append("\n");
            }
        }
    }
}
