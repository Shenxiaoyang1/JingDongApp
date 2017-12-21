package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.LoginBean;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.net.RetrofitHelper;
import com.example.jingdongapp.net.StringApi;

import java.util.HashMap;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class LoginModel implements ILoginModel{
    @Override
    public void OnLogin(String mobile, String password, final OnNetlistener<LoginBean> onNetlistener) {
      /*  HashMap<String, String> mapList = new HashMap<>();
        mapList.put("mobile",mobile);
        mapList.put("password",password);*/
        StringApi stringApi = RetrofitHelper.stringApi();
        stringApi.loginList(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                         onNetlistener.onSuccess(loginBean);
                    }
                });
    }
}
