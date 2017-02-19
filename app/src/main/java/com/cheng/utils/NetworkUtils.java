package com.cheng.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;

import com.cheng.waste.WasteApplication;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import static android.net.TrafficStats.UNSUPPORTED;

/**
 * Created by dev on 2017/2/19.
 */

public class NetworkUtils {

    /**
     * 获取下载流量 某个应用的网络流量数据保存在系统的/proc/uid_stat/$UID/tcp_rcv | tcp_snd文件中
     */
    public static long getRcvTraffic() {
        long rcvTraffic = -1; // 下载流量
        if(TrafficStats.getTotalRxBytes()!=UNSUPPORTED){
            return TrafficStats.getTotalRxBytes();
        }
        //1.获取一个包管理器。
        PackageManager pm = WasteApplication.getInstance().getPackageManager();
        //2.遍历手机操作系统 获取所有的应用程序的uid
        List<ApplicationInfo> appliactaionInfos = pm.getInstalledApplications(0);
        for(ApplicationInfo applicationInfo : appliactaionInfos){
            int uid = applicationInfo.uid;    // 获得软件uid
            rcvTraffic = rcvTraffic + getRcvTrafficByUid(uid);
        }
        return rcvTraffic;
    }

    public static long getSndTraffic(){
        long sndTraffic = -1;
        if(TrafficStats.getTotalRxBytes()!=UNSUPPORTED){
            return TrafficStats.getTotalRxBytes();
        }
        PackageManager pm = WasteApplication.getInstance().getPackageManager();
        List<ApplicationInfo> applicationInfos = pm.getInstalledApplications(0);
        for(ApplicationInfo applicationInfo:applicationInfos){
            int uid = applicationInfo.uid;
            sndTraffic = sndTraffic + getSndTrafficByUid(uid);
        }
        return sndTraffic;
    }

    public static long getRcvTrafficByUid(int uid){
        long rcvTraffic = -1;
        if(TrafficStats.getUidRxBytes(uid)!=UNSUPPORTED){
            return TrafficStats.getUidRxBytes(uid);
        }
        RandomAccessFile rafRcv = null, rafSnd = null; // 用于访问数据记录文件
        String rcvPath = "/proc/uid_stat/" + uid + "/tcp_rcv";
        try {
            rafRcv = new RandomAccessFile(rcvPath, "r");
            rcvTraffic = Long.parseLong(rafRcv.readLine()); // 读取流量统计
            LogUtils.v("rcvTraffic","rcvTraffic:"+rcvTraffic);
        } catch (FileNotFoundException e) {
            rcvTraffic = UNSUPPORTED;
            LogUtils.v("rcvTraffic","rcvTraffic file not found:"+e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.v("rcvTraffic","rcvTraffic1:"+e.toString());
        } finally {
            try {
                if (rafRcv != null)
                    rafRcv.close();
                if (rafSnd != null)
                    rafSnd.close();
            } catch (IOException e) {
            }
        }
        return rcvTraffic;
    }


    public static long getSndTrafficByUid(int uid){
        long sndTraffic = -1;
        if(TrafficStats.getUidTxBytes(uid)!=UNSUPPORTED){
            return TrafficStats.getUidTxBytes(uid);
        }
        RandomAccessFile rafRcv = null, rafSnd = null; // 用于访问数据记录文件
        String sndPath = "/proc/uid_stat/" + uid + "/tcp_send";
        try {
            rafSnd = new RandomAccessFile(sndPath, "r");
            sndTraffic = Long.parseLong(rafRcv.readLine()); // 读取流量统计
            LogUtils.v("NetworkUtils","sndTraffic:"+sndTraffic);
        } catch (FileNotFoundException e) {
            sndTraffic = UNSUPPORTED;
            LogUtils.v("NetworkUtils","sndTraffic file not found:"+e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.v("NetworkUtils","sndTraffic:"+e.toString());
        } finally {
            try {
                if (rafRcv != null)
                    rafSnd.close();
                if (rafSnd != null)
                    rafSnd.close();
            } catch (IOException e) {
            }
        }
        return sndTraffic;
    }
}
