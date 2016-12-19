package com.cheng.bean;

import java.util.List;

/**
 * Created by dev on 2016/12/16.
 */

public class ArticleBean {

    /**
     * data : {"id":2290,"uuid":"6a6cda968c7b4d8f82e1df31e21f9315","author":{"id":381,"pen_name":"王xx","avatar":"http://cdn.yue.fm/a324a983-7971-4847-9cb3-8ddb870c114d.jpg-icon128","tags":[],"intro":"Fanqiao Wang<br>\r\n\r\n\r\n请关注微信公众号：sealandfriends（全是海豹）<br>\r\n\r\n合作请邮件： <br>\r\n \r\ninfo@fanqiaowang.com<br>\r\n\r\n\r\n作品集：<br>\r\nhttp://fanqiaowang.com<br>\r\n"},"title":"海豹漫画｜艰难的决定","excerpt":"大家好，我终于开始画海豹漫画啦，以后还会画更多，争取更新得规律起来！\u2026\u2026","content":"<div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/0a8b75cb-e4fb-4443-b6aa-368587501319.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/bdb9bc33-6145-45ba-8bbf-c73ca93d69e2.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/53ea98c0-6829-4629-a8e4-9b9c17634d7b.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/35496832-465e-4ff8-9b6d-4006ea960276.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/1867ca82-58de-4c21-822c-684782ec3975.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/7a72e9a3-ca35-4833-93ae-b741de3306ef.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/c57d22b7-aee9-4962-ab4e-a755667be255.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/f100dcf8-d106-41ec-9984-100bac0f7e68.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/b8986d3e-9a20-4e55-a26d-4708c18aeae2.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/654d148e-1de1-492c-9070-446326bad96b.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/82b4a47a-e5dd-4878-a8d0-b98844aefa27.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/1bba27a5-844f-4940-84d5-5f21b00c4fe0.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/e724a331-08c1-4437-b9ea-b7892cbc38ee.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/783d1bb2-cc92-4bce-9650-04e4165ac998.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/558b5ba1-5724-4362-afc8-0ecdd19c95ff.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/69b1e128-5f3c-4ec2-aa17-5d1f589a4188.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/67f1e068-ed2e-42c4-b134-9c2a5c8a0606.jpg\"><\/figure><\/div><div class=\"medium-insert-images\"><figure><img src=\"http://cdn.yue.fm/349c384b-6ba6-40f0-aa6c-b8fba68d913b.jpg\"><\/figure><\/div><p>大家好，我终于开始画海豹漫画啦，以后还会画更多，争取更新得规律起来！<\/p>","read_count":75,"liked_count":4,"comments_count":0,"is_liked":false,"tags":[{"id":19,"content":"漫画"}],"url":"http://www.yue.fm/article/6a6cda968c7b4d8f82e1df31e21f9315","scrolled":false,"progress":0,"created_at":"2016-09-18 13:54:07","updated_at":"2016-09-23 16:05:39","published_at":""}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2290
         * uuid : 6a6cda968c7b4d8f82e1df31e21f9315
         * author : {"id":381,"pen_name":"王xx","avatar":"http://cdn.yue.fm/a324a983-7971-4847-9cb3-8ddb870c114d.jpg-icon128","tags":[],"intro":"Fanqiao Wang<br>\r\n\r\n\r\n请关注微信公众号：sealandfriends（全是海豹）<br>\r\n\r\n合作请邮件： <br>\r\n \r\ninfo@fanqiaowang.com<br>\r\n\r\n\r\n作品集：<br>\r\nhttp://fanqiaowang.com<br>\r\n"}
         * title : 海豹漫画｜艰难的决定
         * excerpt : 大家好，我终于开始画海豹漫画啦，以后还会画更多，争取更新得规律起来！……
         * content : <div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/0a8b75cb-e4fb-4443-b6aa-368587501319.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/bdb9bc33-6145-45ba-8bbf-c73ca93d69e2.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/53ea98c0-6829-4629-a8e4-9b9c17634d7b.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/35496832-465e-4ff8-9b6d-4006ea960276.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/1867ca82-58de-4c21-822c-684782ec3975.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/7a72e9a3-ca35-4833-93ae-b741de3306ef.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/c57d22b7-aee9-4962-ab4e-a755667be255.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/f100dcf8-d106-41ec-9984-100bac0f7e68.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/b8986d3e-9a20-4e55-a26d-4708c18aeae2.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/654d148e-1de1-492c-9070-446326bad96b.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/82b4a47a-e5dd-4878-a8d0-b98844aefa27.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/1bba27a5-844f-4940-84d5-5f21b00c4fe0.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/e724a331-08c1-4437-b9ea-b7892cbc38ee.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/783d1bb2-cc92-4bce-9650-04e4165ac998.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/558b5ba1-5724-4362-afc8-0ecdd19c95ff.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/69b1e128-5f3c-4ec2-aa17-5d1f589a4188.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/67f1e068-ed2e-42c4-b134-9c2a5c8a0606.jpg"></figure></div><div class="medium-insert-images"><figure><img src="http://cdn.yue.fm/349c384b-6ba6-40f0-aa6c-b8fba68d913b.jpg"></figure></div><p>大家好，我终于开始画海豹漫画啦，以后还会画更多，争取更新得规律起来！</p>
         * read_count : 75
         * liked_count : 4
         * comments_count : 0
         * is_liked : false
         * tags : [{"id":19,"content":"漫画"}]
         * url : http://www.yue.fm/article/6a6cda968c7b4d8f82e1df31e21f9315
         * scrolled : false
         * progress : 0
         * created_at : 2016-09-18 13:54:07
         * updated_at : 2016-09-23 16:05:39
         * published_at :
         */

        private int id;
        private String uuid;
        private AuthorBean author;
        private String title;
        private String excerpt;
        private String content;
        private int read_count;
        private int liked_count;
        private int comments_count;
        private boolean is_liked;
        private String url;
        private boolean scrolled;
        private int progress;
        private String created_at;
        private String updated_at;
        private String published_at;
        private List<TagsBean> tags;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getExcerpt() {
            return excerpt;
        }

        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getRead_count() {
            return read_count;
        }

        public void setRead_count(int read_count) {
            this.read_count = read_count;
        }

        public int getLiked_count() {
            return liked_count;
        }

        public void setLiked_count(int liked_count) {
            this.liked_count = liked_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isIs_liked() {
            return is_liked;
        }

        public void setIs_liked(boolean is_liked) {
            this.is_liked = is_liked;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isScrolled() {
            return scrolled;
        }

        public void setScrolled(boolean scrolled) {
            this.scrolled = scrolled;
        }

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getPublished_at() {
            return published_at;
        }

        public void setPublished_at(String published_at) {
            this.published_at = published_at;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class AuthorBean {
            /**
             * id : 381
             * pen_name : 王xx
             * avatar : http://cdn.yue.fm/a324a983-7971-4847-9cb3-8ddb870c114d.jpg-icon128
             * tags : []
             * intro : Fanqiao Wang<br>


             请关注微信公众号：sealandfriends（全是海豹）<br>

             合作请邮件： <br>

             info@fanqiaowang.com<br>


             作品集：<br>
             http://fanqiaowang.com<br>

             */

            private int id;
            private String pen_name;
            private String avatar;
            private String intro;
            private List<?> tags;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPen_name() {
                return pen_name;
            }

            public void setPen_name(String pen_name) {
                this.pen_name = pen_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }

        public static class TagsBean {
            /**
             * id : 19
             * content : 漫画
             */

            private int id;
            private String content;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
