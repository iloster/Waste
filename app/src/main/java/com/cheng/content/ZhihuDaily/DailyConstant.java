package com.cheng.content.ZhihuDaily;

/**
 * Created by dev on 2017/1/8.
 */

public class DailyConstant {

    // 获取最新新闻
    public static final String DAILY_URL_LATEST = "http://news-at.zhihu.com/api/4/news/latest";
    // 获取新闻详情
    public static final String DAILY_URL_DETAIL = "http://news-at.zhihu.com/api/4/news/";
    // 获取过往新闻
    public static final String DAILY_URL_BEFORE = "http://news.at.zhihu.com/api/4/news/before/";

    public static final String HTML_CSS_DAY =
            "<style type=\"text/css\">\n" +
            "img {\n" +
            "  max-width: 100%;\n" +
            "  display: block;\n" +
            "  margin: 1px auto;\n" +
            "}\n" +
            "p{" +
            "   text-indent: 2em;" +
            "   line-height:20pt;"+
            "}" +
//            ".title {\n" +
//            "  line-height: 1.2em;\n" +
//            "  color: #000;\n" +
//            "  font-size: 22px;\n" +
//            "  margin: 20px 0 10px;\n" +
//            "  font-weight: bold;\n" +
//            "}\n" +
            ".title{" +
            "   width:90%;" +
            "   padding-left:10px;" +
            "   padding-right:10px;" +
            "   text-indent: 0em;"+
            "   font-size: 24px;" +
            "}"+
            ".author{" +
             "   color:#000;" +
             "   font-size: 22px;\n" +
             "}"+
             ".question{" +
             "   color:#000;" +
             "   font-size: 24px;\n" +
              "}"+
             ".content{" +
             "   color:#000;" +
             "   font-size: 22px;\n" +
             "}"+
            ".images-content{ \n" +
            "   position: absolute; \n" +
            "   z-index: 1; \n" +
            "   left: 0; \n" +
            "   bottom:0; \n" +
            "   width: 100%; \n" +
            "   color: #fff; \n" +
//            "   font-size: 23px;\n" +
            "   background: rgba(0,0,0,.7); \n" +
            "   height: auto; \n" +
            "} \n" +
            ".images-wrapper{ \n" +
            "   width:100%; \n" +
            "   height:auto; \n" +
            "   position:relative; \n" +
            "   color: #ffe;"+
            "} " +
            " </style>" ;
    public static final String HTML_CSS_NIGHT =
            "<style type=\"text/css\">\n" +
             "img {\n" +
             "  max-width: 100%;\n" +
                    "  display: block;\n" +
                    "  margin: 1px auto;\n" +
                    "}\n" +
                    "p{" +
                    "   text-indent: 2em;" +
                    "   line-height:20pt;"+
                    "}" +
//                    ".title {\n" +
//                    "  line-height: 1.2em;\n" +
//                    "  color: #000;\n" +
//                    "  font-size: 22px;\n" +
//                    "  margin: 20px 0 10px;\n" +
//                    "  font-weight: bold;\n" +
//                    "}\n"+
                    ".title{" +
                    "   width:90%;" +
                    "   padding-left:10px;" +
                    "   padding-right:10px;" +
                    "   text-indent: 0em;"+
                    "   font-size: 24px;\n" +
                    "}"+
                    ".author{" +
                    "   color:#616161;" +
                    "   font-size: 22px;\n" +
                    "}"+
                    ".question{" +
                     "   color:#AAAAAA;" +
                    "   font-size: 24px;\n" +
                     "}"+
                    ".content{" +
                    "   color:#616161;" +
                    "   font-size: 22px;\n" +
                    "}"+
                    ".images-content{ \n" +
                    "   position: absolute; \n" +
                    "   z-index: 1; \n" +
                    "   left: 0; \n" +
                    "   bottom:0; \n" +
                    "   width: 100%; \n" +
                    "   color: #fff; \n" +
//                    "   font-size: 23px;\n" +
                    "   background: rgba(0,0,0,.7); \n" +
                    "   height: auto; \n" +
                    "} \n" +
                    ".images-wrapper{ \n" +
                    "   width:100%; \n" +
                    "   height:auto; \n" +
                    "   position:relative; \n" +
                    "   color: #ffe;"+
                    "} " +
                    " </style>" ;
    public static final String HTML_STR =
            "<html>" +
             "<meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/> " +

            "{css}"+
            "<body>" +
                "<div class=\"images-wrapper\"> \n" +
                    "<img src=\"{imageurl}\"/> \n" +
                    "<div class=\"images-content\"> " +
                        "<p class=\"title\">{title}</p>\n"+
                    "</div> \n" +
                "</div> " +
                "{body}" +
            "</body>" +
            "</html>";
}
