package com.cheng.content.v2ex.Main;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/20.
 */

public class V2exMainView extends BaseSubView{
    private String TAG = "V2exMainView";

    private Context mContext;
    private V2exPresenter mV2exPresenter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public V2exMainView(Context context) {
        super(context);
        mContext = context;
        LogUtils.v(TAG,"ctor");
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main,this);
        initUI();

    }

    private void initUI(){
//        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("最热"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("最新"));//添加tab选项卡
        List<View> list = new ArrayList<>();
        View view = new V2exMainPagerView(mContext,1);
        View view1 = new V2exMainPagerView(mContext,2);
        list.add(view);
        list.add(view1);
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        List<String> titleList = new ArrayList<>();
        titleList.add("最热");
        titleList.add("最新");
        V2exMainPagerAdapter v2exMainPager = new V2exMainPagerAdapter(mContext,list,titleList);
        mViewPager.setAdapter(v2exMainPager);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(v2exMainPager);//给Tabs设置适配器

    }

}
