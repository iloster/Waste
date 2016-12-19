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
import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.MyViewFlipper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cheng on 2016/12/13.
 */

public class FloatContentView extends RelativeLayout implements MyViewFlipper.OnViewFlipperListener {
    private String TAG = "FloatContentView";

    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;

    private Button mCloseBtn;

    private List<View> listView;
    private MyViewFlipper mViewFipper;
    private Context mContext;

    public FloatContentView(Context context) {
        super(context);
        mContext =context;
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);
        LinearLayout containLayout = (LinearLayout)findViewById(R.id.containLayout);
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight()*3/4;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width,height);
        LogUtils.v(TAG,"width:"+width);
        LogUtils.v(TAG,"height:"+height);
        containLayout.setLayoutParams(params);

        mViewFipper = (MyViewFlipper)findViewById(R.id.myViewFlipper);
        mViewFipper.setOnViewFlipperListener(this);
//        mViewFipper.addView(showArticleView());
        mCloseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWindowManager.removeFloatContentView(getContext());
                MyWindowManager.createFloatIconView(getContext());
            }
        });
    }


    @Override
    public View getNextView() {
       return showArticleView();
    }

    @Override
    public View getPreviousView() {
        LogUtils.v(TAG,"getPreviousView");
        return showVideoView();
    }

    public View showArticleView(){
//        return new ArticleSubView(mContext);
        return null;
    }

    public View showVideoView(){
//        return new ArticleSubView(mContext);
        return null;
    }
}
