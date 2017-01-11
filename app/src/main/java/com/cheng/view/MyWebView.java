package com.cheng.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.cheng.utils.LogUtils;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cheng on 2017/1/7.
 */

public class MyWebView extends WebView {

    private String TAG="MyWebView";
    private ProgressBar mProgressbar;
    private long timeout = 30000;
    private Handler mHandler;

    private Timer timer;
    private OnWebViewListener mOnWebViewListener;
    private boolean mLoadingFinish = false;
    public MyWebView(Context context, AttributeSet attrs) {
        super(context,attrs);

        mProgressbar = new ProgressBar(context,null, android.R.attr.progressBarStyleHorizontal);
        mProgressbar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                5, 0, 0));

        Drawable drawable = context.getResources().getDrawable(R.drawable.webview_progress);
        mProgressbar.setProgressDrawable(drawable);
        addView(mProgressbar);
        // setWebViewClient(new WebViewClient(){});
        setWebChromeClient(new MyWebChromeClient());
        //是否可以缩放
        //getSettings().setSupportZoom(true);
        //getSettings().setBuiltInZoomControls(true);
        setWebViewClient(new MyWebViewClient());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setBlockNetworkImage(false);
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 1){
                    mOnWebViewListener.onTimeout();
                }
            }
        };
    }


    public void setWebViewListener(OnWebViewListener listener){
        mOnWebViewListener = listener;
    }
    private class MyWebChromeClient extends WebChromeClient{

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

    private class MyWebViewClient extends WebViewClient{

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
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressbar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressbar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public interface OnWebViewListener{
        void onTimeout();
    }
}
