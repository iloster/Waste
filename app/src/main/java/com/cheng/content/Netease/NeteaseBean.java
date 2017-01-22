package com.cheng.content.Netease;

import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteaseBean {


    /**
     * title : 金正恩新年首次视察部队 赠送士兵步枪
     * digest :
     * source : 网易原创
     * postid : PHOT2416G000100A
     * imgsrc : http://cms-bucket.nosdn.127.net/79debe158b2c452984e4695897a6434820170119204447.jpeg
     * ptime : 2017-01-19 20:45:06
     * boardid : photoview_bbs
     * photoid : 2229456
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/1bde1126c0a544609663f4430f14a19220170119204450.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/2f31d27490144ff5bf2fd6b742cd9d8120170119204448.jpeg"}]
     * posttype : 2
     */

    private String title;
    private String digest;
    private String source;
    private String postid;
    private String imgsrc;
    private String ptime;
    private String boardid;
    private String photoid;
    private int posttype;
    /**
     * imgsrc : http://cms-bucket.nosdn.127.net/1bde1126c0a544609663f4430f14a19220170119204450.jpeg
     */

    private List<ImgextraBean> imgextra;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid;
    }

    public int getPosttype() {
        return posttype;
    }

    public void setPosttype(int posttype) {
        this.posttype = posttype;
    }

    public List<ImgextraBean> getImgextra() {
        return imgextra;
    }

    public void setImgextra(List<ImgextraBean> imgextra) {
        this.imgextra = imgextra;
    }

    public static class ImgextraBean {
        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
