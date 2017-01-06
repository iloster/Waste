package com.cheng.content.DBMoment;

import com.cheng.db.DBMainEntityDao;
import com.cheng.waste.WasteApplication;

import java.util.List;

/**
 * Created by cheng on 2017/1/6.
 */

public class DBDbUtil {

    public static void save(String time,String ret){
        DBMainEntity dbMainEntity = new DBMainEntity(null,time,ret);
        WasteApplication.getInstance().daoSession.getDBMainEntityDao().insert(dbMainEntity);
    }

    public static List<DBMainEntity> get(String time){
        return WasteApplication.getInstance().daoSession.getDBMainEntityDao().queryBuilder()
                .where(DBMainEntityDao.Properties.Time.eq(time))
                .build().list();
    }
}
