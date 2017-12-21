package com.example.jingdongapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jingdongapp.widget.FlowGroupView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mBack;
    private EditText mEdName;
    /**
     * 搜索
     */
    private TextView mSousuo;
    private ListView mLv;
    /**
     * 清空历史记录
     */
    private Button mBtn;
    private LinearLayout mLsjl;
    private FlowGroupView flowGroupView;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        SouSuoClick();
        addData();
        listener();

    }

    private void listener() {
        mBack.setOnClickListener(this);
    }

    private void addData() {
        strings = new ArrayList<>();
        strings.add("电脑电脑城");
        strings.add("新品相机，高清，选我吧");
        strings.add("手机手机，真的是手机呦");
        strings.add("玩具，芭比娃娃，机器人");
        strings.add("零食，大礼包");
        strings.add("蛋糕，提拉米苏");
        strings.add("服装，男装，女装，老年装");
        //为布局添加内容
        for (int i = 0; i < strings.size(); i++) {
            addTextView(strings.get(i));
        }
    }

    private void addTextView(String s) {
        TextView child = new TextView(this);
        ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
        params.setMargins(5, 5, 5, 5);
        child.setLayoutParams(params);
        child.setBackgroundResource(R.drawable.flag);
        child.setText(s);
        child.setTextColor(Color.parseColor("#ffffff"));
//        initEvents(child);//监听
        flowGroupView.addView(child);
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mEdName = (EditText) findViewById(R.id.ed_name);
        mSousuo = (TextView) findViewById(R.id.sousuo);
        mLv = (ListView) findViewById(R.id.lv);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mLsjl = (LinearLayout) findViewById(R.id.lsjl);
        flowGroupView = (FlowGroupView) findViewById(R.id.flowGroupView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                break;
            case R.id.back:
                finish();
                break;
        }
    }

    private void SouSuoClick() {
        mSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEdName.getText().toString().trim();
                Intent intent = new Intent(SearchActivity.this, SearachListActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}
