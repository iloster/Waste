package com.cheng.content.Qsbk;

/**
 * Created by dev on 2017/2/24.
 */

public interface IQsbkView {

    /**
     * 刷新数据
     * @param bean
     */
    void refreshData(QsbkBean bean);

    /**
     * 网络请求错误的时候
     */
    void showError();
}
