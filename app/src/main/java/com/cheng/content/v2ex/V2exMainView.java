package com.cheng.content.v2ex;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
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

public class V2exMainView extends BaseSubView implements IV2exMainView{
    private String TAG = "V2exMainView";

    private Context mContext;
    private V2exPresenter mV2exPresenter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
//    private RecyclerView mRecyclerView;
    public V2exMainView(Context context) {
        super(context);
        mContext = context;
        LogUtils.v(TAG,"ctor");
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main,this);
        initUI();
        mV2exPresenter = new V2exPresenter(this);
//        mV2exPresenter.loadData();
    }

    private void initUI(){
//        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView1);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout.addTab(mTabLayout.newTab().setText("最新"));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));//添加tab选项卡
        List<View> list = new ArrayList<>();
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_v2ex_main_pager,null);
        list.add(view);
        list.add(view);

        List<String> titleList = new ArrayList<>();
        titleList.add("最新");
        titleList.add("最热");
        V2exMainPager v2exMainPager = new V2exMainPager(mContext,list,titleList);
        mViewPager.setAdapter(v2exMainPager);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(v2exMainPager);//给Tabs设置适配器
    }

    @Override
    public void showData(List<V2exMainBean> v2exMainBeanList) {
        LogUtils.v(TAG,"size:"+v2exMainBeanList.size());
        LogUtils.v(TAG,"ss:"+v2exMainBeanList.get(1).getTitle());
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setAdapter(new V2exMainViewItem(mContext,v2exMainBeanList));
    }

    @Override
    public void showLoading(boolean flag) {

    }
}
