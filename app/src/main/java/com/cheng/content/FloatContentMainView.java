package com.cheng.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cheng.content.DBMoment.DBView;
import com.cheng.content.v2ex.V2exMainView;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;

/**
 * Created by cheng on 2016/12/21.
 */

public class FloatContentMainView extends BaseSubView {

    private String TAG = "FloatContentMainView";
    private Button button;
    public FloatContentMainView(final Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.float_content_main,this);
        LogUtils.v(TAG,"FloatContentMainView : ctor");
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyWindowManager.replaceSubView(new V2exMainView(context),"V2EX");
                MyWindowManager.replaceSubView(new DBView(),"豆瓣一刻");
            }
        });
    }

}
