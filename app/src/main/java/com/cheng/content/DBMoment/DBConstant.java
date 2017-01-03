package com.cheng.content.DBMoment;

/**
 * 保存豆瓣一刻用到的常量
 * Created by dev on 2017/1/3.
 */

public class DBConstant {
    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";

    //item的样式
    public static final int ITEM_TYPE1 = 10001;
    public static final int ITEM_TYPE2 = 10002;
    public static final int ITEM_TYPE3 = 10003;
}
