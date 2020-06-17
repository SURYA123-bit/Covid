package com.test.covidassesment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    final int pagecount = 3;
    private String tabTitles[] = new String[]{"For Kids","For Elders","For Health Workers"};

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FirstFragment();
            case 1 :
                return new SecondFragment();
            case 2 :
                return new ThirdFragment();
                default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return pagecount;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
