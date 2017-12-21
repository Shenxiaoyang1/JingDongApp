package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public interface IDetailsModel {
    public void  onShowDetails(String pscid,OnNetlistener<DetailsBean> onNetlistener);
}
