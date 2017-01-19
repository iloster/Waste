package com.cheng.content.Netease;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

/**
 * Created by dev on 2017/1/18.
 */

public class NeteaseDetail extends BaseSubView {

    private String TAG = "NeteaseDetail";
    private Context mContext;
    private MyWebViewEx mWebView;
    private NeteaseBean mNeteaseBean;
    private NeteaseDetailBean mNeteaseDetailBean;
    public NeteaseDetail(NeteaseBean bean) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mNeteaseBean = bean;
        LayoutInflater.from(mContext).inflate(R.layout.content_netease_detail,this);

        initUI();
        loadData();
    }

    private void initUI(){
        mWebView = (MyWebViewEx)findViewById(R.id.webView);
    }

    private void loadData(){
        String url = String.format(NeteaseConstant.ARTICLE_URL,mNeteaseBean.getPostid());
        HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                mNeteaseDetailBean = gson.fromJson(ret,NeteaseDetailBean.class);
                showData();
            }
        });
    }

    private void showData(){
        String html = NeteaseConstant.HTML_STR.replace("{body}",handlerHtml()).replace("{title}",mNeteaseDetailBean.getTitle()).replace("{source}",mNeteaseDetailBean.getSource()+"  "+mNeteaseDetailBean.getPtime());
        LogUtils.v(TAG,"showData:"+html);
        mWebView.loadData(html);
    }
    /**
     * 处理html
     */
    private String handlerHtml(){

        String bodyStr = mNeteaseDetailBean.getBody();
        LogUtils.v(TAG,"handlerHtml:"+bodyStr);
        for (int i = 0 ; i<mNeteaseDetailBean.getImg().size();i++){
            String str1 = mNeteaseDetailBean.getImg().get(i).getRef();
            String str2 = "<img src=\""+mNeteaseDetailBean.getImg().get(i).getSrc()+"\"/><br/>";
            bodyStr = bodyStr.replaceAll(str1,str2);
        }
        return bodyStr;
    }
}
