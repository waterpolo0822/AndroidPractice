package com.example.george.loop2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView);
        btn=(Button) findViewById(R.id.button);
    }
    public void loop(View v) {
        for (int a = 1; a <= 100; a++)
          {
              tv.append(String.valueOf(a));
              tv.append("\n");
          }
//        int a = 1;
//        while(a<=5)
//        {
//            int b = 1;
//            while(b<=a)
//            {
//                tv.append(String.valueOf(b));
//                b++;
//            }
//            tv.append("\n");
//            a++;
//        }
//        for(int a =1 ;a<=5;a++)
//        {
//            for(int b =1 ;b<=a;b++)
//            {
//                tv.append("*");
//            }
//            tv.append("\n");
//        }

    }
}
