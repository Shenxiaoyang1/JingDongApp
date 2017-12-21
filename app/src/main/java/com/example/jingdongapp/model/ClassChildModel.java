package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public class ClassChildModel implements IClassChildModel {
    @Override
    public void OnShowChild(int cid, final OnNetlistener<ClassChildBean> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.classList(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ClassChildBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ClassChildBean classChildBean) {
                            onNetlistener.onSuccess(classChildBean);
                    }
                });
    }
}
