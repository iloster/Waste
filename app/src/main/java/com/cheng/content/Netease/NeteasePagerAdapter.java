package com.cheng.content.Netease;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.utils.LogUtils;

import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteasePagerAdapter extends PagerAdapter {


    private String TAG = "NeteasePagerAdapter";
    private Context mContext;
    private List<View> mList;
    private List<String> mTitleList;

    public NeteasePagerAdapter(List<View> list,List<String> titleList){
        mList = list;
        mTitleList = titleList;
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LogUtils.v(TAG,"instantiateItem:"+position);
        View view = mList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(mList.get(position));
    }
}
