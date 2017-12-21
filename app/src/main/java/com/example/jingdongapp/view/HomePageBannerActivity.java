package com.example.jingdongapp.view;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public interface HomePageBannerActivity {
    public void onShowBanner(List<HomePageBanner.DataBean> bannerList);
    public void onShowTuijian(HomePageBanner homePageBanner);

}
