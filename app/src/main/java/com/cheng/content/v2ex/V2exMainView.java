package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;

import java.util.List;

/**
 * Created by cheng on 2016/12/20.
 */

public class V2exMainView extends BaseSubView implements IV2exMainView{
    private String TAG = "V2exMainView";

    private Context mContext;
    private V2exPresenter mV2exPresenter;
    private RecyclerView mRecyclerView;
    public V2exMainView(Context context) {
        super(context);
        mContext = context;
        LogUtils.v(TAG,"ctor");
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main,this);
        initUI();
        mV2exPresenter = new V2exPresenter(this);
        mV2exPresenter.loadData();
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void showData(List<V2exMainBean> v2exMainBeanList) {
        LogUtils.v(TAG,"size:"+v2exMainBeanList.size());
        mRecyclerView.setAdapter(new V2exMainViewItem(mContext,v2exMainBeanList));
    }

    @Override
    public void showLoading(boolean flag) {

    }
}
