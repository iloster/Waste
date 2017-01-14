package com.cheng.content;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cheng.content.DBMoment.DBView;
import com.cheng.content.GuoKr.GuokrView;
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
        final List<String> list = new ArrayList<>();
        list.add("V2EX");
        list.add("豆瓣一刻");
        list.add("果壳精选");
        list.add("知乎日报");
        FloatContentMainItem floatContentMainItem = new FloatContentMainItem(mContext,list);
        floatContentMainItem.setItemOnClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
               switch (position){
                   case 0:{
                       V2exMainView v2exMainView = new V2exMainView(mContext);
                       MyWindowManager.replaceSubView(v2exMainView,list.get(position));
                   }
                   break;
                   case 1:{
                       DBView dbView = new DBView();
                       MyWindowManager.replaceSubView(dbView,list.get(position));
                   }
                   break;
                   case 2:{
                       GuokrView guokrView = new GuokrView();
                       MyWindowManager.replaceSubView(guokrView,list.get(position));
                   }
                   break;
                   case 3:{
                       DailyView dailyView = new DailyView();
                       MyWindowManager.replaceSubView(dailyView,list.get(position));
                   }break;
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
