package com.cheng.content.ZhihuDaily;

import com.cheng.content.DBMoment.DBMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void loadData(String timeStr, final boolean flag){
        String url = DailyConstant.Daily_URL_BEFORE + timeStr;
        LogUtils.v(TAG,"loadData url:"+url);
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mDailyView.showError(flag);
            }

            @Override
            public void onSuccess(String ret) {
                try {
                    Gson gson = new Gson();
                    DailyMainBean dailyMainBean = gson.fromJson(ret, DailyMainBean.class);
                    mDailyView.refreshData(dailyMainBean.getStories(), flag);

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date date = sdf.parse(dailyMainBean.getDate());
                    long timeStr = date.getTime();
                    for(int i = 0;i<dailyMainBean.getStories().size();i++){
                        dailyMainBean.getStories().get(i).setShowtime(timeStr);
                    }
                }catch (Exception e){
                    mDailyView.showError(flag);
                }
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
