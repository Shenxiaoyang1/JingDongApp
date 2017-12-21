package com.example.jingdongapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 申晓杨 on 2017/12/12.
 * 创建一个适配器，管理所有的fragment对象
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    //创建一个集合，对象是fragment对象
    List<Fragment> list;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    /**
     * 返回需要展示的fragment
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * 返回需要展示的fangment数量
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }
}
