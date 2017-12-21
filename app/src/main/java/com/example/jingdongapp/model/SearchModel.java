package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.SearchListBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class SearchModel implements ISearchModel {
    @Override
    public void onShowSearch(String name, final OnNetlistener<SearchListBean> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.searchList(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchListBean searchListBean) {
                        onNetlistener.onSuccess(searchListBean);
                    }
                });
    }


}
