package com.cheng.content.Netease;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteaseConstant {


    public static final String LIST_URL = "http://apistudy-demoloster.rhcloud.com/netease/type/%s/page/%s";

    public static final String ARTICLE_URL = "http://apistudy-demoloster.rhcloud.com/netease/postid/%s";

//    public static final String PHOTO_URL = "http://c.m.163.com/photo/api/set/0001/2229221.json";
    public static final String PHOTO_URL = "http://apistudy-demoloster.rhcloud.com/netease/photoid/%s";

    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_PHOTO = 2;

    public static final int TAB_TOUTIAO = 0;
    public static final int TAB_KEJI = 1;
    public static final int TAB_SHEHUI = 2;

    public static final String HTML_STR = "<html><meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/> <style type=\"text/css\">\n" +
            "        img {\n" +
            "  max-width: 100%;\n" +
            "  display: block;\n" +
            "  margin: 1px auto;\n" +
            "}\n" +
            ".title {\n" +
            "  line-height: 1.2em;\n" +
            "  color: #000;\n" +
            "  font-size: 22px;\n" +
            "  margin: 20px 0 10px;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "    </style><body><p class=\"title\">{title}</p><p>{source}</p>{body}</body></html>";


}
