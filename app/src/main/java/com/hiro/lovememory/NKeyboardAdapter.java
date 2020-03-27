package com.hiro.lovememory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;
import java.util.logging.Handler;

public class NKeyboardAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> numList;

    public NKeyboardAdapter(Context context, int layout, List<String> numList) {
        this.context = context;
        this.layout = layout;
        this.numList = numList;
    }

    @Override
    public int getCount() {
        return numList.size();
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
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.btnNum = convertView.findViewById(R.id.btnNum);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        return convertView;
    }

    private class ViewHolder{
        Button btnNum;
    }
}
