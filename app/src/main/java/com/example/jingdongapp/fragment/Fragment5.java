package com.example.jingdongapp.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongapp.LoginActivity;
import com.example.jingdongapp.R;
import com.example.jingdongapp.RegistActivity;
import com.example.jingdongapp.net.MyApp;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by 申晓杨 on 2017/12/12.
 */

public class Fragment5 extends Fragment {


    private View view;
    private ImageView mSet;
    private ImageView mXinxi;
    private TextView mNickName;
    private LinearLayout mLogin;
    private SharedPreferences sharedPreferences;
    private String nickName;
    private String username;
    private TextView user_xinxi;
    private SimpleDraweeView user_img;
    private int uid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, container, false);
        sharedPreferences = getActivity().getSharedPreferences("user", MODE_PRIVATE);
        initView(view);
        initlogin();
        return view;
    }

    private void initView(View view) {
        mSet = (ImageView) view.findViewById(R.id.set);
        mXinxi = (ImageView) view.findViewById(R.id.xinxi);
        mNickName = (TextView) view.findViewById(R.id.nickName);
        mLogin = (LinearLayout) view.findViewById(R.id.login);
        user_img = (SimpleDraweeView) view.findViewById(R.id.user_img);
        user_xinxi = (TextView) view.findViewById(R.id.user_xinxi);

    }

    private void initlogin() {
        boolean islogin = MyApp.sp.getBoolean("islogin", false);

        if (islogin) {
            String name = MyApp.sp.getString("name", "null");
            Log.e("---登陆状态;", true + "");
            mLogin.setVisibility(View.GONE);
            user_xinxi.setText(name);
            Log.e("---登陆状态;", false + "");
            mLogin.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT).show();
        }

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
       /* mDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegistActivity.class);
                startActivity(intent);
            }
        });*/
    }

}
