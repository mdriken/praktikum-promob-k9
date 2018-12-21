package com.example.riken.etic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.riken.etic.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter <String> {

    Context context;
    String[] names;
    ArrayList<String> mylist = new ArrayList<String>();

    public CustomAdapter(Context context, ArrayList<String> mylist) {
        super(context, R.layout.spinner_item, mylist);
        this.context = context;
        this.mylist = mylist;
//        this.images = images;

    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item,null);
        TextView tl = (TextView)row.findViewById(R.id.tv_kursi);
//        ImageView il = (ImageView)row.findViewById(R.id.iv_kursi);

        tl.setText(mylist.get(position));
//        il.setImageResource(images[position]);

        return row ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item,null);
        TextView tl = (TextView)row.findViewById(R.id.tv_kursi);
//        ImageView il = (ImageView)row.findViewById(R.id.iv_kursi);

        tl.setText(mylist.get(position));
//        il.setImageResource(images[position]);

        return row ;

    }
}
