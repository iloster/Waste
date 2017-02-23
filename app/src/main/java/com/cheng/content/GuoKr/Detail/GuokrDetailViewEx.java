package com.cheng.content.GuoKr.Detail;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.cheng.content.GuoKr.GuokrStringUtils;
import com.cheng.content.GuoKr.Main.GuokrMainBean;
import com.cheng.utils.TimeUtils;
import com.cheng.view.BaseSubView;
import com.cheng.waste.MyWindowManager;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;

import java.util.List;

/**
 * Created by cheng on 2017/2/22.
 */

public class GuokrDetailViewEx extends BaseSubView implements IGuokrDetailView{

    /****ui控件**/
    private RecyclerView mRecyclerView;

   /**变量**/
   private Context mContext;
    private GuokrDetailPresenter mPresenter;
    private GuokrMainBean.ResultBean mResultBean;
    public GuokrDetailViewEx(GuokrMainBean.ResultBean resultBean) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mResultBean = resultBean;
        LayoutInflater.from(mContext).inflate(R.layout.content_guokr_detailex,this);

        initUI();

        mPresenter = new GuokrDetailPresenter(this);
        mPresenter.loadData(mResultBean);
    }

    private void initUI(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showData(GuokrDetailBean bean) {
        MyWindowManager.hideLoading();
        String content = bean.getResult().get(0).getContent();
        String title = bean.getResult().get(0).getTitle();
        String author = bean.getResult().get(0).getAuthor();
        String time = TimeUtils.getTimeByFormat(new Long(bean.getResult().get(0).getDate_picked())*1000,"yyyy-MM-dd HH:MM");
        List<String> list = GuokrStringUtils.splitHtml(content);
        list.add(0,"<title>"+title+"</title>");
        list.add(1,"<time>"+time+"\t\t"+author+"</time>");
        GuokrDetailAdapter adapter = new GuokrDetailAdapter(list);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public void onRefreshClick() {
        super.onRefreshClick();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
