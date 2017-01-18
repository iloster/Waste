package com.cheng.content.Netease;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteaseViewItem extends RecyclerView.Adapter{

    private Context mContext;
    private List<NeteaseBean> mList;
    private BaseSubView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    public NeteaseViewItem(List<NeteaseBean> list){
        mList = list;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_netease_main_item,parent,false);
        ItemHolder itemHolder = new ItemHolder(view);
        view.setOnClickListener(itemHolder);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder h = (ItemHolder)holder;
        NeteaseBean bean = mList.get(position);

        int width = (int)mContext.getResources().getDimension(R.dimen.x130);
        int height = (int)mContext.getResources().getDimension(R.dimen.x100);
        Picasso.with(mContext).load(bean.getImgsrc()).resize(width,height).placeholder(R.mipmap.default_cover_image).into(h.mNeteaseItemIcon);
        h.mNeteaseItemTitle.setText(bean.getTitle());
        h.mNeteaseItemContent.setText(bean.getDigest()+"...");
        h.mNeteaseItemSource.setText(bean.getSource());
        h.mNeteaseItemTime.setText(bean.getPtime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnRecyclerViewItemClickListener(BaseSubView.OnRecyclerViewItemClickListener listener){
        mOnRecyclerViewItemClickListener = listener;
    }
    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView mNeteaseItemIcon;
        public TextView mNeteaseItemTitle;
        public TextView mNeteaseItemContent;
        public TextView mNeteaseItemSource;
        public TextView mNeteaseItemTime;

        public ItemHolder(View itemView) {
            super(itemView);

            mNeteaseItemIcon = (ImageView)itemView.findViewById(R.id.netease_item_icon);
            mNeteaseItemTitle = (TextView)itemView.findViewById(R.id.netease_item_title);
            mNeteaseItemContent = (TextView)itemView.findViewById(R.id.netease_item_content);
            mNeteaseItemSource = (TextView)itemView.findViewById(R.id.netease_item_source);
            mNeteaseItemTime = (TextView)itemView.findViewById(R.id.netease_item_time);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mList.get(getAdapterPosition()));
        }
    }
}
