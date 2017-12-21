package com.example.jingdongapp.presenter;

import android.util.Log;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.model.GridModel;
import com.example.jingdongapp.model.HomePageBannerModel;
import com.example.jingdongapp.model.IGridModel;
import com.example.jingdongapp.model.IHomePageBannerModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.Fragment_tuijianActivity;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class GridPresenter {
    Fragment_tuijianActivity fragment_tuijianActivity;
    IGridModel iGridModel;

    public GridPresenter(Fragment_tuijianActivity fragment_tuijianActivity) {
        this.fragment_tuijianActivity = fragment_tuijianActivity;
        iGridModel= new GridModel();
    }
    public void onShowGrid(){
      iGridModel.onShowGrid(new OnNetlistener<GridListBean>() {
          @Override
          public void onSuccess(GridListBean gridListBean) {
              List<GridListBean.DataBean> dataList = gridListBean.getData();
              fragment_tuijianActivity.onShowGrid(dataList);
              Log.d("集合是",dataList.toString());
          }

          @Override
          public void onError(Exception e) {

          }
      });
    }
}
