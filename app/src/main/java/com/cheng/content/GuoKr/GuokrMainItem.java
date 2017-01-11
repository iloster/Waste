package com.cheng.content.GuoKr;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
