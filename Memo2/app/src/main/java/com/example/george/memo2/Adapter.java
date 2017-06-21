package com.example.george.memo2;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by george on 2017/06/15.
 */

public class Adapter extends ResourceCursorAdapter {
    public Adapter (Context context,int layout,Cursor cursor,int flags)
    {
        super(context,layout,cursor,flags);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        TextView textView = (TextView)view.findViewById(R.id.title1);
        textView.setText(title);

    }
}
