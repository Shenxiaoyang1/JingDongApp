package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/16.
 */

public class DetailsListsModel implements IDetailsListModel {
    @Override
    public void onShowDetails(String pid, final OnNetlistener<DetailsListBean> onNetlistener) {
        RetrofitHelper.stringApi().detailsLists(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DetailsListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DetailsListBean detailsListBean) {
                       onNetlistener.onSuccess(detailsListBean);
                    }
                });
    }

    //展示架构信息
    @Override
    public void OnShowMsg(String pid, String uid, String token, final OnNetlistener<AddCard> onNetlistener) {
        RetrofitHelper.stringApi().addCart(pid,uid,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddCard>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AddCard addCard) {
                        onNetlistener.onSuccess(addCard);
                    }
                });
    }
}
