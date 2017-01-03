package com.cheng.config;

/**
 * 用于保存一些常量
 * Created by cheng on 2016/12/6.
 */

public class Constants {
    //是否为测试环境
    public static final boolean DEBUG = true;
    public static final String URL = "http://srv.yue.fm/article/random?device_id=A99BDCA9-44B2-4F73-9EE1-DD0046AAD1F7";

    public static final String V2EX_URL_HOT = "https://www.v2ex.com/api/topics/hot.json";
    public static final String V2EX_URL_LATEST = "https://www.v2ex.com/api/topics/latest.json";
    public static final String V2EX_URL_REPLAY = "https://www.v2ex.com/api/replies/show.json?topic_id=";//329991";

    // 获取最新新闻
    public static final String ZHIHU_URL_LATEST = "http://news-at.zhihu.com/api/4/news/latest";
    // 获取新闻详情
    public static final String ZHIHU_URL_DETAIL = "http://news-at.zhihu.com/api/4/news/";
    // 获取过往新闻
    public static final String ZHIHU_URLDEFORE = "http://news.at.zhihu.com/api/4/news/before/";

    // 获取果壳精选的文章列表,通过组合相应的参数成为完整的url
    // Guokr handpick articles. make complete url by combining params
    public static final String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=25&ad=1";

    // 获取果壳文章的具体信息 V1
    // specific information of guokr post V1
    public static final String GUOKR_ARTICLE_LINK_V1 = "http://jingxuan.guokr.com/pick/";

    // 获取果壳文章的具体信息 V2
    // V2
    // public static final String GUOKR_ARTICLE_LINK_V2 = "http://jingxuan.guokr.com/pick/v2/";

    // 获取果壳精选的轮播文章列表
    // carousel posts
    // public static final String GUOKR_HANDPICK_CAROUSEL = "http://apis.guokr.com/flowingboard/item/handpick_carousel.json";

    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";
}
