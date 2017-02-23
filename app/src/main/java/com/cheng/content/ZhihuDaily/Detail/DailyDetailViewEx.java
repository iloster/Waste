package com.cheng.content.ZhihuDaily.Detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.content.ZhihuDaily.DailyStringUtils;
import com.cheng.content.ZhihuDaily.Main.DailyMainBean;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.List;

/**
 * Created by dev on 2017/2/23.
 */

public class DailyDetailViewEx extends BaseSubView implements IDailyDetailView {

    private String TAG = "DailyDetailViewEx";

    /*ui*/
    private RecyclerView mRecyclerView;

    /*变量*/
    private Context mContext;
    private DailyMainBean.StoriesBean mStoriesBean;
    private DailyDetailPresenter mPresenter;
    public DailyDetailViewEx(DailyMainBean.StoriesBean storiesBean) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mStoriesBean = storiesBean;
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detailex,this);

        initUI();

        mPresenter = new DailyDetailPresenter(this);
        mPresenter.loadData(mStoriesBean);
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager l = new LinearLayoutManager(mContext);
        l.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(l);
    }

    @Override
    public void showData(DailyDetailBean bean) {
        LogUtils.v(TAG,"showData");
        MyWindowManager.hideLoading();

        String body = bean.getBody();
        List<String> list = DailyStringUtils.splitHtml(body);
        list.add(0,"<title>"+bean.getTitle()+"</title>");
//        list.add(1,String.format("<time>%s</time>",bean.gets));
       for (String s : list) {
           LogUtils.v(TAG,"str:"+s);
        }
        DailyDetailAdapter adapter = new DailyDetailAdapter(list);
        mRecyclerView.setAdapter(adapter);
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
