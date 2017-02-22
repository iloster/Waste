package com.cheng.content.DBMoment.Detail;

import com.cheng.content.DBMoment.DBConstant;
import com.cheng.content.DBMoment.Main.DBMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/2/8.
 */

public class DBDetailPresenter {

    private DBDetailViewEx mDBDetailView;
    private Call mCall;
    public DBDetailPresenter(DBDetailViewEx view){
        mDBDetailView = view;
    }

    public void release(){
        if(mCall!=null){
            mCall.cancel();
        }
    }
    public void loadData(DBMainBean bean){
        String url = DBConstant.DOUBAN_ARTICLE_DETAIL + bean.getId();
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mDBDetailView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                DBDetailBean dbDetailBean = gson.fromJson(ret,DBDetailBean.class);
                mDBDetailView.showData(dbDetailBean);
            }
        });
    }

}
