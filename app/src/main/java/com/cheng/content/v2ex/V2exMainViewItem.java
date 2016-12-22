package com.cheng.content.v2ex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }

    @Override
    public int getItemCount() {
        return mV2exMainBeanList.size();
    }


    class V2exMainViewItemHolder extends RecyclerView.ViewHolder{

        public V2exMainViewItemHolder(View itemView) {
            super(itemView);
        }
    }
}
