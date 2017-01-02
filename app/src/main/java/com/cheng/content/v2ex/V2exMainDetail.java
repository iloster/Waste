package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.config.Constants;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by cheng on 2016/12/26.
 */

public class V2exMainDetail extends BaseSubView {

    private String TAG = "V2exMainDetail";

    private Context mContext;
    private String mCommentUrl="";

    private V2exEntity mV2exEntity;
    private RecyclerView mRecyclerView;

    public V2exMainDetail(Context context,V2exEntity v) {
        super(context);
        mContext = context;
        mV2exEntity = v;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_detail,this);
        initUI();
        showComment();
    }

    private void initUI(){

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }


    public void showComment(){
        mCommentUrl = Constants.V2EX_URL_REPLAY + mV2exEntity.getId();
        LogUtils.v(TAG,"showComment: "+mCommentUrl);
        HttpUtil.getInstance().enqueue(mCommentUrl, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {

                Type type = new TypeToken<List<V2exMainCommentBean>>(){}.getType();
                List<V2exMainCommentBean> list = new Gson().fromJson(ret,type);
                LogUtils.v(TAG,"showComment success size:"+list.size());
                V2exMainCommentItem v2exMainCommentItem = new V2exMainCommentItem(mContext,list,mV2exEntity);

                mRecyclerView.setAdapter(v2exMainCommentItem);
            }
        });
    }

}
