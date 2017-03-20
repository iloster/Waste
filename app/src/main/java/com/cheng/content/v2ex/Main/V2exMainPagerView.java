package com.cheng.content.v2ex.Main;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cheng.content.v2ex.Detail.V2exDetailView;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;

import java.util.ArrayList;
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
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private V2exMainViewItem mV2exMainViewItem;
    private List<V2exMainBean> mV2exMainBeanList = new ArrayList<>();
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;
    public V2exMainPagerView(Context context) {
        super(context);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main_pager,this);
        initUI();

        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        mV2exPresenter = new V2exPresenter(this);
//        mV2exPresenter.loadData();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mV2exPresenter!=null){
            mV2exPresenter.release();
        }
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        mErrorLayout = (LinearLayout)findViewById(R.id.errorLayout);
        mErrorBtn = (Button)findViewById(R.id.errorBtn);
        mErrorLayout.setVisibility(GONE);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.theme_primary);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mV2exPresenter.refreshData();
            }
        });
    }

    public void loadData(int index){
        mV2exPresenter.loadData(index);
    }

    @Override
    public void showData(int index,List<V2exMainBean> v2exMainBeanList) {
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setVisibility(VISIBLE);
        mErrorLayout.setVisibility(GONE);

        mSwipeRefreshLayout.setRefreshing(false);
//            mV2exEntityList = V2exDbUtils.get(index);
        LogUtils.v(TAG,"showData:"+v2exMainBeanList.size());
        mV2exMainViewItem = new V2exMainViewItem(mContext, v2exMainBeanList);
        mRecyclerView.setAdapter(mV2exMainViewItem);
        mV2exMainViewItem.setItemOnClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                mV2exPresenter.getDetail((V2exMainBean) data);
            }
        });
    }

    @Override
    public void showLoading(boolean flag) {

    }

    @Override
    public void showDetail(V2exMainBean v) {
        V2exDetailView v2ExDetail = new V2exDetailView(mContext,v);
        MyWindowManager.replaceSubView(v2ExDetail,"V2EX");
        MyWindowManager.showLoading();
//        V2exMainWebDetail v2exMainWebDetail = new V2exMainWebDetail(mContext,v);
//        MyWindowManager.replaceSubView(v2exMainWebDetail,"V2EX");
    }

    @Override
    public void refreshData(int index, List<V2exMainBean> v) {
        LogUtils.v(TAG,"refreshData:"+v.size());
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mErrorLayout.setVisibility(GONE);
        mSwipeRefreshLayout.setRefreshing(false);
        if(v.size()>0){
            for(int i = 0; i < v.size(); i++){
                mV2exMainBeanList.add(i,v.get(i));
            }
            mV2exMainViewItem.notifyItemRangeInserted(0,v.size());
            mV2exMainViewItem.notifyDataSetChanged();
        }
    }

    @Override
    public void showError() {
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setVisibility(GONE);
        mErrorLayout.setVisibility(VISIBLE);
    }


    public interface OnRecyclerViewItemClickListener{
        public void onItemClick(int position,Object data);
    }
}
