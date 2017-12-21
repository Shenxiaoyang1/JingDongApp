package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.model.DetailsListsModel;
import com.example.jingdongapp.model.IDetailsListModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.DetailsListView;

/**
 * Created by 申晓杨 on 2017/12/16.
 */

public class DetailsListPresenter {
    public IDetailsListModel iDetailsListModel;
    public DetailsListView detailsListView;

    public DetailsListPresenter(DetailsListView detailsListView) {
        this.detailsListView = detailsListView;
        iDetailsListModel = new DetailsListsModel();
    }

    public void OnShowDetails(final String pid){
          iDetailsListModel.onShowDetails(pid, new OnNetlistener<DetailsListBean>() {
              @Override
              public void onSuccess(DetailsListBean detailsListBean) {
                  detailsListView.onShow(detailsListBean);
              }

              @Override
              public void onError(Exception e) {

              }
          });
    }

    public void OnShowMsg(String pid,String uid,String token){
        iDetailsListModel.OnShowMsg(pid, uid, token, new OnNetlistener<AddCard>() {
            @Override
            public void onSuccess(AddCard addCard) {
                detailsListView.onShowMsg(addCard);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
