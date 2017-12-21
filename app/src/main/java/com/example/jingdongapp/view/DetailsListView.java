package com.example.jingdongapp.view;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.presenter.DetailsPresenter;

/**
 * Created by 申晓杨 on 2017/12/16.
 */

public interface DetailsListView {
    public void onShow(DetailsListBean detailsListBean);

    void onShowMsg(AddCard addCard);
}
