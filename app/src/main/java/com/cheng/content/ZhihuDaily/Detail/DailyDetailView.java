package com.cheng.content.ZhihuDaily.Detail;

import android.view.LayoutInflater;

import com.cheng.config.Constants;
import com.cheng.content.ZhihuDaily.DailyConstant;
import com.cheng.content.ZhihuDaily.Main.DailyMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.SpUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/1/9.
 */

public class DailyDetailView extends BaseSubView implements IDailyDetailView{
    private MyWebViewEx mWebView;
    private Call mCall;
    private DailyMainBean.StoriesBean mStoriesBean;
    private DailyDetailPresenter mPresenter;
    public DailyDetailView(DailyMainBean.StoriesBean storiesBean) {
        super(WasteApplication.getInstance());

        LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_db_detail,this);

        mStoriesBean = storiesBean;
        initUI();

        mPresenter = new DailyDetailPresenter(this);
        mPresenter.loadData(storiesBean);

    }

    private void initUI(){
        mWebView = (MyWebViewEx)findViewById(R.id.webView);

        mWebView.setWebViewListener(new MyWebViewEx.OnWebViewListener() {
            @Override
            public void onTimeout() {
                MyWindowManager.showErrorView();
            }
        });
    }

    public boolean onWebViewBack(){
        if(mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.release();
    }

    @Override
    public void showData(DailyDetailBean bean) {
        String body = bean.getBody();
        String html = DailyConstant.HTML_STR.replace("{imageurl}",bean.getImage()).replace("{title}",bean.getTitle()).replace("{body}",body);
        if(SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)){
            html = html.replace("{css}",DailyConstant.HTML_CSS_NIGHT);
        }else{
            html = html.replace("{css}",DailyConstant.HTML_CSS_DAY);
        }
        mWebView.loadData(html);
    }

    @Override
    public void showError() {

    }
}
