package com.cheng.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.cheng.waste.WasteApplication;

/**
 * Created by cheng on 2016/12/7.
 */

public class DeviceUtils {

    private static Context mContext = WasteApplication.getInstance();
    public static void init(Context context){
        mContext =context;
    }
    public static int getWidth(){
      WindowManager wm = (WindowManager)mContext.getSystemService(mContext.WINDOW_SERVICE);
      return wm.getDefaultDisplay().getWidth();
    }
    public static int getHeight(){
        WindowManager wm = (WindowManager)mContext.getSystemService(mContext.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    /**
     * 判断网络是否连接
     * @return
     */
    public static boolean isNetworkConnected(){
        ConnectivityManager cm = (ConnectivityManager) WasteApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    /**
     * 获取屏幕dpi
     * @return
     */
    public static int getDpi(){
        DisplayMetrics metric = new DisplayMetrics();
        return metric.densityDpi;
    }
}
