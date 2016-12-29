package com.cheng.content.v2ex;

import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
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
//                mIV2exMainView.showData(mIndex,v2exMainBeanList);
                mIV2exMainView.showData(mIndex,handlerHotTopicBean(v2exMainBeanList));
            }
        });
    }


    public List<V2exHotTopicEntity> handlerHotTopicBean(List<V2exMainBean> v2exMainBeanList){
        List<V2exHotTopicEntity> list = new ArrayList<V2exHotTopicEntity>();
        for(int i = 0;i<v2exMainBeanList.size();i++){
            V2exMainBean v = v2exMainBeanList.get(i);
            V2exHotTopicEntity v2exHotTopicEntity = new V2exHotTopicEntity(new Long(v.getId()),v.getTitle(),
                    v.getUrl(),v.getContent(),v.getContent_rendered(),v.getReplies(),v.getMember().getId(),v.getMember().getUsername(),
            v.getMember().getTagline(),v.getMember().getAvatar_mini(),v.getMember().getAvatar_normal(),v.getMember().getAvatar_large(),
                    String.valueOf(v.getNode().getId()),v.getNode().getTitle(),v.getNode().getTitle_alternative(),v.getNode().getUrl(),String.valueOf(v.getNode().getTopics()),
            v.getNode().getAvatar_mini(),v.getNode().getAvatar_normal(),v.getNode().getAvatar_large(),v.getCreated(),v.getLast_modified(),v.getLast_touched());
            list.add(v2exHotTopicEntity);
        }
        return list;
    }

    /**
     * 获取详情
     * @param v2exMainBean
     */
    public void getDetail(V2exMainBean v2exMainBean){
//        V2exMainDetail v2exMainDetail = new V2exMainDetail(mCon)
        mIV2exMainView.showDetail(v2exMainBean);
    }

}
