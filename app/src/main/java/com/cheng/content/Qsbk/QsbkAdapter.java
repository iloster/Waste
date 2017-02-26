package com.cheng.content.Qsbk;

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
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dev on 2017/2/24.
 */

public class QsbkAdapter extends RecyclerView.Adapter{

    private String TAG = "Peek_QsbkAdapter";
    private int STYPE_CONTENT = 0;
    private int STYLE_MORE = 1;
    private List<QsbkBean.ItemsBean> mItemsBeanList;
    private Context mContext;
    public QsbkAdapter(List<QsbkBean.ItemsBean> itemsBeanList){
        mItemsBeanList = itemsBeanList;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==STYPE_CONTENT) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_qsbk_item, parent, false);
            ItemHolder holder = new ItemHolder(view);
            return holder;
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_loadmore_btn,parent,false);
            MoreHolder holder = new MoreHolder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position<mItemsBeanList.size()-1) {
            ItemHolder h = (ItemHolder) holder;
            QsbkBean.ItemsBean bean = mItemsBeanList.get(position);
            if (bean.getUser() != null) {
                String url = bean.getUser().getMedium();
                LogUtils.v(TAG, "url:" + url);
                Picasso.with(mContext).load("http:" + bean.getUser().getMedium()).into(h.mIcon);
                h.mAuthorTxt.setText(bean.getUser().getLogin());
            } else {
                h.mAuthorTxt.setText("匿名");
            }
            h.mTimeTxt.setText(TimeUtils.formatTime(new Long(bean.getPublished_at()) * 1000));
            h.mContentTxt.setText(bean.getContent());
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return mItemsBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position<mItemsBeanList.size()-1){
            return STYPE_CONTENT;
        }else{
            return STYLE_MORE;
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        public ImageView mIcon;
        public TextView mAuthorTxt;
        public TextView mTimeTxt;
        public TextView mContentTxt;
        public ItemHolder(View itemView) {
            super(itemView);
            mIcon = (ImageView)itemView.findViewById(R.id.qsbk_item_icon);
            mAuthorTxt = (TextView)itemView.findViewById(R.id.qsbk_item_author);
            mTimeTxt = (TextView)itemView.findViewById(R.id.qsbk_item_time);
            mContentTxt = (TextView)itemView.findViewById(R.id.qsbk_item_content);

        }
    }

    private class MoreHolder extends RecyclerView.ViewHolder{

        public MoreHolder(View itemView) {
            super(itemView);
        }
    }
}
