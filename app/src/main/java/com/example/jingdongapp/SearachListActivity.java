package com.example.jingdongapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jingdongapp.adapter.MySearchAdapter;
import com.example.jingdongapp.bean.SearchListBean;
import com.example.jingdongapp.presenter.SearchPresenter;
import com.example.jingdongapp.view.SearchView;

import java.util.List;

public class SearachListActivity extends AppCompatActivity implements SearchView{
public SearchPresenter searchPresenter;
    private ImageView mBack;
    private EditText mImg;
    private ImageView mQiehuan;
    private RecyclerView mRv;
    private  MySearchAdapter mySearchAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searach_list);
        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        searchPresenter = new SearchPresenter(this);
        searchPresenter.OnShowSearch(name);
        mImg.setText(name);
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mImg = (EditText) findViewById(R.id.img);
        mQiehuan = (ImageView) findViewById(R.id.qiehuan);
        mRv = (RecyclerView) findViewById(R.id.rv);
    }


    @Override
    public void onShowSearch(List<SearchListBean.DataBean> listBeans) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        mySearchAdapter = new MySearchAdapter(listBeans, this);
        mRv.setAdapter(mySearchAdapter);
        mySearchAdapter.SetOnItemClick(new MySearchAdapter.OnItemClickListener() {
            @Override
            public void OnClick(String pid) {
                Intent intent = new Intent(SearachListActivity.this, DetailsListActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);

            }
        });

    }
}
