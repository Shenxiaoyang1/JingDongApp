package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.RegistBean;
import com.example.jingdongapp.model.IRegistModel;
import com.example.jingdongapp.model.RegistModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.RegistView;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class RegistPresenter {
    public static IRegistModel iRegistModel;
    public static RegistView registView;

    public RegistPresenter(RegistView registView) {
        this.registView = registView;
        iRegistModel = new RegistModel();
    }

    public void onShowNews(String mobile,String password){
        iRegistModel.onShowNews(mobile, password, new OnNetlistener<RegistBean>() {
            @Override
            public void onSuccess(RegistBean registBean) {
                String code = registBean.getCode();
                String msg = registBean.getMsg();
                registView.show(code,msg);

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
