package com.cheng.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.cheng.utils.LogUtils;
import com.cheng.waste.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dev on 2017/1/5.
 */

public class MultiHtmlTextView extends RecyclerView {
    private String TAG = "MultiHtmlTextView";
    private Context mContext;
    List<String> list = new ArrayList<>();
    public MultiHtmlTextView(Context context) {
        super(context);
        LogUtils.v("sss","0");

    }

    public MultiHtmlTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public void setText(Context context,String str){

        mContext = context;
        Pattern p = Pattern.compile("(<.*?/>)");
        Matcher m = p.matcher(str);
        while(m.find()){
            list.add(m.group(1));
            LogUtils.v(TAG,"setText:"+m.group(1));
        }
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
            tv.setTextColor(getResources().getColor(R.color.seconaary_text));
            LayoutParams param1 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
            view.addView(tv,param1);

            RelativeLayout.LayoutParams param2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            param2.addRule(RelativeLayout.CENTER_HORIZONTAL);
            ImageView image = new ImageView(mContext);

            image.setScaleType(ImageView.ScaleType.CENTER);
            image.setTag("image");
            view.addView(image,param2);
            
            RecycleHolder holder = new RecycleHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RecycleHolder h = (RecycleHolder)holder;
            String str = list.get(position);
            if(str.indexOf("<img")==0) {
                Pattern p = Pattern.compile("src=\"(.*?)\"");
                Matcher m = p.matcher(str);
                if(m.find()){
                    String url = m.group(1);
                    Picasso.with(mContext).load(url).into(h.image);
                }

            }else{
                h.tv.setText(Html.fromHtml(str));
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class RecycleHolder extends RecyclerView.ViewHolder{

        TextView tv;
        ImageView image;
        public RecycleHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewWithTag("tv");
            image = (ImageView)itemView.findViewWithTag("image");
        }
    }
}
