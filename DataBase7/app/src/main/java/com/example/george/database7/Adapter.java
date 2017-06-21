package com.example.george.database7;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by george on 2017/06/15.
 */

public class Adapter extends ResourceCursorAdapter {
    LayoutInflater inflater;
    public Adapter(Context context,int layout,Cursor cursor,int flags)
    {
        super(context,layout,cursor,flags);
    }
//    @Override
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        return inflater.inflate(R.layout.list_item,parent,false);
//    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String namae = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        TextView name = (TextView)view.findViewById(R.id.naming);
        name.setText(namae);
    }
}
