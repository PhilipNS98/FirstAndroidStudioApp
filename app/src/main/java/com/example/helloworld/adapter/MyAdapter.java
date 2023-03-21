package com.example.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloworld.R;
import com.example.helloworld.model.Item;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Item> items;
    private LayoutInflater inflater;

    public MyAdapter(List<Item> item, Context context) {
        this.items = item;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // inflate
        if (view == null) {
            view = inflater.inflate(R.layout.myrow, null);
        }
        TextView textView = view.findViewById(R.id.rowTextView);
        textView.setText(items.get(position).getText());
        ImageView imageView = view.findViewById(R.id.rowImageView);
        imageView.setImageResource(items.get(position).getImage());


        return view;
    }
}
