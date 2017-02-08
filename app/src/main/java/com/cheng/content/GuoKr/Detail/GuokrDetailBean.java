package com.cheng.content.GuoKr.Detail;

import java.util.List;

/**
 * Created by dev on 2017/2/8.
 */

public class GuokrDetailBean {

    /**
     * now : 2017-02-08T16:35:02.785783+08:00
     * ok : true
     * result : [{"link_v2_sync_img":"http://jingxuan.guokr.com/pick/v2/78450/sync/","source_name":"果壳日历","video_url":"","current_user_has_collected":false,"likings_count":75,"images":["http://3.im.guokr.com/2XOFBYqFyFkxI4XGY43VOsNWfAUrXexvOQQsqfaywtDAAwAATAIAAFBO.png"],"video_duration":null,"id":78450,"category":"calendar","style":"calendar","title":"2月8日，\u201c科幻小说之父\u201d凡尔纳的生日","content":"<p>1828年的今天，科幻小说之父儒勒·凡尔纳诞生。他一生写了六十多部大大小小的科幻小说，总题为《在已知和未知的世界漫游》。如今，凡尔纳想象中的潜水艇、登月等事物都已成真。你看过几本凡尔纳的小说？你最喜欢的是哪一本？<\/p>","source_data":{"image":"http://1.im.guokr.com/VY8V8kDDMj0gIX3ekpdauZDShgEgciXqL-J-0mXOAYQ8AAAAPAAAAFBO.png","title":"果壳小伙伴","id":"None","key":"果壳日历","summary":"果壳精选欢迎自媒体入驻，Email联系media@guokr.com，请注明\u201c果壳精选自媒体合作\u201d。"},"headline_img_tb":"","link_v2":"http://jingxuan.guokr.com/pick/v2/78450/","date_picked":1486512060,"is_top":false,"link":"http://jingxuan.guokr.com/pick/78450/","headline_img":"","replies_count":null,"current_user_has_liked":false,"page_source":"http://jingxuan.guokr.com/pick/78450/?ad=1","author":"","summary":"1828年的今天，科幻小说之父儒勒·凡尔纳诞生。他一生写了六十多部大大小小的科幻小说，总题为《在已知和未知的世界漫游》。如今，凡尔","source":"calendar","reply_root_id":0,"date_created":1486455045}]
     */

    private String now;
    private boolean ok;
    private List<ResultBean> result;

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * link_v2_sync_img : http://jingxuan.guokr.com/pick/v2/78450/sync/
         * source_name : 果壳日历
         * video_url :
         * current_user_has_collected : false
         * likings_count : 75
         * images : ["http://3.im.guokr.com/2XOFBYqFyFkxI4XGY43VOsNWfAUrXexvOQQsqfaywtDAAwAATAIAAFBO.png"]
         * video_duration : null
         * id : 78450
         * category : calendar
         * style : calendar
         * title : 2月8日，“科幻小说之父”凡尔纳的生日
         * content : <p>1828年的今天，科幻小说之父儒勒·凡尔纳诞生。他一生写了六十多部大大小小的科幻小说，总题为《在已知和未知的世界漫游》。如今，凡尔纳想象中的潜水艇、登月等事物都已成真。你看过几本凡尔纳的小说？你最喜欢的是哪一本？</p>
         * source_data : {"image":"http://1.im.guokr.com/VY8V8kDDMj0gIX3ekpdauZDShgEgciXqL-J-0mXOAYQ8AAAAPAAAAFBO.png","title":"果壳小伙伴","id":"None","key":"果壳日历","summary":"果壳精选欢迎自媒体入驻，Email联系media@guokr.com，请注明\u201c果壳精选自媒体合作\u201d。"}
         * headline_img_tb :
         * link_v2 : http://jingxuan.guokr.com/pick/v2/78450/
         * date_picked : 1486512060
         * is_top : false
         * link : http://jingxuan.guokr.com/pick/78450/
         * headline_img :
         * replies_count : null
         * current_user_has_liked : false
         * page_source : http://jingxuan.guokr.com/pick/78450/?ad=1
         * author :
         * summary : 1828年的今天，科幻小说之父儒勒·凡尔纳诞生。他一生写了六十多部大大小小的科幻小说，总题为《在已知和未知的世界漫游》。如今，凡尔
         * source : calendar
         * reply_root_id : 0
         * date_created : 1486455045
         */

