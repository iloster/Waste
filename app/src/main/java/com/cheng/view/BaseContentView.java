package com.cheng.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheng.content.FloatContentMainView;
import com.cheng.utils.LogUtils;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import org.jsoup.Connection;

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
    private TextView mContentTitle;
    private RelativeLayout mSubView;

    private List<View> mListView = new ArrayList<>();
    private List<String> mTitleList = new ArrayList<>();
    private View mErrorView;
    private Button mErrorButton;
    public BaseContentView(Context context) {
        super(context);
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);
        mBackBtn = (Button)findViewById(R.id.backBtn);
        mContentTitle = (TextView)findViewById(R.id.contentTitle);

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

    public void replaceView(View view,String title) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        mSubView.addView(view, params);
        mContentTitle.setText(title);
        mListView.add(view);
        mTitleList.add(title);
        if(mListView.size()>1){
            mBackBtn.setVisibility(VISIBLE);
        }else{
            mBackBtn.setVisibility(INVISIBLE);
        }
    }

    public void popView(){
        hideErrorView();
        if(!getCurView().onWebViewBack()) {
            View view = mListView.remove(mListView.size() - 1);
            mSubView.removeView(view);

            mTitleList.remove(mTitleList.size() - 1);
            mContentTitle.setText(mTitleList.get(mTitleList.size() - 1));
            if (mListView.size() == 1) {
                mBackBtn.setVisibility(INVISIBLE);
            }
        }
    }

    public BaseSubView getCurView(){
        return (BaseSubView) mListView.get(mListView.size() - 1);
    }

    public void showErrorView(){
        //显示errorview
        mErrorView = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_error_view,null);
        mErrorButton = (Button)mErrorView.findViewById(R.id.errorBtn);
        mErrorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseSubView curView = getCurView();
                hideErrorView();
                curView.onRefreshClick();
            }
        });
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mSubView.addView(mErrorView,params);
        mErrorView.setVisibility(VISIBLE);
    }
    public void hideErrorView(){
       // mErrorView.setVisibility(GONE);
        if(mErrorView != null) {
            mSubView.removeView(mErrorView);
        }
    }

}
