package com.cheng.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cheng.waste.R;

/**
 * Created by cheng on 2016/12/21.
 */

public class FloatContentMainView extends RelativeLayout {

    private Button button;
    public FloatContentMainView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.float_content_main,null);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
