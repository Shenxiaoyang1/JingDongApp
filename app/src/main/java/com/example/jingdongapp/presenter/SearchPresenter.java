package com.example.jingdongapp.presenter;

import com.example.jingdongapp.SearchActivity;
import com.example.jingdongapp.bean.SearchListBean;
import com.example.jingdongapp.model.ISearchModel;
import com.example.jingdongapp.model.SearchModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.SearchView;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/13.
 */

public class SearchPresenter {
    public ISearchModel iSearchModel;
    public SearchView searchView;

    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        iSearchModel = new SearchModel();
    }

    //查询的参数
    public void OnShowSearch(final String name){
        iSearchModel.onShowSearch(name, new OnNetlistener<SearchListBean>() {
            @Override
            public void onSuccess(SearchListBean searchListBean) {
                List<SearchListBean.DataBean> data = searchListBean.getData();
                searchView.onShowSearch(data);

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
