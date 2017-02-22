package com.cheng.content.GuoKr.Detail;

import com.cheng.content.GuoKr.GuokrConstant;
import com.cheng.content.GuoKr.Main.GuokrMainBean;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/2/8.
 */

public class GuokrDetailPresenter {

    private GuokrDetailViewEx mGuokrDetailView;
    private Call mCall;
    public GuokrDetailPresenter(GuokrDetailViewEx guokrDetailView){
        mGuokrDetailView = guokrDetailView;
    }

    public void loadData(GuokrMainBean.ResultBean resultBean){
        String url = GuokrConstant.GUOKR_DETAIL + resultBean.getId();
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                mGuokrDetailView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                GuokrDetailBean bean = gson.fromJson(ret, GuokrDetailBean.class);
                mGuokrDetailView.showData(bean);
            }
        });
    }

    public void release(){
        if(mCall!=null){
            mCall.cancel();
        }
    }
}
