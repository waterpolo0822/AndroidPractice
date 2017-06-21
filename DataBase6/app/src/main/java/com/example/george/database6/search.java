package com.example.george.database6;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class search extends AppCompatActivity {
    EditText id;
    Button search;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        id = (EditText)findViewById(R.id.id);
        search = (Button)findViewById(R.id.search);
        text = (TextView)findViewById(R.id.text);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase helper = new DataBase(getApplicationContext());
                int a  = Integer.parseInt(id.getText().toString());
                helper.search(a,text);
            }
        });
    }
}
