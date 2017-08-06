package com.multiplelisttest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by zhangjiaying on 2017/8/6.
 */

public class MyAdapter extends ArrayAdapter<ItemBean>{
    private Context context;
    private List<ItemBean> lists;

    public MyAdapter(Context context, int resource, List<ItemBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.lists = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
