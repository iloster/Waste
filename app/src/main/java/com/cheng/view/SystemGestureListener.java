package com.cheng.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.cheng.utils.LogUtils;

/**
 * Created by dev on 2017/1/25.
 */

public class SystemGestureListener extends GestureDetector.SimpleOnGestureListener{

    private String TAG = "SystemGestureListener";
    /** 左右滑动的最短距离 */
    private int distance = 100;
    /** 左右滑动的最大速度 */
    private int velocity = 200;

    private onSystemFlipListener mSystemFlipListener;
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        LogUtils.v(TAG,"onFling");
        if(e2.getX()-e1.getX()>distance && velocityX>=200){
            mSystemFlipListener.onFlipLeft();
        }
        return false;
    }

    public interface onSystemFlipListener{
        void onFlipLeft();
    }

    public void setOnFlipListener(onSystemFlipListener listener){
        mSystemFlipListener = listener;
    }

}
