package com.cheng.waste;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cheng.config.Constants;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.utils.SpUtils;

import java.lang.reflect.Field;

/**
 * Created by cheng on 2016/12/7.
 */

public class FloatIconView extends LinearLayout{

    private String TAG = "FloatIconView";
    /**
     * 记录系统状态栏的高度
     */
    private static int statusBarHeight;


    private WindowManager windowManager;
    private WindowManager.LayoutParams mParams;

    private ImageView mFloatBtn;
    private LinearLayout mFloatIconLayout;
    /**
     * 记录当前手指位置在屏幕上的横坐标值
     */
    private float xInScreen;

    /**
     * 记录当前手指位置在屏幕上的纵坐标值
     */
    private float yInScreen;

    /**
     * 记录手指按下时在屏幕上的横坐标的值
     */
    private float xDownInScreen;

    /**
     * 记录手指按下时在屏幕上的纵坐标的值
     */
    private float yDownInScreen;

    /**
     * 记录手指按下时在小悬浮窗的View上的横坐标的值
     */
    private float xInView;

    /**
     * 记录手指按下时在小悬浮窗的View上的纵坐标的值
     */
    private float yInView;

    private long mPressdownTime;

    private float xLastInScreen;
    private float yLastInScreen;
    public FloatIconView(Context context) {
        super(context);

        windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        LayoutInflater.from(context).inflate(R.layout.service_float_icon, this);

        mFloatBtn = (ImageView) findViewById(R.id.floatIconBtn);
        mFloatIconLayout = (LinearLayout)findViewById(R.id.floatIconLayout);

        mFloatBtn.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 手指按下时记录必要数据,纵坐标的值都需要减去状态栏高度
                        xInView = event.getX();
                        yInView = event.getY();
                        xDownInScreen = event.getRawX();
                        yDownInScreen = event.getRawY() - getStatusBarHeight();
                        xInScreen = event.getRawX();
                        yInScreen = event.getRawY() - getStatusBarHeight();
                        mPressdownTime = System.currentTimeMillis();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        xInScreen = event.getRawX();
                        yInScreen = event.getRawY() - getStatusBarHeight();
                        // 手指移动的时候更新小悬浮窗的位置
                        updateViewPosition(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        // 如果手指离开屏幕时，xDownInScreen和xInScreen相等，且yDownInScreen和yInScreen相等，则视为触发了单击事件。

                        LogUtils.v(TAG,"time:"+(System.currentTimeMillis()-mPressdownTime>1000));
                        if (xDownInScreen == xInScreen && yDownInScreen == yInScreen) {
                            LogUtils.v(TAG,"click");
                            if(SpUtils.getBoolean(Constants.LONGPRESS_SP_KEY,true)&&System.currentTimeMillis()-mPressdownTime>500) {
                                mFloatIconLayout.setAlpha(0);
                                xLastInScreen = xInScreen;
                                yLastInScreen = yInScreen;
                                xInScreen = DeviceUtils.getWidth();
                                yInScreen = DeviceUtils.getHeight();
                                updateViewPosition(false);
                            }else {
                                if(mFloatIconLayout.getAlpha() == 0){
                                    xInScreen = xLastInScreen;
                                    yInScreen = yLastInScreen;
                                    updateViewPosition(false);
                                    
                                    mFloatIconLayout.setAlpha(1);
                                }else{
                                    openFloatContentView();
                                }
                            }
                        }

                        break;
                    default:
                        break;
                }
                return true;
            }
        });



    }



    /**
     * 将小悬浮窗的参数传入，用于更新小悬浮窗的位置。
     *
     * @param params 小悬浮窗的参数
     */
    public void setParams(WindowManager.LayoutParams params) {
        mParams = params;
    }

    /**
     * 更新小悬浮窗在屏幕中的位置。
     */
    private void updateViewPosition(boolean flag) {
        mParams.x = (int) (xInScreen - xInView);
        mParams.y = (int) (yInScreen - yInView);
        if(flag) {
            SpUtils.setInt("posX", mParams.x);
            SpUtils.setInt("posY", mParams.y);
        }
        windowManager.updateViewLayout(this, mParams);
    }

    /**
     * 用于获取状态栏的高度。
     *
     * @return 返回状态栏高度的像素值。
     */
    private int getStatusBarHeight() {
        if (statusBarHeight == 0) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                statusBarHeight = getResources().getDimensionPixelSize(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statusBarHeight;
    }

    private void openFloatContentView(){
        MyWindowManager.reomveFloatIconView(getContext());
        MyWindowManager.createFloatContentView(getContext());
    }

}
