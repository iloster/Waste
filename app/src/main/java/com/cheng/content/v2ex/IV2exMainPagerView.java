package com.cheng.content.v2ex;

import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public interface IV2exMainPagerView {
    void showData(int index);
    void showLoading(boolean flag);
    void showDetail(V2exEntity v);
    void refreshData(int index,List<V2exEntity> v);
    void showError();
}
