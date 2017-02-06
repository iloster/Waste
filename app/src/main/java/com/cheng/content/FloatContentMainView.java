package com.cheng.content;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cheng.config.Constants;
import com.cheng.content.DBMoment.DBView;
import com.cheng.content.GuoKr.GuokrView;
import com.cheng.content.Netease.NeteaseView;
import com.cheng.content.ZhihuDaily.DailyView;
import com.cheng.content.v2ex.V2exMainView;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/21.
 */

public class FloatContentMainView extends BaseSubView {

    private String TAG = "FloatContentMainView";
    private RecyclerView mRecyclerView;
    private Context mContext;
    public FloatContentMainView(final Context context) {
        super(context);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.float_content_main,this);
        LogUtils.v(TAG,"FloatContentMainView : ctor");

        initUI();
        showIcon();
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(3));
    }

    private void showIcon(){
        final List<BlockItem> list = new ArrayList<>();

        for(int i = 0;i< Constants.BLOCK_COUNT; i++){
            BlockItem blockItem = new BlockItem(i,Constants.BLOCK_NAMES[i],Constants.BLOCK_ICONS[i]);
            list.add(blockItem);
        }
        FloatContentMainItem floatContentMainItem = new FloatContentMainItem(mContext,list);
        floatContentMainItem.setItemOnClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                BlockItem item = (BlockItem)data;
               switch (item.getId()){
                   case Constants.ID_V2EX:{
                       V2exMainView v2exMainView = new V2exMainView(mContext);
                       MyWindowManager.replaceSubView(v2exMainView,item.getName());

                   }
                   break;
                   case Constants.ID_DBMOMENT:{
                       DBView dbView = new DBView();
                       MyWindowManager.replaceSubView(dbView,item.getName());
                   }
                   break;
                   case Constants.ID_GUOKR:{
                       GuokrView guokrView = new GuokrView();
                       MyWindowManager.replaceSubView(guokrView,item.getName());
                   }
                   break;
                   case Constants.ID_ZHIHUDAILY:{
                       DailyView dailyView = new DailyView();
                       MyWindowManager.replaceSubView(dailyView,item.getName());
                   }
                   break;
                   default:break;

               }
            }
        });
        mRecyclerView.setAdapter(floatContentMainItem);
    }



    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //不是第一个的格子都设一个左边和底部的间距
            outRect.left = space;
            outRect.bottom = space;
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) %3==0) {
                outRect.left = 0;
            }
        }

    }


}
