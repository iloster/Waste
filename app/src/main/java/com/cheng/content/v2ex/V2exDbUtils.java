package com.cheng.content.v2ex;

import com.cheng.content.v2ex.Main.V2exMainBean;
import com.cheng.db.V2exEntityDao;
import com.cheng.utils.LogUtils;
import com.cheng.waste.WasteApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheng on 2016/12/29.
 */

public class V2exDbUtils {
    private static String TAG = "V2exDbUtils";
    public static List<V2exEntity> save(int type,List<V2exMainBean> v2exMainBeanList){
        List<V2exEntity> list = new ArrayList<V2exEntity>();
        for(int i = 0;i<v2exMainBeanList.size();i++) {
            V2exMainBean v = v2exMainBeanList.get(i);
            if(!isInDb(v.getId(),type)) {
                V2exEntity v2ExEntity = new V2exEntity(null, new Long(v.getId()), v.getTitle(),
                        v.getUrl(), v.getContent(), v.getContent_rendered(), v.getReplies(), v.getMember().getId(), v.getMember().getUsername(),
                        v.getMember().getTagline(), v.getMember().getAvatar_mini(), v.getMember().getAvatar_normal(), v.getMember().getAvatar_large(),
                        String.valueOf(v.getNode().getId()), v.getNode().getTitle(), v.getNode().getTitle_alternative(), v.getNode().getUrl(), String.valueOf(v.getNode().getTopics()),
                        v.getNode().getAvatar_mini(), v.getNode().getAvatar_normal(), v.getNode().getAvatar_large(), v.getCreated(), v.getLast_modified(), v.getLast_touched(), type);
                list.add(v2ExEntity);

                WasteApplication.getInstance().daoSession.getV2exEntityDao().insert(v2ExEntity);
            }
        }
        return list;
    }

    public static List<V2exEntity> get(int type){
        return WasteApplication.getInstance().daoSession.getV2exEntityDao().queryBuilder()
                .where(V2exEntityDao.Properties.Node_type.eq(type))
                .orderDesc(V2exEntityDao.Properties.Created)
                .limit(10)
                .build()
                .list();
    }

    public static void delete(){
         WasteApplication.getInstance().daoSession.getV2exEntityDao().deleteAll();
    }

    public static boolean isInDb(long id,int type){
        long count = WasteApplication.getInstance().daoSession.getV2exEntityDao().queryBuilder()
                .where(V2exEntityDao.Properties.Id.eq(id),V2exEntityDao.Properties.Node_type.eq(type))
                .count();
        LogUtils.v(TAG,"isInDb  id:"+id+"| type:"+type+"| count:"+count);
        if(count>0){

            return true;
        }else{
            return false;
        }
    }
}
