package com.cheng.content.v2ex;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.squareup.picasso.Picasso;

/**
 * Created by cheng on 2016/12/26.
 */

public class V2exMainDetail extends BaseSubView {
    private ImageView mTopicDetailIcon;
    private TextView mTopicDetailName;
    private TextView mTopicDetailTime;
    private TextView mTopicDetailTitle;
    private TextView mTopicDetailContent;
    private Context mContenxt;

    public V2exMainDetail(Context context) {
        super(context);
        mContenxt = context;
        LayoutInflater.from(context).inflate(R.layout.content_v2ex_detail,this);
        initUI();
    }

    private void initUI(){
        mTopicDetailIcon = (ImageView)findViewById(R.id.topic_detail_icon);
        mTopicDetailName = (TextView)findViewById(R.id.topic_detail_name);
        mTopicDetailTime = (TextView)findViewById(R.id.topic_detail_time);
        mTopicDetailTitle = (TextView)findViewById(R.id.topic_detail_title);
        mTopicDetailContent = (TextView)findViewById(R.id.topic_detail_content);
    }

    public void showDetail(V2exEntity v){
        String url = "http:"+v.getAvatar_normal();
        Picasso.with(mContenxt).load(url).into(mTopicDetailIcon);
        mTopicDetailName.setText(v.getUsername());
        mTopicDetailTime.setText(TimeUtils.formatTime(new Long(v.getCreated())*1000));
        mTopicDetailTitle.setText(v.getTitle());
        mTopicDetailContent.setText(Html.fromHtml(v.getContent_rendered()));
    }


}
