package com.chinghao.timemanager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chinghao.timemanager.entities.MainPageItem;

import java.util.List;

/**
 * Created by ChingHao on 2016/12/20.
 */

public class MainPageAdapter extends FragmentPagerAdapter{
    private List<MainPageItem> mPageItems;
    public MainPageAdapter(FragmentManager fm, List<MainPageItem> pageItems) {
        super(fm);
        mPageItems=pageItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mPageItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPageItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPageItems.get(position).getTitle();
    }
}
