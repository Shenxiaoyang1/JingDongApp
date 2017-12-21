package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.CartList;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/18.
 */

public interface ICartModel {
    public void getCart(String uid, String token, OnNetlistener<CartList> onNetlistener);
}
