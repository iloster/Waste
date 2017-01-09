package com.cheng.content.ZhihuDaily;

import android.content.Context;
import android.view.LayoutInflater;
import android.webkit.WebView;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/1/9.
 */

public class DailyDetail extends BaseSubView{
    private MyWebView mWebView;
    private Call mCall;
    private DailyMainBean.StoriesBean mStoriesBean;
    public DailyDetail(DailyMainBean.StoriesBean storiesBean) {
        super(WasteApplication.getInstance());

        LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_db_detail,this);

        mStoriesBean = storiesBean;
        initUI();
        loadData();
    }

    private void initUI(){
        mWebView = (MyWebView)findViewById(R.id.webView);
    }

    private void loadData(){
        String url = DailyConstant.Daily_URL_DETAIL + mStoriesBean.getId();
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                DailyDetailBean bean = gson.fromJson(ret,DailyDetailBean.class);
                showData(bean);
            }
        });
    }

    private void showData(DailyDetailBean bean){
        mWebView.loadUrl(bean.getShare_url());
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
