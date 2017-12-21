package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.model.DetailsModel;
import com.example.jingdongapp.model.IDetailsModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.DetailsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public class DetailsPresenter {
    public DetailsView detailsView;
    public IDetailsModel iDetailsModel;

    public DetailsPresenter(DetailsView detailsView) {
        this.detailsView = detailsView;
        iDetailsModel = new DetailsModel();
    }
    public void onShowDetails(String pscid){
        iDetailsModel.onShowDetails(pscid, new OnNetlistener<DetailsBean>() {
            @Override
            public void onSuccess(DetailsBean detailsBean) {
                List<DetailsBean.DataBean> data = detailsBean.getData();
                detailsView.OnShowDetails(data);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
