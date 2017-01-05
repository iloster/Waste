package com.cheng.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.cheng.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 2017/1/5.
 */

public class MultiHtmlTextView extends RecyclerView {
    private Context mContext;
    List<String> list = new ArrayList<>();
    public MultiHtmlTextView(Context context) {
        super(context);
        LogUtils.v("sss","0");

    }

    public MultiHtmlTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public void setText(Context context){
        mContext = context;
        LogUtils.v("sss","1");
        list.add("ssss");
        list.add("2222");
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        setLayoutManager(layoutManager);
        setAdapter(new RecyclerViewItem());
    }

    private class RecyclerViewItem extends RecyclerView.Adapter{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LogUtils.v("sss","ss");
            RelativeLayout view = new RelativeLayout(mContext);

            TextView tv = new TextView(mContext);
            tv.setTag("tv");
            LayoutParams param1 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
            view.addView(tv,param1);

            LayoutParams param2 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            ImageView image = new ImageView(mContext);
            image.setScaleType(ImageView.ScaleType.CENTER);
            view.addView(image,param2);
            
            RecycleHolder holder = new RecycleHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RecycleHolder h = (RecycleHolder)holder;
            h.tv.setText(list.get(position));
            h.tv.setTextColor(Color.BLACK);
            h.tv.setBackgroundColor(Color.BLUE);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class RecycleHolder extends RecyclerView.ViewHolder{

        TextView tv;
        public RecycleHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewWithTag("tv");
        }
    }
}
