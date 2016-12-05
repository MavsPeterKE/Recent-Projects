package com.example.peter_pc.companyprofiler;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here
    public CustomAdapter(Context context, ArrayList<Item> data) //modify here
    {
        this.mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual movie
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);//modify here
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);//modify here
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);//modify here
            viewHolder.tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);//modify here
            viewHolder.imgMain = (ImageView) convertView.findViewById(R.id.imgMain);//modify here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Item b = data.get(position);//modify here
        viewHolder.tvName.setText(b.getName());//modify here
        viewHolder.tvEmail.setText(b.getEmail());//modify here
        viewHolder.tvPhone.setText(b.getPhone());//modify here
        viewHolder.tvLocation.setText(b.getLocation());//modify here
        //viewHolder.imgMain.setImageResource(R.drawable.boma);//modify here
        Picasso.with(mContext).load("http://cypressoutlook.com/config/images/"+b.getImgUrl()).into(viewHolder.imgMain);
        return convertView;

    }
    static class ViewHolder {
        TextView tvName;//modify here
        TextView tvEmail;//modify here
        TextView tvPhone;//modify here
        TextView tvLocation;//modify here
        ImageView imgMain;

    }

}