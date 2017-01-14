package com.cheng.content.GuoKr;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2017/1/10.
 */

public class GuokrView extends BaseSubView implements IGuokrView{
    private String TAG = "GuoKrView";

    private Context mContext;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    private GuokrPresenter mPresenter;
    private List<GuokrMainBean.ResultBean> mResultBeanList = new ArrayList<>();
    private GuokrMainItem mGuokrMainItem;
    private int mOffsetDay = 0;
    private boolean mIsRefresh = false;
    public GuokrView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_guokr_view,this);

        initUI();

        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);

        mPresenter = new GuokrPresenter(this);
        mPresenter.loadData(0,true);
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);


            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(linearLayoutManager);


        mGuokrMainItem = new GuokrMainItem(mResultBeanList);
        mRecyclerView.setAdapter(mGuokrMainItem);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
//                下拉刷新
                mPresenter.loadData(0,true);
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==mGuokrMainItem.getItemCount()){
                    LogUtils.v(TAG,"上拉刷新");
                    if(!mIsRefresh) {
                        mIsRefresh = true;
                        mSwipeRefreshLayout.setRefreshing(true);
                        mPresenter.loadData(mOffsetDay,false);
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

        mGuokrMainItem.setOnRecyclerViewItemClickListener(new BaseSubView.OnRecyclerViewItemClickListener(){

            @Override
            public void onItemClick(int position, Object data) {
                LogUtils.v(TAG,"onItemClick:"+position);
                GuokrDetail guokrDetail = new GuokrDetail((GuokrMainBean.ResultBean)data);
                MyWindowManager.replaceSubView(guokrDetail,"果壳精选");
            }
        });
    }


    public void onRefreshClick(){
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.loadData(0,true);
    }

    @Override
    public void refreshData(List<GuokrMainBean.ResultBean> list, boolean flag) {
        LogUtils.v("refreshData","size:"+list.size());
        mSwipeRefreshLayout.setRefreshing(false);
        mIsRefresh = false;
        if(list.size()>0){
            mOffsetDay = mOffsetDay + 1;
            if(flag) {
                //下拉刷新  数据插到前面
                //int orgLength = mResultBeanList.size();
                List<GuokrMainBean.ResultBean> list1 = new ArrayList<>();
                for(int i = 0;i<list.size();i++){
                    if((!mResultBeanList.contains(i)) ||(list.get(i).getId() != mResultBeanList.get(i).getId())){
                        list1.add(list.get(i));
                    }
                }
                for (int i = 0; i < list1.size(); i++) {
                    mResultBeanList.add(i, list1.get(i));
                }
                mGuokrMainItem.notifyItemRangeChanged(0, list1.size());
            }else{
                int orgLength = mResultBeanList.size();
                for(int i = 0;i<list.size();i++){
                    mResultBeanList.add(orgLength+i,list.get(i));
                }
                mGuokrMainItem.notifyItemRangeChanged(orgLength,orgLength+list.size());
            }
            mGuokrMainItem.notifyDataSetChanged();
        }
    }

    @Override
    public void showError() {
        mIsRefresh = false;
        mSwipeRefreshLayout.setRefreshing(false);
        if(mResultBeanList.size()>0){
            Toast.makeText(mContext,"数据加载失败",Toast.LENGTH_SHORT).show();
        }else{
            MyWindowManager.showErrorView();
        }
    }
}
