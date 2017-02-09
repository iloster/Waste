package com.cheng.waste;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;

import com.cheng.utils.DeviceUtils;
import com.cheng.utils.LogUtils;

import java.util.Timer;
import java.util.TimerTask;

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
        LogUtils.v(TAG, "=======onCreate======");

        showFloatIcon();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        LogUtils.v(TAG, "======onStart======");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v(TAG, "======onDestroy======");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.v(TAG, "======onUnbind======");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }


    public void showFloatIcon() {
        MyWindowManager.createFloatIconView(getApplicationContext());
    }

    public void removeWaste(){
        MyWindowManager.removeFloatContentView(WasteApplication.getInstance());
        MyWindowManager.reomveFloatIconView(WasteApplication.getInstance());
    }
}


