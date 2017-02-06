package com.cheng.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cheng.utils.LogUtils;
import com.cheng.waste.FloatService;

/**
 *
 * 监听开机广播，然后自启动应用
 * Created by dev on 2017/2/6.
 */

public class BootBroadcastReceiver extends BroadcastReceiver{
    private String TAG = "BootBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.v(TAG,"开机了~~~~");
        Intent i = new Intent(context, FloatService.class);
        context.startService(i);
    }
}
