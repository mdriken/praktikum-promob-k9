package com.example.riken.etic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.riken.etic.fragment.TabJadwalFragment;
import com.example.riken.etic.fragment.TabSinopsisFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                TabJadwalFragment tabJadwalFragment = new TabJadwalFragment();
                return tabJadwalFragment;
            case 1:
                TabSinopsisFragment tabSinopsisFragment = new TabSinopsisFragment();
                return  tabSinopsisFragment;
//            case 2:
//                Tab3 tab3 = new Tab3();
//                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
