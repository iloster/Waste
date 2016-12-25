package com.cheng.content.v2ex;

import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public interface IV2exMainPagerView {
    void showData(int index,List<V2exMainBean> v2exMainBeanList);
    void showLoading(boolean flag);
    void showDetail();
}
