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
    private WebView mWebView;


    public DBDetail(DBMainBean dbMainBean) {
        super(WasteApplication.getInstance());
        LogUtils.v(TAG,"DBDetail");
        mDbMainBean = dbMainBean;
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detail,this);

        initUI();
        loadData();

    }

    private void initUI(){
        mWebView = (WebView)findViewById(R.id.webView);
    }

    private void loadData(){
        String url = DBConstant.DOUBAN_ARTICLE_DETAIL+mDbMainBean.getId();
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {

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
        mWebView.loadUrl(mDbDetailBean.getUrl());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(false);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }
}
