package com.example.george.afor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView7);
        tv2=(TextView)findViewById(R.id.textView8);
        tv3=(TextView)findViewById(R.id.textView9);
        tv4=(TextView)findViewById(R.id.textView10);
        tv5=(TextView)findViewById(R.id.textView11);
    }
    public void loop(View v) {
        String a = "x";
        int c = 1;
        String f="tv1";

        while (c <= 5) {
            f.setText(a);
            c++;
        }
    }
}
