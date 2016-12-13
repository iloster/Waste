package com.cheng.utils;

import android.util.Log;

import com.cheng.config.Constants;


/**
 * 将log封装一下，测试环境打印日志，正式环境不打印
 * Created by cheng on 2016/12/4.
 */

public class LogUtils {

    public static void v(String tag, String msg){
        if(Constants.DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void e(String tag,String msg){
        if(Constants.DEBUG) {
            Log.e(tag, msg);
        }
    }
}
