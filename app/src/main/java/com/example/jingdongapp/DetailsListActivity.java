package com.example.jingdongapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jingdongapp.bean.AddCard;
import com.example.jingdongapp.bean.DetailsListBean;
import com.example.jingdongapp.net.MyApp;
import com.example.jingdongapp.presenter.DetailsListPresenter;
import com.example.jingdongapp.view.DetailsListView;
import com.facebook.drawee.view.SimpleDraweeView;

public class DetailsListActivity extends AppCompatActivity implements View.OnClickListener ,DetailsListView{

    private ImageView mBack;
    private SimpleDraweeView mGoodsimg;
    private TextView mTitles;
    private TextView mJieshao;
    private TextView mYuanjia;
    private TextView mPrice;
    private ImageView mGys;
    private ImageView mGz;
    private ImageView mGoods;
    /**
     * 加入购物车
     */
    private Button mAddGoods;
    private DetailsListPresenter detailsListPresenter;
    private String pid;
    private SharedPreferences sharedPreferences;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_list);
        initView();
        detailsListPresenter = new DetailsListPresenter(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        detailsListPresenter.OnShowDetails(pid);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);

    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mGoodsimg = (SimpleDraweeView) findViewById(R.id.goodsimg);
        mTitles = (TextView) findViewById(R.id.titles);
        mJieshao = (TextView) findViewById(R.id.jieshao);
        mYuanjia = (TextView) findViewById(R.id.yuanjia);
        mPrice = (TextView) findViewById(R.id.price);
        mGys = (ImageView) findViewById(R.id.gys);
        mGz = (ImageView) findViewById(R.id.gz);
        mGoods = (ImageView) findViewById(R.id.goods);
        mAddGoods = (Button) findViewById(R.id.addGoods);
        mAddGoods.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.addGoods:
              //设置点击事件，获取pid,uid,token值
                String uid = MyApp.sp.getString("uid", "");
                String token= MyApp.sp.getString("token", "");
                detailsListPresenter.OnShowMsg(uid,pid,token);
                Toast.makeText(DetailsListActivity.this,msg,Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onShow(DetailsListBean detailsListBean) {
        mPrice.setText(detailsListBean.getData().getPrice());
        mTitles.setText(detailsListBean.getData().getTitle());
        String images = detailsListBean.getData().getImages();
        String[] split = images.split("\\|");
        mGoodsimg.setImageURI(split[0]);
    }

    @Override
    public void onShowMsg(AddCard addCard) {
        //展示加购信息
        msg = addCard.getMsg();
    }
}
