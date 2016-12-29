package com.cheng.content.v2ex;

import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public class V2exPresenter {
    private String TAG = "V2exPresenter";
    private IV2exMainPagerView mIV2exMainView;
    private int mIndex;
    public V2exPresenter(IV2exMainPagerView iv2exMainView, int index){
        mIV2exMainView = iv2exMainView;
        mIndex = index;
    }

    /**
     * 加载数据
     */
    public void loadData(){
        LogUtils.v(TAG,"V2exPresenter:loadData");
        String url = "";
        if(mIndex == 1){
            url = Constants.V2EX_URL_HOT;
        }else{
            url = Constants.V2EX_URL_LATEST;
        }
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<V2exMainBean>>(){}.getType();
                List<V2exMainBean> v2exMainBeanList = gson.fromJson(ret,type);
                V2exDbUtils.save(mIndex,v2exMainBeanList);
                mIV2exMainView.showData(mIndex);
            }
        });
    }

    /**
     * 获取详情
     * @param
     */
    public void getDetail(V2exEntity v){
//        V2exMainDetail v2exMainDetail = new V2exMainDetail(mCon)
        mIV2exMainView.showDetail(v);
    }

}
