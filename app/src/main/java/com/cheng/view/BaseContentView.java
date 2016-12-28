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

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Created by cheng on 2016/12/20.
 */

public class BaseContentView extends RelativeLayout{
    private String TAG = "FloatContentView";

    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;
    private Button mCloseBtn;
    private Button mBackBtn;
    private LinearLayout mContainLayout;
    private RelativeLayout mSubView;

    private List<View> mListView = new ArrayList<>();
    public BaseContentView(Context context) {
        super(context);
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);
        mBackBtn = (Button)findViewById(R.id.backBtn);

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

        mBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                popView();
            }
        });
    }

    public RelativeLayout getSubViewContainer(){
        return mSubView;
    }

    public void replaceView(View view) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        mSubView.addView(view, params);
        mListView.add(view);
        if(mListView.size()>1){
            mBackBtn.setVisibility(VISIBLE);
        }else{
            mBackBtn.setVisibility(INVISIBLE);
        }
    }

    public void popView(){
        View view = mListView.remove(mListView.size() - 1);
        mSubView.removeView(view);
        if(mListView.size() == 1){
            mBackBtn.setVisibility(INVISIBLE);
        }
    }


}
