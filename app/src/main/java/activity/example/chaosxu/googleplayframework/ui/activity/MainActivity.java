package activity.example.chaosxu.googleplayframework.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

import activity.example.chaosxu.googleplayframework.R;
import activity.example.chaosxu.googleplayframework.adapter.MainPagerAdapter;
import activity.example.chaosxu.googleplayframework.bean.PageInfo;
import activity.example.chaosxu.googleplayframework.ui.fragment.CategoryFragment;
import activity.example.chaosxu.googleplayframework.ui.fragment.HomeFragment;
import activity.example.chaosxu.googleplayframework.ui.fragment.HotFragment;
import activity.example.chaosxu.googleplayframework.ui.fragment.RecommendFragment;
import activity.example.chaosxu.googleplayframework.ui.fragment.SubjectFragment;
import activity.example.chaosxu.googleplayframework.ui.view.PagerSlidingTab;
import activity.example.chaosxu.googleplayframework.util.Utils;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

        @Bind(R.id.slidingTab)
        PagerSlidingTab slidingTab;
        @Bind(R.id.viewPager)
        ViewPager viewPager;
        @Bind(R.id.ll_main)
        LinearLayout llMain;
        @Bind(R.id.drawerLayout)
        DrawerLayout drawerLayout;

        private ActionBarDrawerToggle drawerToggle;
        private ArrayList<PageInfo> pageInfos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ButterKnife.bind(this);

                //设置ActionBar
                setActionBar();

                //初始化数据
                initData();
        }

        /**
         * 设置ActionBar
         */
        private void setActionBar() {
                ActionBar actionBar = getSupportActionBar();

                actionBar.setDisplayShowHomeEnabled(true);//启用home按钮
                actionBar.setDisplayHomeAsUpEnabled(true);//显示出来home按钮

                //设置汉堡包按钮
                drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
                drawerToggle.syncState();//同步DrawerLayout和ActionBar的状态

                //给汉堡包按钮添加旋转动画
                drawerLayout.addDrawerListener(drawerToggle);
        }

        /**
         * 初始化数据
         */
        private void initData() {
                pageInfos = preparePageInfo();
                MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), pageInfos);
                viewPager.setAdapter(mainPagerAdapter);
                slidingTab.setViewPager(viewPager);
        }

        /**
         * 准备页面信息
         *
         * @return
         */
        private ArrayList<PageInfo> preparePageInfo() {
                ArrayList<PageInfo> list = new ArrayList<>();
                String[] tabs = Utils.getStringArray(R.array.tab_names);

                list.add(new PageInfo(tabs[0], new HomeFragment()));
                list.add(new PageInfo(tabs[1], new SubjectFragment()));
                list.add(new PageInfo(tabs[2], new RecommendFragment()));
                list.add(new PageInfo(tabs[3], new CategoryFragment()));
                list.add(new PageInfo(tabs[4], new HotFragment()));
                return list;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                        case android.R.id.home:
                                drawerToggle.onOptionsItemSelected(item);
                                break;
                }
                return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                ButterKnife.unbind(this);
        }

}
