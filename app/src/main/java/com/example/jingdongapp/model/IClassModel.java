package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public interface IClassModel {
    public void OnShowClass(OnNetlistener<GridListBean> onNetlistener);

}
