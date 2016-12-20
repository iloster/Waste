package com.cheng.waste;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.PixelFormat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cheng.utils.DeviceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/7.
 */

public class MyWindowManager {
    /**
     * 小悬浮窗View的实例
     */
    private static FloatIconView mFloatIconView;

    /**
     * 大悬浮窗View的实例
     */
    private static FloatContentView mFloatContentView;

    /**
     * 小悬浮窗View的参数
     */
    private static WindowManager.LayoutParams mFloatIconViewParams;

    /**
     * 大悬浮窗View的参数
     */
    private static WindowManager.LayoutParams mFloatContentViewParams;

    /**
     * 用于控制在屏幕上添加或移除悬浮窗
     */
    private static WindowManager mWindowManager;

    private static View subView;

    /**
     * 如果WindowManager还未创建，则创建一个新的WindowManager返回。否则返回当前已创建的WindowManager。
     *
     * @param context
     *            必须为应用程序的Context.
     * @return WindowManager的实例，用于控制在屏幕上添加或移除悬浮窗。
     */
    private static WindowManager getWindowManager(Context context) {
        if (mWindowManager == null) {
            mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return mWindowManager;
    }

    /**
     * 创建一个小悬浮窗。初始位置为屏幕的右部中间位置。
     *
     * @param context
     *            必须为应用程序的Context.
     */
    public static void createFloatIconView(Context context) {
        WindowManager windowManager = getWindowManager(context);
        if (mFloatIconView == null) {
            mFloatIconView = new FloatIconView(context);
            if (mFloatIconViewParams == null) {
                mFloatIconViewParams = new WindowManager.LayoutParams();
                mFloatIconViewParams.type = WindowManager.LayoutParams.TYPE_PHONE;
                mFloatIconViewParams.format = PixelFormat.RGBA_8888;
                mFloatIconViewParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                mFloatIconViewParams.gravity = Gravity.LEFT | Gravity.TOP;
                mFloatIconViewParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
                mFloatIconViewParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                mFloatIconViewParams.x = windowManager.getDefaultDisplay().getWidth();
                mFloatIconViewParams.y = windowManager.getDefaultDisplay().getHeight() / 2;
            }
            mFloatIconView.setParams(mFloatIconViewParams);
            windowManager.addView(mFloatIconView, mFloatIconViewParams);
        }
    }

    public static void reomveFloatIconView(Context context){
        if(mFloatIconView != null){
            getWindowManager(context).removeView(mFloatIconView);
            mFloatIconView = null;
        }
    }

    public static void createFloatContentView(Context context){
        WindowManager windowManager = getWindowManager(context);
        if(mFloatContentView == null){
            mFloatContentView = new FloatContentView(context);

            if(mFloatContentViewParams == null){
                mFloatContentViewParams = new WindowManager.LayoutParams();
                mFloatContentViewParams.type = WindowManager.LayoutParams.TYPE_PHONE;
                mFloatContentViewParams.format = PixelFormat.RGBA_8888;
                mFloatContentViewParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                mFloatContentViewParams.gravity = Gravity.LEFT | Gravity.TOP;
                mFloatContentViewParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                mFloatContentViewParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//                mFloatContentViewParams.x = DeviceUtils.getWidth();
//                mFloatContentViewParams.y = DeviceUtils.getHeight() / 2;
            }
//            mFloatContentView.setParams(mFloatContentViewParams);
            windowManager.addView(mFloatContentView, mFloatContentViewParams);
        }
    }

    public static void removeFloatContentView(Context context){
        if(mFloatContentView!=null){
            getWindowManager(context).removeView(mFloatContentView);
            mFloatContentView = null;
        }
    }

    public static void replaceFloatContentView(Context context,View obj){
        WindowManager windowManager = getWindowManager(context);
        if(subView == null){
            subView = obj;

            if(mFloatContentViewParams == null){
                mFloatContentViewParams = new WindowManager.LayoutParams();
                mFloatContentViewParams.type = WindowManager.LayoutParams.TYPE_PHONE;
                mFloatContentViewParams.format = PixelFormat.RGBA_8888;
                mFloatContentViewParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
                mFloatContentViewParams.gravity = Gravity.LEFT | Gravity.TOP;
                mFloatContentViewParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                mFloatContentViewParams.height = WindowManager.LayoutParams.MATCH_PARENT;
//                mFloatContentViewParams.x = DeviceUtils.getWidth();
//                mFloatContentViewParams.y = DeviceUtils.getHeight() / 2;
            }
//            mFloatContentView.setParams(mFloatContentViewParams);
            windowManager.addView(subView, mFloatContentViewParams);
        }
    }

}
