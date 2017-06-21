package com.example.george.spinner2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = (TextView)findViewById(R.id.tv);

        int result = getIntent().getExtras().getInt("value");
        String con = getIntent().getExtras().getString("answer");
        String value = String.valueOf(result);
        tv.append(con+value);
    }
}
