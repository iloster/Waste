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
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
    private boolean mIsLoaded = false;
    private List<NeteaseBean> mNeteaseBeanList = new ArrayList<NeteaseBean>();
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


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
            }
        });
    }

    public void loadData(){
       if(!mIsLoaded){
           mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
           mSwipeRefreshLayout.setRefreshing(true);
           requestData();
       }else{
           LogUtils.v(TAG,"数据已经加载过了");
       }

    }

    public void showData(){

    }

    public void requestData(){
        String type="main";
        if(mIndex == NeteaseConstant.TAB_TOUTIAO){
            type = "main";
        }else if(mIndex == NeteaseConstant.TAB_KEJI){
            type = "keji";
        }else if(mIndex==NeteaseConstant.TAB_SHEHUI){
            type = "shehui";
        }
        String url = String.format(NeteaseConstant.LIST_URL,type,0);
        LogUtils.v(TAG,"loadData url:"+url);
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {
                MyWindowManager.showErrorView();
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(String ret) {
                LogUtils.v(TAG,"ret:"+ret);
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<NeteaseBean>>() {
                    }.getType();
                    List<NeteaseBean> list = gson.fromJson(ret, type);

                    NeteaseViewItem neteaseViewItem = new NeteaseViewItem(list);
                    mRecyclerView.setAdapter(neteaseViewItem);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mIsLoaded = true;
                }catch (Exception e){
                    MyWindowManager.showErrorView();
                }
            }
        });
    }
}
