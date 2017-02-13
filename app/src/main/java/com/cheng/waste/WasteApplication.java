package com.cheng.waste;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatDelegate;

import com.cheng.config.Constants;
import com.cheng.db.DaoMaster;
import com.cheng.db.DaoSession;
import com.cheng.utils.DeviceUtils;
import com.cheng.utils.SpUtils;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by cheng on 2016/12/29.
 */

public class WasteApplication extends Application {
    private static WasteApplication instance;
    public DaoSession daoSession;
    private String DATABASE_NAME = "waste.db";
    public static WasteApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;
        //加入内存泄漏检测机制
        initLeakCanary();
        //加入Bugly统计
//        initBugly();
        initDB();
        AppCompatDelegate.setDefaultNightMode(SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)?AppCompatDelegate.MODE_NIGHT_YES:AppCompatDelegate.MODE_NIGHT_NO);
    }

    private void initLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }


    private void initDB(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private void initBugly(){
        //正式为false ，测试环境为true
        Bugly.init(getApplicationContext(), "1be8278f1a", true);
    }
}
