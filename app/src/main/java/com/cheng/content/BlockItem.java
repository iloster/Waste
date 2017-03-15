package com.cheng.content;

/**
 * Created by dev on 2017/2/6.
 */

public class BlockItem {

//    private int sort; //位置
    private String name; //名字
    private int icon; //图片 路径
    private int id;

    public BlockItem(int id,String name,int icon){
        this.name = name;
        this.icon = icon;
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setIcon(int icon){
        this.icon = icon;
    }

    public int getIcon(){
        return this.icon;
    }
}
