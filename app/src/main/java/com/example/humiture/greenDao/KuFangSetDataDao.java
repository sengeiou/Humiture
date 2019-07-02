package com.example.humiture.greenDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.humiture.data.KuFangSetData;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "KU_FANG_SET_DATA".
*/
public class KuFangSetDataDao extends AbstractDao<KuFangSetData, Long> {

    public static final String TABLENAME = "KU_FANG_SET_DATA";

    /**
     * Properties of entity KuFangSetData.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StoreId = new Property(1, int.class, "storeId", false, "STORE_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Up_WD = new Property(3, String.class, "up_WD", false, "UP__WD");
        public final static Property Down_WD = new Property(4, String.class, "down_WD", false, "DOWN__WD");
        public final static Property Up_SD = new Property(5, String.class, "up_SD", false, "UP__SD");
        public final static Property Down_SD = new Property(6, String.class, "down_SD", false, "DOWN__SD");
        public final static Property Up_PM = new Property(7, String.class, "up_PM", false, "UP__PM");
        public final static Property Down_PM = new Property(8, String.class, "down_PM", false, "DOWN__PM");
        public final static Property Up_TVOC = new Property(9, String.class, "up_TVOC", false, "UP__TVOC");
        public final static Property Down_TVOC = new Property(10, String.class, "down_TVOC", false, "DOWN__TVOC");
        public final static Property Up_JL = new Property(11, String.class, "up_JL", false, "UP__JL");
        public final static Property Down_JL = new Property(12, String.class, "down_JL", false, "DOWN__JL");
        public final static Property Up_JQ = new Property(13, String.class, "up_JQ", false, "UP__JQ");
        public final static Property Down_JQ = new Property(14, String.class, "down_JQ", false, "DOWN__JQ");
        public final static Property Up_EOC2 = new Property(15, String.class, "up_EOC2", false, "UP__EOC2");
        public final static Property Down_EOC2 = new Property(16, String.class, "down_EOC2", false, "DOWN__EOC2");
        public final static Property Up_GAS = new Property(17, String.class, "up_GAS", false, "UP__GAS");
        public final static Property Down_GAS = new Property(18, String.class, "down_GAS", false, "DOWN__GAS");
    }


    public KuFangSetDataDao(DaoConfig config) {
        super(config);
    }
    
    public KuFangSetDataDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"KU_FANG_SET_DATA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"STORE_ID\" INTEGER NOT NULL ," + // 1: storeId
                "\"NAME\" TEXT," + // 2: name
                "\"UP__WD\" TEXT," + // 3: up_WD
                "\"DOWN__WD\" TEXT," + // 4: down_WD
                "\"UP__SD\" TEXT," + // 5: up_SD
                "\"DOWN__SD\" TEXT," + // 6: down_SD
                "\"UP__PM\" TEXT," + // 7: up_PM
                "\"DOWN__PM\" TEXT," + // 8: down_PM
                "\"UP__TVOC\" TEXT," + // 9: up_TVOC
                "\"DOWN__TVOC\" TEXT," + // 10: down_TVOC
                "\"UP__JL\" TEXT," + // 11: up_JL
                "\"DOWN__JL\" TEXT," + // 12: down_JL
                "\"UP__JQ\" TEXT," + // 13: up_JQ
                "\"DOWN__JQ\" TEXT," + // 14: down_JQ
                "\"UP__EOC2\" TEXT," + // 15: up_EOC2
                "\"DOWN__EOC2\" TEXT," + // 16: down_EOC2
                "\"UP__GAS\" TEXT," + // 17: up_GAS
                "\"DOWN__GAS\" TEXT);"); // 18: down_GAS
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"KU_FANG_SET_DATA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, KuFangSetData entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStoreId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String up_WD = entity.getUp_WD();
        if (up_WD != null) {
            stmt.bindString(4, up_WD);
        }
 
        String down_WD = entity.getDown_WD();
        if (down_WD != null) {
            stmt.bindString(5, down_WD);
        }
 
        String up_SD = entity.getUp_SD();
        if (up_SD != null) {
            stmt.bindString(6, up_SD);
        }
 
        String down_SD = entity.getDown_SD();
        if (down_SD != null) {
            stmt.bindString(7, down_SD);
        }
 
        String up_PM = entity.getUp_PM();
        if (up_PM != null) {
            stmt.bindString(8, up_PM);
        }
 
        String down_PM = entity.getDown_PM();
        if (down_PM != null) {
            stmt.bindString(9, down_PM);
        }
 
        String up_TVOC = entity.getUp_TVOC();
        if (up_TVOC != null) {
            stmt.bindString(10, up_TVOC);
        }
 
        String down_TVOC = entity.getDown_TVOC();
        if (down_TVOC != null) {
            stmt.bindString(11, down_TVOC);
        }
 
        String up_JL = entity.getUp_JL();
        if (up_JL != null) {
            stmt.bindString(12, up_JL);
        }
 
        String down_JL = entity.getDown_JL();
        if (down_JL != null) {
            stmt.bindString(13, down_JL);
        }
 
        String up_JQ = entity.getUp_JQ();
        if (up_JQ != null) {
            stmt.bindString(14, up_JQ);
        }
 
        String down_JQ = entity.getDown_JQ();
        if (down_JQ != null) {
            stmt.bindString(15, down_JQ);
        }
 
        String up_EOC2 = entity.getUp_EOC2();
        if (up_EOC2 != null) {
            stmt.bindString(16, up_EOC2);
        }
 
        String down_EOC2 = entity.getDown_EOC2();
        if (down_EOC2 != null) {
            stmt.bindString(17, down_EOC2);
        }
 
        String up_GAS = entity.getUp_GAS();
        if (up_GAS != null) {
            stmt.bindString(18, up_GAS);
        }
 
        String down_GAS = entity.getDown_GAS();
        if (down_GAS != null) {
            stmt.bindString(19, down_GAS);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, KuFangSetData entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getStoreId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String up_WD = entity.getUp_WD();
        if (up_WD != null) {
            stmt.bindString(4, up_WD);
        }
 
        String down_WD = entity.getDown_WD();
        if (down_WD != null) {
            stmt.bindString(5, down_WD);
        }
 
        String up_SD = entity.getUp_SD();
        if (up_SD != null) {
            stmt.bindString(6, up_SD);
        }
 
        String down_SD = entity.getDown_SD();
        if (down_SD != null) {
            stmt.bindString(7, down_SD);
        }
 
        String up_PM = entity.getUp_PM();
        if (up_PM != null) {
            stmt.bindString(8, up_PM);
        }
 
        String down_PM = entity.getDown_PM();
        if (down_PM != null) {
            stmt.bindString(9, down_PM);
        }
 
        String up_TVOC = entity.getUp_TVOC();
        if (up_TVOC != null) {
            stmt.bindString(10, up_TVOC);
        }
 
        String down_TVOC = entity.getDown_TVOC();
        if (down_TVOC != null) {
            stmt.bindString(11, down_TVOC);
        }
 
        String up_JL = entity.getUp_JL();
        if (up_JL != null) {
            stmt.bindString(12, up_JL);
        }
 
        String down_JL = entity.getDown_JL();
        if (down_JL != null) {
            stmt.bindString(13, down_JL);
        }
 
        String up_JQ = entity.getUp_JQ();
        if (up_JQ != null) {
            stmt.bindString(14, up_JQ);
        }
 
        String down_JQ = entity.getDown_JQ();
        if (down_JQ != null) {
            stmt.bindString(15, down_JQ);
        }
 
        String up_EOC2 = entity.getUp_EOC2();
        if (up_EOC2 != null) {
            stmt.bindString(16, up_EOC2);
        }
 
        String down_EOC2 = entity.getDown_EOC2();
        if (down_EOC2 != null) {
            stmt.bindString(17, down_EOC2);
        }
 
        String up_GAS = entity.getUp_GAS();
        if (up_GAS != null) {
            stmt.bindString(18, up_GAS);
        }
 
        String down_GAS = entity.getDown_GAS();
        if (down_GAS != null) {
            stmt.bindString(19, down_GAS);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public KuFangSetData readEntity(Cursor cursor, int offset) {
        KuFangSetData entity = new KuFangSetData( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // storeId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // up_WD
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // down_WD
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // up_SD
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // down_SD
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // up_PM
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // down_PM
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // up_TVOC
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // down_TVOC
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // up_JL
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // down_JL
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // up_JQ
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // down_JQ
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // up_EOC2
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // down_EOC2
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // up_GAS
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18) // down_GAS
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, KuFangSetData entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStoreId(cursor.getInt(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUp_WD(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDown_WD(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUp_SD(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDown_SD(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUp_PM(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDown_PM(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setUp_TVOC(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setDown_TVOC(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setUp_JL(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDown_JL(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setUp_JQ(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setDown_JQ(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setUp_EOC2(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setDown_EOC2(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setUp_GAS(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setDown_GAS(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(KuFangSetData entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(KuFangSetData entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(KuFangSetData entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
