package com.example.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.ClassChildBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;


/**
 * Created by peng on 2017/11/9.
 * 分类右侧的gridView
 */

public class ElvRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ClassChildBean.DataBean.ListBean> listBeen;
    //2、定义一个属性
    private OnItemClickListener onItemClickListener;

    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener {
        public void onItemClick(String pscid);
    }

    //3、定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ElvRvAdapter(Context context, List<ClassChildBean.DataBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.elv_rv_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ClassChildBean.DataBean.ListBean listBean = listBeen.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(listBean.getName());
        myViewHolder.iv.setImageURI(listBean.getIcon());
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(listBean.getPscid()+"");

            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private SimpleDraweeView iv;
        private TextView tv;
        private LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }

}
