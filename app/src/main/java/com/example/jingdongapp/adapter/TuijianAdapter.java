package com.example.jingdongapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.HomePageBanner;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/17.
 */

public class TuijianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   public List<HomePageBanner.TuijianBean.ListBean> list;
   public Context context;
   public LayoutInflater inflater;

   //2.定义一个全局变量
    public OnItemClickListener onItemClickListener;
   //1.定义一节接口
    public interface OnItemClickListener{
        public void OnClick(String pid);
    }
    //3.定义一个方法，进行调用
    public void OnClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public TuijianAdapter(List<HomePageBanner.TuijianBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tuijian,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          MyViewHolder myViewHolder = (MyViewHolder) holder;
        final HomePageBanner.TuijianBean.ListBean listBean = list.get(position);
        myViewHolder.fresco.setImageURI(listBean.getImages());
        myViewHolder.price.setText(listBean.getPrice());
        myViewHolder.title.setText(listBean.getTitle());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              onItemClickListener.OnClick(listBean.getPid());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView fresco;
        TextView title,price;
        LinearLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.fresco);
            title = itemView.findViewById(R.id.titile);
            price = itemView.findViewById(R.id.price);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
