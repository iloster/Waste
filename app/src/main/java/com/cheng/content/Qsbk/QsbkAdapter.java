package com.cheng.content.Qsbk;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.List;

/**
 * Created by dev on 2017/2/24.
 */

public class QsbkAdapter extends RecyclerView.Adapter{

    private String TAG = "Peek_QsbkAdapter";
    private List<QsbkBean.ItemsBean> mItemsBeanList;
    private Context mContext;
    public QsbkAdapter(List<QsbkBean.ItemsBean> itemsBeanList){
        mItemsBeanList = itemsBeanList;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_qsbk_item,parent,false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder h = (ItemHolder)holder;
        QsbkBean.ItemsBean bean = mItemsBeanList.get(position);
        h.tv.setText(bean.getContent());
    }

    @Override
    public int getItemCount() {
        return mItemsBeanList.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ItemHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.txt);
        }
    }
}
