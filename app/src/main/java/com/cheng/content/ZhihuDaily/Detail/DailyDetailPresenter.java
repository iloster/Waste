package com.cheng.content.ZhihuDaily.Detail;

import com.cheng.content.ZhihuDaily.DailyConstant;
import com.cheng.content.ZhihuDaily.Main.DailyMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/2/8.
 */

public class DailyDetailPresenter {

    private DailyDetailView mDailyDetailView;
    private Call mCall = null;
    public DailyDetailPresenter(DailyDetailView view){
        mDailyDetailView = view;
    }

    public void loadData(DailyMainBean.StoriesBean storiesBean){
        String url = DailyConstant.DAILY_URL_DETAIL + storiesBean.getId();

        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mDailyDetailView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                DailyDetailBean bean = gson.fromJson(ret,DailyDetailBean.class);
                mDailyDetailView.showData(bean);
            }
        });
    }

    public void release() {
        if(mCall != null){
            mCall.cancel();
        }
    }
}
