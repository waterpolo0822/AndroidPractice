package com.example.george.database6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class delete extends AppCompatActivity {
    EditText kesu;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        kesu = (EditText)findViewById(R.id.kesu);
        delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(kesu.getText().toString());
                DataBase helper = new DataBase(getApplicationContext());
                helper.delete(a);
            }
        });
    }
}
