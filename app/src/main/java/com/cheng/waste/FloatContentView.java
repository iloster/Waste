package com.cheng.waste;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheng.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cheng on 2016/12/13.
 */

public class FloatContentView extends RelativeLayout {
    private String TAG = "FloatContentView";

    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;

    private Button mCloseBtn;
    private ViewPager mContentViewPager;
    private List<View> listView;
    public FloatContentView(Context context) {
        super(context);
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

        mContentViewPager = (ViewPager)findViewById(R.id.contentViewPager);
        listView = new ArrayList<>();
        for(int i = 0;i<2;i++){
            View view = LayoutInflater.from(context).inflate(R.layout.service_float_content_item,this,false);
            TextView textView = (TextView)view.findViewById(R.id.contentTxt);
            textView.setText("ssss");
            listView.add(view);
        }
        FloatContentAdapter adapter = new FloatContentAdapter(context,listView);
        mContentViewPager.setAdapter(adapter);
        mContentViewPager.setCurrentItem(0);
        mCloseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWindowManager.removeFloatContentView(getContext());
                MyWindowManager.createFloatIconView(getContext());
            }
        });
    }
}
