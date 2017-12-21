package com.example.jingdongapp.view;

import com.example.jingdongapp.bean.CartList;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/18.
 */

public interface CartView {
    public void OnShow(List<CartList.DataBean> groupList,List<List<CartList.DataBean.ListBean>> childList);
}
