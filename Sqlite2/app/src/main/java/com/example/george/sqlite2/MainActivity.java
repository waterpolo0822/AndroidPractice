package com.example.george.sqlite2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button register,show,delete,deleteall,search;
    EditText name,age;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OpenHelper helper = new OpenHelper(this);
        register = (Button)findViewById(R.id.register);
        show = (Button)findViewById(R.id.show);
        delete = (Button)findViewById(R.id.delete);
        deleteall = (Button)findViewById(R.id.deleteall);
        search = (Button)findViewById(R.id.serch);
        result = (TextView)findViewById(R.id.result);

        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                String namae = name.getText().toString();
                int tosi = Integer.parseInt(age.getText().toString());
                values.put("name",namae);
                values.put("age",tosi);
                db.insert("misao",null,values);
                name.setText(null);
                age.setText(null);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(MainActivity.this,ShowDatabase.class);
                startActivity(m);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namae = name.getText().toString();
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("misao","name=?",new String[]{namae});
            }
        });
        deleteall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("misao",null,null);
                db.close();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                String namae = name.getText().toString();

                Cursor cursor = db.query
                        ("misao",new String[]{"name","age"},
                                "name = ?",new String[]{namae},null,null,null);
                boolean mov = cursor.moveToFirst();
                while (mov){
                    result.setText(cursor.getString(0)+String.valueOf(cursor.getInt(1)));
                    mov=cursor.moveToNext();

                }
                cursor.close();
                db.close();
            }
        });

    }
}
