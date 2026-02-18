package com.app.labbca6thsem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] items;
    int[] images;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] items, int[] images) {
        this.context = context;
        this.items = items;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.item_icon);
        TextView name = convertView.findViewById(R.id.item_name);

        icon.setImageResource(images[position]);
        name.setText(items[position]);

        return convertView;
    }
}
