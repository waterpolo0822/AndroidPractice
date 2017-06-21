package com.example.george.sqllite1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends Activity {
    EditText name, age;
    Button register, show, delete, deleteall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyOpenHelper helper = new MyOpenHelper(getApplicationContext());
        final SQLiteDatabase db = helper.getWritableDatabase();
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        register = (Button) findViewById(R.id.register);
        show = (Button) findViewById(R.id.show);
        delete = (Button) findViewById(R.id.delete);
        deleteall = (Button) findViewById(R.id.deleteall);
//        search = (Button)findViewById(R.id.search);
//        result = (TextView)findViewById(R.id.result);
        final String namae = name.getText().toString();
        final int tosi = Integer.parseInt(age.getText().toString());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("name", namae);
                values.put("age", tosi);
                db.insert("register", null, values);
                name.setText(null);
                age.setText(null);
                Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_LONG).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this, ShowDataBase.class);
                startActivity(m);
            }
        });
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = helper.getReadableDatabase();
//                Cursor cursor = db.query("Register",new String[]{"name","age"},"name = ?",
//                                         new String[]{namae},null,null,null);
//                boolean mov = cursor.moveToFirst();
//                while(mov){
//                    result.setText(cursor.getString(0)+String.valueOf(cursor.getInt(1)));
//                    cursor.moveToNext();
//                }
//                cursor.close();
//                db.close();
//
//            }
//        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("register", "name = ?", new String[]{namae});
            }
        });
        deleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("register",null,null);
            }
        });
    }
}

