package com.cheng.content.DBMoment;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MultiHtmlTextView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import io.github.angebagui.mediumtextview.MediumTextView;

/**
 * Created by dev on 2017/1/4.
 */

public class DBDetail extends BaseSubView {
    private String TAG = "DBDetail";
    private Context mContext;
    private DBDetailBean mDbDetailBean;
    private DBMainBean mDbMainBean;
    private TextView mDBDetailTitle;
    private MediumTextView mDBDetailContent;
    private MultiHtmlTextView mTest;

    public DBDetail(DBMainBean dbMainBean) {
        super(WasteApplication.getInstance());
        LogUtils.v(TAG,"DBDetail");
        mDbMainBean = dbMainBean;
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_detail,this);

        initUI();
        //loadData();

    }

    private void initUI(){
        mDBDetailTitle = (TextView)findViewById(R.id.db_detail_title);
        mDBDetailContent = (MediumTextView)findViewById(R.id.db_detail_content);

        mTest = (MultiHtmlTextView)findViewById(R.id.test);
        mTest.setText(mContext);
    }

    private void loadData(){
        String url = DBConstant.DOUBAN_ARTICLE_DETAIL+mDbMainBean.getId();
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                mDbDetailBean = gson.fromJson(ret,DBDetailBean.class);
                showData();
            }
        });
    }
    private void showData(){
        //mDBDetailContent.setText(mDbDetailBean.getContent());
        String content = mDbDetailBean.getContent();
        String content1 = "";
        for(int i = 0;i<mDbDetailBean.getPhotos().size();i++){
            content = content.replace("id=\""+mDbDetailBean.getPhotos().get(i).getTag_name()+"\"","src="+mDbDetailBean.getPhotos().get(i).getLarge().getUrl());
        }
        content = content.replaceAll("<[/]*?(?!a|img|p)[^<>]*?>", "");
        LogUtils.v(TAG,"content1:"+content);
        mDBDetailContent.setText(content);
    }
}
