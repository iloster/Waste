package com.cheng.content.ZhihuDaily.Main;

import com.cheng.content.ZhihuDaily.Main.DailyMainBean;

import java.util.List;

/**
 * Created by cheng on 2017/1/8.
 */

public interface IDailyView {
    public void refreshData(List<DailyMainBean.StoriesBean> list, boolean flag);
    public void showError(boolean flag);
}
