package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.SearchListBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public interface ISearchModel {
    public void onShowSearch(String name ,OnNetlistener<SearchListBean> onNetlistener);
}
