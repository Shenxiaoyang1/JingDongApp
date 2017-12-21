package com.example.jingdongapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jingdongapp.adapter.MyFragmentAdapter;
import com.example.jingdongapp.fragment.Fragment1;
import com.example.jingdongapp.fragment.Fragment2;
import com.example.jingdongapp.fragment.Fragment3;
import com.example.jingdongapp.fragment.Fragment4;
import com.example.jingdongapp.fragment.Fragment5;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {


    private BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");

        bottomTabBar = (BottomTabBar) findViewById(R.id.bottomTabBar);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(100,100)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.BLACK)
                .addTabItem("首页",R.drawable.ac0,Fragment1.class)
                .addTabItem("发现",R.drawable.abw, Fragment2.class)
                .addTabItem("分类",R.drawable.aby, Fragment3.class)
                .addTabItem("购物车",R.drawable.abu, Fragment4.class)
                .addTabItem("我的",R.drawable.ac2, Fragment5.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

    }



