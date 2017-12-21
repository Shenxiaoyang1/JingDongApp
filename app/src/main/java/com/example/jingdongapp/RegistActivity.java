package com.example.jingdongapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongapp.presenter.RegistPresenter;
import com.example.jingdongapp.view.RegistView;

public class RegistActivity extends AppCompatActivity implements RegistView, View.OnClickListener {

    private ImageView mIvExit;
    /**
     * 京东登录
     */
    private TextView mTvTitle;
    /**
     * 用户名/邮箱/手机号
     */
    private EditText mEtName;
    /**
     * 请输入密码
     */
    private EditText mEtPassword;
    /**
     * 注册
     */
    private Button mBtZhuce;
    private String code1,msg1;
    private RegistPresenter registPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
        registPresenter = new RegistPresenter(this);
    }

    private void initView() {
        mIvExit = (ImageView) findViewById(R.id.iv_exit);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtZhuce = (Button) findViewById(R.id.bt_zhuce);
        mBtZhuce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:

            case R.id.bt_zhuce:
                String name = mEtName.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                registPresenter.onShowNews(name,password);
                break;
        }
    }

    @Override
    public void show(String code,String msg) {
         code1 = code;
         msg1 = msg;
        if(code1.equals("0")){
            Toast.makeText(RegistActivity.this,msg1,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegistActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(RegistActivity.this,msg1,Toast.LENGTH_SHORT).show();
            mEtName.setText("");
            mEtPassword.setText("");
        }
    }



}
