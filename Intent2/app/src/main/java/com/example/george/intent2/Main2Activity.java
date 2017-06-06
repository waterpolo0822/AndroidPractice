
package com.example.george.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res=(TextView)findViewById(R.id.result);
        //
        // Intent m=getIntent();
        //String result=m.getStringExtra("result");
        String resultss = getIntent().getExtras().getString("result");
        res.append(resultss);
    }
}
