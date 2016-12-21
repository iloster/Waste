package com.cheng.waste;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.cheng.utils.LogUtils;

public class FloatService extends Service {

    private final String TAG = "FloatService";

    public FloatService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
//        super.onCreate();
        LogUtils.v(TAG, "onCreate");
        showFloatIcon();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtils.v(TAG, "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v(TAG, "onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.v(TAG, "onUnbind");
        return super.onUnbind(intent);
    }


    public void showFloatIcon() {
        MyWindowManager.createFloatIconView(getApplicationContext());
    }


}


