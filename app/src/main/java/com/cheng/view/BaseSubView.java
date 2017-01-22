package com.cheng.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.cheng.utils.LogUtils;

/**
 * Created by dev on 2016/12/21.
 */

public class BaseSubView extends RelativeLayout{
    private boolean mIsLeave = false;
    public BaseSubView(Context context) {
        super(context);

    }

    public void onRefreshClick(){

    }
    public interface OnRecyclerViewItemClickListener{
        public void onItemClick(int position,Object data);
    }

    /**
     * 返回true表示浏览器的返回
     * @return
     */
    public boolean onWebViewBack(){
        return false;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mIsLeave = true;

    }

    public boolean getIsLeave(){
        return mIsLeave;
    }
}
