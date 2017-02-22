package com.cheng.content.DBMoment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理豆瓣一刻的文章
 * Created by dev on 2017/2/22.
 */

public class DBStringUtils {

    public static List splitHtml(String str){
        List resultList = new ArrayList();//(<p>.*?</p>)|
        Pattern p = Pattern.compile("((<p>.*?</p>)|(<img.*?>)).*?");//匹配<p>开头，</p>结尾的文档
        Matcher m = p.matcher(str);//开始编译
        while (m.find()) {
            resultList.add(m.group(1));//获取被匹配的部分
        }
        return resultList;
    }

    public static String getImgUrl(String str){
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
            return matcher.group(1);
        }
        return null;
    }
}
