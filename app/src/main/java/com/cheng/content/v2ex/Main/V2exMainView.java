package com.cheng.content.v2ex.Main;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.cheng.content.v2ex.V2exConstants;
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
    private List mList = new ArrayList<>();
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
        for(int i = 0;i< V2exConstants.V2EX_URL.length;i++){
            V2exMainPagerView v = new V2exMainPagerView(mContext,i);
            mList.add(v);
        }

        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        List<String> titleList = new ArrayList<>();
        for(int i = 0;i<V2exConstants.V2EX_TITLE.length;i++){
            titleList.add(V2exConstants.V2EX_TITLE[i]);
        }

        V2exMainPagerAdapter v2exMainPager = new V2exMainPagerAdapter(mContext,mList,titleList);
        mViewPager.setAdapter(v2exMainPager);
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(v2exMainPager);//给Tabs设置适配器
        showListByIndex(0);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LogUtils.v(TAG,"position:"+position);
                showListByIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void showListByIndex(int index){
        V2exMainPagerView v= (V2exMainPagerView) mList.get(index);
        if(v!=null){
            v.loadData(0);
        }
    }

}
