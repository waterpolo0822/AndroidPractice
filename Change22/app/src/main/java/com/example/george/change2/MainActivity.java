package com.example.george.change2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView4);
        tv4=(TextView)findViewById(R.id.textView5);
        tv5=(TextView)findViewById(R.id.textView6);
        tv6=(TextView)findViewById(R.id.textView7);
        tv7=(TextView)findViewById(R.id.textView8);
        tv8=(TextView)findViewById(R.id.textView9);
        btn=(Button)findViewById(R.id.button);
    }
    public void Changes(View v)
    {
        tv5.setText("Raz");
        tv6.setText("Delhi");
        tv8.setText("IT");

    }


}
