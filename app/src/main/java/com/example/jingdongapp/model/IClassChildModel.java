package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/15.
 */

public interface IClassChildModel {
    public void OnShowChild(int cid,OnNetlistener<ClassChildBean> onNetlistener);
}
