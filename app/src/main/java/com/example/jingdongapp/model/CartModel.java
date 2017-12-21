package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.CartList;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/18.
 */

public class CartModel implements ICartModel {
    @Override
    public void getCart(String uid, String token, final OnNetlistener<CartList> onNetlistener) {
        RetrofitHelper.stringApi().cartList(uid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CartList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CartList cartList) {
                      onNetlistener.onSuccess(cartList);
                    }
                });
    }
}
