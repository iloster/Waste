package com.cheng.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by dev on 2016/12/21.
 */

public class BaseSubView extends RelativeLayout{

    private BaseSubViewListener mBaseSubViewListener;
    public BaseSubView(Context context) {
        super(context);
    }

    public void setBaseSubViewListener(BaseSubViewListener baseSubViewListener){
        this.mBaseSubViewListener = baseSubViewListener;
    }


    public interface BaseSubViewListener{
        void replaceSubView(View view);
    }
}
