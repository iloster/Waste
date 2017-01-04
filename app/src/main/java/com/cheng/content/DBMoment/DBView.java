package com.cheng.content.DBMoment;

import android.content.Context;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by dev on 2017/1/3.
 */

public class DBView extends BaseSubView{

    private String TAG = "DBView";
    private LinearLayout mErrorLayout;
    private Button mErrorBtn;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Context mContext;

    public DBView() {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(mContext).inflate(R.layout.content_db_view,this);

        initUI();
        loadData();
    }

    private void initUI(){
        mErrorLayout = (LinearLayout)findViewById(R.id.errorLayout);
        mErrorBtn = (Button)findViewById(R.id.errorBtn);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void loadData(){
        String url = DBConstant.DOUBAN_MOMENT + TimeUtils.getDBTimerStr();
        LogUtils.v(TAG,"loadData:"+url);
        HttpUtil.getInstance().enqueue(url, new CallBack() {
            @Override
            public void onError() {
                showError(true);
            }

            @Override
            public void onSuccess(String ret) {
                showError(false);
//                LogUtils.v(TAG,"loadData success:"+ret);
                Gson gson = new Gson();
                try {
                    JSONObject jsonObject = new JSONObject(ret);
                    String posts = jsonObject.getString("posts");
                    Type type = new TypeToken<List<DBMainBean>>(){}.getType();
                    List<DBMainBean> list = gson.fromJson(posts,type);
                    showData(list);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void showData(List<DBMainBean> list){
        LogUtils.v(TAG,"showData: size="+list.size());
        DBMainItem dbMainItem = new DBMainItem(list);
        dbMainItem.setItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                MyWindowManager.replaceSubView(new DBDetail((DBMainBean) data),"豆瓣一刻");
            }
        });
        mRecyclerView.setAdapter(dbMainItem);
    }
    private void showError(boolean flag){
        if(flag){
            mSwipeRefreshLayout.setVisibility(GONE);
            mErrorLayout.setVisibility(VISIBLE);
        }else{
            mSwipeRefreshLayout.setVisibility(VISIBLE);
            mErrorLayout.setVisibility(GONE);
        }
    }


    public interface OnRecyclerViewItemClickListener{
        public void onItemClick(int position,Object data);
    }
}
