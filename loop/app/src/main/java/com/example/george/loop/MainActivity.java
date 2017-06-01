package com.example.george.loop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.textView);
        bt1 = (Button)findViewById(R.id.button);

    }
    public void loop(View v)
    {
        String a="x";
        int b=1;
        while(b<=5)
        {
            int c=1;
            while(c<=b)
            {
                tv1.append("*");
            }
            tv1.append("/n");
            b++;
        }


    }
}
