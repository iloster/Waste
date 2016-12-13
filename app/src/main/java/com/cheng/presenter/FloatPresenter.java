package com.cheng.presenter;

import com.cheng.waste.IFloatView;

/**
 * Created by cheng on 2016/12/6.
 */

public class FloatPresenter {
    private String TAG = "FloatPresenter";

    private IFloatView mFloatView;
    public FloatPresenter(IFloatView floatView){
        mFloatView = floatView;
    }

    public void showFloatIcon(){
        mFloatView.showFloatIcon();
    }

}
