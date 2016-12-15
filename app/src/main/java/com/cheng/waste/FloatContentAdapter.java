package com.cheng.waste;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheng.utils.LogUtils;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by cheng on 2016/12/13.
 */

public class FloatContentAdapter extends PagerAdapter {
    private String TAG = "FloatContentAdapter";
    private List<View> mListView;
    private Context mContext;
    public FloatContentAdapter(Context context, List<View> listView) {
        mListView = listView;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mListView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View curView = mListView.get(position%getCount());
//        TextView text = (TextView) curView.findViewById(R.id.contentTxt);
//        text.setText(position);
        LogUtils.v(TAG,"instantiateItem:"+position);
        container.addView(curView);
        return mListView.get(position%getCount());
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LogUtils.v(TAG,"destroyItem");
        container.removeView(mListView.get(position % mListView.size()));
    }
}
