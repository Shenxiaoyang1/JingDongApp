package com.example.jingdongapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongapp.net.MyApp;
import com.example.jingdongapp.presenter.LoginPresenter;
import com.example.jingdongapp.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    String code1;
    String msg1;
    public String mobile, password;
    private FragmentManager fragmentManager;
    private SharedPreferences sharedPreferences;
    private ImageView mCha;
    /**
     * 用户名/邮箱/手机号
     */
    private EditText mZhanghao;
    /**
     * 请输入密码
     */
    private EditText mMima;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 手机快速登录
     */
    private TextView mPhonezc;
    private ImageView mQq;
   /* private Tencent mTencent;*/
   private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loginPresenter = new LoginPresenter(this);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);

        //点击注册
        initRegist();
        //点击事件
        listener();

    }

    private void listener() {
        mCha.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mQq.setOnClickListener(this);
        mPhonezc.setOnClickListener(this);
    }

    private void initView() {

        mCha = (ImageView) findViewById(R.id.cha);
        mZhanghao = (EditText) findViewById(R.id.zhanghao);
        mMima = (EditText) findViewById(R.id.mima);
        mLogin = (Button) findViewById(R.id.login);
        mPhonezc = (TextView) findViewById(R.id.phonezc);
        mQq = (ImageView) findViewById(R.id.qq);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cha:
                finish();
                break;
            case R.id.login:
                String name = mZhanghao.getText().toString().trim();
                String pwd = mMima.getText().toString().trim();
                loginPresenter.getNews(name, pwd);
                break;

        }
    }

    @Override
    public void onGetNew(String code, String msg, String nickName, int uid,String username,String token) {
        code1 = code;
        msg1 = msg;
        String s = token;
        if (code1.equals("0")) {

            Log.e("-----登陆过", "-------");
            MyApp.edit.putBoolean("islogin", true);
            MyApp.edit.putString("uid", uid+"");
            MyApp.edit.putString("name",username);
            MyApp.edit.putString("token",s);
            MyApp.edit.commit();
            Toast.makeText(LoginActivity.this, msg + "=====" + uid+username, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();
            MyApp.edit.putBoolean("islogin",false);
            MyApp.edit.commit();
            mZhanghao.setText("");
            mMima.setText("");
        }
    }

    //点击注册
    private void initRegist() {
        mPhonezc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onFailure(Exception e) {

    }
}
