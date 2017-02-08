package com.cheng.content.DBMoment.Main;

import com.cheng.content.DBMoment.Main.DBMainBean;

import java.util.List;

/**
 * Created by cheng on 2017/1/6.
 */

public interface IDBView {
    void refreshData(List<DBMainBean> list, boolean flag);
    void showError(boolean flag);
}
