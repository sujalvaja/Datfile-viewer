package com.example.datfileviewr.viewpage.ViewPager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public  class ViewPagerAdaptor extends FragmentPagerAdapter {
    private  List<Fragment> mList = new ArrayList();
    private  List<String> mTitleList = new ArrayList();


    public ViewPagerAdaptor(FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNull(fragmentManager);
    }


    public Fragment getItem(int i) {
        return this.mList.get(i);
    }

    public int getCount() {
        return this.mList.size();
    }

    public  void addFragment(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "title");
        this.mList.add(fragment);
        this.mTitleList.add(str);
    }

    public CharSequence getPageTitle(int i) {
        return this.mTitleList.get(i);
    }
}

