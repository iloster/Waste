package com.cheng.content.v2ex;

import android.telecom.Call;

import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public class V2exPresenter {
    private String TAG = "V2exPresenter";
    private IV2exMainView mIV2exMainView;
    public V2exPresenter(IV2exMainView iv2exMainView){
        mIV2exMainView = iv2exMainView;
    }

    /**
     * 加载数据
     */
    public void loadData(){
        LogUtils.v(TAG,"V2exPresenter:loadData");
        HttpUtil.getInstance().enqueue(Constants.V2EX_URL_HOT, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<V2exMainBean>>(){}.getType();
                List<V2exMainBean> v2exMainBeanList = gson.fromJson(ret,type);
                mIV2exMainView.showData(v2exMainBeanList);
            }
        });

    }

}
