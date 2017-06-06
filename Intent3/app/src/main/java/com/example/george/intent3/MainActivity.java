package com.example.george.intent3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et0,et1,et2,et3,et4,et5,et6,et7,et8;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et0=(EditText)findViewById(R.id.namae);
        et1=(EditText)findViewById(R.id.number);
        et2=(EditText)findViewById(R.id.address);
        et3=(EditText)findViewById(R.id.ongaku);
        et4=(EditText)findViewById(R.id.word);
        et5=(EditText)findViewById(R.id.kuni);
        et6=(EditText)findViewById(R.id.titi);
        et7=(EditText)findViewById(R.id.haha);
        et8=(EditText)findViewById(R.id.undou);
        bt1=(Button)findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et0.getText().toString();
                String phone = et1.getText().toString();
                String email = et2.getText().toString();
                String music = et3.getText().toString();
                String pass = et4.getText().toString();
                String country = et5.getText().toString();
                String father = et6.getText().toString();
                String mother = et7.getText().toString();
                String sports = et8.getText().toString();
                Intent i = new Intent(MainActivity.this,out.class);
                i.putExtra("name",name);
                i.putExtra("phone",phone);
                i.putExtra("email",email);
                i.putExtra("music",music);
                i.putExtra("pass",pass);
                i.putExtra("country",country);
                i.putExtra("father",father);
                i.putExtra("mother",mother);
                i.putExtra("sports",sports);
                startActivity(i);
            }
        });
    }
}
