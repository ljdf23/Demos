package com.retrofit.android.retrofitdemo.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LINE".
*/
public class LineDao extends AbstractDao<Line, Long> {

    public static final String TABLENAME = "LINE";

    /**
     * Properties of entity Line.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property LineId = new Property(1, String.class, "lineId", false, "LINE_ID");
        public final static Property Number = new Property(2, Long.class, "number", false, "NUMBER");
        public final static Property PlanId = new Property(3, Long.class, "planId", false, "PLAN_ID");
        public final static Property PlanName = new Property(4, String.class, "planName", false, "PLAN_NAME");
        public final static Property Owner = new Property(5, String.class, "owner", false, "OWNER");
        public final static Property MainLine = new Property(6, Boolean.class, "mainLine", false, "MAIN_LINE");
        public final static Property PlanDetail = new Property(7, Long.class, "planDetail", false, "id");
    }

    private DaoSession daoSession;

    private Query<Line> phoneAllLines_LinesQuery;

    public LineDao(DaoConfig config) {
        super(config);
    }
    
    public LineDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LINE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"LINE_ID\" TEXT NOT NULL ," + // 1: lineId
                "\"NUMBER\" INTEGER," + // 2: number
                "\"PLAN_ID\" INTEGER," + // 3: planId
                "\"PLAN_NAME\" TEXT," + // 4: planName
                "\"OWNER\" TEXT," + // 5: owner
                "\"MAIN_LINE\" INTEGER," + // 6: mainLine
                "\"id\" INTEGER);"); // 7: planDetail
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LINE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Line entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getLineId());
 
        Long number = entity.getNumber();
        if (number != null) {
            stmt.bindLong(3, number);
        }
 
        Long planId = entity.getPlanId();
        if (planId != null) {
            stmt.bindLong(4, planId);
        }
 
        String planName = entity.getPlanName();
        if (planName != null) {
            stmt.bindString(5, planName);
        }
 
        String owner = entity.getOwner();
        if (owner != null) {
            stmt.bindString(6, owner);
        }
 
        Boolean mainLine = entity.getMainLine();
        if (mainLine != null) {
            stmt.bindLong(7, mainLine ? 1L: 0L);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Line entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getLineId());
 
        Long number = entity.getNumber();
        if (number != null) {
            stmt.bindLong(3, number);
        }
 
        Long planId = entity.getPlanId();
        if (planId != null) {
            stmt.bindLong(4, planId);
        }
 
        String planName = entity.getPlanName();
        if (planName != null) {
            stmt.bindString(5, planName);
        }
 
        String owner = entity.getOwner();
        if (owner != null) {
            stmt.bindString(6, owner);
        }
 
        Boolean mainLine = entity.getMainLine();
        if (mainLine != null) {
            stmt.bindLong(7, mainLine ? 1L: 0L);
        }
    }

    @Override
    protected final void attachEntity(Line entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Line readEntity(Cursor cursor, int offset) {
        Line entity = new Line( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // lineId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // number
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // planId
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // planName
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // owner
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0 // mainLine
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Line entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLineId(cursor.getString(offset + 1));
        entity.setNumber(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setPlanId(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setPlanName(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setOwner(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setMainLine(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Line entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Line entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Line entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "lines" to-many relationship of PhoneAllLines. */
    public List<Line> _queryPhoneAllLines_Lines(Long id) {
        synchronized (this) {
            if (phoneAllLines_LinesQuery == null) {
                QueryBuilder<Line> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Id.eq(null));
                phoneAllLines_LinesQuery = queryBuilder.build();
            }
        }
        Query<Line> query = phoneAllLines_LinesQuery.forCurrentThread();
        query.setParameter(0, id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPlainDetailDao().getAllColumns());
            builder.append(" FROM LINE T");
            builder.append(" LEFT JOIN PLAIN_DETAIL T0 ON T.\"id\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Line loadCurrentDeep(Cursor cursor, boolean lock) {
        Line entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        PlainDetail planDetail = loadCurrentOther(daoSession.getPlainDetailDao(), cursor, offset);
        entity.setPlanDetail(planDetail);

        return entity;    
    }

    public Line loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Line> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Line> list = new ArrayList<Line>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Line> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Line> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}