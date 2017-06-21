package com.example.george.spinner3;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by george on 2017/06/20.
 */

public class Adapter extends ResourceCursorAdapter {
    public Adapter (Context context,int layout,Cursor cursor,int flags){
        super(context,layout,cursor,flags);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String song = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        TextView name = (TextView)view.findViewById(R.id.naming);
        name.setText(song);
    }
}
