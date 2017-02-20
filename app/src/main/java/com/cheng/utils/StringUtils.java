package com.cheng.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cheng on 2017/2/20.
 */

public class StringUtils {
    public static String filterTagA(String str){
        Pattern pattern = Pattern.compile("</*a.*?>");
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }
}
