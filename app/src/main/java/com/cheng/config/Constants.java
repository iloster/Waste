package com.cheng.config;

import com.cheng.waste.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于保存一些常量
 * Created by cheng on 2016/12/6.
 */

public class Constants {
    //是否为测试环境
    public static final boolean DEBUG = true;

    public static final String URL = "http://srv.yue.fm/article/random?device_id=A99BDCA9-44B2-4F73-9EE1-DD0046AAD1F7";


    public static final int WINSIZE_LITTLE = 1;
    public static final int WINSIZE_FULLSCREEN = 2;
    public static final String WINSIZE_SP_KEY = "winsize";
    public static final String LONGPRESS_SP_KEY = "longpress";
    public static final String NIGHTSHIFT_SP_KEY = "nightshift";
    public static final String SHOWSPEED_SP_KEY = "showspeed";

    public static final int BLOCK_COUNT = 4;
    public static final int ID_V2EX = 0;
    public static final int ID_DBMOMENT = 1;
    public static final int ID_GUOKR = 2;
    public static final int ID_ZHIHUDAILY = 3;

//    public static final String NAME_V2EX = "v2ex";
//    public static final String NAME_DBMOMENT ="豆瓣一刻";
//    public static final String NAME_GUOKR = "果壳";
//    public static final String NAME_ZHIHUDAILT ="知乎日报";
    public static final String[] BLOCK_NAMES = {"V2EX","豆瓣一刻","果壳精选","知乎日报"};
    public static final int[] BLOCK_ICONS = {R.mipmap.v2ex,R.mipmap.douban,R.mipmap.guokr,R.mipmap.zhihu};
}
