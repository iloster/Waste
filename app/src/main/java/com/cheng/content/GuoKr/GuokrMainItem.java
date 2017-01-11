package com.cheng.content.GuoKr;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.utils.LogUtils;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dev on 2017/1/11.
 */

public class GuokrMainItem extends RecyclerView.Adapter{

    private List<GuokrMainBean.ResultBean> mList;
    public GuokrMainItem(List<GuokrMainBean.ResultBean> list){
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_guokr_item,parent,false);
        GuokrMainItemHolder holder = new GuokrMainItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GuokrMainItemHolder h = (GuokrMainItemHolder)holder;

        GuokrMainBean.ResultBean bean = mList.get(position);
        String url = bean.getHeadline_img_tb();
        LogUtils.v("onBindViewHolder:","url"+url);
        Picasso.with(WasteApplication.getInstance()).load(url).resize(120,90).into(h.mGuokrItemIcon);
        h.mGuokrItemTitle.setText(bean.getTitle());
        h.mGuokrItemContent.setText(bean.getSummary());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class GuokrMainItemHolder extends RecyclerView.ViewHolder{

        public TextView mGuokrItemTitle;
        public TextView mGuokrItemContent;
        public ImageView mGuokrItemIcon;

        public GuokrMainItemHolder(View itemView) {
            super(itemView);

            mGuokrItemTitle = (TextView)itemView.findViewById(R.id.guokr_item_title);
            mGuokrItemContent = (TextView)itemView.findViewById(R.id.guokr_item_content);
            mGuokrItemIcon = (ImageView)itemView.findViewById(R.id.guokr_item_icon);
        }
    }

}
