package com.cheng.content.ZhihuDaily;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * 知乎日报
 * Created by dev on 2017/1/8.
 */

public class DailyView extends BaseSubView{
    private String TAG = "Daily";
    private Context mContext;
    public DailyView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_daily_view,this);

        initUI();
    }

    private void initUI(){

    }


}
