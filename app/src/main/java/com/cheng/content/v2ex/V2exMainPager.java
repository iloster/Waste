package com.cheng.content.v2ex;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.waste.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/25.
 */

public class V2exMainPager extends PagerAdapter {

    private String TAG = "V2exMainPager";
    private Context mContext;
    private List<View> mList;
    private List<String> mTitleList;
    public V2exMainPager(Context context, List<View> list,List<String> titleList){
        mContext = context;
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
        LogUtils.v(TAG,"ss:"+position);
        View view = mList.get(position);
        final RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
//        recyclerView.setTag("recycleView");
        HttpUtil.getInstance().enqueue(Constants.V2EX_URL_HOT, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<V2exMainBean>>(){}.getType();
                List<V2exMainBean> v2exMainBeanList = gson.fromJson(ret,type);
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
                layoutManager.setOrientation(OrientationHelper.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new V2exMainViewItem(mContext,v2exMainBeanList));
            }
        });
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
