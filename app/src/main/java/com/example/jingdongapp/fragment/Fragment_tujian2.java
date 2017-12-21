package com.example.jingdongapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.adapter.MyGridAdapter;
import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.presenter.GridPresenter;
import com.example.jingdongapp.presenter.HomePageBannerPresenter;
import com.example.jingdongapp.view.Fragment_tuijianActivity;
import com.example.jingdongapp.view.HomePageBannerActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class Fragment_tujian2 extends Fragment implements Fragment_tuijianActivity{
    private RecyclerView recyclerView;
    public GridPresenter gridPresenter;
    public  List<GridListBean.DataBean> lists = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian_fragment2,container,false);
        //gridView = view.findViewById(R.id.gridview);
        recyclerView = view.findViewById(R.id.rcy);
        gridPresenter = new GridPresenter(this);
        gridPresenter.onShowGrid();

        return view;
    }

    @Override
    public void onShowGrid(List<GridListBean.DataBean> gridList) {

        for (int i = 10; i <gridList.size() ; i++) {
            GridListBean.DataBean dataBean = gridList.get(i);
            lists.add(dataBean);
            Log.d("数量    ",lists.size()+"");
        }

        MyGridAdapter gridAdapter = new MyGridAdapter(lists, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),5));
        recyclerView.setAdapter(gridAdapter);
    }
}
