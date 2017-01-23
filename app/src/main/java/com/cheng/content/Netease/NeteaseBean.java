package com.cheng.content.Netease;

import java.util.List;

/**
 * Created by dev on 2017/1/17.
 */

public class NeteaseBean {


    /**
     * title : 看客特刊：八年白宫路 奥巴马时代落幕
     * digest :
     * source : 网易原创
     * postid : PHOT2410Q00013R7
     * imgsrc : http://cms-bucket.nosdn.127.net/aaca84f6fb4348c18bcb2db02fadf3ea20170120073427.jpeg
     * ptime : 2017-01-20 07:35:18
     * boardid : photoview_bbs
     * photoid : 2229274
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/9facacb8f09140bf9fa466affa382b0c20170120073426.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/17796960841e43e2be28de4766feb52b20170120073426.jpeg"}]
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
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/9facacb8f09140bf9fa466affa382b0c20170120073426.jpeg
         */

        private String imgsrc;

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }
    }
}
