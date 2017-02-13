package com.cheng.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheng.config.Constants;
import com.cheng.content.FloatContentMainView;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;
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
    private View mLoadingView;

    private float xLastInView;
    private float yLastInView;
    private float xCurInView;
    private float yCurInView;

    public BaseContentView(Context context) {
        super(context);
        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_content,this);

        mCloseBtn = (Button)findViewById(R.id.closeBtn);
        mBackBtn = (Button)findViewById(R.id.backBtn);
        mContentTitle = (TextView)findViewById(R.id.contentTitle);
        mContainLayout = (LinearLayout) findViewById(R.id.containLayout);
        mSubView = (RelativeLayout) findViewById(R.id.subView);

        int width = windowManager.getDefaultDisplay().getWidth();
        int height = 0;
        if(SpUtils.getInt(Constants.WINSIZE_SP_KEY,Constants.WINSIZE_LITTLE) == Constants.WINSIZE_LITTLE){
            height = windowManager.getDefaultDisplay().getHeight()*3/4;
        }else{
            height = windowManager.getDefaultDisplay().getHeight();
        }

        mContainLayout.setLayoutParams(new RelativeLayout.LayoutParams(width,height));


        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT,MATCH_PARENT);
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

//        mContainLayout.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        xLastInView = event.getX();
//                        yLastInView = event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        xCurInView = event.getX();
//                        yCurInView = event.getY();
//                        int dx = (int)(xCurInView - xLastInView);
//                        int dy = (int)(yCurInView - yLastInView);
//                        MarginLayoutParams margin=new MarginLayoutParams(mContainLayout.getLayoutParams());
//                        margin.setMargins(dx,dy, dx+margin.width, dy+margin.height);
//                        LayoutParams params1 = new LayoutParams(margin);
//                        mContainLayout.setLayoutParams(params1);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        break;
//                }
//                return true;
//            }
//        });
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
        hideLoadingView();
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
        mErrorView = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_error_view, null);
        mErrorButton = (Button) mErrorView.findViewById(R.id.errorBtn);
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
        mSubView.addView(mErrorView, params);
        mErrorView.setVisibility(VISIBLE);
    }
    public void hideErrorView(){
       // mErrorView.setVisibility(GONE);
        if(mErrorView != null) {
            mSubView.removeView(mErrorView);
        }
    }

    public void showLoadingView(){
        LogUtils.v(TAG,"showLoadingView");
        mLoadingView = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_loading_view,null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mSubView.addView(mLoadingView,params);
        mLoadingView.setVisibility(VISIBLE);
    }

    public void hideLoadingView(){
        LogUtils.v(TAG,"hideLoadingView");
        if(mLoadingView!=null){
            mSubView.removeView(mLoadingView);
        }
    }

}
