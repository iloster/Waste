package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.waste.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by dev on 2016/12/21.
 */

public class V2exMainViewItem extends RecyclerView.Adapter {

    private Context mContext;
    private List<V2exMainBean> mV2exMainBeanList;
    private String TAG = "V2exMainViewItem";
    private V2exMainPagerView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    public V2exMainViewItem(Context context, List<V2exMainBean> v2exMainBeanList){
        mContext = context;
        mV2exMainBeanList = v2exMainBeanList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_v2ex_main_item,parent,false);
        V2exMainViewItemHolder holder = new V2exMainViewItemHolder(view);
        view.setOnClickListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        V2exMainViewItemHolder myViewHolder = (V2exMainViewItemHolder)holder;
        V2exMainBean v2exMainBean = mV2exMainBeanList.get(position);
        myViewHolder.mV2exItemTitleTxt.setText(v2exMainBean.getTitle());
        LogUtils.v(TAG,"reply:"+v2exMainBean.getReplies());
        myViewHolder.mV2exItemReplyTxt.setText(v2exMainBean.getReplies()+"个回复");
        myViewHolder.mV2exItemNodeTxt.setText(v2exMainBean.getNode().getTitle());
        myViewHolder.mV2exItemTimeTxt.setText(TimeUtils.formatTime(new Long(v2exMainBean.getCreated())*1000));
        myViewHolder.mV2exItemUserTxt.setText(v2exMainBean.getMember().getUsername());
        String url = "http:"+v2exMainBean.getMember().getAvatar_normal();
        LogUtils.v(TAG,"url:"+url);
        Picasso.with(mContext).load(url).into(myViewHolder.mV2exItemIconImg);
    }

    @Override
    public int getItemCount() {
        return mV2exMainBeanList.size();
    }

    public void setItemOnClickListener(V2exMainPagerView.OnRecyclerViewItemClickListener onClickListener){
        mOnRecyclerViewItemClickListener = onClickListener;
    }
    class V2exMainViewItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mV2exItemTitleTxt;
        public TextView mV2exItemNodeTxt;
        public TextView mV2exItemUserTxt;
        public TextView mV2exItemReplyTxt;
        public TextView mV2exItemTimeTxt;
        public ImageView mV2exItemIconImg;
        public V2exMainViewItemHolder(View itemView) {
            super(itemView);
            mV2exItemIconImg = (ImageView)itemView.findViewById(R.id.topic_item_icon);
            mV2exItemTitleTxt = (TextView)itemView.findViewById(R.id.topic_item_title);
            mV2exItemNodeTxt = (TextView)itemView.findViewById(R.id.topic_item_node);
            mV2exItemUserTxt = (TextView)itemView.findViewById(R.id.topic_item_name);
            mV2exItemReplyTxt = (TextView)itemView.findViewById(R.id.topic_item_reply);
            mV2exItemTimeTxt = (TextView)itemView.findViewById(R.id.topic_item_time);
        }

        @Override
        public void onClick(View v) {
            LogUtils.v(TAG,"position:"+getAdapterPosition());
            int position = getAdapterPosition();
            mOnRecyclerViewItemClickListener.onItemClick(position,mV2exMainBeanList.get(position));
        }
    }
}
