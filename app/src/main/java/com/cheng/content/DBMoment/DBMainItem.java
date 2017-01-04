package com.cheng.content.DBMoment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by dev on 2017/1/3.
 */

public class DBMainItem extends RecyclerView.Adapter{

    private Context mContext;
    private List<DBMainBean> mDBMainBeanList;
    private DBView.OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;
    public DBMainItem(List<DBMainBean> list){
        mContext = WasteApplication.getInstance();
        mDBMainBeanList = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == DBConstant.ITEM_TYPE2){
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item2, parent, false);
            DBMainItemType2Holder holder = new DBMainItemType2Holder(view);
            view.setOnClickListener(holder);
            return holder;
        }else if(viewType == DBConstant.ITEM_TYPE3){
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item3, parent, false);
            DBMainItemType3Holder holder = new DBMainItemType3Holder(view);
            view.setOnClickListener(holder);
            return holder;
        }else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.content_db_item1, parent, false);
            DBMainItemType1Holder holder = new DBMainItemType1Holder(view);
            view.setOnClickListener(holder);
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

        }else if(bean.getDisplay_style() == DBConstant.ITEM_TYPE3){
            DBMainItemType3Holder holder3 = (DBMainItemType3Holder) holder;
            holder3.mDBItemTitle.setText(bean.getTitle());
            DBMainBean.ThumbsBean.SmallBean small1 = bean.getThumbs().get(0).getSmall();
            DBMainBean.ThumbsBean.SmallBean small2 = bean.getThumbs().get(1).getSmall();
            DBMainBean.ThumbsBean.SmallBean small3 = bean.getThumbs().get(2).getSmall();
            Picasso.with(mContext).load(small1.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon1);
            Picasso.with(mContext).load(small2.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon2);
            Picasso.with(mContext).load(small3.getUrl()).placeholder(R.mipmap.db_default_image).resize(320,213).into(holder3.mDBItemIcon3);

        }else{
            DBMainItemType1Holder holder1 = (DBMainItemType1Holder) holder;
            holder1.mDBItemTitle.setText(bean.getTitle());
            holder1.mDBItemAbstract.setText(bean.getAbstractX());
        }

    }

    @Override
    public int getItemCount() {
        return mDBMainBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDBMainBeanList.get(position).getDisplay_style();
    }

    public void setItemClickListener(DBView.OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
    class DBMainItemType1Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mDBItemTitle;
        public TextView mDBItemAbstract;
        public DBMainItemType1Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemAbstract = (TextView)itemView.findViewById(R.id.db_item_abstract);
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
        public DBMainItemType2Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemAbstract = (TextView)itemView.findViewById(R.id.db_item_abstract);
            mDBItemIcon = (ImageView)itemView.findViewById(R.id.db_item_icon);
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
        public DBMainItemType3Holder(View itemView) {
            super(itemView);
            mDBItemTitle = (TextView)itemView.findViewById(R.id.db_item_title);
            mDBItemIcon1 = (ImageView)itemView.findViewById(R.id.db_item_icon1);
            mDBItemIcon2 = (ImageView)itemView.findViewById(R.id.db_item_icon2);
            mDBItemIcon3 = (ImageView)itemView.findViewById(R.id.db_item_icon3);
        }

        @Override
        public void onClick(View view) {
            mOnRecyclerViewItemClickListener.onItemClick(getAdapterPosition(),mDBMainBeanList.get(getAdapterPosition()));
        }
    }
}
