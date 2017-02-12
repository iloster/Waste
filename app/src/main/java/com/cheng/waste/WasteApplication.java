package com.cheng.waste;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatDelegate;

import com.cheng.config.Constants;
import com.cheng.db.DaoMaster;
import com.cheng.db.DaoSession;
import com.cheng.utils.SpUtils;
import com.squareup.leakcanary.LeakCanary;

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
        //加入内存泄漏检测机制
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        instance = this;
        initDB();
        AppCompatDelegate.setDefaultNightMode(SpUtils.getBoolean(Constants.NIGHTSHIFT_SP_KEY,false)?AppCompatDelegate.MODE_NIGHT_YES:AppCompatDelegate.MODE_NIGHT_NO);
    }

    private void initDB(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

}
