package com.retrofit.android.retrofitdemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PHONE_ALL_LINES".
*/
public class PhoneAllLinesDao extends AbstractDao<PhoneAllLines, Long> {

    public static final String TABLENAME = "PHONE_ALL_LINES";

    /**
     * Properties of entity PhoneAllLines.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
    }

    private DaoSession daoSession;


    public PhoneAllLinesDao(DaoConfig config) {
        super(config);
    }
    
    public PhoneAllLinesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PHONE_ALL_LINES\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT );"); // 0: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PHONE_ALL_LINES\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PhoneAllLines entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PhoneAllLines entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
    }

    @Override
    protected final void attachEntity(PhoneAllLines entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PhoneAllLines readEntity(Cursor cursor, int offset) {
        PhoneAllLines entity = new PhoneAllLines( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PhoneAllLines entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PhoneAllLines entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PhoneAllLines entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PhoneAllLines entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
