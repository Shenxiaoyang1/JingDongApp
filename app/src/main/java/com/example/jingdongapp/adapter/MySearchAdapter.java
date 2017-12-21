package com.example.jingdongapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.SearchListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class MySearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<SearchListBean.DataBean> list;
    public Context context;
    public LayoutInflater inflater;

    public MySearchAdapter(List<SearchListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    public OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        public void OnClick(String pid);
    }
    public void SetOnItemClick(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = inflater.inflate(R.layout.fenye_item,null);
        return new MySearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MySearchViewHolder mySearchViewHolder;
        mySearchViewHolder = (MySearchViewHolder) holder;
        final SearchListBean.DataBean dataBean = list.get(position);
        mySearchViewHolder.fresco.setImageURI(dataBean.getImages());
        mySearchViewHolder.price.setText(dataBean.getPrice());
        mySearchViewHolder.title.setText(dataBean.getTitle());
        mySearchViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnClick(dataBean.getPid());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MySearchViewHolder extends RecyclerView.ViewHolder{
       SimpleDraweeView fresco;
       TextView price,title;
       LinearLayout ll;
        public MySearchViewHolder(View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.fresco);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            ll = itemView.findViewById(R.id.ll);

        }
    }
}
