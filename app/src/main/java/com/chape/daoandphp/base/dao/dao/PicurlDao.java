package com.chape.daoandphp.base.dao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PICURL".
*/
public class PicurlDao extends AbstractDao<Picurl, Long> {

    public static final String TABLENAME = "PICURL";

    /**
     * Properties of entity Picurl.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Pic_title = new Property(1, String.class, "pic_title", false, "PIC_TITLE");
        public final static Property Pic_content = new Property(2, String.class, "pic_content", false, "PIC_CONTENT");
    }


    public PicurlDao(DaoConfig config) {
        super(config);
    }
    
    public PicurlDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PICURL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PIC_TITLE\" TEXT," + // 1: pic_title
                "\"PIC_CONTENT\" TEXT);"); // 2: pic_content
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PICURL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Picurl entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String pic_title = entity.getPic_title();
        if (pic_title != null) {
            stmt.bindString(2, pic_title);
        }
 
        String pic_content = entity.getPic_content();
        if (pic_content != null) {
            stmt.bindString(3, pic_content);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Picurl entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String pic_title = entity.getPic_title();
        if (pic_title != null) {
            stmt.bindString(2, pic_title);
        }
 
        String pic_content = entity.getPic_content();
        if (pic_content != null) {
            stmt.bindString(3, pic_content);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Picurl readEntity(Cursor cursor, int offset) {
        Picurl entity = new Picurl( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // pic_title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // pic_content
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Picurl entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPic_title(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPic_content(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Picurl entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Picurl entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Picurl entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
