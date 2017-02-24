package com.cheng.content.Qsbk;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

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
    public QsbkView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_qsbk_view,this);

        initUI();
        mPresenter = new QsbkPresenter(this);
        mPresenter.loadData(mPage);
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void refreshData(QsbkBean bean) {
        LogUtils.v(TAG,"refreshData");
        List<QsbkBean.ItemsBean> itemsBeanList = bean.getItems();
        QsbkAdapter adapter = new QsbkAdapter(itemsBeanList);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError() {

    }
}
