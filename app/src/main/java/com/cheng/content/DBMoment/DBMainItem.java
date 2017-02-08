package com.cheng.content.DBMoment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dev on 2017/1/3.
 */

public class DBMainItem extends RecyclerView.Adapter{
    private String TAG = "DBMainItem";
    private Context mContext;
    private List<DBMainBean> mDBMainBeanList;
    private DBView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    public DBMainItem(List<DBMainBean> list){
        mContext = WasteApplication.getInstance();
        mDBMainBeanList = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == DBConstant.ITEM_TYPE2 || viewType == DBConstant.ITEM_TYPE2_PLUS){
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item2, parent, false);
            DBMainItemType2Holder holder = new DBMainItemType2Holder(view);
            view.setOnClickListener(holder);
            if(viewType == DBConstant.ITEM_TYPE2_PLUS){
                holder.mDBItemTime.setVisibility(View.VISIBLE);
            }else{
                holder.mDBItemTime.setVisibility(View.GONE);
            }
            return holder;
        }else if(viewType == DBConstant.ITEM_TYPE3|| viewType == DBConstant.ITEM_TYPE3_PLUS){
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item3, parent, false);
            DBMainItemType3Holder holder = new DBMainItemType3Holder(view);
            view.setOnClickListener(holder);
            if(viewType == DBConstant.ITEM_TYPE3_PLUS){
                holder.mDBItemTime.setVisibility(View.VISIBLE);
            }else{
                holder.mDBItemTime.setVisibility(View.GONE);
            }
            return holder;
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item1, parent, false);
            DBMainItemType1Holder holder = new DBMainItemType1Holder(view);
            view.setOnClickListener(holder);
            if(viewType == DBConstant.ITEM_TYPE1_PLUS){
                holder.mDBItemTime.setVisibility(View.VISIBLE);
            }else{
                holder.mDBItemTime.setVisibility(View.GONE);
            }
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DBMainBean bean = mDBMainBeanList.get(position);
        if(bean.getDisplay_style()==DBConstant.ITEM_TYPE2) {
            DBMainItemType2Holder holder2 = (DBMainItemType2Holder) holder;
            holder2.mDBItemTitle.setText(bean.getTitle());
            holder2.mDBItemAbstract.setText(bean.getAbstractX());
            String url = bean.getThumbs().get(0).getSmall().getUrl();
            Picasso.with(mContext).load(url).placeholder(R.mipmap.db_default_image).resize(90,90).into(holder2.mDBItemIcon);
            if(holder2.mDBItemTime.getVisibility()==View.VISIBLE){
                if(TimeUtils.isSameDay(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),System.currentTimeMillis())){
                    holder2.mDBItemTime.setText("今天");
                }else {
                    holder2.mDBItemTime.setText(TimeUtils.getTimeByFormat(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
                }
            }
        }else if(bean.getDisplay_style() == DBConstant.ITEM_TYPE3){
            DBMainItemType3Holder holder3 = (DBMainItemType3Holder) holder;
            holder3.mDBItemTitle.setText(bean.getTitle());
            DBMainBean.ThumbsBean.SmallBean small1 = bean.getThumbs().get(0).getSmall();
            DBMainBean.ThumbsBean.SmallBean small2 = bean.getThumbs().get(1).getSmall();
            DBMainBean.ThumbsBean.SmallBean small3 = bean.getThumbs().get(2).getSmall();
            Picasso.with(mContext).load(small1.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon1);
            Picasso.with(mContext).load(small2.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon2);
            Picasso.with(mContext).load(small3.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon3);
            if(holder3.mDBItemTime.getVisibility()==View.VISIBLE){
                if(TimeUtils.isSameDay(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),System.currentTimeMillis())){
                    holder3.mDBItemTime.setText("今天");
                }else {
                    holder3.mDBItemTime.setText(TimeUtils.getTimeByFormat(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
                }
            }
        }else{
            DBMainItemType1Holder holder1 = (DBMainItemType1Holder) holder;
            holder1.mDBItemTitle.setText(bean.getTitle());
            holder1.mDBItemAbstract.setText(bean.getAbstractX());
            if(holder1.mDBItemTime.getVisibility()==View.VISIBLE){
                if(TimeUtils.isSameDay(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),System.currentTimeMillis())){
                    holder1.mDBItemTime.setText("今天");
                }else {
                    holder1.mDBItemTime.setText(TimeUtils.getTimeByFormat(TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return mDBMainBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return mDBMainBeanList.get(position).getDisplay_style()+10000;
        }else{
            DBMainBean bean = mDBMainBeanList.get(position);
            DBMainBean lastBean = mDBMainBeanList.get(position - 1);
            long curTimeStamp = TimeUtils.getTimestamp(bean.getPublished_time(),"yyyy-MM-dd HH:mm:ss");
            long lastTimeStamp = TimeUtils.getTimestamp(lastBean.getPublished_time(),"yyyy-MM-dd HH:mm:ss");
//            LogUtils.v(TAG,"curTimeStamp:"+bean.getPublished_time() + "|lastTimeStamp:"+lastBean.getPublished_time()+"|isSame:"+TimeUtils.isSameDay(curTimeStamp,lastTimeStamp));
            if(TimeUtils.isSameDay(curTimeStamp,lastTimeStamp)){
                return mDBMainBeanList.get(position).getDisplay_style();
            }else{
                return mDBMainBeanList.get(position).getDisplay_style() + 10000;
            }
        }
    }

    public void setItemClickListener(DBView.OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
    class DBMainItemType1Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mDBItemTitle;
        public TextView mDBItemAbstract;
        public TextView mDBItemTime;
        public DBMainItemType1Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemAbstract = (TextView)itemView.findViewById(R.id.db_item_abstract);
            mDBItemTime = (TextView)itemView.findViewById(R.id.cardview_item_time);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mDBMainBeanList.get(getAdapterPosition()));
        }
    }
    class DBMainItemType2Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mDBItemTitle;
        public TextView mDBItemAbstract;
        public ImageView mDBItemIcon;
        public TextView mDBItemTime;
        public DBMainItemType2Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemAbstract = (TextView)itemView.findViewById(R.id.db_item_abstract);
            mDBItemIcon = (ImageView)itemView.findViewById(R.id.db_item_icon);
            mDBItemTime = (TextView)itemView.findViewById(R.id.cardview_item_time);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mDBMainBeanList.get(getAdapterPosition()));
        }
    }

    class DBMainItemType3Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mDBItemTitle;
        public ImageView mDBItemIcon1;
        public ImageView mDBItemIcon2;
        public ImageView mDBItemIcon3;
        public TextView mDBItemTime;
        public DBMainItemType3Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemIcon1 = (ImageView)itemView.findViewById(R.id.db_item_icon1);
            mDBItemIcon2 = (ImageView)itemView.findViewById(R.id.db_item_icon2);
            mDBItemIcon3 = (ImageView)itemView.findViewById(R.id.db_item_icon3);
            mDBItemTime = (TextView)itemView.findViewById(R.id.cardview_item_time);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mDBMainBeanList.get(getAdapterPosition()));
        }
    }
}
