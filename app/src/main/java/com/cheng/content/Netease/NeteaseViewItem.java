package com.cheng.content.Netease;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    public NeteaseViewItem(List<NeteaseBean> list){
        mList = list;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_netease_main_item,parent,false);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder h = (ItemHolder)holder;
        NeteaseBean bean = mList.get(position);

        Picasso.with(mContext).load(bean.getImgsrc()).resize(130,100).into(h.mNeteaseItemIcon);
        h.mNeteaseItemTitle.setText(bean.getTitle());
        h.mNeteaseItemContent.setText(bean.getDigest());
        h.mNeteaseItemSource.setText("来源:"+bean.getSource());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        public ImageView mNeteaseItemIcon;
        public TextView mNeteaseItemTitle;
        public TextView mNeteaseItemContent;
        public TextView mNeteaseItemSource;

        public ItemHolder(View itemView) {
            super(itemView);

            mNeteaseItemIcon = (ImageView)itemView.findViewById(R.id.netease_item_icon);
            mNeteaseItemTitle = (TextView)itemView.findViewById(R.id.netease_item_title);
            mNeteaseItemContent = (TextView)itemView.findViewById(R.id.netease_item_content);
            mNeteaseItemSource = (TextView)itemView.findViewById(R.id.netease_item_source);
        }
    }
}
