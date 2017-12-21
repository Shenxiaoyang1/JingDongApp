package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.model.HomePageBannerModel;
import com.example.jingdongapp.model.IHomePageBannerModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.HomePageBannerActivity;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class HomePageBannerPresenter {
    public static IHomePageBannerModel iHomePageBannerModel;
    public static HomePageBannerActivity homePageBannerActivity;

    public HomePageBannerPresenter(HomePageBannerActivity homePageBannerActivity) {
        this.homePageBannerActivity = homePageBannerActivity;
        iHomePageBannerModel = new HomePageBannerModel();
    }
//展示轮播图
    public void OnShowBanner(){
        iHomePageBannerModel.onShowBanner(new OnNetlistener<HomePageBanner>() {
            @Override
            public void onSuccess(HomePageBanner homePageBanner) {
                List<HomePageBanner.DataBean> data = homePageBanner.getData();
                homePageBannerActivity.onShowBanner(data);
                homePageBannerActivity.onShowTuijian(homePageBanner);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


}
