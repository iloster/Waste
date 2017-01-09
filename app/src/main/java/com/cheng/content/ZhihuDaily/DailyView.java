package com.cheng.content.ZhihuDaily;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.content.DBMoment.DBDetail;
import com.cheng.content.DBMoment.DBMainBean;
import com.cheng.content.DBMoment.IDBView;
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

public class DailyView extends BaseSubView implements IDailyView{
    private String TAG = "Daily";
    private Context mContext;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private DailyPresenter mPresenter;

    private List<DailyMainBean.StoriesBean> mStoriesBeanList = new ArrayList<>();
    private DailyMainItem mDailyMainItem;
    public DailyView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_daily_view,this);

        initUI();

        mPresenter = new DailyPresenter(this);
        mPresenter.loadData("20170108");
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
                DailyDetail dailyDetail = new DailyDetail((DailyMainBean.StoriesBean)data);
                MyWindowManager.replaceSubView(dailyDetail,"知乎日报");
            }
        });

    }

    @Override
    public void refreshData(List<DailyMainBean.StoriesBean> list) {
        if(list.size()>0){
            int orgLenght = mStoriesBeanList.size();
            for(int i = 0;i<list.size();i++){
                mStoriesBeanList.add(i,list.get(i));
            }
            mDailyMainItem.notifyItemRangeInserted(orgLenght,orgLenght+list.size());
            mDailyMainItem.notifyDataSetChanged();
        }
    }

    @Override
    public void showError() {

    }
}
