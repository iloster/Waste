package com.cheng.content.GuoKr.Main;

import java.util.List;

/**
 * Created by cheng on 2017/1/11.
 */

public interface IGuokrView {
    void refreshData(List<GuokrMainBean.ResultBean> list, boolean flag);
    void showError();
}
