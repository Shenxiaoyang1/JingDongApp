package com.example.jingdongapp.model;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.net.OnNetlistener;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public interface IHomePageBannerModel {
    public void onShowBanner(OnNetlistener<HomePageBanner> onNetlistener);

}
