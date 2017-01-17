package com.cheng.content.Netease;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteasePagerView extends BaseSubView{

    private String TAG = "NeteasePagerView";
    private Context mContext ;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private int mIndex;
    public NeteasePagerView(int index) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mIndex = index;
        LayoutInflater.from(mContext).inflate(R.layout.content_netease_main_pager,this);

        initUI();
    }

    private void initUI(){
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void loadData(int index){
        LogUtils.v(TAG,"loadData mIndex:"+mIndex + "|index:"+index);
        String url = String.format(NeteaseConstant.LIST_URL,"main",0);
        LogUtils.v(TAG,"loadData url:"+url);
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                LogUtils.v(TAG,"ret:"+ret);
                Gson gson = new Gson();
                Type type = new TypeToken<List<NeteaseBean>>(){}.getType();
                List<NeteaseBean> list = gson.fromJson(ret,type);

                NeteaseViewItem neteaseViewItem = new NeteaseViewItem(list);
                mRecyclerView.setAdapter(neteaseViewItem);
            }
        });
    }

    public void showData(){

    }
}
