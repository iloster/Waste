package com.cheng.content.GuoKr;

/**
 * Created by cheng on 2017/1/11.
 */

public class GuokrConstant {
    public static final String GUOKR_ARTICLES = "http://www.guokr.com/apis/handpick/v2/article.json?limit=20&retrieve_type=by_offset&ad=1&offset=";
//    http://www.guokr.com/apis/handpick/v2/article.json?pick_id=78450
    public static final String GUOKR_DETAIL = "http://www.guokr.com/apis/handpick/v2/article.json?pick_id=";


    public static final String HTML_STR = "<html><meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/> <style type=\"text/css\">\n" +
            "  img {\n" +
            "  max-width: 100%;\n" +
            "  display: block;\n" +
            "  margin: 1px auto;\n" +
            "}\n" +
            "p {" +
            "   text-indent: 2em;" +
            "   line-height:20pt;" +
            "   word-wrap:break-word"+
//            "   text-overflow : clip | ellipsis" +
            "}" +

            ".title {\n" +
            "   text-indent: 0em;" +
            "  line-height: 1.2em;\n" +
            "  color: #000;\n" +
            "  font-size: 22px;\n" +
            "  margin: 20px 0 10px;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "    </style><body><p class=\"title\">{title}</p><p>{source}</p>{body}</body></html>";
}
