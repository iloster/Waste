package com.cheng.content.GuoKr;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * Created by dev on 2017/1/12.
 */

public class GuokrDetail extends BaseSubView {
    private Context mContext;
    private GuokrMainBean.ResultBean mResultBean;
    private MyWebView mWebView;

    public GuokrDetail(GuokrMainBean.ResultBean resultBean) {
        super(WasteApplication.getInstance());

        mContext = WasteApplication.getInstance();
        mResultBean = resultBean;
        LayoutInflater.from(mContext).inflate(R.layout.content_guokr_detail,this);

        initUI();
        showData();
    }

    private void initUI(){
        mWebView = (MyWebView)findViewById(R.id.webView);
    }

    private void showData(){
        String url = mResultBean.getLink_v2();
        mWebView.loadUrl(url);
    }
}
