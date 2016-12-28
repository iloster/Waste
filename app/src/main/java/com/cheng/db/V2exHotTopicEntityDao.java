package com.cheng.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.cheng.content.v2ex.V2exHotTopicEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "V2EX_HOT_TOPIC_ENTITY".
*/
public class V2exHotTopicEntityDao extends AbstractDao<V2exHotTopicEntity, Long> {

    public static final String TABLENAME = "V2EX_HOT_TOPIC_ENTITY";

    /**
     * Properties of entity V2exHotTopicEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Url = new Property(2, String.class, "url", false, "URL");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property Content_rendered = new Property(4, String.class, "content_rendered", false, "CONTENT_RENDERED");
        public final static Property Replies = new Property(5, int.class, "replies", false, "REPLIES");
        public final static Property UserId = new Property(6, long.class, "userId", false, "USER_ID");
        public final static Property Username = new Property(7, String.class, "username", false, "USERNAME");
        public final static Property Tagline = new Property(8, String.class, "tagline", false, "TAGLINE");
        public final static Property Avatar_mini = new Property(9, String.class, "avatar_mini", false, "AVATAR_MINI");
        public final static Property Avatar_normal = new Property(10, String.class, "avatar_normal", false, "AVATAR_NORMAL");
        public final static Property Avatar_large = new Property(11, String.class, "avatar_large", false, "AVATAR_LARGE");
        public final static Property Node_id = new Property(12, String.class, "node_id", false, "NODE_ID");
        public final static Property Node_name = new Property(13, String.class, "node_name", false, "NODE_NAME");
        public final static Property Node_title_alternative = new Property(14, String.class, "node_title_alternative", false, "NODE_TITLE_ALTERNATIVE");
        public final static Property Node_url = new Property(15, String.class, "node_url", false, "NODE_URL");
        public final static Property Node_topics = new Property(16, String.class, "node_topics", false, "NODE_TOPICS");
        public final static Property Node_avatar_mini = new Property(17, String.class, "node_avatar_mini", false, "NODE_AVATAR_MINI");
        public final static Property Node_avatar_normal = new Property(18, String.class, "node_avatar_normal", false, "NODE_AVATAR_NORMAL");
        public final static Property Node_avatar_large = new Property(19, String.class, "node_avatar_large", false, "NODE_AVATAR_LARGE");
        public final static Property Created = new Property(20, long.class, "created", false, "CREATED");
        public final static Property Last_modified = new Property(21, long.class, "last_modified", false, "LAST_MODIFIED");
        public final static Property Last_touched = new Property(22, long.class, "last_touched", false, "LAST_TOUCHED");
    }


    public V2exHotTopicEntityDao(DaoConfig config) {
        super(config);
    }
    
    public V2exHotTopicEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"V2EX_HOT_TOPIC_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"URL\" TEXT," + // 2: url
                "\"CONTENT\" TEXT," + // 3: content
                "\"CONTENT_RENDERED\" TEXT," + // 4: content_rendered
                "\"REPLIES\" INTEGER NOT NULL ," + // 5: replies
                "\"USER_ID\" INTEGER NOT NULL ," + // 6: userId
                "\"USERNAME\" TEXT," + // 7: username
                "\"TAGLINE\" TEXT," + // 8: tagline
                "\"AVATAR_MINI\" TEXT," + // 9: avatar_mini
                "\"AVATAR_NORMAL\" TEXT," + // 10: avatar_normal
                "\"AVATAR_LARGE\" TEXT," + // 11: avatar_large
                "\"NODE_ID\" TEXT," + // 12: node_id
                "\"NODE_NAME\" TEXT," + // 13: node_name
                "\"NODE_TITLE_ALTERNATIVE\" TEXT," + // 14: node_title_alternative
                "\"NODE_URL\" TEXT," + // 15: node_url
                "\"NODE_TOPICS\" TEXT," + // 16: node_topics
                "\"NODE_AVATAR_MINI\" TEXT," + // 17: node_avatar_mini
                "\"NODE_AVATAR_NORMAL\" TEXT," + // 18: node_avatar_normal
                "\"NODE_AVATAR_LARGE\" TEXT," + // 19: node_avatar_large
                "\"CREATED\" INTEGER NOT NULL ," + // 20: created
                "\"LAST_MODIFIED\" INTEGER NOT NULL ," + // 21: last_modified
                "\"LAST_TOUCHED\" INTEGER NOT NULL );"); // 22: last_touched
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"V2EX_HOT_TOPIC_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, V2exHotTopicEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(3, url);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String content_rendered = entity.getContent_rendered();
        if (content_rendered != null) {
            stmt.bindString(5, content_rendered);
        }
        stmt.bindLong(6, entity.getReplies());
        stmt.bindLong(7, entity.getUserId());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(8, username);
        }
 
        String tagline = entity.getTagline();
        if (tagline != null) {
            stmt.bindString(9, tagline);
        }
 
        String avatar_mini = entity.getAvatar_mini();
        if (avatar_mini != null) {
            stmt.bindString(10, avatar_mini);
        }
 
        String avatar_normal = entity.getAvatar_normal();
        if (avatar_normal != null) {
            stmt.bindString(11, avatar_normal);
        }
 
        String avatar_large = entity.getAvatar_large();
        if (avatar_large != null) {
            stmt.bindString(12, avatar_large);
        }
 
        String node_id = entity.getNode_id();
        if (node_id != null) {
            stmt.bindString(13, node_id);
        }
 
        String node_name = entity.getNode_name();
        if (node_name != null) {
            stmt.bindString(14, node_name);
        }
 
        String node_title_alternative = entity.getNode_title_alternative();
        if (node_title_alternative != null) {
            stmt.bindString(15, node_title_alternative);
        }
 
        String node_url = entity.getNode_url();
        if (node_url != null) {
            stmt.bindString(16, node_url);
        }
 
        String node_topics = entity.getNode_topics();
        if (node_topics != null) {
            stmt.bindString(17, node_topics);
        }
 
        String node_avatar_mini = entity.getNode_avatar_mini();
        if (node_avatar_mini != null) {
            stmt.bindString(18, node_avatar_mini);
        }
 
        String node_avatar_normal = entity.getNode_avatar_normal();
        if (node_avatar_normal != null) {
            stmt.bindString(19, node_avatar_normal);
        }
 
        String node_avatar_large = entity.getNode_avatar_large();
        if (node_avatar_large != null) {
            stmt.bindString(20, node_avatar_large);
        }
        stmt.bindLong(21, entity.getCreated());
        stmt.bindLong(22, entity.getLast_modified());
        stmt.bindLong(23, entity.getLast_touched());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, V2exHotTopicEntity entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(3, url);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        String content_rendered = entity.getContent_rendered();
        if (content_rendered != null) {
            stmt.bindString(5, content_rendered);
        }
        stmt.bindLong(6, entity.getReplies());
        stmt.bindLong(7, entity.getUserId());
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(8, username);
        }
 
        String tagline = entity.getTagline();
        if (tagline != null) {
            stmt.bindString(9, tagline);
        }
 
        String avatar_mini = entity.getAvatar_mini();
        if (avatar_mini != null) {
            stmt.bindString(10, avatar_mini);
        }
 
        String avatar_normal = entity.getAvatar_normal();
        if (avatar_normal != null) {
            stmt.bindString(11, avatar_normal);
        }
 
        String avatar_large = entity.getAvatar_large();
        if (avatar_large != null) {
            stmt.bindString(12, avatar_large);
        }
 
        String node_id = entity.getNode_id();
        if (node_id != null) {
            stmt.bindString(13, node_id);
        }
 
        String node_name = entity.getNode_name();
        if (node_name != null) {
            stmt.bindString(14, node_name);
        }
 
        String node_title_alternative = entity.getNode_title_alternative();
        if (node_title_alternative != null) {
            stmt.bindString(15, node_title_alternative);
        }
 
        String node_url = entity.getNode_url();
        if (node_url != null) {
            stmt.bindString(16, node_url);
        }
 
        String node_topics = entity.getNode_topics();
        if (node_topics != null) {
            stmt.bindString(17, node_topics);
        }
 
        String node_avatar_mini = entity.getNode_avatar_mini();
        if (node_avatar_mini != null) {
            stmt.bindString(18, node_avatar_mini);
        }
 
        String node_avatar_normal = entity.getNode_avatar_normal();
        if (node_avatar_normal != null) {
            stmt.bindString(19, node_avatar_normal);
        }
 
        String node_avatar_large = entity.getNode_avatar_large();
        if (node_avatar_large != null) {
            stmt.bindString(20, node_avatar_large);
        }
        stmt.bindLong(21, entity.getCreated());
        stmt.bindLong(22, entity.getLast_modified());
        stmt.bindLong(23, entity.getLast_touched());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public V2exHotTopicEntity readEntity(Cursor cursor, int offset) {
        V2exHotTopicEntity entity = new V2exHotTopicEntity( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // url
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // content_rendered
            cursor.getInt(offset + 5), // replies
            cursor.getLong(offset + 6), // userId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // username
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // tagline
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // avatar_mini
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // avatar_normal
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // avatar_large
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // node_id
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // node_name
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // node_title_alternative
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // node_url
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // node_topics
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // node_avatar_mini
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // node_avatar_normal
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // node_avatar_large
            cursor.getLong(offset + 20), // created
            cursor.getLong(offset + 21), // last_modified
            cursor.getLong(offset + 22) // last_touched
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, V2exHotTopicEntity entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContent_rendered(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setReplies(cursor.getInt(offset + 5));
        entity.setUserId(cursor.getLong(offset + 6));
        entity.setUsername(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTagline(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAvatar_mini(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setAvatar_normal(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setAvatar_large(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setNode_id(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setNode_name(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setNode_title_alternative(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setNode_url(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setNode_topics(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setNode_avatar_mini(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setNode_avatar_normal(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setNode_avatar_large(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setCreated(cursor.getLong(offset + 20));
        entity.setLast_modified(cursor.getLong(offset + 21));
        entity.setLast_touched(cursor.getLong(offset + 22));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(V2exHotTopicEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(V2exHotTopicEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(V2exHotTopicEntity entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
