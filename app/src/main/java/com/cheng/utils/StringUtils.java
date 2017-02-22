package com.cheng.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cheng on 2017/2/20.
 */

public class StringUtils {

    public static String filterDB(String str){
        Pattern pattern1 = Pattern.compile("</*a.*?>");
        Pattern pattern2 =  Pattern.compile("<img class=\"avatar cache-avatar\".*?>");
        Matcher matcher1 = pattern1.matcher(str);
        String str1 = matcher1.replaceAll("");
        Matcher matcher2 = pattern2.matcher(str1);
        return matcher2.replaceAll("");
    }

    public static String filterGuokr(String str){
        Pattern pattern = Pattern.compile("</*a.*?>");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }

    public static String filterDaily(String str){
        Pattern pattern = Pattern.compile("</*a.*?>");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }
}
