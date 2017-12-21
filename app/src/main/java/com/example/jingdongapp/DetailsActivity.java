package com.example.jingdongapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jingdongapp.adapter.DetailsAdapter;
import com.example.jingdongapp.bean.DetailsBean;
import com.example.jingdongapp.presenter.DetailsPresenter;
import com.example.jingdongapp.view.DetailsListView;
import com.example.jingdongapp.view.DetailsView;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsView {


    private DetailsPresenter detailsPresenter;
    private ImageView mBack;
    private EditText mImg;
    private ImageView mQiehuan;
    private RecyclerView mRv;
    private DetailsAdapter detailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searach_list);
        initView();

        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        detailsPresenter = new DetailsPresenter(this);
        detailsPresenter.onShowDetails(pscid);
    }


    @Override
    public void OnShowDetails(List<DetailsBean.DataBean> list) {
        mRv.setLayoutManager(new LinearLayoutManager(this));
        detailsAdapter = new DetailsAdapter(list,this);
        mRv.setAdapter(detailsAdapter);
    //设置条目点击事件，进行跳转到详情界面
        detailsAdapter.setOnItemClickListener(new DetailsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String pid) {
                Intent intent = new Intent(DetailsActivity.this, DetailsListActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
                Toast.makeText(DetailsActivity.this,"pid",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mImg = (EditText) findViewById(R.id.img);
        mQiehuan = (ImageView) findViewById(R.id.qiehuan);
        mRv = (RecyclerView) findViewById(R.id.rv);
    }

}
