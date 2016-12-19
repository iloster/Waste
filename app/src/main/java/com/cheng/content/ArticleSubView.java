package com.cheng.content;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cheng.bean.ArticleBean;
import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.waste.R;
import com.gc.materialdesign.views.ProgressBarCircularIndeterminate;
import com.google.gson.Gson;

/**
 * Created by dev on 2016/12/16.
 */

public class ArticleSubView extends RelativeLayout{

    private TextView mTitleTxt;
    private TextView mContentTxt;
    private ProgressBarCircularIndeterminate mLoading;
    public ArticleSubView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.service_float_content_item,this);
        initView();
        loadData();
    }

    private void initView(){
        mTitleTxt = (TextView)findViewById(R.id.titleTxt);
        mContentTxt = (TextView)findViewById(R.id.contentTxt);
        mLoading = (ProgressBarCircularIndeterminate)findViewById(R.id.loading);
        showLoading(true);
    }
    /**
     * 加载数据
     */
    private void loadData(){
        HttpUtil.getInstance().enqueue(Constants.URL, new CallBack() {
            @Override
            public void onError() {
                showFail();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                ArticleBean articleBean = gson.fromJson(ret, ArticleBean.class);
                showSucc(articleBean);
            }
        });
    }

    private void showSucc(ArticleBean articleBean){
        showLoading(false);
        mTitleTxt.setText(articleBean.getData().getTitle());
        mContentTxt.setText(Html.fromHtml(articleBean.getData().getContent()));
    }
    /**
     * 是否显示loading
     */
    private void showLoading(boolean bVisiable){
        if(bVisiable){
            mLoading.setVisibility(VISIBLE);
        }else{
            mLoading.setVisibility(INVISIBLE);
        }
    }

    private void showFail(){

    }
}
