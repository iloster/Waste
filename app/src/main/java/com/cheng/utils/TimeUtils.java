package com.cheng.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by cheng on 2016/12/23.
 */

public class TimeUtils {

    private static String TAG = "TimeUtiles";
    /**
     * 友好的方式显示时间
     */
    public static String formatTime(long time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //帖子时间
        Date date = new Date(time);
        String res = simpleDateFormat.format(date);
        LogUtils.v(TAG,"time:"+time+"|res:"+res);
        //当前时间戳
        long curTime = System.currentTimeMillis();
         //时间差 毫秒
        long spaceTime = curTime - time;
        LogUtils.v(TAG,"spaceTime:"+spaceTime);
        if(spaceTime<1*60*1000){
            return "刚刚";
        }else if(spaceTime<5*60*1000){
            return "5分钟之前";
        }else if(spaceTime<30*60*1000){
            return "10分钟之前";
        }else if(spaceTime<60*60*1000){
            return "半小时之前";
        }else if(spaceTime<24*60*60*1000){
            return String.format("%d小时之前",spaceTime/(1000*60*60));
        }else if(spaceTime<48*60*60*1000){
            return "一天之前";
        }else{
            return  res;
        }

    }

    public static String getNowTimeStr(){
        long curTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //帖子时间
        Date date = new Date(curTime);
        String res = simpleDateFormat.format(date);
        return res;
    }

    public static String getDBTimerStr(){
        long curTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(curTime);
        String res = simpleDateFormat.format(date);
        return res;
    }

    public static String getDBOffsetTimeStr(int offset){
        Calendar  cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,  offset*-1);
        String res = new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
        return res;
    }

    public static String getDailyOffsetTimeStr(int offset){
        Calendar  cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,  (offset-1)*-1);
        String res = new SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());
        return res;
    }

    public static boolean isSameDay(long time1,long time2){
        String timeStr1 = new SimpleDateFormat("yyMMdd").format(new Date(time1));
        String timeStr2 = new SimpleDateFormat("yyMMdd").format(new Date(time2));
        return timeStr1.equals(timeStr2);
    }

    public static String getTimeByFormat(long time,String formatstr){
        return new SimpleDateFormat(formatstr).format(new Date(time));
    }

    public static long getTimestamp(String timeStr,String formatstr){
        SimpleDateFormat sdf = new SimpleDateFormat(formatstr);
        Date d;
        long l = 0;
        try {
            d = sdf.parse(timeStr);
            l = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l;
    }
}
