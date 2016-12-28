package com.cheng.waste;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.cheng.db.DaoMaster;
import com.cheng.db.DaoSession;

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
    }

    private void initDB(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DATABASE_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
}
