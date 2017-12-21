package com.example.jingdongapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jingdongapp.DetailsListActivity;
import com.example.jingdongapp.R;
import com.example.jingdongapp.SearchActivity;
import com.example.jingdongapp.adapter.MyGridAdapter;
import com.example.jingdongapp.adapter.TuijianAdapter;
import com.example.jingdongapp.banner.GlideImageLoader;
import com.example.jingdongapp.bean.HomePageBanner;
import com.example.jingdongapp.presenter.HomePageBannerPresenter;
import com.example.jingdongapp.view.HomePageBannerActivity;
import com.example.jingdongapp.widget.NoticeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/12.
 */

public class Fragment1 extends Fragment implements HomePageBannerActivity {
    private HomePageBannerPresenter homePageBannerPresenter;
    private List<String> list = new ArrayList<>();
    private Banner banner;
    private GridView gridView;
    private Fragment_tujian1 fragment_tujian1;
    private Fragment_tujian2 fragment_tujian2;
    private List<Fragment> fragments = new ArrayList<>();
    private MyGridAdapter gridAdapter;
    private View view;
    private ViewPager vp;
    private ImageView mSaoyisao;
    /**
     * 好货来袭，抢海量尖货
     */
    private EditText mEdInput;
    private ImageView mXiaoxi;
    private Banner mBanner;
    private ViewPager mVp;
    private NoticeView noticeView;
    private long mHour = 02;
    private long mMin = 15;
    private long mSecond = 36;
    private boolean isRun = true;
    /**
     * 秒杀的设置
     */
    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                computeTime();
                if (mHour < 10) {
                    mHours.setText("0" + mHour + "");
                } else {
                    mHours.setText("0" + mHour + "");
                }
                if (mMin < 10) {
                    mMinute.setText("0" + mMin + "");
                } else {
                    mMinute.setText(mMin + "");
                }
                if (mSecond < 10) {
                    mIdcount.setText("0" + mSecond + "");
                } else {
                    mIdcount.setText(mSecond + "");
                }
            }
        }
    };
    /**
     * 02
     */
    private TextView mHours;
    /**
     * 33
     */
    private TextView mMinute;
    /**
     * 33
     */
    private TextView mIdcount;
    private RecyclerView rcy_tuijian;
    private List<HomePageBanner.TuijianBean.ListBean> tuijianList = new ArrayList<>();
    private TuijianAdapter tuijianAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        Fresco.initialize(getContext());
        initView();
        homePageBannerPresenter = new HomePageBannerPresenter(this);
        homePageBannerPresenter.OnShowBanner();
        viewpager();
        //京东快报
        initNews();
        //限时秒杀
        startRun();
        mEdInputClick();
        return view;
    }

    private void startRun() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (isRun) {
                    try {
                        Thread.sleep(1000); // sleep 1000ms
                        Message message = Message.obtain();
                        message.what = 1;
                        timeHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    private void computeTime() {
        mSecond--;
        if (mSecond < 0) {
            mMin--;
            mSecond = 59;
            if (mMin < 0) {
                mMin = 59;
                mHour--;
            }
        }
    }

    private void initNews() {

        List<String> notices = new ArrayList<>();
        notices.add("大促销下单拆福袋，亿万新年红包随便拿");
        notices.add("家电五折团，抢十亿无门槛现金红包");
        notices.add("星球大战剃须刀首发送200元代金券");
        noticeView.addNotice(notices);
        noticeView.startFlipping();
    }
    //搜索框设置点击事件

    private void mEdInputClick() {
        mEdInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        banner = view.findViewById(R.id.banner);
        //viewPager = view.findViewById(R.id.vp);
        //rv = view.findViewById(R.id.vp);
        vp = (ViewPager) view.findViewById(R.id.vp);
        mSaoyisao = (ImageView) view.findViewById(R.id.saoyisao);
        mEdInput = (EditText) view.findViewById(R.id.ed_input);
        mXiaoxi = (ImageView) view.findViewById(R.id.xiaoxi);
        mBanner = (Banner) view.findViewById(R.id.banner);
        mVp = (ViewPager) view.findViewById(R.id.vp);
        noticeView = (NoticeView) view.findViewById(R.id.notice_view);
        mHours = (TextView) view.findViewById(R.id.hours);
        mMinute = (TextView) view.findViewById(R.id.minute);
        mIdcount = (TextView) view.findViewById(R.id.idcount);
        rcy_tuijian = view.findViewById(R.id.tuijian);
    }

    private void viewpager() {
        fragment_tujian1 = new Fragment_tujian1();
        fragment_tujian2 = new Fragment_tujian2();
        fragments.add(fragment_tujian1);
        fragments.add(fragment_tujian2);
        Log.d("数量", fragments.size() + "");
        vp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    public void onShowBanner(List<HomePageBanner.DataBean> bannerList) {
        for (int i = 0; i < bannerList.size(); i++) {
            String icon = bannerList.get(i).getIcon();
            list.add(icon);
            banner.setImageLoader(new GlideImageLoader());
            banner.setImages(list);
            banner.start();
        }

    }

    @Override
    public void onShowTuijian(HomePageBanner homePageBanner) {
        List<HomePageBanner.TuijianBean.ListBean> listChild = homePageBanner.getTuijian().getList();
        for (int i = 0; i <listChild.size() ; i++) {
            HomePageBanner.TuijianBean.ListBean listBean = listChild.get(i);

            tuijianList.add(listBean);
        }
        tuijianAdapter = new TuijianAdapter(tuijianList, getContext());
        rcy_tuijian.setAdapter(tuijianAdapter);
        rcy_tuijian.setLayoutManager(new GridLayoutManager(getContext(),2));
        tuijianAdapter.OnClickListener(new TuijianAdapter.OnItemClickListener() {
            @Override
            public void OnClick(String pid) {
                Intent intent = new Intent(getContext(), DetailsListActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }
        });

    }


}
