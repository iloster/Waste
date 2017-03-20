package com.cheng.content.v2ex;

/**
 * Created by dev on 2017/2/6.
 */

public class V2exConstants {
    public static final String V2EX_URL_HOT = "https://www.v2ex.com/api/topics/hot.json";
    public static final String V2EX_URL_LATEST = "https://www.v2ex.com/api/topics/latest.json";
    public static final String V2EX_URL_REPLAY = "https://www.v2ex.com/api/replies/show.json?topic_id=";//329991";
    public static final String V2EX_URL_TOPIC = "https://www.v2ex.com/api/topics/show.json?id=";

    public static final int V2EX_INDEX_HOT = 1;
    public static final int V2EX_INDEX_LATEST = 2;

    public static final String V2EX_URL_QNA = "http://192.168.31.246/AppApi/public/index.php/v2ex/node/qna/page/1";
    public static final int V2EX_INDEX_QNA = 0;

//    share
    public static final String V2EX_URL_SHARE = "http://192.168.31.246/AppApi/public/index.php/v2ex/node/share/page/1";
    public static final int V2EX_INDEX_SHARE = 1;
//  create
    public static final String V2EX_URL_CREATE = "http://192.168.31.246/AppApi/public/index.php/v2ex/node/create/page/1";
    public static final int V2EX_INDEX_CREATE = 2;

    public static final String V2EX_URL_AUTISTIC = "http://192.168.31.246/AppApi/public/index.php/v2ex/node/autistic/page/1";
    public static final int V2EX_INDEX_AUTISTIC = 3;

    public static final String V2EX_URL_IDEAS = "";
    public static final String[] V2EX_URL = {
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/qna/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/share/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/create/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/autistic/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/random/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/design/page/1",
            "http://192.168.31.246/AppApi/public/index.php/v2ex/node/programmer/page/1",

    };

    public static final String[] V2EX_TITLE = {
      "问与答","分享发现","分享创造","自言自语","奇思妙想","随想","设计","程序员",
    };
}
