package com.cheng.content.DBMoment;

import android.content.Context;
import android.view.LayoutInflater;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MultiHtmlTextView;
import com.cheng.view.MyWebView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import io.github.angebagui.mediumtextview.MediumTextView;

/**
 * Created by dev on 2017/1/4.
 */

public class DBDetail extends BaseSubView {
    private String TAG = "DBDetail";
    private Context mContext;
    private DBDetailBean mDbDetailBean;
    private DBMainBean mDbMainBean;
    private MyWebView mWebView;


    public DBDetail(DBMainBean dbMainBean) {
        super(WasteApplication.getInstance());
        LogUtils.v(TAG,"DBDetail");
        mDbMainBean = dbMainBean;
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detail,this);

        initUI();
        //loadData();
        showData();
    }

    private void initUI(){
        mWebView = (MyWebView) findViewById(R.id.webView);
        mWebView.setWebViewListener(new MyWebView.OnWebViewListener() {
            @Override
            public void onTimeout() {
                LogUtils.v(TAG,"加载超时");
                MyWindowManager.showErrorView();
            }
        });
    }

    private void loadData(){
        String url = DBConstant.DOUBAN_ARTICLE_DETAIL+mDbMainBean.getId();
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {
                MyWindowManager.showErrorView();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                mDbDetailBean = gson.fromJson(ret,DBDetailBean.class);
                showData();
            }
        });
    }
    private void showData(){
        mWebView.loadUrl(mDbMainBean.getUrl());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    @Override
    public void onRefreshClick() {
        showData();
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
