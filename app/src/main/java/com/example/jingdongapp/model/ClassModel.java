package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class ClassModel implements  IClassModel {
    @Override
    public void OnShowClass(final OnNetlistener<GridListBean> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.gridList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GridListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(GridListBean gridListBean) {
                       onNetlistener.onSuccess(gridListBean);
                    }
                });

    }
}
