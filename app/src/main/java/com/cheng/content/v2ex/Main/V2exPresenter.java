package com.cheng.content.v2ex.Main;

import android.util.Log;

import com.cheng.content.v2ex.V2exConstants;
import com.cheng.content.v2ex.V2exEntity;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 * Created by dev on 2016/12/21.
 */

public class V2exPresenter {
    private String TAG = "V2exPresenter";
    private IV2exMainPagerView mIV2exMainView;
    private int mIndex;
    private Call mCall = null;
    public V2exPresenter(IV2exMainPagerView iv2exMainView){
        mIV2exMainView = iv2exMainView;
    }

    /**
     * 加载数据
     */
    public void loadData(final int index){
        LogUtils.v(TAG,"V2exPresenter:loadData");
        String url = V2exConstants.V2EX_URL[index];
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mIV2exMainView.showError();
            }

            @Override
            public void onSuccess(String ret) {
//                LogUtils.v(TAG,"ret:"+ret);
                Gson gson = new Gson();
                Type type = new TypeToken<List<V2exMainBean>>(){}.getType();
                List<V2exMainBean> v2exMainBeanList = gson.fromJson(ret,type);
//                V2exDbUtils.save(mIndex,v2exMainBeanList);
                mIV2exMainView.showData(index,v2exMainBeanList);
            }
        });

    }

    /**
     * 获取详情
     * @param
     */
    public void getDetail(V2exMainBean v){
        mIV2exMainView.showDetail(v);
    }

    /**
     * 刷新数据
     */
    public void refreshData(){
        LogUtils.v(TAG,"V2exPresenter:loadData");
        String url = "";
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<V2exMainBean>>(){}.getType();
                List<V2exMainBean> v2exMainBeanList = gson.fromJson(ret,type);
//                List<V2exEntity> list = V2exDbUtils.save(mIndex,v2exMainBeanList);
                mIV2exMainView.refreshData(mIndex,v2exMainBeanList);
            }
        });
    }

    public void release(){
        if(mCall!=null){
            mCall.cancel();
        }
    }

}
