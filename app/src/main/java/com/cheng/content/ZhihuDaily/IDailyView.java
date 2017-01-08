package com.cheng.content.ZhihuDaily;

import java.util.List;

/**
 * Created by cheng on 2017/1/8.
 */

public interface IDailyView {
    public void refreshData(List<DailyMainBean.StoriesBean> list);
    public void showError();
}
