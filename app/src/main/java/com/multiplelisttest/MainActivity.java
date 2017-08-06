package com.multiplelisttest;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果需要提前设置 默认值的 话，需要修改 数据源里的 isSelected
 */

public class MainActivity extends ListActivity {
    List<ItemBean> lists;
   List<ItemBean> selected =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        lists = new ArrayList<>();
        for(int i = 0; i< 35; i++){
            ItemBean bean = new ItemBean();
            bean.setKey(i);
            bean.setValue(i+"nishi de ");
            lists.add(bean);
        }
        setListAdapter(new ListAdapter(this,lists));
        final ListView listView = getListView();

        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

            ItemBean select = lists.get(position);
            select.setSelected(!select.isSelected());

        getSelected();

    }

    private void getSelected(){
        selected.clear();
        if(lists != null && lists.size() > 0){
            for(ItemBean bean :lists){
                if(bean.isSelected()){
                    selected.add(bean);
                    Toast.makeText(this,bean.getValue()+"****"+bean.isSelected()+"",Toast.LENGTH_SHORT).show();
                }
            }
        }
        Toast.makeText(this,"以供选择了："+selected.size()+"个",Toast.LENGTH_SHORT).show();
    }
}
