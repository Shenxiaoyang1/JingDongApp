package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/16.
 */

public interface IDetailsListModel {
    public void onShowDetails(String pid,OnNetlistener<DetailsListBean> onNetlistener);
    public void OnShowMsg(String pid, String uid, String token, OnNetlistener<AddCard> onNetlistener);
}
