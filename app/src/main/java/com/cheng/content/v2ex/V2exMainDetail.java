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

    public void showDetail(V2exMainBean v2exMainBean){
        String url = "http:"+v2exMainBean.getMember().getAvatar_normal();
        Picasso.with(mContenxt).load(url).into(mTopicDetailIcon);
        mTopicDetailName.setText(v2exMainBean.getMember().getUsername());
        mTopicDetailTime.setText(TimeUtils.formatTime(new Long(v2exMainBean.getCreated())*1000));
        mTopicDetailTitle.setText(v2exMainBean.getTitle());
        mTopicDetailContent.setText(Html.fromHtml(v2exMainBean.getContent_rendered()));
    }


}
