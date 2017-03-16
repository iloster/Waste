package com.cheng.content.v2ex.Detail;

import com.cheng.content.v2ex.Main.V2exMainBean;
import com.cheng.content.v2ex.V2exConstants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;

/**
 * Created by cheng on 2017/3/16.
 */

public class V2exDetailPresenter {
    private String TAG = "V2exDetailPresenter";
    private V2exDetailView mV2exDetailView;

    private Call mCommentCall;
    private Call mTopicCall;
    public V2exDetailPresenter(V2exDetailView v2exDetailView){
        mV2exDetailView = v2exDetailView;
    }
    public void loadTopic(V2exMainBean v2exMainBean){
        String topicUrl = V2exConstants.V2EX_URL_TOPIC + v2exMainBean.getVid();
        mTopicCall = HttpUtil.getInstance().enqueueEx(topicUrl, new CallBack() {
            @Override
            public void onError() {
                mV2exDetailView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                LogUtils.v(TAG,"loadTopic");
                Gson gson = new Gson();
                V2exTopicBean[] v2exTopicBean = gson.fromJson(ret,V2exTopicBean[].class);
                mV2exDetailView.showTopic(v2exTopicBean[0]);
                mV2exDetailView.showDetail();
            }
        });
    }

    public void loadComment(V2exMainBean v2exMainBean){
        String commentUrl = V2exConstants.V2EX_URL_REPLAY + v2exMainBean.getVid();
        mCommentCall = HttpUtil.getInstance().enqueueEx(commentUrl, new CallBack() {
            @Override
            public void onError() {
                mV2exDetailView.showError();
            }

            @Override
            public void onSuccess(String ret) {
                Type type = new TypeToken<List<V2exCommentBean>>(){}.getType();
                List<V2exCommentBean> list = new Gson().fromJson(ret,type);
                LogUtils.v(TAG,"showComment success size:"+list.size());
                mV2exDetailView.showComment(list);
                mV2exDetailView.showDetail();
            }
        });
    }

}

