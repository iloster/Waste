package com.cheng.content.GuoKr.Main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dev on 2017/1/11.
 */

public class GuokrMainItem extends RecyclerView.Adapter{

    private List<GuokrMainBean.ResultBean> mList;
    private BaseSubView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    private int SHOW_TIME = 0;
    private int HIDE_TIME = 1;
    public GuokrMainItem(List<GuokrMainBean.ResultBean> list){
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_guokr_item,parent,false);
        GuokrMainItemHolder holder = new GuokrMainItemHolder(view);
        view.setOnClickListener(holder);
        if(viewType==SHOW_TIME){
            holder.mGuokrItemTime.setVisibility(View.VISIBLE);
        }else{
            holder.mGuokrItemTime.setVisibility(View.GONE);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GuokrMainItemHolder h = (GuokrMainItemHolder)holder;

        GuokrMainBean.ResultBean bean = mList.get(position);
        String url = bean.getHeadline_img_tb();
        if(bean.getStyle().equals("calendar")){
            url = bean.getImages().get(0);
        }
        Picasso.with(WasteApplication.getInstance()).load(url).placeholder(R.mipmap.default_cover_image).resize(120,90).into(h.mGuokrItemIcon);
        h.mGuokrItemTitle.setText(bean.getTitle());
        h.mGuokrItemContent.setText(bean.getSummary()+"...");
        h.mGuokrItemTag.setText(bean.getCategory());
        h.mGuokrItemSource.setText(bean.getSource_name());
        if(h.mGuokrItemTime.getVisibility()==View.VISIBLE){
            if(TimeUtils.isSameDay(new Long(bean.getDate_picked())*1000,System.currentTimeMillis())){
                h.mGuokrItemTime.setText("今天");
            }else {
                h.mGuokrItemTime.setText(TimeUtils.getTimeByFormat(new Long(bean.getDate_picked())*1000,"yyyy-MM-dd"));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return SHOW_TIME;
        }else{
            GuokrMainBean.ResultBean bean1 = mList.get(position);
            GuokrMainBean.ResultBean bean2 = mList.get(position-1);
            return TimeUtils.isSameDay(new Long(bean1.getDate_picked())*1000,new Long(bean2.getDate_picked())*1000)?HIDE_TIME:SHOW_TIME;
        }

    }

    public void setOnRecyclerViewItemClickListener(BaseSubView.OnRecyclerViewItemClickListener listener){
        mOnRecyclerViewItemClickListener = listener;
    }

    private class GuokrMainItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mGuokrItemTag;
        public TextView mGuokrItemSource;
        public TextView mGuokrItemTitle;
        public TextView mGuokrItemContent;
        public ImageView mGuokrItemIcon;
        public TextView mGuokrItemTime;
        public GuokrMainItemHolder(View itemView) {
            super(itemView);

            mGuokrItemTime = (TextView)itemView.findViewById(R.id.cardview_item_time);
            mGuokrItemTag = (TextView)itemView.findViewById(R.id.guokr_item_tag);
            mGuokrItemSource = (TextView)itemView.findViewById(R.id.guokr_item_source);
            mGuokrItemTitle = (TextView)itemView.findViewById(R.id.guokr_item_title);
            mGuokrItemContent = (TextView)itemView.findViewById(R.id.guokr_item_content);
            mGuokrItemIcon = (ImageView)itemView.findViewById(R.id.guokr_item_icon);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mList.get(getAdapterPosition()));
        }
    }

}
