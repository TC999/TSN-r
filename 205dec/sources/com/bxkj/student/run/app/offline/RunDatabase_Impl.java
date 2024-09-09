package com.bxkj.student.run.app.offline;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.dao.RunDao_Impl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class RunDatabase_Impl extends RunDatabase {
    private volatile RunDao _runDao;

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `runDb`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "runDb");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) { // from class: com.bxkj.student.run.app.offline.RunDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("CREATE TABLE IF NOT EXISTS `runDb` (`identify` TEXT NOT NULL, `userNumber` TEXT NOT NULL, `sportsType` TEXT NOT NULL, `sportsSet` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `countTime` TEXT NOT NULL, `distance` TEXT NOT NULL, `latLngList` TEXT NOT NULL, `stepList` TEXT NOT NULL, `passLatLngList` TEXT NOT NULL, `points` TEXT NOT NULL, `isFaceOut` TEXT NOT NULL, `faceDetectCount` TEXT NOT NULL, `uploadType` TEXT NOT NULL, PRIMARY KEY(`identify`))");
                _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6086b83f23b783fbba0999d9978a4461')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase _db) {
                _db.execSQL("DROP TABLE IF EXISTS `runDb`");
                if (((RoomDatabase) RunDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.get(i4)).onDestructiveMigration(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase _db) {
                if (((RoomDatabase) RunDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.get(i4)).onCreate(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase _db) {
                ((RoomDatabase) RunDatabase_Impl.this).mDatabase = _db;
                RunDatabase_Impl.this.internalInitInvalidationTracker(_db);
                if (((RoomDatabase) RunDatabase_Impl.this).mCallbacks != null) {
                    int size = ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((RoomDatabase.Callback) ((RoomDatabase) RunDatabase_Impl.this).mCallbacks.get(i4)).onOpen(_db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase _db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase _db) {
                DBUtil.dropFtsSyncTriggers(_db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
                HashMap hashMap = new HashMap(15);
                hashMap.put("identify", new TableInfo.Column("identify", "TEXT", true, 1, null, 1));
                hashMap.put("userNumber", new TableInfo.Column("userNumber", "TEXT", true, 0, null, 1));
                hashMap.put("sportsType", new TableInfo.Column("sportsType", "TEXT", true, 0, null, 1));
                hashMap.put("sportsSet", new TableInfo.Column("sportsSet", "TEXT", true, 0, null, 1));
                hashMap.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, 1));
                hashMap.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, 1));
                hashMap.put("countTime", new TableInfo.Column("countTime", "TEXT", true, 0, null, 1));
                hashMap.put("distance", new TableInfo.Column("distance", "TEXT", true, 0, null, 1));
                hashMap.put("latLngList", new TableInfo.Column("latLngList", "TEXT", true, 0, null, 1));
                hashMap.put("stepList", new TableInfo.Column("stepList", "TEXT", true, 0, null, 1));
                hashMap.put("passLatLngList", new TableInfo.Column("passLatLngList", "TEXT", true, 0, null, 1));
                hashMap.put("points", new TableInfo.Column("points", "TEXT", true, 0, null, 1));
                hashMap.put("isFaceOut", new TableInfo.Column("isFaceOut", "TEXT", true, 0, null, 1));
                hashMap.put("faceDetectCount", new TableInfo.Column("faceDetectCount", "TEXT", true, 0, null, 1));
                hashMap.put("uploadType", new TableInfo.Column("uploadType", "TEXT", true, 0, null, 1));
                TableInfo tableInfo = new TableInfo("runDb", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(_db, "runDb");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "runDb(com.bxkj.student.run.app.offline.table.RunDb).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "6086b83f23b783fbba0999d9978a4461", "5d22fe996d3088d7515d411b76facb7e")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(RunDao.class, RunDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // com.bxkj.student.run.app.offline.RunDatabase
    public RunDao runDao() {
        RunDao runDao;
        if (this._runDao != null) {
            return this._runDao;
        }
        synchronized (this) {
            if (this._runDao == null) {
                this._runDao = new RunDao_Impl(this);
            }
            runDao = this._runDao;
        }
        return runDao;
    }
}
