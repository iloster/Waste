package com.cheng.content.GuoKr.Detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.content.GuoKr.Main.GuokrMainBean;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * Created by cheng on 2017/2/22.
 */

public class GuokrDetailViewEx extends BaseSubView implements IGuokrDetailView{

    /****ui控件**/
    private RecyclerView mRecyclerView;

   /**变量**/
   private Context mContext;
    private GuokrDetailPresenter mPresenter;
    private GuokrMainBean.ResultBean mResultBean;
    public GuokrDetailViewEx(GuokrMainBean.ResultBean resultBean) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mResultBean = resultBean;
        LayoutInflater.from(mContext).inflate(R.layout.content_guokr_detailex,this);

        initUI();

        mPresenter = new GuokrDetailPresenter(this);
        mPresenter.loadData(mResultBean);
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void showData(GuokrDetailBean bean) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