        private String link_v2_sync_img;
        private String source_name;
        private String video_url;
        private boolean current_user_has_collected;
        private int likings_count;
        private Object video_duration;
        private int id;
        private String category;
        private String style;
        private String title;
        private String content;
        private SourceDataBean source_data;
        private String headline_img_tb;
        private String link_v2;
        private int date_picked;
        private boolean is_top;
        private String link;
        private String headline_img;
        private Object replies_count;
        private boolean current_user_has_liked;
        private String page_source;
        private String author;
        private String summary;
        private String source;
        private int reply_root_id;
        private int date_created;
        private List<String> images;

        public String getLink_v2_sync_img() {
            return link_v2_sync_img;
        }

        public void setLink_v2_sync_img(String link_v2_sync_img) {
            this.link_v2_sync_img = link_v2_sync_img;
        }

        public String getSource_name() {
            return source_name;
        }

        public void setSource_name(String source_name) {
            this.source_name = source_name;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public boolean isCurrent_user_has_collected() {
            return current_user_has_collected;
        }

        public void setCurrent_user_has_collected(boolean current_user_has_collected) {
            this.current_user_has_collected = current_user_has_collected;
        }

        public int getLikings_count() {
            return likings_count;
        }

        public void setLikings_count(int likings_count) {
            this.likings_count = likings_count;
        }

        public Object getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(Object video_duration) {
            this.video_duration = video_duration;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public SourceDataBean getSource_data() {
            return source_data;
        }

        public void setSource_data(SourceDataBean source_data) {
            this.source_data = source_data;
        }

        public String getHeadline_img_tb() {
            return headline_img_tb;
        }

        public void setHeadline_img_tb(String headline_img_tb) {
            this.headline_img_tb = headline_img_tb;
        }

        public String getLink_v2() {
            return link_v2;
        }

        public void setLink_v2(String link_v2) {
            this.link_v2 = link_v2;
        }

        public int getDate_picked() {
            return date_picked;
        }

        public void setDate_picked(int date_picked) {
            this.date_picked = date_picked;
        }

        public boolean isIs_top() {
            return is_top;
        }

        public void setIs_top(boolean is_top) {
            this.is_top = is_top;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getHeadline_img() {
            return headline_img;
        }

        public void setHeadline_img(String headline_img) {
            this.headline_img = headline_img;
        }

        public Object getReplies_count() {
            return replies_count;
        }

        public void setReplies_count(Object replies_count) {
            this.replies_count = replies_count;
        }

        public boolean isCurrent_user_has_liked() {
            return current_user_has_liked;
        }

        public void setCurrent_user_has_liked(boolean current_user_has_liked) {
            this.current_user_has_liked = current_user_has_liked;
        }

        public String getPage_source() {
            return page_source;
        }

        public void setPage_source(String page_source) {
            this.page_source = page_source;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getReply_root_id() {
            return reply_root_id;
        }

        public void setReply_root_id(int reply_root_id) {
            this.reply_root_id = reply_root_id;
        }

        public int getDate_created() {
            return date_created;
        }

        public void setDate_created(int date_created) {
            this.date_created = date_created;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public static class SourceDataBean {
            /**
             * image : http://1.im.guokr.com/VY8V8kDDMj0gIX3ekpdauZDShgEgciXqL-J-0mXOAYQ8AAAAPAAAAFBO.png
             * title : 果壳小伙伴
             * id : None
             * key : 果壳日历
             * summary : 果壳精选欢迎自媒体入驻，Email联系media@guokr.com，请注明“果壳精选自媒体合作”。
             */

            private String image;
            private String title;
            private String id;
            private String key;
            private String summary;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }
        }
    }
}
