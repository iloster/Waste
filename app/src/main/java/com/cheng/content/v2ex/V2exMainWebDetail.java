package com.cheng.content.v2ex;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * Created by cheng on 2017/1/14.
 */

public class V2exMainWebDetail extends BaseSubView {
    private Context mContext;
    private MyWebViewEx mWebView;
    private V2exEntity mV2exEntity;
    public V2exMainWebDetail(Context context,V2exEntity v) {
        super(context);
        mContext = context;
        mV2exEntity = v;
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detail,this);

        initUI();
        showData();
    }

    public void initUI(){
        mWebView = (MyWebViewEx)findViewById(R.id.webView);
        mWebView.setWebViewListener(new MyWebViewEx.OnWebViewListener() {
            @Override
            public void onTimeout() {
                MyWindowManager.showErrorView();
            }
        });
    }

    public void showData(){
        mWebView.loadUrl(mV2exEntity.getUrl());
    }
    public boolean onWebViewBack(){
        if(mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }else{
            return false;
        }
    }
}
