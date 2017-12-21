package com.example.jingdongapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jingdongapp.DetailsActivity;
import com.example.jingdongapp.R;
import com.example.jingdongapp.adapter.MyClassAdapter;
import com.example.jingdongapp.adapter.MyExplandListAdapter;
import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.presenter.ClassChildPresenter;
import com.example.jingdongapp.presenter.ClassPresenter;
import com.example.jingdongapp.view.ClassChildView;
import com.example.jingdongapp.view.ClassView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/12.
 */

public class Fragment2 extends Fragment implements ClassView,ClassChildView{
    private View view;
    private ListView mLv;
    private ClassPresenter classPresenter;
    private ExpandableListView elv;
    public ClassChildPresenter classChildPresenter;
    private List<String> listParent = new ArrayList<>();
    private  List<List<ClassChildBean.DataBean.ListBean>> childList = new ArrayList<>();
    public MyExplandListAdapter myExplandListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        initView(view);
        classPresenter = new ClassPresenter(this);
        classChildPresenter = new ClassChildPresenter(this);
        classPresenter.OnShowClass();

        return view;
    }

    private void initView(View view) {
        mLv = (ListView) view.findViewById(R.id.lv);
        elv = view.findViewById(R.id.rcy);
    }
//条目点击事件
    @Override
    public void OnShowClass(final List<GridListBean.DataBean> lists) {
        mLv.setAdapter(new MyClassAdapter(lists,getContext()));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int cid = lists.get(i).getCid();
                classChildPresenter.OnShowClass(cid);
                Toast.makeText(getContext(),cid+"",Toast.LENGTH_SHORT).show();

            }
        });
    }
//展示二级列表
    @Override
    public void OnShowClassChild(List<ClassChildBean.DataBean> allList) {
        for (int i = 0; i <allList.size() ; i++) {
             listParent.add(allList.get(i).getName());
             childList.add(allList.get(i).getList()) ;

        }
        myExplandListAdapter = new MyExplandListAdapter(getContext(),listParent,childList);
        elv.setAdapter(myExplandListAdapter);
        for (int i = 0; i <allList.size() ; i++) {
            elv.expandGroup(i);
        }

    }
}
