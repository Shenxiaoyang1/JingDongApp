package com.example.jingdongapp.net;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.CartList;
import com.example.jingdongapp.bean.ClassChildBean;
import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.bean.GridListBean;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.bean.LoginBean;
import com.example.jingdongapp.bean.RegistBean;
import com.example.jingdongapp.bean.SearchListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public interface StringApi {
    //展示首页banner
    @GET(Api.HOMEPAGE_BANNER)
    Observable<HomePageBanner> bannerList();
    //展示首页网格
    @GET(Api.GRID)
    Observable<GridListBean> gridList();
    //展示搜索
    @GET(Api.SEARCH)
    Observable<SearchListBean> searchList(@Query("keywords") String name);
    //展示登录
    @GET(Api.LOGIN)
    Observable<LoginBean> loginList(@Query("mobile") String mobile, @Query("password") String password);
    //注册
    @GET(Api.REGIST)
    Observable<RegistBean> registList(@Query("mobile") String mobile, @Query("password") String password);
    //展示商品子布局（二级列表）
    @GET(Api.GOODS_CHILD)
    Observable<ClassChildBean> classList(@Query("cid") int cid);
    //商品详情列表
    @GET(Api.GOODS_DETAILS)
    Observable<DetailsBean> detailsList(@Query("pscid") String pscid);
    //展示商品详情
    @GET(Api.GOODS_DETAILS_LIST)
    Observable<DetailsListBean> detailsLists(@Query("pid") String pid);
    //加入购物车
    @GET(Api.ADD_CART)
    Observable<AddCard> addCart(@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);
    //查看购物车
    @GET(Api.CartList)
    Observable<CartList> cartList(@Query("uid") String uid,@Query("token") String token);
}
