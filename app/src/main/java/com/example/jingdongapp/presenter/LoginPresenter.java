package com.example.jingdongapp.presenter;

import com.example.jingdongapp.bean.LoginBean;
import com.example.jingdongapp.model.ILoginModel;
import com.example.jingdongapp.model.LoginModel;
import com.example.jingdongapp.net.OnNetlistener;
import com.example.jingdongapp.view.LoginView;

/**
 * Created by 申晓杨 on 2017/12/14.
 */

public class LoginPresenter {
    public LoginView loginView;
    public ILoginModel loginModel;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }
    //获取输入名字和密码
    public void getNews(String mobile,String pass){
        loginModel.OnLogin(mobile, pass, new OnNetlistener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                String code = loginBean.getCode();
                String msg = loginBean.getMsg();
                int uid = loginBean.getData().getUid();
                String nickname =(String) loginBean.getData().getNickname();
                String username = loginBean.getData().getUsername();
                String token = loginBean.getData().getToken();
                loginView.onGetNew(code,msg,nickname,uid,username,token);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    };
}
