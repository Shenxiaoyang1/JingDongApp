package com.example.jingdongapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.jingdongapp.R;
import com.example.jingdongapp.adapter.MyAdapter;
import com.example.jingdongapp.banner.MessageEvent;
import com.example.jingdongapp.banner.PriceAndCountEvent;
import com.example.jingdongapp.bean.CartList;
import com.example.jingdongapp.net.MyApp;
import com.example.jingdongapp.presenter.CartListPresenter;
import com.example.jingdongapp.view.CartView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/12.
 */

public class Fragment3 extends Fragment implements CartView {
    private View view;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;

    private MyAdapter myAdapter;
    private CartListPresenter cartListPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        initView(view);
        cartListPresenter = new CartListPresenter(this);

        //设置点击事件，获取pid,uid,token值
        String uid = MyApp.sp.getString("uid", "");
        String token= MyApp.sp.getString("token", "");
        cartListPresenter.OnShowNews(uid,token);
        EventBus.getDefault().register(this);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变其他按钮的状态
                myAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        return view;
    }

    private void initView(View view) {
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }

    @Override
    public void OnShow(List<CartList.DataBean> groupList, List<List<CartList.DataBean.ListBean>> childList) {
      myAdapter = new MyAdapter(getContext(), groupList, childList);
        mElv.setAdapter(myAdapter);
        mElv.setGroupIndicator(null);
    }
    @Subscribe
    public void OnMessage(MessageEvent messageEvent){
        //这个方法是其他按钮全部选中，改变的是全选按钮的状态
        mCheckbox2.setChecked(messageEvent.isChecked());
    }
    @Subscribe
    public void OnMessage(PriceAndCountEvent priceAndCountEvent){

        int count = priceAndCountEvent.getCount();
        int price = priceAndCountEvent.getPrice();
        mTvPrice.setText(price+"");
        mTvNum.setText(count+"");

    }


}
