package com.cheng.content.Qsbk;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

/**
 * Created by dev on 2017/2/24.
 */

public class QsbkAdapter extends RecyclerView.Adapter{

    private String TAG = "Peek_QsbkAdapter";
    private QsbkBean.ItemsBean mItemsBean;
    private Context mContext;
    public QsbkAdapter(QsbkBean.ItemsBean itemsBeanList){
        mItemsBean = itemsBeanList;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.content_qsbk_item,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        public ItemHolder(View itemView) {
            super(itemView);
        }
    }
}
