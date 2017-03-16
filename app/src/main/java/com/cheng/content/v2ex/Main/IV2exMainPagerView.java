package com.cheng.content.v2ex.Main;

import com.cheng.content.v2ex.V2exEntity;

import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public interface IV2exMainPagerView {
    void showData(int index,List<V2exMainBean> v2exMainBean);
    void showLoading(boolean flag);
    void showDetail(V2exMainBean v);
    void refreshData(int index,List<V2exMainBean> v);
    void showError();
}
