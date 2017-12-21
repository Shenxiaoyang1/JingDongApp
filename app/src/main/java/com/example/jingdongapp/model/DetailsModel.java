package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public class DetailsModel implements IDetailsModel{
    @Override
    public void onShowDetails(String pscid, final OnNetlistener<DetailsBean> onNetlistener) {
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.detailsList(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DetailsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetlistener.onError((Exception) e);
                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        onNetlistener.onSuccess(detailsBean);
                    }
                });


    }
}
