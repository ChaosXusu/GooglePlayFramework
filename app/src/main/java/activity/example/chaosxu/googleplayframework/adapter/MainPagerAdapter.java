package activity.example.chaosxu.googleplayframework.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import activity.example.chaosxu.googleplayframework.bean.PageInfo;

/**
 * Created by ChaosXu on 2016/05/30 030.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<PageInfo> pageInfos;
    public MainPagerAdapter(FragmentManager fm,ArrayList<PageInfo> pageInfos) {
        super(fm);
        this.pageInfos = pageInfos;
    }
    @Override
    public Fragment getItem(int position) {
        return pageInfos.get(position).fragment;
    }
    @Override
    public int getCount() {
        return pageInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageInfos.get(position).title;
    }
}
