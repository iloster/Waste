package com.cheng.content.v2ex.Detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.content.v2ex.V2exEntity;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.waste.R;
import com.squareup.picasso.Picasso;
import com.zzhoujay.richtext.RichText;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.List;

/**
 * Created by cheng on 2017/1/2.
 */

public class V2exCommentAdapter extends RecyclerView.Adapter {

    private String TAG = "V2exCommentAdapter";
    private Context mContext;
    private List<V2exCommentBean> mV2ExCommentBeanList;
    private V2exEntity mV2exEntity;

    public V2exCommentAdapter(Context context, List<V2exCommentBean> list, V2exEntity v2exEntity) {
        mContext = context;
        mV2ExCommentBeanList = list;
        mV2exEntity = v2exEntity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LogUtils.v(TAG, "onCreateViewHolder: viewType "+viewType);
        View view ;
        if(viewType == 0) {
            view = LayoutInflater.from(mContext).inflate(R.layout.content_v2ex_detail_topic, parent, false);
            return new V2exMainDetailTopicHolder(view);
        }else {
            view = LayoutInflater.from(mContext).inflate(R.layout.content_v2ex_comment_item, parent, false);
            return new V2exMainCommentItemHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position == 0){
            V2exMainDetailTopicHolder vHolder = (V2exMainDetailTopicHolder)holder;
            String url = "http:"+mV2exEntity.getAvatar_normal();
            Picasso.with(mContext).load(url).into(vHolder.mTopicDetailIcon);
            vHolder.mTopicDetailName.setText(mV2exEntity.getUsername());
            vHolder.mTopicDetailTime.setText(TimeUtils.formatTime(new Long(mV2exEntity.getCreated())*1000));
            vHolder.mTopicDetailTitle.setText(mV2exEntity.getTitle());
//            vHolder.mTopicDetailContent.setHtml(mV2exEntity.getContent_rendered(), new HtmlHttpImageGetter(vHolder.mTopicDetailContent));
            RichText.fromMarkdown(mV2exEntity.getContent()).into(vHolder.mTopicDetailContent);
            vHolder.mTopicDetailHead.setText("总共"+(getItemCount()-1)+"个回复  |  直到"+TimeUtils.getNowTimeStr());
        }else {

            V2exMainCommentItemHolder vHolder = (V2exMainCommentItemHolder) holder;
            V2exCommentBean v = mV2ExCommentBeanList.get(position-1);
//            if(position == 1){
//                vHolder.mHeadLayout.setVisibility(View.VISIBLE);
//                vHolder.mCommentItemHead.setVisibility(View.VISIBLE);
//                vHolder.mCommentItemHead.setText("总共"+(getItemCount()-1)+"个回复 | 直到"+TimeUtils.getNowTimeStr());
//            }else{
                vHolder.mHeadLayout.setVisibility(View.GONE);
//            }
            String url = "http:"+v.getMember().getAvatar_mini();
            vHolder.mCommentItemContent.setText(v.getContent());
            Picasso.with(mContext).load(url).into(vHolder.mCommentItemIcon);
            vHolder.mCommentItemName.setText(v.getMember().getUsername());
            vHolder.mCommentItemTime.setText(position+"楼"+" • "+TimeUtils.formatTime(new Long(v.getCreated())*1000));
            if(v.getThanks()>0){
                vHolder.mCommentItemThank.setVisibility(View.VISIBLE);
                vHolder.mCommentItemThankIcon.setVisibility(View.VISIBLE);
                vHolder.mCommentItemThank.setText(String.valueOf(v.getThanks()));
            }else{
                vHolder.mCommentItemThank.setVisibility(View.INVISIBLE);
                vHolder.mCommentItemThankIcon.setVisibility(View.INVISIBLE);
            }
        }
    }


    @Override
    public int getItemCount() {
        return mV2ExCommentBeanList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        if(position == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public class V2exMainCommentItemHolder extends RecyclerView.ViewHolder {

        public ImageView mCommentItemIcon;
        public TextView mCommentItemName;
        public TextView mCommentItemTime;
        public TextView mCommentItemContent;
        public ImageView mCommentItemThankIcon;
        public TextView mCommentItemThank;
        public LinearLayout mHeadLayout;
        public TextView mCommentItemHead;
        public V2exMainCommentItemHolder(View itemView) {
            super(itemView);

            mCommentItemIcon = (ImageView) itemView.findViewById(R.id.comment_item_icon);
            mCommentItemName = (TextView) itemView.findViewById(R.id.comment_item_name);
            mCommentItemTime = (TextView) itemView.findViewById(R.id.comment_item_time);
            mCommentItemContent = (TextView) itemView.findViewById(R.id.comment_item_content);

            mCommentItemThankIcon = (ImageView) itemView.findViewById(R.id.comment_item_thankIcon);
            mCommentItemThank = (TextView) itemView.findViewById(R.id.comment_item_thank);

            mHeadLayout = (LinearLayout)itemView.findViewById(R.id.headLayout);
            //mHeadLayout.setVisibility(View.GONE);
            mCommentItemHead = (TextView) itemView.findViewById(R.id.comment_item_head);

        }
    }

    public class V2exMainDetailTopicHolder extends RecyclerView.ViewHolder{

        public ImageView mTopicDetailIcon;
        public TextView mTopicDetailName;
        public TextView mTopicDetailTime;
        public TextView mTopicDetailTitle;
        public TextView mTopicDetailContent;
        public TextView mTopicDetailHead;
        public V2exMainDetailTopicHolder(View itemView) {
            super(itemView);

            mTopicDetailIcon = (ImageView)itemView.findViewById(R.id.topic_detail_icon);
            mTopicDetailName = (TextView)itemView.findViewById(R.id.topic_detail_name);
            mTopicDetailTime = (TextView)itemView.findViewById(R.id.topic_detail_time);
            mTopicDetailTitle = (TextView)itemView.findViewById(R.id.topic_detail_title);
            mTopicDetailContent = (TextView)itemView.findViewById(R.id.topic_detail_content);
            mTopicDetailHead = (TextView)itemView.findViewById(R.id.topic_detail_head);

        }
    }
}
