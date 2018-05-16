package com.app.pgbooking.ui.main.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.app.pgbooking.R;

import java.util.ArrayList;
import java.util.List;

public class TabPageAdapter extends FragmentPagerAdapter {
    private Context mContext;

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragmentTitles = new ArrayList<>();

    private Typeface font;

    public TabPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        font = Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto-Regular.ttf");
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(mContext).inflate(R.layout.tab_view, null, false);
        TextView tabText = tab.findViewById(R.id.tabText);
        tabText.setTypeface(font);
        tabText.setText(mFragmentTitles.get(position));
        if (position == 0) {
            tab.setSelected(true);
        }
        return tab;
    }
}