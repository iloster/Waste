package com.cheng.content.ZhihuDaily;

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
 * Created by cheng on 2017/1/8.
 */

public class DailyMainItem extends RecyclerView.Adapter {

    private String TAG = "DailyMainItem";
    private List<DailyMainBean.StoriesBean> mStoriesBeanList;

    public DailyMainItem(List<DailyMainBean.StoriesBean> list){
        mStoriesBeanList = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_daily_item,parent,false);
        DailyMainHolder holder = new DailyMainHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DailyMainHolder h = (DailyMainHolder)holder;
        DailyMainBean.StoriesBean storiesBean = mStoriesBeanList.get(position);

        h.mDailyItemTitle.setText(storiesBean.getTitle());
        String url = storiesBean.getImages().get(0);
        LogUtils.v(TAG,"icon url: "+url);
        Picasso.with(WasteApplication.getInstance()).load(url).resize(80,80).into(h.mDailyItemIcon);
    }

    @Override
    public int getItemCount() {
        return mStoriesBeanList.size();
    }

    private class DailyMainHolder extends RecyclerView.ViewHolder{

        public TextView mDailyItemTitle;
        public ImageView mDailyItemIcon;
        public DailyMainHolder(View itemView) {
            super(itemView);

            mDailyItemIcon = (ImageView)itemView.findViewById(R.id.daily_item_icon);
            mDailyItemTitle = (TextView)itemView.findViewById(R.id.daily_item_title);
        }
    }
}
