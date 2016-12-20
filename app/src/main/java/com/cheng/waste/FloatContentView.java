package com.cheng.waste;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cheng.config.Constants;
//import com.cheng.content.ArticleSubView;
import com.cheng.content.v2ex.V2exMainView;
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseContentView;
import com.cheng.view.MyViewFlipper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cheng on 2016/12/13.
 */

public class FloatContentView extends BaseContentView {
    private String TAG = "FloatContentView";

    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;

    private Button mCloseBtn;
    private Context mContext;

    private Button mV2exBtn;

    private LinearLayout mContainLayout;
    public FloatContentView(final Context context) {
        super(context);
//        mContext =context;
//        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
//        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);
//
//        mCloseBtn = (Button)findViewById(R.id.closeBtn);
//        mV2exBtn = (Button)findViewById(R.id.v2exBtn);
//
//
//        mContainLayout = (LinearLayout)findViewById(R.id.containLayout);
//        int width = windowManager.getDefaultDisplay().getWidth();
//        int height = windowManager.getDefaultDisplay().getHeight()*3/4;
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width,height);
//        LogUtils.v(TAG,"width:"+width);
//        LogUtils.v(TAG,"height:"+height);
//        mContainLayout.setLayoutParams(params);
//
//
//        mCloseBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MyWindowManager.removeFloatContentView(getContext());
//                MyWindowManager.createFloatIconView(getContext());
//            }
//        });
//
//        mV2exBtn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               MyWindowManager.replaceFloatContentView(getContext(),new V2exMainView(context));
//            }
//        });
        replaceView(new V2exMainView(context));
    }


}
