package com.example.george.gridview2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.george.gridview2.R;

/**
 * Created by george on 2017/06/16.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public ImageAdapter (Context context)
    {this.context = context;}
    @Override
    public int getCount() {
        return photos.length;
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
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100,100));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);
        }
        else
        {
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(photos[position]);
        return imageView;
    }
    public int []photos = {
            R.drawable.images,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,



    };
}
