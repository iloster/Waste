package com.cheng.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.cheng.waste.WasteApplication;

/**
 * Created by cheng on 2017/1/14.
 */

public class SpUtils {

    private static String SP_NAME = "WasteSp";

    public static int getInt(String key,int defaultValue){
        SharedPreferences sp = WasteApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key,defaultValue);
    }
    public static void setInt(String key,int value){
        SharedPreferences sp = WasteApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key,value);
        editor.commit();
    }

    public static float getFloat(String key,float defaultValue){
        SharedPreferences sp = WasteApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getFloat(key,defaultValue);
    }
    public static void setFloat(String key,float value){
        SharedPreferences sp = WasteApplication.getInstance().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key,value);
        editor.commit();
    }
}
