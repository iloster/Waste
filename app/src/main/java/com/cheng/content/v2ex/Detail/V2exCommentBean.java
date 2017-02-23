package com.cheng.content.v2ex.Detail;

/**
 * Created by cheng on 2017/1/2.
 */

public class V2exCommentBean {

    /**
     * id : 3886724
     * thanks : 0
     * content : 但是… ie 只支持部分新特性呀。
     * content_rendered : 但是… ie 只支持部分新特性呀。
     * member : {"id":150651,"username":"Vogan","tagline":"","avatar_mini":"//cdn.v2ex.co/avatar/51cc/ceba/150651_mini.png?m=1452864173","avatar_normal":"//cdn.v2ex.co/avatar/51cc/ceba/150651_normal.png?m=1452864173","avatar_large":"//cdn.v2ex.co/avatar/51cc/ceba/150651_large.png?m=1452864173"}
     * created : 1482641183
     * last_modified : 1482641183
     */

    private int id;
    private int thanks;
    private String content;
    private String content_rendered;
    /**
     * id : 150651
     * username : Vogan
     * tagline :
     * avatar_mini : //cdn.v2ex.co/avatar/51cc/ceba/150651_mini.png?m=1452864173
     * avatar_normal : //cdn.v2ex.co/avatar/51cc/ceba/150651_normal.png?m=1452864173
     * avatar_large : //cdn.v2ex.co/avatar/51cc/ceba/150651_large.png?m=1452864173
     */

    private MemberBean member;
    private int created;
    private int last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThanks() {
        return thanks;
    }

    public void setThanks(int thanks) {
        this.thanks = thanks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public static class MemberBean {
        private int id;
        private String username;
        private String tagline;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public void setAvatar_normal(String avatar_normal) {
            this.avatar_normal = avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }
    }
}
