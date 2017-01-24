package com.example.peter_pc.companyprofiler;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NavDrawerAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here
    public NavDrawerAdapter(Context context, ArrayList<Item> data) //modify here
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
        return data.get(position);// get the actual data position
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
            convertView = inflater.inflate(R.layout.list_item_layout2, parent,false);//modify here
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvNames);//modify here
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tvEmails);//modify here
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhones);//modify here
            viewHolder.tvLocation = (TextView) convertView.findViewById(R.id.tvLocationss);//modify here
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
        return convertView;

    }
    static class ViewHolder {
        TextView tvName;//modify here
        TextView tvEmail;//modify here
        TextView tvPhone;//modify here
        TextView tvLocation;//modify here

    }

}