package com.cheng.content.v2ex.Main;


/**
 * Created by dev on 2016/12/21.
 */
public class V2exMainBean {

    /**
     * id : 329083
     * title : 分享几个 Setapp 和即刻 3.0 邀请码
     * url : http://www.v2ex.com/t/329083
     * content : Setapp:

     1. https://setapp.com?inviteToken=900b5412-c2d5-11e6-addf-0a725144e551
     2. https://setapp.com?inviteToken=901ffad4-c2d5-11e6-9aeb-0a725144e551
     3. https://setapp.com?inviteToken=9033206e-c2d5-11e6-b91a-0a725144e551

     即刻 3.0 ：

     LQZ00M

     U9W144
     * content_rendered : <p>Setapp:</p>
     <ol>
     <li><a href="https://setapp.com?inviteToken=900b5412-c2d5-11e6-addf-0a725144e551" rel="nofollow">https://setapp.com?inviteToken=900b5412-c2d5-11e6-addf-0a725144e551</a></li>
     <li><a href="https://setapp.com?inviteToken=901ffad4-c2d5-11e6-9aeb-0a725144e551" rel="nofollow">https://setapp.com?inviteToken=901ffad4-c2d5-11e6-9aeb-0a725144e551</a></li>
     <li><a href="https://setapp.com?inviteToken=9033206e-c2d5-11e6-b91a-0a725144e551" rel="nofollow">https://setapp.com?inviteToken=9033206e-c2d5-11e6-b91a-0a725144e551</a></li>
     </ol>
     <p>即刻 3.0 ：</p>
     <p>LQZ00M</p>
     <p>U9W144</p>

     * replies : 109
     * member : {"id":118847,"username":"chroming","tagline":"","avatar_mini":"//cdn.v2ex.co/avatar/1c84/e767/118847_mini.png?m=1482287354","avatar_normal":"//cdn.v2ex.co/avatar/1c84/e767/118847_normal.png?m=1482287354","avatar_large":"//cdn.v2ex.co/avatar/1c84/e767/118847_large.png?m=1482287354"}
     * node : {"id":22,"name":"macos","title":"macOS","title_alternative":"macOS","url":"http://www.v2ex.com/go/macos","topics":9496,"avatar_mini":"//cdn.v2ex.co/navatar/b6d7/67d2/22_mini.png?m=1480728943","avatar_normal":"//cdn.v2ex.co/navatar/b6d7/67d2/22_normal.png?m=1480728943","avatar_large":"//cdn.v2ex.co/navatar/b6d7/67d2/22_large.png?m=1480728943"}
     * created : 1482287208
     * last_modified : 1482287208
     * last_touched : 1482303010
     */
    private int id;
    private String title;
    private String url;
    private String content;
    private String content_rendered;
    private int replies;
    private MemberBean member;
    private NodeBean node;
    private int created;
    private int last_modified;
    private int last_touched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public NodeBean getNode() {
        return node;
    }

    public void setNode(NodeBean node) {
        this.node = node;
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

    public int getLast_touched() {
        return last_touched;
    }

    public void setLast_touched(int last_touched) {
        this.last_touched = last_touched;
    }

    public static class MemberBean {
        /**
         * id : 118847
         * username : chroming
         * tagline :
         * avatar_mini : //cdn.v2ex.co/avatar/1c84/e767/118847_mini.png?m=1482287354
         * avatar_normal : //cdn.v2ex.co/avatar/1c84/e767/118847_normal.png?m=1482287354
         * avatar_large : //cdn.v2ex.co/avatar/1c84/e767/118847_large.png?m=1482287354
         */

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

    public static class NodeBean {
        /**
         * id : 22
         * name : macos
         * title : macOS
         * title_alternative : macOS
         * url : http://www.v2ex.com/go/macos
         * topics : 9496
         * avatar_mini : //cdn.v2ex.co/navatar/b6d7/67d2/22_mini.png?m=1480728943
         * avatar_normal : //cdn.v2ex.co/navatar/b6d7/67d2/22_normal.png?m=1480728943
         * avatar_large : //cdn.v2ex.co/navatar/b6d7/67d2/22_large.png?m=1480728943
         */

        private int id;
        private String name;
        private String title;
        private String title_alternative;
        private String url;
        private int topics;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_alternative() {
            return title_alternative;
        }

        public void setTitle_alternative(String title_alternative) {
            this.title_alternative = title_alternative;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTopics() {
            return topics;
        }

        public void setTopics(int topics) {
            this.topics = topics;
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