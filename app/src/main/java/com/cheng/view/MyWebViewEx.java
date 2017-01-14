package com.cheng.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.cheng.utils.LogUtils;
import com.cheng.waste.R;

import org.w3c.dom.Attr;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dev on 2017/1/14.
 */

public class MyWebViewEx extends LinearLayout {

    private String TAG = "MyWebViewEx";
    private ProgressBar mProgressbar;
    private WebView mWebView;
    private Context mContext;

    private long timeout = 30000;
    private Handler mHandler;

    private Timer timer;
    private OnWebViewListener mOnWebViewListener;
    private boolean mLoadingFinish = false;
    public MyWebViewEx(Context context) {
        super(context);
        mContext = context;
        initUI();
    }

    public MyWebViewEx(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
        mContext = context;

        initUI();

    }
    private void initUI(){
        LogUtils.v("MyWebViewEx","initUI");
        setOrientation(VERTICAL);
        mProgressbar = new ProgressBar(mContext,null, android.R.attr.progressBarStyleHorizontal);
        mProgressbar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,5));
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.webview_progress);
        mProgressbar.setProgressDrawable(drawable);
        this.addView(mProgressbar);

        mWebView = new WebView(mContext);
        mWebView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        this.addView(mWebView);

        mWebView.setWebChromeClient(new MyWebChromeClient());
        //是否可以缩放
        //getSettings().setSupportZoom(true);
        //getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setBlockNetworkImage(false);
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 1){
                    mOnWebViewListener.onTimeout();
                }
            }
        };
    }

    public void loadUrl(String url){
        if(mWebView==null){
            LogUtils.v("MyWebViewEx","mWebView is null");
        }
        mWebView.loadUrl(url);
    }

    public boolean canGoBack(){
        return mWebView.canGoBack();
    }

    public void goBack(){
        mWebView.goBack();
    }

    public void setWebViewListener(OnWebViewListener listener){
        mOnWebViewListener = listener;
    }


    private class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            LogUtils.v(TAG,"newProgress:"+newProgress);
            if(newProgress == 100){
                mProgressbar.setVisibility(GONE);
            }else{
                if(mProgressbar.getVisibility() == GONE){
                    mProgressbar.setVisibility(VISIBLE);
                }
                mProgressbar.setProgress(newProgress);
            }
            if(newProgress >= 60){
                mLoadingFinish = true;
                timer.cancel();
                timer.purge();
            }
            super.onProgressChanged(view, newProgress);
        }

    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mLoadingFinish = false;
            timer = new Timer();
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                        /*
                         * 超时后,首先判断页面加载进度,超时并且进度小于100,就执行超时后的动作
                         */
                    if(!mLoadingFinish) {
                        Message msg = new Message();
                        msg.what = 1;
                        mHandler.sendMessage(msg);
                        timer.cancel();
                        timer.purge();
                    }
                }
            };
            timer.schedule(tt, timeout, 1);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mLoadingFinish = true;
            timer.cancel();
            timer.purge();
            LogUtils.v(TAG,"onPageFinished");
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
            //return super.shouldOverrideUrlLoading(view, url);
        }


    }



    public interface OnWebViewListener{
        void onTimeout();
    }


}
