package com.cheng.content.Qsbk;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 2017/2/24.
 */

public class QsbkView extends BaseSubView implements IQsbkView{
    private String TAG = "Peek_QsbkView";

    private RecyclerView mRecyclerView;
    private Context mContext;

    private QsbkPresenter mPresenter;
    private int mPage = 1;
    private QsbkAdapter mQsbkAdapter;
    private List<QsbkBean.ItemsBean> mItemsBeanList = new ArrayList<QsbkBean.ItemsBean>();
    private boolean mIsRefresh = false;
    public QsbkView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_qsbk_view,this);

        initUI();
        mPresenter = new QsbkPresenter(this);
        mPresenter.loadData(mPage);
    }

    /**
     * 初始化UI
     */
    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem ;
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //最后一个可见的ITEM
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1== mQsbkAdapter.getItemCount()){
                    LogUtils.v(TAG,"上拉刷新");
                    if(!mIsRefresh) {
                        mIsRefresh = true;
//                        mSwipeRefreshLayout.setRefreshing(true);
                        mPresenter.loadData(mPage+1);
                    }else{
                        LogUtils.v(TAG,"数据还没有加载完");
                    }
                }
            }
        });
    }

    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
        mPresenter.loadData(1);
        MyWindowManager.showLoading();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.release();
    }

    @Override
    public void refreshData(QsbkBean bean) {
        LogUtils.v(TAG,"refreshData:"+bean.getCount());
        if(bean.getCount()>0) {
            mPage = mPage + 1;
            if(mItemsBeanList.size()==0) {
                mItemsBeanList = bean.getItems();
                mQsbkAdapter = new QsbkAdapter(mItemsBeanList);
                mRecyclerView.setAdapter(mQsbkAdapter);
            }else{
                int orgLength = mItemsBeanList.size();
                for(int i = 0;i<bean.getItems().size();i++){
                    mItemsBeanList.add(orgLength,bean.getItems().get(i));
                }
                mQsbkAdapter.notifyItemRangeInserted(orgLength,orgLength+bean.getItems().size());
                Toast.makeText(mContext,"数据更新成功",Toast.LENGTH_SHORT).show();
            }
        }else{
            showError();
        }
    }

    @Override
    public void showError() {
        LogUtils.v(TAG,"showError");
        MyWindowManager.hideLoading();
        if(mItemsBeanList.size()>0){
            Toast.makeText(mContext,"获取数据失败",Toast.LENGTH_SHORT).show();
        }else {
            MyWindowManager.showErrorView();
        }
    }
}
