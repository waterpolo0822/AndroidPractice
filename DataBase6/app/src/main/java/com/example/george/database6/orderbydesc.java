package com.example.george.database6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class orderbydesc extends AppCompatActivity {
    TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderbydesc);
        order = (TextView)findViewById(R.id.order);
        DataBase helper = new DataBase(this);
        helper.order(order);
    }
}
