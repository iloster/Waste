package com.cheng.content.v2ex;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by cheng on 2016/12/28.
 */
@Entity
public class V2exEntity {
    @Id(autoincrement = true)
    private Long vid;
    private long id;
    private String title;
    private String url;
    private String content;
    private String content_rendered;
    private int replies;
    private long userId;
    private String username;
    private String tagline;
    private String avatar_mini;
    private String avatar_normal;
    private String avatar_large;
    private String node_id;
    private String node_name;
    private String node_title_alternative;
    private String node_url;
    private String node_topics;
    private String node_avatar_mini;
    private String node_avatar_normal;
    private String node_avatar_large;
    private long created;
    private long last_modified;
    private long last_touched;
    private int node_type;
    @Generated(hash = 1837906298)
    public V2exEntity(Long vid, long id, String title, String url, String content,
            String content_rendered, int replies, long userId, String username,
            String tagline, String avatar_mini, String avatar_normal,
            String avatar_large, String node_id, String node_name,
            String node_title_alternative, String node_url, String node_topics,
            String node_avatar_mini, String node_avatar_normal,
            String node_avatar_large, long created, long last_modified,
            long last_touched, int node_type) {
        this.vid = vid;
        this.id = id;
        this.title = title;
        this.url = url;
        this.content = content;
        this.content_rendered = content_rendered;
        this.replies = replies;
        this.userId = userId;
        this.username = username;
        this.tagline = tagline;
        this.avatar_mini = avatar_mini;
        this.avatar_normal = avatar_normal;
        this.avatar_large = avatar_large;
        this.node_id = node_id;
        this.node_name = node_name;
        this.node_title_alternative = node_title_alternative;
        this.node_url = node_url;
        this.node_topics = node_topics;
        this.node_avatar_mini = node_avatar_mini;
        this.node_avatar_normal = node_avatar_normal;
        this.node_avatar_large = node_avatar_large;
        this.created = created;
        this.last_modified = last_modified;
        this.last_touched = last_touched;
        this.node_type = node_type;
    }
    @Generated(hash = 1618468526)
    public V2exEntity() {
    }
    public Long getVid() {
        return this.vid;
    }
    public void setVid(Long vid) {
        this.vid = vid;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent_rendered() {
        return this.content_rendered;
    }
    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }
    public int getReplies() {
        return this.replies;
    }
    public void setReplies(int replies) {
        this.replies = replies;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTagline() {
        return this.tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public String getAvatar_mini() {
        return this.avatar_mini;
    }
    public void setAvatar_mini(String avatar_mini) {
        this.avatar_mini = avatar_mini;
    }
    public String getAvatar_normal() {
        return this.avatar_normal;
    }
    public void setAvatar_normal(String avatar_normal) {
        this.avatar_normal = avatar_normal;
    }
    public String getAvatar_large() {
        return this.avatar_large;
    }
    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }
    public String getNode_id() {
        return this.node_id;
    }
    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
    public String getNode_name() {
        return this.node_name;
    }
    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }
    public String getNode_title_alternative() {
        return this.node_title_alternative;
    }
    public void setNode_title_alternative(String node_title_alternative) {
        this.node_title_alternative = node_title_alternative;
    }
    public String getNode_url() {
        return this.node_url;
    }
    public void setNode_url(String node_url) {
        this.node_url = node_url;
    }
    public String getNode_topics() {
        return this.node_topics;
    }
    public void setNode_topics(String node_topics) {
        this.node_topics = node_topics;
    }
    public String getNode_avatar_mini() {
        return this.node_avatar_mini;
    }
    public void setNode_avatar_mini(String node_avatar_mini) {
        this.node_avatar_mini = node_avatar_mini;
    }
    public String getNode_avatar_normal() {
        return this.node_avatar_normal;
    }
    public void setNode_avatar_normal(String node_avatar_normal) {
        this.node_avatar_normal = node_avatar_normal;
    }
    public String getNode_avatar_large() {
        return this.node_avatar_large;
    }
    public void setNode_avatar_large(String node_avatar_large) {
        this.node_avatar_large = node_avatar_large;
    }
    public long getCreated() {
        return this.created;
    }
    public void setCreated(long created) {
        this.created = created;
    }
    public long getLast_modified() {
        return this.last_modified;
    }
    public void setLast_modified(long last_modified) {
        this.last_modified = last_modified;
    }
    public long getLast_touched() {
        return this.last_touched;
    }
    public void setLast_touched(long last_touched) {
        this.last_touched = last_touched;
    }
    public int getNode_type() {
        return this.node_type;
    }
    public void setNode_type(int node_type) {
        this.node_type = node_type;
    }
    
}
