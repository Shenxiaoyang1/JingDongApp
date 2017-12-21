package com.example.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.GridListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class MyGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<GridListBean.DataBean> list;
    public Context context;
    public LayoutInflater inflater;

    public MyGridAdapter(List<GridListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.gridview, null);
//        View view = inflater.inflate(R.layout.gridview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GridListBean.DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ((MyViewHolder) holder).name.setText(dataBean.getName());
        ((MyViewHolder) holder).img.setImageURI(dataBean.getIcon());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }
}
