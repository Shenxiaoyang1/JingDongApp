package com.example.jingdongapp.view;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public interface LoginView {
    public void onGetNew(String code,String msg,String nickName,int uid,String username,String token);
    public void onFailure(Exception e);
}
