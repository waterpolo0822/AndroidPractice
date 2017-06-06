package com.example.george.popup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.editText);
        btn1=(Button)findViewById(R.id.button);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String aaa = et1.getText().toString();
        Toast.makeText(MainActivity.this,aaa
                ,Toast.LENGTH_LONG).show();

    }
}
