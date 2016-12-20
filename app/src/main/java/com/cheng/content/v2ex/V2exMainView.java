package com.cheng.content.v2ex;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.cheng.utils.LogUtils;
import com.cheng.waste.R;

/**
 * Created by cheng on 2016/12/20.
 */

public class V2exMainView extends RelativeLayout {
    private String TAG = "V2exMainView";
    public V2exMainView(Context context) {
        super(context);
//        replaceView(this);
        LogUtils.v(TAG,"ctor");
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_main,this);

    }
}
