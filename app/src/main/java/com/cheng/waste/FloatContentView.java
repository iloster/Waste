package com.cheng.waste;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

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
    private List<View> list_view;
    public FloatContentView(Context context) {
        super(context);
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);
        mContentViewPager = (ViewPager)findViewById(R.id.contentViewPager);
        mCloseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWindowManager.removeFloatContentView(getContext());
                MyWindowManager.removeFloatContentView(getContext());
            }
        });
    }
}
