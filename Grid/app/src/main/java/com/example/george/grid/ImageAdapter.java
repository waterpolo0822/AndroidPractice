package com.example.george.grid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by george on 2017/06/15.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mcontext;
    public ImageAdapter (Context mcontext)
    {this.mcontext = mcontext;}

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null)
        {
            imageView = new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }
        else
        {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.app,
            R.drawable.bmw,
            R.drawable.burgerking,
            R.drawable.coca,
            R.drawable.facebook,
            R.drawable.fanta,
            R.drawable.flog,
            R.drawable.google,
            R.drawable.intel,
            R.drawable.lego,
            R.drawable.logp,
            R.drawable.nexus,
            R.drawable.nike,
            R.drawable.olympic,
            R.drawable.panda,
            R.drawable.starbucks,
            R.drawable.twitter,
            R.drawable.unity,
            R.drawable.volks,
            R.drawable.youtube,
            R.drawable.icc,
            R.drawable.microsoft,
            R.drawable.ryu,
            R.drawable.hua,
            R.drawable.pengin,
            R.drawable.hm,
            R.drawable.monkey,
            R.drawable.twitter2,
            R.drawable.ok,
            R.drawable.busin,
            R.drawable.google2,
            R.drawable.green,
            R.drawable.music,
            R.drawable.elephant,
            R.drawable.lions,
            R.drawable.android,
            R.drawable.candy
    };
}
