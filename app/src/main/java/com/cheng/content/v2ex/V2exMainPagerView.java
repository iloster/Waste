package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
    private List<V2exEntity> mV2exEntityList = new ArrayList<>();
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;
    public V2exMainPagerView(Context context,int index) {
        super(context);
        mContext = context;
        mIndex = index;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main_pager,this);
        LogUtils.v(TAG,"index:"+index);
        initUI();

        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        mV2exPresenter = new V2exPresenter(this,mIndex);
        mV2exPresenter.loadData();
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

        mErrorBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mV2exPresenter.loadData();
            }
        });
    }


    @Override
    public void showData(int index) {
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setVisibility(VISIBLE);
        mErrorLayout.setVisibility(GONE);
        if(index == mIndex) {
            mSwipeRefreshLayout.setRefreshing(false);
            mV2exEntityList = V2exDbUtils.get(index);
            mV2exMainViewItem = new V2exMainViewItem(mContext, mV2exEntityList);
            mRecyclerView.setAdapter(mV2exMainViewItem);
            mV2exMainViewItem.setItemOnClickListener(new OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int position, Object data) {
                    mV2exPresenter.getDetail((V2exEntity) data);
                }
            });
        }
    }

    @Override
    public void showLoading(boolean flag) {

    }

    @Override
    public void showDetail(V2exEntity v) {
        V2exMainDetail v2exMainDetail = new V2exMainDetail(mContext,v);
        //v2exMainDetail.showDetail(v);
        MyWindowManager.replaceSubView(v2exMainDetail,"V2EX");
    }

    @Override
    public void refreshData(int index, List<V2exEntity> v) {
        LogUtils.v(TAG,"refreshData:"+v.size());
        mSwipeRefreshLayout.setRefreshing(false);
        mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        mErrorLayout.setVisibility(GONE);
        mSwipeRefreshLayout.setRefreshing(false);
        if(mIndex == index&&v.size()>0){
            for(int i = 0; i < v.size(); i++){
                mV2exEntityList.add(i,v.get(i));
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
