package com.example.androidcustomgridlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] imageId;

    public CustomGrid(Context c, String[] web, int[] imageId) {
        mContext = c;
        this.imageId = imageId;
        this.web = web;
    }

    @Override
    public int getCount() {
        return web.length;
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            // Inflate the grid_single layout if it's null
            grid = inflater.inflate(R.layout.grid_single, null);
        } else {
            grid = convertView;
        }

        // Set the data for each grid item
        TextView textView = grid.findViewById(R.id.grid_text);
        ImageView imageView = grid.findViewById(R.id.grid_image);

        textView.setText(web[position]);
        imageView.setImageResource(imageId[position]);

        return grid;
    }
}
