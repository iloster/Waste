package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;

import java.util.List;

/**
 * Created by cheng on 2016/12/25.
 */

public class V2exMainPagerView extends BaseSubView implements IV2exMainPagerView {

    private Context mContext;
    private String TAG = "V2exMainPagerView";
    private int mIndex;
    private RecyclerView mRecyclerView;
    private V2exPresenter mV2exPresenter;
    public V2exMainPagerView(Context context,int index) {
        super(context);
        mContext = context;
        mIndex = index;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main_pager,this);
        LogUtils.v(TAG,"index:"+index);
        initUI();

        mV2exPresenter = new V2exPresenter(this,mIndex);
        mV2exPresenter.loadData();
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void showData(int index, List<V2exHotTopicEntity> list) {
        if(index == mIndex) {
            V2exMainViewItem v2exMainViewItem = new V2exMainViewItem(mContext, list);
            mRecyclerView.setAdapter(v2exMainViewItem);
            v2exMainViewItem.setItemOnClickListener(new OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int position, Object data) {
                    mV2exPresenter.getDetail((V2exMainBean)data);
                }
            });
        }
    }

    @Override
    public void showLoading(boolean flag) {

    }

    @Override
    public void showDetail(V2exMainBean v2exMainBean) {
        V2exMainDetail v2exMainDetail = new V2exMainDetail(mContext);
        v2exMainDetail.showDetail(v2exMainBean);
        MyWindowManager.replaceSubView(v2exMainDetail);
    }


    public interface OnRecyclerViewItemClickListener{
        public void onItemClick(int position,Object data);
    }
}
