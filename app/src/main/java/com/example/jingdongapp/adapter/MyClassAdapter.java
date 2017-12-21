package com.example.jingdongapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.GridListBean;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class MyClassAdapter extends BaseAdapter{

    public List<GridListBean.DataBean> list;
    public Context context;
    public LayoutInflater inflater;

    public MyClassAdapter(List<GridListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder;
        if(view==null){
            myViewHolder = new MyViewHolder();
            view = inflater.inflate(R.layout.elv_item1,null);
            myViewHolder.textView = view.findViewById(R.id.tv);
            view.setTag(myViewHolder);
        }else{
            myViewHolder = (MyViewHolder) view.getTag();

        }
        String name = list.get(i).getName();
        myViewHolder.textView.setText(name);
        return view;
    }

    class MyViewHolder {
        TextView textView;
    }
}
