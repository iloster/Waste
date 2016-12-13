package com.cheng.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by cheng on 2016/12/7.
 */

public class DeviceUtils {

    private static Context mContext;
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
}
