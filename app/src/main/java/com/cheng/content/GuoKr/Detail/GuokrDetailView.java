package com.cheng.content.GuoKr.Detail;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.config.Constants;
import com.cheng.content.GuoKr.GuokrConstant;
import com.cheng.content.GuoKr.Main.GuokrMainBean;
import com.cheng.utils.SpUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * Created by dev on 2017/1/12.
 */

public class GuokrDetailView extends BaseSubView implements IGuokrDetailView{
    private Context mContext;
    private GuokrMainBean.ResultBean mResultBean;
    private MyWebViewEx mWebView;
    private GuokrDetailPresenter mPresenter;
    public GuokrDetailView(GuokrMainBean.ResultBean resultBean) {
        super(WasteApplication.getInstance());

        mContext = WasteApplication.getInstance();
        mResultBean = resultBean;
        LayoutInflater.from(mContext).inflate(R.layout.content_guokr_detail,this);

        initUI();
        mPresenter = new GuokrDetailPresenter(this);
        mPresenter.loadData(mResultBean);
        MyWindowManager.showLoading();
//        showData();

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mPresenter.release();
    }

    @Override
    public boolean onWebViewBack() {
        if(mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onRefreshClick() {
        mPresenter.loadData(mResultBean);
    }

    private void initUI(){
        mWebView = (MyWebViewEx)findViewById(R.id.webView);
        mWebView.setWebViewListener(new MyWebViewEx.OnWebViewListener() {
            @Override
            public void onTimeout() {
//                LogUtils.v(TAG,"加载超时");
                MyWindowManager.showErrorView();
            }
        });
    }

//    private void showData(){
//        String url = mResultBean.getLink_v2();
//        mWebView.loadUrl(url);
//    }

    @Override
    public void showData(GuokrDetailBean bean) {
        MyWindowManager.hideLoading();
        String content = bean.getResult().get(0).getContent();
        String title = bean.getResult().get(0).getTitle();
        String author = bean.getResult().get(0).getAuthor();
        String html = GuokrConstant.HTML_STR.replace("{title}",title).replace("{source}",author).replace("{body}",content);
        if(SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)){
            html = html.replace("{css}",GuokrConstant.HTML_CSS_NIGHT);
        }else{
            html = html.replace("{css}",GuokrConstant.HTML_CSS_DAY);
        }
        mWebView.loadData(html);
    }

    @Override
    public void showError() {
        MyWindowManager.hideLoading();
        MyWindowManager.showErrorView();
    }
}
