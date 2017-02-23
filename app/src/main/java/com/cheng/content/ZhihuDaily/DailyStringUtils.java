package com.cheng.content.ZhihuDaily;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dev on 2017/2/23.
 */

public class DailyStringUtils {

    public static List splitHtml(String str){
        List resultList = new ArrayList();//(<p>.*?</p>)|
        Pattern p = Pattern.compile("((<p>[^(<img)].*?</p>)|(<img.*?>)).*?");//匹配<p>开头，</p>结尾的文档
        Matcher m = p.matcher(str);//开始编译
        while (m.find()) {
            if(!m.group(1).startsWith("<img class=\"avatar\""))
                resultList.add(m.group(1));//获取被匹配的部分
        }
        return resultList;
    }

    public static String getImgSrc(String str){
        Pattern pattern = Pattern.compile("src=\"(.*?)\"");
        Matcher matcher =pattern.matcher(str);
        while (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static String getText(String str){
        Pattern pattern = Pattern.compile("<p>(.*?)</p>");
        Matcher matcher =pattern.matcher(str);
        while (matcher.find()){
//            return matcher.group(1);
            if(matcher.group(1)!=null){
                Pattern pattern1 = Pattern.compile("</*a.*?>");
                Matcher matcher1 = pattern1.matcher(matcher.group(1));
                return matcher1.replaceAll("");
            }
        }
        return null;
    }

    public static String getTitle(String str){
        Pattern pattern = Pattern.compile("<title>(.*?)</title>",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    public static String getTime(String str){
        Pattern pattern = Pattern.compile("<time>(.*?)</time>");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }
}
