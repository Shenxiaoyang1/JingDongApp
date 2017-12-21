package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.RegistBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class RegistModel implements IRegistModel {
    @Override
    public void onShowNews(String mobile, String password, final OnNetlistener<RegistBean> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.registList(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RegistBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegistBean registBean) {
                        onNetlistener.onSuccess(registBean);
                    }
                });
    }
}
