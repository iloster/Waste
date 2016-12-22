package com.cheng.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cheng.content.FloatContentMainView;
import com.cheng.utils.LogUtils;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by cheng on 2016/12/20.
 */

public class BaseContentView extends RelativeLayout implements FloatContentMainView.SubViewListener{
    private String TAG = "FloatContentView";

    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;
    private Button mCloseBtn;
    private LinearLayout mContainLayout;
    private RelativeLayout mSubView;

    public BaseContentView(Context context) {
        super(context);
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);

        mSubView = (RelativeLayout) findViewById(R.id.subView);
//        int width = windowManager.getDefaultDisplay().getWidth();
//        int height = windowManager.getDefaultDisplay().getHeight()*3/4;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT);
        mSubView.setLayoutParams(params);

        mCloseBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyWindowManager.removeFloatContentView(getContext());
                MyWindowManager.createFloatIconView(getContext());
            }
        });
    }

    public void replaceView(View view){
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT);
        mSubView.addView(view,params);
    }

    @Override
    public void replaceSubView(View view) {
        replaceView(view);
    }
}
