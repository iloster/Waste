package com.cheng.content.DBMoment;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 * Created by cheng on 2017/1/6.
 */

public class DBPresenter {

    private String TAG = "DBPresenter";
    private DBView mDBView;
    private Call mCall;
    public DBPresenter(DBView dbView){
        mDBView = dbView;
    }

    public void loadData(final String timeStr, final boolean flag) {
        String url = DBConstant.DOUBAN_MOMENT + timeStr;
        LogUtils.v(TAG, "loadData:" + url);
        if (DBDbUtil.get(timeStr).size() == 0) {
            mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
                @Override
                public void onError() {
                    LogUtils.v(TAG, "onError");
                    mDBView.showError(true);
                }

                @Override
                public void onSuccess(String ret) {
                    mDBView.showError(false);
                    //                LogUtils.v(TAG,"loadData success:"+ret);
                    DBDbUtil.save(timeStr, ret);
                    Gson gson = new Gson();
                    try {
                        JSONObject jsonObject = new JSONObject(ret);
                        String posts = jsonObject.getString("posts");
                        Type type = new TypeToken<List<DBMainBean>>() {
                        }.getType();
                        List<DBMainBean> list = gson.fromJson(posts, type);
                        //将数据存入数据库
                        mDBView.refreshData(list,flag);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        } else {
            String dbStr = DBDbUtil.get(timeStr).get(0).getRet();
            LogUtils.v(TAG,"dbStr:"+dbStr);
            Gson gson = new Gson();
            try {
                JSONObject jsonObject = new JSONObject(dbStr);
                String posts = jsonObject.getString("posts");
                Type type = new TypeToken<List<DBMainBean>>() {
                }.getType();
                List<DBMainBean> list = gson.fromJson(posts, type);
                //将数据存入数据库
                mDBView.refreshData(list,flag);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void release(){
        LogUtils.v(TAG,"release");
        try{
            mCall.cancel();
        }catch (Exception e){
            LogUtils.v(TAG,"Exception:"+e.toString());
        }
    }
}
