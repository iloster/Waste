package com.cheng.content.ZhihuDaily;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
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
    private BaseSubView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    private int SHOW_TIME = 0;
    private int HIDE_TIME = 1;

    public DailyMainItem(List<DailyMainBean.StoriesBean> list){
        mStoriesBeanList = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_daily_item,parent,false);
        DailyMainHolder holder = new DailyMainHolder(view);
        view.setOnClickListener(holder);
        if(viewType==SHOW_TIME){
            holder.mDailyItemTime.setVisibility(View.VISIBLE);
        }else{
            holder.mDailyItemTime.setVisibility(View.GONE);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DailyMainHolder h = (DailyMainHolder)holder;
        DailyMainBean.StoriesBean storiesBean = mStoriesBeanList.get(position);

        h.mDailyItemTitle.setText(storiesBean.getTitle());
        String url = storiesBean.getImages().get(0);
//        LogUtils.v(TAG,"icon url: "+url);
        Picasso.with(WasteApplication.getInstance()).load(url).placeholder(R.mipmap.default_cover_image).resize(80,80).into(h.mDailyItemIcon);
        if(h.mDailyItemTime.getVisibility()==View.VISIBLE){
            if(TimeUtils.isSameDay(storiesBean.getShowtime(),System.currentTimeMillis())){
                h.mDailyItemTime.setText("今天");
            }else {
                h.mDailyItemTime.setText(TimeUtils.getTimeByFormat(storiesBean.getShowtime(),"yyyy-MM-dd"));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mStoriesBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return SHOW_TIME;
        }else{
            DailyMainBean.StoriesBean bean1 = mStoriesBeanList.get(position);
            DailyMainBean.StoriesBean bean2 = mStoriesBeanList.get(position-1);
            return bean1.getShowtime() == bean2.getShowtime()?HIDE_TIME:SHOW_TIME;
        }
    }

    public void setOnRecyclerViewItemClickListener(BaseSubView.OnRecyclerViewItemClickListener listener){
        mOnRecyclerViewItemClickListener = listener;
    }
    private class DailyMainHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mDailyItemTitle;
        public ImageView mDailyItemIcon;
        public TextView mDailyItemTime;
        public DailyMainHolder(View itemView) {
            super(itemView);

            mDailyItemIcon = (ImageView)itemView.findViewById(R.id.daily_item_icon);
            mDailyItemTitle = (TextView)itemView.findViewById(R.id.daily_item_title);
            mDailyItemTime = (TextView)itemView.findViewById(R.id.cardview_item_time);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mStoriesBeanList.get(getAdapterPosition()));
        }
    }
}
