package com.cheng.content.DBMoment;

import java.util.List;

/**
 * Created by cheng on 2017/1/6.
 */

public interface IDBView {
    void refreshData(List<DBMainBean> list);
    void showError(boolean flag);
}
