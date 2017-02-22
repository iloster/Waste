package com.cheng.content.DBMoment.Detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.content.DBMoment.DBStringUtils;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

/**
 * Created by dev on 2017/2/22.
 */

public class DBDetailAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<String> mList;
    private String TAG = "DBDetailAdapter";
    public DBDetailAdapter(List<String> list){
        mList = list;
        mContext = WasteApplication.getInstance();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.content_detailex_item,parent,false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemHolder h = (ItemHolder)holder;
        String str = mList.get(position);
        if(str.startsWith("<img")){
            h.image.setVisibility(View.VISIBLE);
            h.tv.setVisibility(View.GONE);
            String url = DBStringUtils.getImgUrl(str);
            LogUtils.v(TAG,"url:"+url);
            Picasso.with(mContext).load(url).into(h.image);
        }else {
            h.image.setVisibility(View.GONE);
            String txt = DBStringUtils.getText(str);
            if(txt!=null) {
                h.tv.setText("\t\t\t\t" + DBStringUtils.getText(str));
                h.tv.setVisibility(View.VISIBLE);
            }else{
                h.tv.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder{

        public TextView tv;
        public ImageView image;
        public ItemHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
