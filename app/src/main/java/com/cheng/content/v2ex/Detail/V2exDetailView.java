package com.cheng.content.v2ex.Detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cheng.content.v2ex.Main.V2exMainBean;
import com.cheng.content.v2ex.V2exConstants;
import com.cheng.content.v2ex.V2exEntity;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by cheng on 2016/12/26.
 */

public class V2exDetailView extends BaseSubView implements IV2exDetailView{

    private String TAG = "V2exMainDetail";

    private Context mContext;
    private String mCommentUrl="";

    private V2exMainBean mV2exMainBean;
    private RecyclerView mRecyclerView;
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;
    private Call mCall = null;
    private V2exTopicBean mV2exTopicBean;
    private List<V2exCommentBean> mV2exCommentBeanList;
    private V2exDetailPresenter mPresenter;


    public V2exDetailView(Context context, V2exMainBean v) {
        super(context);
        mContext = context;
        mV2exMainBean = v;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_detail,this);

        initUI();
        mPresenter = new V2exDetailPresenter(this);
        mPresenter.loadTopic(mV2exMainBean);
        mPresenter.loadComment(mV2exMainBean);


    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mErrorLayout = (LinearLayout)findViewById(R.id.errorLayout);
        mErrorBtn = (Button)findViewById(R.id.errorBtn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mErrorLayout.setVisibility(GONE);
    }


    @Override
    public void showComment(List<V2exCommentBean> list) {
        mV2exCommentBeanList = list;
    }

    @Override
    public void showTopic(V2exTopicBean v2exTopicBean) {
        mV2exTopicBean = v2exTopicBean;
    }

    @Override
    public void showDetail() {
        if(mV2exTopicBean!=null&&mV2exCommentBeanList.size()!=0) {
            MyWindowManager.hideLoading();
            V2exCommentAdapter v2exCommentAdapter = new V2exCommentAdapter(mContext, mV2exCommentBeanList, mV2exTopicBean);
            mRecyclerView.setAdapter(v2exCommentAdapter);
        }
    }

    @Override
    public void showError() {
        MyWindowManager.hideLoading();
        mRecyclerView.setVisibility(VISIBLE);
    }

    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
        MyWindowManager.showLoading();
        if(mV2exTopicBean == null){
            mPresenter.loadTopic(mV2exMainBean);
        }
        if(mV2exCommentBeanList.size()==0){
            mPresenter.loadComment(mV2exMainBean);
        }
    }
}
