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
    public static final int ITEM_TYPE1_PLUS = 20001;
    public static final int ITEM_TYPE2 = 10002;
    public static final int ITEM_TYPE2_PLUS = 20002;
    public static final int ITEM_TYPE3 = 10003;
    public static final int ITEM_TYPE3_PLUS = 20003;

    public static final String HTML_STR =
            "<html>" +
                    "<meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/> " +

                    "<style type=\"text/css\">\n" +
                    ".body-night{" +
                    "   background:#343434;" +
                    "   color:#AAAAAA;" +
                    "}"+
                    ".body-day{" +
                    "   background:#FFFFFF;" +
                    "   color:#000000;" +
                    "}"+
                    "img {\n" +
                    "  max-width: 100%;\n" +
                    "  display: block;\n" +
                    "  margin: 1px auto;\n" +
                    "}\n" +
                    "p {" +
                    "   width:100%"+
                    "   text-indent: 2em;" +
                    "   line-height:20pt;" +
                    "   word-wrap:break-word"+
        //            "   text-overflow : clip | ellipsis" +
                    "}" +
                    "#content{" +
                    "   font-size: 20px;"+
                    "}"+
                    "#title {\n" +
                    "   text-indent: 0em;" +
                    "  line-height: 1.2em;\n" +
                    "  color: #000;\n" +
                    "  font-size: 22px;\n" +
                    "  margin: 20px 0 10px;\n" +
                    "  font-weight: bold;\n" +
                    "}\n" +
                    "</style>" +
                    "<script>" +
                    "function nightShift(){\n" +
                        "var body = document.getElementById(\"body\");\n" +
                        "body.setAttribute(\"class\",\"body-night\");\n"+
                    "}"+
                    "</script>"+
                    "<body id=\"body\" class=\"body-day\">{body}</body>" +
             "</html>";
}
