package com.cheng.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cheng.content.v2ex.V2exMainView;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;

/**
 * Created by cheng on 2016/12/21.
 */

public class FloatContentMainView extends BaseSubView {

    private Button button;
    private SubViewListener mSubViewListener;
    public FloatContentMainView(final Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.float_content_main,this);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mSubViewListener.replaceSubView(new V2exMainView(context));
            }
        });
    }

    public void setSubViewListener(SubViewListener subViewListener){
        this.mSubViewListener = subViewListener;
    }
    public interface SubViewListener{
        public void replaceSubView(View view);
    }
}
