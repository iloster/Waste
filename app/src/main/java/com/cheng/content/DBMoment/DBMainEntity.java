package com.cheng.content.DBMoment;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cheng on 2017/1/6.
 */
@Entity
public class DBMainEntity {
    @Id(autoincrement = true)
    private Long id;
    private String time;
    private String ret;
    @Generated(hash = 1969158347)
    public DBMainEntity(Long id, String time, String ret) {
        this.id = id;
        this.time = time;
        this.ret = ret;
    }
    @Generated(hash = 2038242563)
    public DBMainEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getRet() {
        return this.ret;
    }
    public void setRet(String ret) {
        this.ret = ret;
    }
}
