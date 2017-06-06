package com.example.george.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button add,sub,man,div;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        man=(Button)findViewById(R.id.man);
        div=(Button)findViewById(R.id.div);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        man.setOnClickListener(this);
        div.setOnClickListener(this);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
    }

    @Override
    public void onClick(View v) {
        int a=Integer.parseInt(et1.getText().toString());
        int b=Integer.parseInt(et2.getText().toString());
        Intent m=new Intent(MainActivity.this,Main2Activity.class);
        switch (v.getId())
        {
            case R.id.add:
            {
                int c=a+b;
                m.putExtra("result",String.valueOf(c));
            }break;
            case R.id.sub:
            {
                int d=a-b;
                m.putExtra("result",String.valueOf(d));
            }break;
            case R.id.man:
            {
                int e=a*b;
                m.putExtra("result",String.valueOf(e));
            }break;
            case R.id.div:
            {
                int f=a/b;
                m.putExtra("result",String.valueOf(f));
            }break;
        }
        startActivity(m);

    }
}
