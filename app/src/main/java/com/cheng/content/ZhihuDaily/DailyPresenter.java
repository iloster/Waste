package com.cheng.content.ZhihuDaily;

import com.cheng.content.DBMoment.DBMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.Call;

/**
 * Created by cheng on 2017/1/8.
 */

public class DailyPresenter {

    private String TAG = "DailyPreseter";
    private DailyView mDailyView;
    private Call mCall;
    public DailyPresenter(DailyView dailyView){
        mDailyView = dailyView;
    }

    /**
     * 获取最新数据
     * @param timeStr
     */
    public void loadData(String timeStr){
        String url = DailyConstant.Daily_URL_BEFORE + timeStr;
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mDailyView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                DailyMainBean dailyMainBean = gson.fromJson(ret,DailyMainBean.class);
                mDailyView.refreshData(dailyMainBean.getStories());
            }
        });
    }

    /**
     * 需要取消http请求
     *
     * */
    public void release(){
        mCall.cancel();
    }
}
