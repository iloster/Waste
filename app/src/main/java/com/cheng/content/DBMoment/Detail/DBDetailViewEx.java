package com.cheng.content.DBMoment.Detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.content.DBMoment.DBStringUtils;
import com.cheng.content.DBMoment.Main.DBMainBean;
import com.cheng.content.DBMoment.Main.IDBView;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.Iterator;
import java.util.List;

/**
 * Created by dev on 2017/2/22.
 */

public class DBDetailViewEx extends BaseSubView implements IDBDetailView {
    private String TAG = "DBDetailViewEx";

    /*ui控件*/
    private RecyclerView mRecyclerView;
    /*变量名*/
    private Context mContext;
    private DBMainBean mDbMainBean;
    private DBDetailPresenter mPresenter;

    public DBDetailViewEx(DBMainBean dbMainBean) {
        super(WasteApplication.getInstance());
        mDbMainBean = dbMainBean;
        mContext = WasteApplication.getInstance();
        LayoutInflater.from(WasteApplication.getInstance()).inflate(R.layout.content_db_detailex,this);
        initUI();

        mPresenter = new DBDetailPresenter(this);
        mPresenter.loadData(dbMainBean);
    }


    private void initUI(){
        LogUtils.v(TAG,"initUI");
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void showData(DBDetailBean bean) {
        MyWindowManager.hideLoading();
        String content = bean.getContent();
        List<DBDetailBean.PhotosBean> photosBeanList= bean.getPhotos();
        for(int i = 0;i<photosBeanList.size();i++){
            String reg1 = "<img id=\""+photosBeanList.get(i).getTag_name();
            String reg2 = "<img src=\""+photosBeanList.get(i).getMedium().getUrl();
            content = content.replaceAll(reg1,reg2);
        }
        LogUtils.v(TAG,"content:"+content);
        List<String> list = DBStringUtils.splitHtml(content);
        list.add(0,"<title>"+bean.getTitle()+"</title>");
        list.add(1,"<time>"+bean.getCreated_time()+"</time>");
//        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//            String context = (String) iterator.next();
//            System.out.println(context);
//        }
        DBDetailAdapter adapter = new DBDetailAdapter(list);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError() {
        MyWindowManager.showErrorView();
    }


    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
        if(mPresenter!=null) {
            mPresenter.loadData(mDbMainBean);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mPresenter!=null){
            mPresenter.release();
        }
    }
}
