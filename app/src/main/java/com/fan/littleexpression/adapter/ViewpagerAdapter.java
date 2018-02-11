package com.fan.littleexpression.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fan.littleexpression.R;
import com.fan.littleexpression.pages.Page1;
import com.fan.littleexpression.pages.Page2;
import com.fan.littleexpression.pages.Page3;
import com.fan.littleexpression.pages.Page4;
import com.fan.littleexpression.pages.Page5;
import com.fan.littleexpression.pages.Page6;

/**
 * Created by Fan on 2018/2/1.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private String[] title = {"one", "two", "three", "Four", "Five", "Six"};
    private Fragment[] fragments = new Fragment[title.length];

    public ViewpagerAdapter(FragmentManager fm, String[] title) {
        super(fm);
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            if (position == 0) fragments[position] = new Page1();
            if (position == 1) fragments[position] = new Page2();
            if (position == 2) fragments[position] = new Page3();
            if (position == 3) fragments[position] = new Page4();
            if (position == 4) fragments[position] = new Page5();
            if (position == 5) fragments[position] = new Page6();
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

}