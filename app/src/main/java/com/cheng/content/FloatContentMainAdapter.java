package com.cheng.content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.view.BaseSubView;
import com.cheng.waste.FloatContentView;
import com.cheng.waste.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cheng on 2017/1/5.
 */

public class FloatContentMainAdapter extends RecyclerView.Adapter {
   private Context mConext;
    private List<BlockItem> mList;
    private BaseSubView.OnRecyclerViewItemClickListener mListener;
    public FloatContentMainAdapter(Context context, List<BlockItem> list){
        mConext = context;
        mList = list;
   }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mConext).inflate(R.layout.float_content_main_item,parent,false);
        ItemHolder holder = new ItemHolder(view);
        view.setOnClickListener(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder h = (ItemHolder)holder;
        BlockItem item = mList.get(position);
        h.name.setText(item.getName());

        Picasso.with(mConext).load(item.getIcon()).resize(48,48).into(h.icon);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setItemOnClickListener(BaseSubView.OnRecyclerViewItemClickListener listener){
        mListener = listener;
    }
    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView icon;
        public TextView name;
        public ItemHolder(View itemView) {
            super(itemView);

            icon = (ImageView)itemView.findViewById(R.id.icon);
            name = (TextView)itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(getAdapterPosition(),mList.get(getAdapterPosition()));
        }
    }
}
