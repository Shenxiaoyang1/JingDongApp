package com.example.jingdongapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.adapter.MyGridAdapter;
import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.presenter.GridPresenter;
import com.example.jingdongapp.presenter.HomePageBannerPresenter;
import com.example.jingdongapp.view.Fragment_tuijianActivity;
import com.example.jingdongapp.view.HomePageBannerActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class Fragment_tujian1 extends Fragment implements Fragment_tuijianActivity{
  public List<GridListBean.DataBean> list = new ArrayList<>();
   public RecyclerView recyclerView;
    public MyGridAdapter myGridAdapter;
    public GridPresenter gridPresenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tuijian_fragment,container,false);
       recyclerView = view.findViewById(R.id.rcy);
        gridPresenter = new GridPresenter(this);
        gridPresenter.onShowGrid();
        return view;
    }



    @Override
    public void onShowGrid(List<GridListBean.DataBean> gridList) {
        for (int i = 0; i <10 ; i++) {
            GridListBean.DataBean dataBean = gridList.get(i);
            list.add(dataBean);
        }
        Log.e("=========",gridList.size()+"");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 5);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyGridAdapter myGridAdapter = new MyGridAdapter(list, getActivity());
        recyclerView.setAdapter(myGridAdapter);

    }
}
