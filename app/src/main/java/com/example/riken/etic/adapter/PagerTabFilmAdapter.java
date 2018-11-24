package com.example.riken.etic.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.riken.etic.fragment.AkanTayangFragment;
import com.example.riken.etic.FragmentSedangTayang;


public class PagerTabFilmAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerTabFilmAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                FragmentSedangTayang fragmentSedangTayang = new FragmentSedangTayang();
                return fragmentSedangTayang;
            case 1:
                AkanTayangFragment akanTayangFragment = new AkanTayangFragment();
                return  akanTayangFragment;
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
