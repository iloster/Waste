package com.cheng.content.GuoKr;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

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
    private List<GuokrMainBean.ResultBean> mResultBeanList;
    private GuokrMainItem mGuokrMainItem;
    private int mOffset = 0;
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
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.recyclerView);

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
    }

    public void onRefreshClick(){
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.loadData(0,true);
    }

    @Override
    public void refreshData(List<GuokrMainBean.ResultBean> list, boolean flag) {
        mSwipeRefreshLayout.setRefreshing(false);
        if(list.size()>0){
            if(flag){
                //下拉刷新  数据插到前面
                //int orgLength = mResultBeanList.size();
                for(int i = 0;i<list.size();i++){
                    mResultBeanList.add(i,list.get(i));
                }
                mGuokrMainItem.notifyItemRangeChanged(0,list.size());
            }
        }else{
            int orgLength = mResultBeanList.size();
            for(int i = 0;i<list.size();i++){
                mResultBeanList.add(orgLength+i,list.get(i));
            }
            mGuokrMainItem.notifyItemRangeChanged(orgLength,orgLength+list.size());
        }
        mGuokrMainItem.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        mSwipeRefreshLayout.setRefreshing(false);
        if(mResultBeanList.size()>0){
            Toast.makeText(mContext,"数据加载失败",Toast.LENGTH_SHORT).show();
        }else{
            MyWindowManager.showErrorView();
        }
    }
}
