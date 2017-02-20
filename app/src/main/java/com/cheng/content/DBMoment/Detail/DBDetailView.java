package com.cheng.content.DBMoment.Detail;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.config.Constants;
import com.cheng.content.DBMoment.DBConstant;
import com.cheng.content.DBMoment.Main.DBMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;
import com.cheng.utils.StringUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dev on 2017/1/4.
 */

public class DBDetailView extends BaseSubView implements IDBDetailView{
    private String TAG = "DBDetail";
    private Context mContext;
    private DBDetailBean mDbDetailBean;
    private DBMainBean mDbMainBean;
    private MyWebViewEx mWebView;
    private DBDetailPresenter mPresenter;

    public DBDetailView(DBMainBean dbMainBean) {
        super(WasteApplication.getInstance());
        LogUtils.v(TAG,"DBDetail");
        mDbMainBean = dbMainBean;
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detail,this);

        initUI();

        mPresenter = new DBDetailPresenter(this);
        mPresenter.loadData(dbMainBean);
    }

    private void initUI(){
        mWebView = (MyWebViewEx) findViewById(R.id.webView);
        mWebView.setWebViewListener(new MyWebViewEx.OnWebViewListener() {
            @Override
            public void onTimeout() {
                LogUtils.v(TAG,"加载超时");
                MyWindowManager.showErrorView();
            }
        });
    }

    @Override
    public void onRefreshClick() {
        mPresenter.loadData(mDbMainBean);
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
    }

    @Override
    public void showData(DBDetailBean bean) {
        String content = bean.getContent();
        List<DBDetailBean.PhotosBean> photosBeanList= bean.getPhotos();
        for(int i = 0;i<photosBeanList.size();i++){
            String reg1 = "<img id=\""+photosBeanList.get(i).getTag_name();
            String reg2 = "<img src=\""+photosBeanList.get(i).getMedium().getUrl();
            content = content.replaceAll(reg1,reg2);
         }
        LogUtils.v(TAG,"content:"+content);
        String html = DBConstant.HTML_STR.replace("{body}",content);
        if(SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)){
            html = html.replace("{css}",DBConstant.HTML_CSS_NIGHT);
        }else{
            html = html.replace("{css}",DBConstant.HTML_CSS_DAY);
        }
        mWebView.loadData(StringUtils.filterTagA(html));
    }

    @Override
    public void showError() {
        MyWindowManager.showErrorView();
    }
}
