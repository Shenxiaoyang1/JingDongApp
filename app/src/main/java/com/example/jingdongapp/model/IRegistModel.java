package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.RegistBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public interface IRegistModel {
    public void onShowNews(String mobile, String password, OnNetlistener<RegistBean> onNetlistener);
}
