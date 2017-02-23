package com.cheng.content.ZhihuDaily.Main;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.cheng.content.ZhihuDaily.Detail.DailyDetailView;
import com.cheng.content.ZhihuDaily.Detail.DailyDetailViewEx;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * 知乎日报
 * Created by dev on 2017/1/8.
 */

public class DailyView extends BaseSubView implements IDailyView {
    private String TAG = "Daily";
    private Context mContext;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private DailyPresenter mPresenter;

    private List<DailyMainBean.StoriesBean> mStoriesBeanList = new ArrayList<>();
    private DailyMainItem mDailyMainItem;

    private int mOffsetDay = 1;
    private boolean mIsRefresh = false;
    private String mNowTimeStr = "";
    public DailyView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_daily_view,this);

        initUI();

        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter = new DailyPresenter(this);
        mNowTimeStr  = TimeUtils.getDailyOffsetTimeStr(0);
        mPresenter.loadData(mNowTimeStr,true);
    }

    private void initUI(){
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);


        mDailyMainItem = new DailyMainItem(mStoriesBeanList);
        mRecyclerView.setAdapter(mDailyMainItem);
        mDailyMainItem.setOnRecyclerViewItemClickListener(new BaseSubView.OnRecyclerViewItemClickListener(){

            @Override
            public void onItemClick(int position, Object data) {
                DailyDetailViewEx dailyDetailView = new DailyDetailViewEx((DailyMainBean.StoriesBean)data);
                MyWindowManager.replaceSubView(dailyDetailView,"知乎日报");
                MyWindowManager.showLoading();
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                LogUtils.v(TAG,"下拉刷新 nowTimeStr:"+mNowTimeStr+"| get:"+TimeUtils.getDailyOffsetTimeStr(0));
                if(!mNowTimeStr.equals(TimeUtils.getDailyOffsetTimeStr(0))){
                    String lastestStr = TimeUtils.getDailyOffsetTimeStr(0);
                    mPresenter.loadData(lastestStr,true);
                }else{
                    mSwipeRefreshLayout.setRefreshing(false);
                }

            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==mDailyMainItem.getItemCount()){
                    LogUtils.v(TAG,"上啦刷新");
                    if(!mIsRefresh) {
                        mIsRefresh = true;
                        // mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
                        mSwipeRefreshLayout.setRefreshing(true);
                        mPresenter.loadData(TimeUtils.getDailyOffsetTimeStr(mOffsetDay),false);
                    }else{
                        LogUtils.v(TAG,"数据还没有加载完");
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //最后一个可见的ITEM
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }
        });


    }

    @Override
    public void refreshData(List<DailyMainBean.StoriesBean> list,boolean flag) {
        LogUtils.v(TAG,"refreshData size:"+list.size());
        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefresh = false;
        if(list.size()>0){
            int orgLenght = mStoriesBeanList.size();
            if(flag){
                //下拉刷新
                for(int i = 0;i<list.size();i++){
                    mStoriesBeanList.add(i,list.get(i));
                }
                mDailyMainItem.notifyItemRangeInserted(0,list.size());
            }else{
                //上拉刷新

                mOffsetDay = mOffsetDay + 1;
                for(int i = 0; i<list.size();i++){
                    mStoriesBeanList.add(orgLenght + i,list.get(i));
                }
                mDailyMainItem.notifyItemRangeInserted(orgLenght,orgLenght+list.size());
            }

            mDailyMainItem.notifyDataSetChanged();
        }
    }

    @Override
    public void showError(boolean flag) {
        LogUtils.v(TAG,"showError:"+flag);
        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefresh = false;
        if(flag){
            Toast.makeText(mContext,"数据加载失败",Toast.LENGTH_SHORT).show();
            if(mStoriesBeanList.size() == 0) {
                MyWindowManager.showErrorView();
            }

        }else{
            Toast.makeText(mContext,"数据加载成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void onRefreshClick(){
        mSwipeRefreshLayout.setRefreshing(true);
        String lastestStr = TimeUtils.getDailyOffsetTimeStr(0);
        mPresenter.loadData(lastestStr,true);
    }
}
