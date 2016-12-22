package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.waste.R;

import java.util.List;

/**
 * Created by dev on 2016/12/21.
 */

public class V2exMainViewItem extends RecyclerView.Adapter {

    private Context mContext;
    private List<V2exMainBean> mV2exMainBeanList;
    public V2exMainViewItem(Context context, List<V2exMainBean> v2exMainBeanList){
        mContext = context;
        mV2exMainBeanList = v2exMainBeanList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        V2exMainViewItemHolder holder = new V2exMainViewItemHolder(LayoutInflater.from(mContext).inflate(R.layout.content_v2ex_main_item,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        V2exMainViewItemHolder myViewHolder = (V2exMainViewItemHolder)holder;
        V2exMainBean v2exMainBean = mV2exMainBeanList.get(position);
        myViewHolder.mV2exItemTitleTxt.setText(v2exMainBean.getTitle());
//        myViewHolder.mV2exItemReplyTxt.setText(v2exMainBean.getReplies());
        myViewHolder.mV2exItemNodeTxt.setText(v2exMainBean.getNode().getTitle());
//        myViewHolder.mV2exItemTimeTxt.setText(v2exMainBean.getLast_modified());
        myViewHolder.mV2exItemUserTxt.setText(v2exMainBean.getMember().getUsername());
    }

    @Override
    public int getItemCount() {
        return mV2exMainBeanList.size();
    }


    class V2exMainViewItemHolder extends RecyclerView.ViewHolder{

        public TextView mV2exItemTitleTxt;
        public TextView mV2exItemNodeTxt;
        public TextView mV2exItemUserTxt;
        public V2exMainViewItemHolder(View itemView) {
            super(itemView);
            mV2exItemTitleTxt = (TextView)itemView.findViewById(R.id.item_topic_title);
            mV2exItemNodeTxt = (TextView)itemView.findViewById(R.id.item_topic_node);
            mV2exItemUserTxt = (TextView)itemView.findViewById(R.id.item_topic_user);
//            mV2exItemReplyTxt = (TextView)itemView.findViewById(R.id.item_topic_replyNum);
//            mV2exItemTimeTxt = (TextView)itemView.findViewById(R.id.item_topic_time1);
        }
    }
}
