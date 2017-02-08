package com.cheng.content.GuoKr.Main;

import com.cheng.content.GuoKr.GuokrConstant;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by cheng on 2017/1/11.
 */

public class GuokrPresenter {

    private String TAG = "GuokrPresenter";
    private GuokrView mGuokrView;
    private Call mCall;
    public GuokrPresenter(GuokrView guokrView){
        mGuokrView = guokrView;
    }

    public void loadData(int offset, final boolean flag){
        String url = GuokrConstant.GUOKR_ARTICLES + offset*20;
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mGuokrView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                LogUtils.v(TAG,"ret:"+ret);
                Gson gson = new Gson();
                GuokrMainBean mainBean = gson.fromJson(ret,GuokrMainBean.class);
                mGuokrView.refreshData(mainBean.getResult(),flag);
            }
        });
    }

    public void release(){
        mCall.cancel();
    }
}
