package com.cheng.common;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;

import com.cheng.utils.LogUtils;
import com.cheng.utils.NetworkUtils;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.OkHttpClient;

/**
 * Created by dev on 2017/2/19.
 */

public class NetworkDection {

    private static NetworkDection mInstance = null;
    private Handler mDelivery;
    private Timer mTimer;
    private int timeout = 1;
    private long mRcvTraffic = 0;
    private long mSndTraffic = 0;
    private NetworkInterface mInterface;
    public NetworkDection(NetworkInterface networkInterface){
        mDelivery = new Handler(Looper.getMainLooper());
        mInterface = networkInterface;
    }

//    public synchronized static NetworkDection getInstance(){
//        if(mInstance == null){
//            mInstance = new NetworkDection();
//        }
//        return mInstance;
//    }

    public void start(){
        mTimer = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                refreshTrafficSpeed();
            }
        };
        mTimer.schedule(t,1000,1000);
    }

    public void stop(){
        mTimer.purge();
        mTimer.cancel();
    }

    private long getRcvTrafficSpeed(){
        long curRcvTraffic = NetworkUtils.getRcvTraffic();
        long speed = curRcvTraffic - mRcvTraffic;
        mRcvTraffic = curRcvTraffic;
        if(mRcvTraffic == 0){
            return 0;
        }
        return speed;
    }
    private long getSndTrafficSpeed(){
        long curSndTraffic = NetworkUtils.getSndTraffic();
        long speed = curSndTraffic - mSndTraffic;
        mSndTraffic = curSndTraffic;
        if(mSndTraffic == 0){
            return 0;
        }
        return speed;
    }

    private void refreshTrafficSpeed(){
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                mInterface.refreshNetworkSpeed(getRcvTrafficSpeed(),getSndTrafficSpeed());
            }
        });
    }
}
