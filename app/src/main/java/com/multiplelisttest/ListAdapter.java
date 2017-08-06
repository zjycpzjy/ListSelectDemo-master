/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.multiplelisttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<ItemBean> lists;
    private LayoutInflater mInflater;
    public ListAdapter(Context context , List<ItemBean> lists) {
        this.context = context;
        this.lists = lists;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    public void clearAdapter(){
        if(lists != null && lists.size() > 0 ){
            lists.clear();
        }
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        ItemBean itemBean = lists.get(i);
        if(view == null) {
            holder =  new Holder();
            view = mInflater.inflate(R.layout.muiti_checkbox, null);
            holder.checkedTextView = (CheckedTextView)view.findViewById(R.id.textt);
            view.setTag(holder);
        }else{
            holder = (Holder)view.getTag();
        }
        holder.checkedTextView.setText(itemBean.getValue());
        if(itemBean.isSelected()){
            holder.checkedTextView.setChecked(true);
        }else{
            holder.checkedTextView.setChecked(false);
        }
        return view;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class Holder{
        CheckedTextView checkedTextView;
    }

}
