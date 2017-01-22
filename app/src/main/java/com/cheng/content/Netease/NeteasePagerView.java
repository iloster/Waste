package com.cheng.content.Netease;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Toast;

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

import okhttp3.Call;

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
    private NeteaseViewItem mNeteaseViewItem;
    private int mCurPage = 0;
    private boolean mIsRefresh = false;
    private Call mCall;
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

        mNeteaseViewItem = new NeteaseViewItem(mNeteaseBeanList);
        mRecyclerView.setAdapter(mNeteaseViewItem);
        mNeteaseViewItem.setOnRecyclerViewItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                //点击事件
                LogUtils.v(TAG,"position:"+position);
                MyWindowManager.replaceSubView(new NeteaseDetail((NeteaseBean)data),"新闻");
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                requestData(true);
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE && (lastVisibleItem + 1 == mNeteaseViewItem.getItemCount())){
                    //上拉刷新
                    if(!mIsRefresh) {
                        mSwipeRefreshLayout.setRefreshing(true);
                        requestData(false);
                        mIsRefresh = true;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager1 = (LinearLayoutManager) recyclerView.getLayoutManager();
                lastVisibleItem = layoutManager1.findLastVisibleItemPosition();
            }
        });


    }

    public void loadData(){
       if(!mIsLoaded){
           mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
           mSwipeRefreshLayout.setRefreshing(true);
           requestData(true);
       }else{
           LogUtils.v(TAG,"数据已经加载过了");
       }

    }

    public void showData(List<NeteaseBean> list,boolean flag){
        mSwipeRefreshLayout.setRefreshing(false);
        mIsLoaded = true;
        mIsRefresh = false;
        if(flag){

            //下拉刷新
            if(list.size()>0){
                for(int i = 0;i<list.size();i++){
                    mNeteaseBeanList.add(i,list.get(i));
                }
                mNeteaseViewItem.notifyItemRangeChanged(0,list.size());
                mNeteaseViewItem.notifyDataSetChanged();
                Toast.makeText(mContext,"数据加载成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(mContext,"数据获取失败",Toast.LENGTH_SHORT).show();
            }
        }else{
            //上拉刷新
            if(list.size()>0){
                mCurPage = mCurPage + 1;
                int orglength = mNeteaseBeanList.size();
                for(int i =0 ;i<list.size();i++){
                    mNeteaseBeanList.add(orglength + i,list.get(i));
                }
                mNeteaseViewItem.notifyItemRangeChanged(orglength,orglength+list.size());
                mNeteaseViewItem.notifyDataSetChanged();
                Toast.makeText(mContext,"数据加载成功",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void showError(){
        mIsRefresh = false;
        mSwipeRefreshLayout.setRefreshing(false);
        if(mNeteaseBeanList.size()>0){
            Toast.makeText(mContext,"数据获取失败",Toast.LENGTH_SHORT).show();
        }else{
            MyWindowManager.showErrorView();
        }
    }
    public void requestData(final boolean flag){
        String type="main";
        if(mIndex == NeteaseConstant.TAB_TOUTIAO){
            type = "main";
        }else if(mIndex == NeteaseConstant.TAB_KEJI){
            type = "keji";
        }else if(mIndex==NeteaseConstant.TAB_SHEHUI){
            type = "shehui";
        }
        int page = 0;
        if(!flag){
            page = mCurPage + 1;
        }
        String url = String.format(NeteaseConstant.LIST_URL,type,page);
        LogUtils.v(TAG,"loadData url:"+url);
        if(mCall != null)
            mCall.cancel();
        mCall = HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {
                showError();
            }

            @Override
            public void onSuccess(String ret) {
                LogUtils.v(TAG,"ret:"+ret);
                try {
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<NeteaseBean>>() {
                    }.getType();
                    List<NeteaseBean> list = gson.fromJson(ret, type);

                    showData(list,flag);
                }catch (Exception e){
                    MyWindowManager.showErrorView();
                }
            }
        });
    }

    public void onRefreshClick(){
        LogUtils.v(TAG,"onRefreshClick");
        mSwipeRefreshLayout.setProgressViewOffset(false, 0, 100);
        mSwipeRefreshLayout.setRefreshing(true);
        requestData(true);
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mCall!=null){
            LogUtils.v(TAG,"onDetachedFromWindow");
            mCall.cancel();
        }

    }
}
