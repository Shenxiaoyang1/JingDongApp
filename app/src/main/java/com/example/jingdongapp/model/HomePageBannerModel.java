package com.example.jingdongapp.model;

import android.util.Log;
import android.widget.LinearLayout;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class HomePageBannerModel implements IHomePageBannerModel {
    @Override
    public void onShowBanner(final OnNetlistener<HomePageBanner> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.bannerList()
                 .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomePageBanner>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        Log.d("TAG",message);
                    }

                    @Override
                    public void onNext(HomePageBanner homePageBanner) {
                       onNetlistener.onSuccess(homePageBanner);
                    }
                });

    }

}
