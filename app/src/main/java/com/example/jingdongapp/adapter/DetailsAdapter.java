package com.example.jingdongapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jingdongapp.DetailsActivity;
import com.example.jingdongapp.DetailsListActivity;
import com.example.jingdongapp.R;
import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.bean.SearchListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public class DetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<DetailsBean.DataBean> list;
    public Context context;
    public LayoutInflater inflater;

    public DetailsAdapter(List<DetailsBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    //2、定义一个属性
    private DetailsAdapter.OnItemClickListener onItemClickListener;

    //1、接口回调第一步，先定义一个接口
    public interface OnItemClickListener {
        public void onItemClick(String pid);
    }

    //3、定义一个方法
    public void setOnItemClickListener(DetailsAdapter.OnItemClickListener onItemClickListener) {
       this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fenye_item,null);
        return new MyDetailsView(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyDetailsView myDetailsView;
        myDetailsView = (MyDetailsView) holder;
        final DetailsBean.DataBean dataBean = list.get(position);
        String images = dataBean.getImages();
        String[] split = images.split("\\|");
       myDetailsView.fresco.setImageURI(split[0]);
       myDetailsView.price.setText(dataBean.getPrice());
       myDetailsView.title.setText(dataBean.getTitle());

        //设置点击事件
        myDetailsView.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               onItemClickListener.onItemClick(dataBean.getPid()+"");
               /* Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("pid",dataBean.getPid()+"");
                context.startActivity(intent);*/

                Log.d("rrr", String.valueOf(dataBean.getPid()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyDetailsView extends RecyclerView.ViewHolder{
        SimpleDraweeView fresco;
        TextView price,title;
        LinearLayout ll;
        public MyDetailsView(View itemView) {
            super(itemView);
            fresco = itemView.findViewById(R.id.fresco);
            price = itemView.findViewById(R.id.price);
            title = itemView.findViewById(R.id.title);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
