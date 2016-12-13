package com.cheng.waste;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by cheng on 2016/12/13.
 */

public class FloatContentAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
