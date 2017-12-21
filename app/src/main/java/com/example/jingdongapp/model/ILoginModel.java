package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.LoginBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public interface ILoginModel {
    public void OnLogin(String mobile, String password, OnNetlistener<LoginBean>onNetlistener);

}
