package com.example.george.evenodd;

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
        tv2=(TextView)findViewById(R.id.textView4);
        et=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);
    }
    public void even(View v)
    {

        int a=Integer.parseInt(et.getText().toString());
        String even="EVEN";
        String odd="ODD";
        if(a%2==0)
        {
            tv2.setText(even);
        }
        else
        {
            tv2.setText(odd);
        }
    }
}
