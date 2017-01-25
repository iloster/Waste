package com.cheng.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by cheng on 16/3/31.
 */
public class HttpUtil {
    private String TAG = "HttpUtil";

    private OkHttpClient mOkHttpClient;

    private static final int HTTP_RET_SUCCESS = 0;
    private static final int HTTP_RET_ERROR = 1;

    private Handler mDelivery;

    private static HttpUtil mInstance = null;
    private Gson gson = new Gson();

    public HttpUtil() {
        mOkHttpClient = new OkHttpClient();
        mDelivery = new Handler(Looper.getMainLooper());
    }
    public static HttpUtil getInstance(){
        if (mInstance == null)
        {
            synchronized (HttpUtil.class)
            {
                if (mInstance == null)
                {
                    mInstance = new HttpUtil();
                }
            }
        }
        return mInstance;
    }

    public String excute(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            return mOkHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *
     * @param service  jie 接口
     * @param param  请求参数 为一个json字符串
     * @param callback  请求回调
     */
    public void enqueue(String url,CallBack callback){
        Log.v("ZedLi","url:"+url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        final CallBack mCallBack = callback;
        mOkHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                sendFailure(call, mCallBack);
                Log.e("ZedLi","onFailure:"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    sendResponse(call, response.body().string(), mCallBack);
                } else {
                    sendFailure(call, mCallBack);
                }
            }
        });

    }


    /**
     *
     * @param url  jie 接口
     * @param callback  请求回调
     */
    public Call enqueueEx(String url,CallBack callback){
        Log.v("ZedLi","url:"+url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        final CallBack mCallBack = callback;
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if(!e.toString().contains("closed")) {
                    if (mCallBack != null) {
                        sendFailure(call, mCallBack);
                    }
                }
                Log.e("ZedLi","onFailure:"+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        sendResponse(call, response.body().string(), mCallBack);
                    }catch (IOException e){
                        sendFailure(call, mCallBack);
                    }
                } else {
                    sendFailure(call, mCallBack);
                }
            }
        });
        return call;
    }

    private void sendFailure(Call call, final CallBack callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }

    private void sendResponse(Call call, final String ret, final CallBack callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(ret);
            }
        });
    }

}
