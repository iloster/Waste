package com.cheng.content.GuoKr;

/**
 * Created by cheng on 2017/1/11.
 */

public class GuokrConstant {
    public static final String GUOKR_ARTICLES = "http://www.guokr.com/apis/handpick/v2/article.json?limit=20&retrieve_type=by_offset&ad=1&offset=";
//    http://www.guokr.com/apis/handpick/v2/article.json?pick_id=78450
    public static final String GUOKR_DETAIL = "http://www.guokr.com/apis/handpick/v2/article.json?pick_id=";

    public static final String HTML_CSS_NIGHT=  "<style type=\"text/css\">\n" +
            ".body{" +
            "   background:#343434;" +
            "}"+
            "  img {\n" +
            "  width: 90%;\n" +
            "  display: block;\n" +
            "  margin: 1px auto;\n" +
            "}\n" +
            "p {" +
            "   text-indent: 2em;" +
            "   line-height:20pt;" +
            "   word-wrap:break-word" +
            "}" +

            ".title {\n" +
            "   text-indent: 0em;" +
            "  line-height: 1.2em;\n" +
            "  color: #AAAAAA;\n" +
            "  font-size: 20px;\n" +
            "  margin: 20px 0 10px;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            ".source{" +
            " font-size:19px;"+
            " color:#616161" +
            "}"+
            ".content{" +
            "   font-size: 18px;" +
            "   color:#616161; "+
            "}"+
            "</style>";
    public static final String HTML_CSS_DAY =  "<style type=\"text/css\">\n" +
            "  img {\n" +
            "  width: 90%;\n" +
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
            "  font-size: 20px;\n" +
            "  margin: 20px 0 10px;\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            ".source{" +
            " font-size:19px;"+
            " color:#000" +
            "}"+
            ".content{" +
            "   font-size: 18px;" +
            "}"+
            "</style>";
    public static final String HTML_STR =
            "<html>" +
                "<meta name=\"viewport\" content=\"width=device-width,target-densitydpi=high-dpi,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/> " +
                "{css}"+
                "<body>" +
                "   <p class=\"title\">{title}</p>" +
                "   <p class=\"source\">{source}</p>" +
                "   <div class=\"content\">{body}</div>" +
                "</body>" +
            "</html>";
}
