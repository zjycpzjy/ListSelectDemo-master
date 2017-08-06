package com.multiplelisttest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果需要提前设置 默认值的 话，需要修改 数据源里的 isSelected
 */

public class MainActivity extends ListActivity {
    private List<ItemBean> lists;
    private List<ItemBean> selected =  new ArrayList<>();
    private RadioButton radioButton;
    private RadioButton multi;
    private RadioGroup rg_content;
    private ListView listView;
    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_main);
        initListData();
        initAdapter();

        radioButton = (RadioButton)findViewById(R.id.single);
        multi = (RadioButton)findViewById(R.id.multi);
        rg_content = (RadioGroup)findViewById(R.id.rg_content);

        initRadioGroup();
    }

    private void initAdapter(){
        adapter =  new ListAdapter(this,lists);
        setListAdapter(adapter);
        listView = getListView();
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    private void initRadioGroup(){
        rg_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.single:
                        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                        adapter.clearAdapter();
                        break;
                    case R.id.multi:
                        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                        adapter.notifyDataSetChanged();
                        adapter.clearAdapter();
                        break;
                }
            }
        });
    }

    private void initListData(){
        lists = new ArrayList<>();
        for(int i = 0; i< 35; i++){
            ItemBean bean = new ItemBean();
            bean.setKey(i);
            bean.setValue(i+"选择列表de ");
            lists.add(bean);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
            ItemBean select = lists.get(position);
            select.setSelected(!select.isSelected());
        getSelected(position,select);
    }

    private void getSelected(int poi,ItemBean select){
        selected.clear();selected.add(select);
        if(lists != null && lists.size() > 0){
            for(ItemBean bean :lists){
                if(bean.isSelected()){
                    selected.add(bean);
                }else{
                    if(selected.contains(bean)){
                        selected.remove(bean);
                    }
                }
            }
        }
        Toast.makeText(this,"一共选择了："+selected.size()+"个",Toast.LENGTH_SHORT).show();
    }
}
