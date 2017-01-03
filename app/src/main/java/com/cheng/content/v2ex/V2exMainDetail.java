package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;

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
        mErrorLayout = (LinearLayout)findViewById(R.id.errorLayout);
        mErrorBtn = (Button)findViewById(R.id.errorBtn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mErrorBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showComment();
            }
        });
    }


    public void showComment(){
        mCommentUrl = Constants.V2EX_URL_REPLAY + mV2exEntity.getId();
        LogUtils.v(TAG,"showComment: "+mCommentUrl);
        HttpUtil.getInstance().enqueue(mCommentUrl, new CallBack() {
            @Override
            public void onError() {
                showError(true);
            }

            @Override
            public void onSuccess(String ret) {
                showError(false);
                Type type = new TypeToken<List<V2exMainCommentBean>>(){}.getType();
                List<V2exMainCommentBean> list = new Gson().fromJson(ret,type);
                LogUtils.v(TAG,"showComment success size:"+list.size());
                V2exMainCommentItem v2exMainCommentItem = new V2exMainCommentItem(mContext,list,mV2exEntity);

                mRecyclerView.setAdapter(v2exMainCommentItem);
            }
        });
    }

    private void showError(boolean flag){
        if(flag){
            mRecyclerView.setVisibility(GONE);
            mErrorLayout.setVisibility(VISIBLE);
        }else{
            mRecyclerView.setVisibility(VISIBLE);
            mErrorLayout.setVisibility(GONE);
        }
    }

}
