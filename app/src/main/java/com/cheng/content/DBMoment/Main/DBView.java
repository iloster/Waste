package com.cheng.content.DBMoment.Main;

import android.content.Context;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cheng.content.DBMoment.Detail.DBDetailView;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/1/3.
 */

public class DBView extends BaseSubView implements IDBView {

    private String TAG = "DBView";
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Context mContext;
    private DBMainItem mDbMainItem;
    private List<DBMainBean> mDBMainBeanList = new ArrayList<>();
    private DBPresenter mPresenter;
    private int mOffsetDay = 0;
    private String mNowTimeStr = "";
    private boolean mIsRefresh = false;
    public DBView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_view,this);

        initUI();
        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter = new DBPresenter(this);
        mNowTimeStr = TimeUtils.getDBTimerStr();
        mPresenter.loadData(TimeUtils.getDBTimerStr(),true);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.release();
    }

    private void initUI() {

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mDbMainItem = new DBMainItem(mDBMainBeanList);
        mDbMainItem.setItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                LogUtils.v(TAG,"onItemClick");
                MyWindowManager.replaceSubView(new DBDetailView((DBMainBean) data),"豆瓣一刻");
            }
        });
        mRecyclerView.setAdapter(mDbMainItem);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(!mNowTimeStr.equals(TimeUtils.getDBTimerStr())) {
                    mPresenter.loadData(TimeUtils.getDBTimerStr(),true);
                }else{
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==mDbMainItem.getItemCount()){
                    LogUtils.v(TAG,"下拉刷新");
                    if(!mIsRefresh) {
                        mIsRefresh = true;
                       // mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
                        mSwipeRefreshLayout.setRefreshing(true);
                        mPresenter.loadData(TimeUtils.getDBOffsetTimeStr(mOffsetDay),false);
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
    public void refreshData(List<DBMainBean> list,boolean flag) {
        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefresh = false;
        int orgLength = mDBMainBeanList.size();
        LogUtils.v(TAG,"refreshData orgLength: "+orgLength);

        if(flag){
            for(int i = 0; i < list.size(); i++) {
                mDBMainBeanList.add(i, list.get(i));
            }
            mDbMainItem.notifyItemRangeInserted(0,list.size());
        }else {
            mOffsetDay = mOffsetDay + 1;
            for(int i = 0; i < list.size(); i++) {
                mDBMainBeanList.add(orgLength + i, list.get(i));
            }
            mDbMainItem.notifyItemRangeInserted(orgLength,orgLength+list.size());
        }

        mDbMainItem.notifyDataSetChanged();
    }

    public void showError(boolean flag){

        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefresh = false;
        if(flag){
            Toast.makeText(mContext,"数据加载失败",Toast.LENGTH_SHORT).show();
            if(mDBMainBeanList.size() == 0) {
                MyWindowManager.showErrorView();
            }

        }else{
            Toast.makeText(mContext,"数据加载成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void onRefreshClick(){
        //mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.loadData(TimeUtils.getDBTimerStr(),true);
    }

}
