package com.cheng.content.Netease;

import android.content.Context;
import android.view.LayoutInflater;

import com.cheng.http.CallBack;
import com.cheng.http.HttpUtil;
import com.cheng.utils.LogUtils;
import com.cheng.view.BaseSubView;
import com.cheng.view.MyWebViewEx;
import com.cheng.waste.R;
import com.cheng.waste.WasteApplication;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by dev on 2017/1/18.
 */

public class NeteaseDetail extends BaseSubView {

    private String TAG = "NeteaseDetail";
    private Context mContext;
    private MyWebViewEx mWebView;
    private NeteaseBean mNeteaseBean;
    private NeteaseDetailBean mNeteaseDetailBean;
    public NeteaseDetail(NeteaseBean bean) {
        super(WasteApplication.getInstance());
        mContext = WasteApplication.getInstance();
        mNeteaseBean = bean;
        LayoutInflater.from(mContext).inflate(R.layout.content_netease_detail,this);

        initUI();
        loadData();
    }

    private void initUI(){
        mWebView = (MyWebViewEx)findViewById(R.id.webView);
    }

    private void loadData(){
        String url = "";
        if(mNeteaseBean.getPosttype() == NeteaseConstant.TYPE_PHOTO){
            url = String.format(NeteaseConstant.PHOTO_URL,mNeteaseBean.getPhotoid());
        }else {
            url = String.format(NeteaseConstant.ARTICLE_URL, mNeteaseBean.getPostid());
        }
        HttpUtil.getInstance().enqueueEx(url, new CallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String ret) {
                Gson gson = new Gson();
                if (mNeteaseBean.getPosttype() == NeteaseConstant.TYPE_PHOTO) {
                    NeteaseDetailPhotoBean bean = gson.fromJson(ret,NeteaseDetailPhotoBean.class);
                    showData(bean);
                } else{
                    mNeteaseDetailBean = gson.fromJson(ret, NeteaseDetailBean.class);
                    showData(mNeteaseDetailBean);
                }
            }
        });
    }

    private void showData(NeteaseDetailBean neteaseDetailBean){
        String html = NeteaseConstant.HTML_STR.replace("{body}",handlerHtml()).replace("{title}",mNeteaseDetailBean.getTitle()).replace("{source}",mNeteaseDetailBean.getSource()+"  "+mNeteaseDetailBean.getPtime());
        LogUtils.v(TAG,"showData:"+html);
        mWebView.loadData(html);
    }

    public void showData(NeteaseDetailPhotoBean bean){
        String html = NeteaseConstant.HTML_STR.replace("{title}",bean.getTitle()).replace("{source}",bean.getSource()+"  "+bean.getPtime()).replace("{body}",handlerPhoto(bean));
        mWebView.loadData(html);
    }
    /**
     * 处理html
     */
    private String handlerHtml(){

        String bodyStr = mNeteaseDetailBean.getBody();
        LogUtils.v(TAG,"handlerHtml:"+bodyStr);
        for (int i = 0 ; i<mNeteaseDetailBean.getImg().size();i++){
            String str1 = mNeteaseDetailBean.getImg().get(i).getRef();
            String str2 = "<img src=\""+mNeteaseDetailBean.getImg().get(i).getSrc()+"\"/>";
            bodyStr = bodyStr.replaceAll(str1,str2);
        }
        return bodyStr;
    }

    public String handlerPhoto(NeteaseDetailPhotoBean bean){
        List<NeteaseDetailPhotoBean.PhotosBean> photosBeanList = bean.getPhotos();
        String str = "";
        for(int i = 0;i<photosBeanList.size();i++){
            NeteaseDetailPhotoBean.PhotosBean b = photosBeanList.get(i);
            String note = b.getNote();
            String url = b.getImgurl();
            str += "<img src=\""+url+"\"/><p>"+note+"</p>";
        }
        return str;
    }
}
