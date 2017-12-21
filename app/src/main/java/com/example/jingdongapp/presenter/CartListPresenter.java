package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.CartList;
import com.example.jingdongapp.model.CartModel;
import com.example.jingdongapp.model.ICartModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.CartView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/18.
 */

public class CartListPresenter {
  public ICartModel iCartModel;
  public CartView cartView;
  public List<List<CartList.DataBean.ListBean>> childList = new ArrayList<>();

    public CartListPresenter(CartView cartView) {
        this.cartView = cartView;
        iCartModel = new CartModel();
    }
    public void OnShowNews(String uid,String token){
        iCartModel.getCart(uid, token, new OnNetlistener<CartList>() {
            @Override
            public void onSuccess(CartList cartList) {
                List<CartList.DataBean> data = cartList.getData();
                for (int i = 0; i <data.size() ; i++) {
                    List<CartList.DataBean.ListBean> list = data.get(i).getList();
                    childList.add(list);
                }
                cartView.OnShow(data,childList);
            }


            @Override
            public void onError(Exception e) {

            }
        });
    }
}
