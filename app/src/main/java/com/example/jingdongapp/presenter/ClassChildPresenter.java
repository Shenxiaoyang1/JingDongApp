package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.model.ClassChildModel;
import com.example.jingdongapp.model.IClassChildModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.ClassChildView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public class ClassChildPresenter {
    public IClassChildModel iClassChildModel;
    public ClassChildView classChildView;
    public List<List<ClassChildBean>> lists = new ArrayList<>();

    public ClassChildPresenter(ClassChildView classChildView) {
        this.classChildView = classChildView;
        iClassChildModel = new ClassChildModel();
    }

    public void OnShowClass(final int cid){
      iClassChildModel.OnShowChild(cid, new OnNetlistener<ClassChildBean>() {
          @Override
          public void onSuccess(ClassChildBean classChildBean) {
              List<ClassChildBean.DataBean> data = classChildBean.getData();
              classChildView.OnShowClassChild(data);
          }

          @Override
          public void onError(Exception e) {

          }
      });
    }
}
