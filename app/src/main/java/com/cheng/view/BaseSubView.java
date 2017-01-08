package com.cheng.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by dev on 2016/12/21.
 */

public class BaseSubView extends RelativeLayout{
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
}
