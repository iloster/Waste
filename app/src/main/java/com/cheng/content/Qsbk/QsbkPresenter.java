package com.cheng.content.Qsbk;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;

import okhttp3.Call;

/**
 * Created by dev on 2017/2/24.
 */

public class QsbkPresenter {
    private String TAG = "Peek_QsbkPresenter";
    private QsbkView mQsbkView;

    private Call mCall;
    public QsbkPresenter(QsbkView view){
        mQsbkView = view;
    }

    public void loadData(int page){
//        int page = 1;
        String url = QsbkConstants.URL + page;

        mCall = HttpUtil.getInstance().enqueueEx(url,new CallBack() {
            @Override
            public void onError() {
                LogUtils.v(TAG,"showError");
                mQsbkView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                try {
                    QsbkBean bean = gson.fromJson(ret,QsbkBean.class);
                    mQsbkView.refreshData(bean);
                }catch (Exception e){
                    mQsbkView.showError();
                }

            }
        });
    }

    public void release(){
        if(mCall!=null){
            mCall.cancel();
        }
    }
}
