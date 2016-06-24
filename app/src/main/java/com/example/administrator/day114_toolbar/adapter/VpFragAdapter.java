package com.example.administrator.day114_toolbar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2016/6/14.
 */
public class VpFragAdapter extends FragmentPagerAdapter{

    Fragment[] mFragments;
    public VpFragAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments[position].getArguments().getString("title");
    }
}
