package com.cheng.content.Netease;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyViewFlipper;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteaseView extends BaseSubView {

    private String TAG = "NeteaseView";
    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public NeteaseView() {
        super(WasteApplication.getInstance());

        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_netease_main,this);

        initUI();
    }

    private void initUI(){
        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mViewPager = (ViewPager)findViewById(R.id.viewPager);

        mTabLayout.addTab(mTabLayout.newTab().setText("头条"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("科技"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("社会"));//添加tab选项卡

        final List<View> viewList = new ArrayList<>();
        viewList.add(new NeteasePagerView(0));
        viewList.add(new NeteasePagerView(1));
        viewList.add(new NeteasePagerView(2));

        List<String> titleList = new ArrayList<>();
        titleList.add("头条");
        titleList.add("科技");
        titleList.add("社会");
        NeteasePagerAdapter adapter = new NeteasePagerAdapter(viewList,titleList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtils.v(TAG,"position:"+position+"|positionOffset:"+positionOffset+"|positionOffsetPixels:"+positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.v(TAG,"position:"+position);
                NeteasePagerView pagerView =(NeteasePagerView)viewList.get(position);
                pagerView.loadData(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                LogUtils.v(TAG,"state:"+state);
            }
        });

    }


}
