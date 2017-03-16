package com.cheng.content.v2ex.Detail;

import java.util.List;

/**
 * Created by cheng on 2017/3/16.
 */

public interface IV2exDetailView {
    void showComment(List<V2exCommentBean> v2exCommentBeen);
    void showTopic(V2exTopicBean v2exTopicBean);
    void showDetail();
    void showError();
}
