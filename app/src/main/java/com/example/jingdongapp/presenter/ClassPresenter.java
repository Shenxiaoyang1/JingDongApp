package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.model.ClassModel;
import com.example.jingdongapp.model.IClassModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.ClassView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class ClassPresenter {
 public ClassView classView;
 public IClassModel iClassModel;

    public ClassPresenter(ClassView classView) {
        this.classView = classView;
        iClassModel = new ClassModel();
    }
    public void OnShowClass(){
        iClassModel.OnShowClass(new OnNetlistener<GridListBean>() {
            @Override
            public void onSuccess(GridListBean gridListBean) {
                List<GridListBean.DataBean> data = gridListBean.getData();
                classView.OnShowClass(data);

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
