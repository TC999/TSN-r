package com.bxkj.student.p094v2.common.p095db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p021db.SupportSQLiteDatabase;
import androidx.sqlite.p021db.SupportSQLiteOpenHelper;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao_Impl;
import com.bxkj.student.p094v2.common.p095db.dao.MenuDao;
import com.bxkj.student.p094v2.common.p095db.dao.MenuDao_Impl;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao_Impl;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao_Impl;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: com.bxkj.student.v2.common.db.AppDatabase_Impl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: m */
    private volatile SportsDao f19947m;

    /* renamed from: n */
    private volatile MenuDao f19948n;

    /* renamed from: o */
    private volatile SportsSetDao f19949o;

    /* renamed from: p */
    private volatile FaceDao f19950p;

    /* renamed from: com.bxkj.student.v2.common.db.AppDatabase_Impl$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5485a extends RoomOpenHelper.Delegate {
        C5485a(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("CREATE TABLE IF NOT EXISTS `sports` (`identify` TEXT NOT NULL, `userNumber` TEXT NOT NULL, `sportsType` TEXT NOT NULL, `sportsSet` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `countTime` TEXT NOT NULL, `distance` TEXT NOT NULL, `gpsDistance` TEXT NOT NULL, `latLngList` TEXT NOT NULL, `stepList` TEXT NOT NULL, `passLatLngList` TEXT NOT NULL, `isFaceOut` TEXT NOT NULL, `faceDetectCount` TEXT NOT NULL, `uploadType` TEXT NOT NULL, `isException` TEXT NOT NULL, `startFace` TEXT NOT NULL, `midFace` TEXT NOT NULL, `endFace` TEXT NOT NULL, `isValid` TEXT NOT NULL DEFAULT '0', `faceCheckingDistance` TEXT NOT NULL, `pauseLatLng` TEXT NOT NULL, `isOpenDevelop` TEXT NOT NULL DEFAULT '0', PRIMARY KEY(`identify`))");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `sports_set` (`userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`))");
            _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set` (`userId`, `type`)");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL)");
            _db.execSQL(RoomMasterTable.CREATE_QUERY);
            _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4467e51910526b0735d285e48e82c955')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("DROP TABLE IF EXISTS `sports`");
            _db.execSQL("DROP TABLE IF EXISTS `menu`");
            _db.execSQL("DROP TABLE IF EXISTS `sports_set`");
            _db.execSQL("DROP TABLE IF EXISTS `face`");
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i)).onDestructiveMigration(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase _db) {
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i)).onCreate(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase _db) {
            ((RoomDatabase) AppDatabase_Impl.this).mDatabase = _db;
            AppDatabase_Impl.this.internalInitInvalidationTracker(_db);
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i)).onOpen(_db);
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
            HashMap hashMap = new HashMap(23);
            hashMap.put("identify", new TableInfo.Column("identify", "TEXT", true, 1, null, 1));
            hashMap.put("userNumber", new TableInfo.Column("userNumber", "TEXT", true, 0, null, 1));
            hashMap.put("sportsType", new TableInfo.Column("sportsType", "TEXT", true, 0, null, 1));
            hashMap.put("sportsSet", new TableInfo.Column("sportsSet", "TEXT", true, 0, null, 1));
            hashMap.put(AnalyticsConfig.RTD_START_TIME, new TableInfo.Column(AnalyticsConfig.RTD_START_TIME, "TEXT", true, 0, null, 1));
            hashMap.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, null, 1));
            hashMap.put("countTime", new TableInfo.Column("countTime", "TEXT", true, 0, null, 1));
            hashMap.put("distance", new TableInfo.Column("distance", "TEXT", true, 0, null, 1));
            hashMap.put("gpsDistance", new TableInfo.Column("gpsDistance", "TEXT", true, 0, null, 1));
            hashMap.put("latLngList", new TableInfo.Column("latLngList", "TEXT", true, 0, null, 1));
            hashMap.put("stepList", new TableInfo.Column("stepList", "TEXT", true, 0, null, 1));
            hashMap.put("passLatLngList", new TableInfo.Column("passLatLngList", "TEXT", true, 0, null, 1));
            hashMap.put("isFaceOut", new TableInfo.Column("isFaceOut", "TEXT", true, 0, null, 1));
            hashMap.put("faceDetectCount", new TableInfo.Column("faceDetectCount", "TEXT", true, 0, null, 1));
            hashMap.put("uploadType", new TableInfo.Column("uploadType", "TEXT", true, 0, null, 1));
            hashMap.put("isException", new TableInfo.Column("isException", "TEXT", true, 0, null, 1));
            hashMap.put("startFace", new TableInfo.Column("startFace", "TEXT", true, 0, null, 1));
            hashMap.put("midFace", new TableInfo.Column("midFace", "TEXT", true, 0, null, 1));
            hashMap.put("endFace", new TableInfo.Column("endFace", "TEXT", true, 0, null, 1));
            hashMap.put("isValid", new TableInfo.Column("isValid", "TEXT", true, 0, "'0'", 1));
            hashMap.put("faceCheckingDistance", new TableInfo.Column("faceCheckingDistance", "TEXT", true, 0, null, 1));
            hashMap.put("pauseLatLng", new TableInfo.Column("pauseLatLng", "TEXT", true, 0, null, 1));
            hashMap.put("isOpenDevelop", new TableInfo.Column("isOpenDevelop", "TEXT", true, 0, "'0'", 1));
            TableInfo tableInfo = new TableInfo("sports", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(_db, "sports");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "sports(com.bxkj.student.v2.common.db.table.SportsDb).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(13);
            hashMap2.put("mkey", new TableInfo.Column("mkey", "TEXT", true, 1, null, 1));
            hashMap2.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            hashMap2.put(RewardPlus.ICON, new TableInfo.Column(RewardPlus.ICON, "TEXT", true, 0, null, 1));
            hashMap2.put("iconS", new TableInfo.Column("iconS", "TEXT", true, 0, null, 1));
            hashMap2.put("isShow", new TableInfo.Column("isShow", "TEXT", true, 0, null, 1));
            hashMap2.put("isEnabled", new TableInfo.Column("isEnabled", "TEXT", true, 0, null, 1));
            hashMap2.put("isLogin", new TableInfo.Column("isLogin", "INTEGER", true, 0, null, 1));
            hashMap2.put("linkUrl", new TableInfo.Column("linkUrl", "TEXT", true, 0, null, 1));
            hashMap2.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
            hashMap2.put("lastUploadTime", new TableInfo.Column("lastUploadTime", "TEXT", true, 0, null, 1));
            hashMap2.put("sort", new TableInfo.Column("sort", "TEXT", true, 0, null, 1));
            hashMap2.put("isShowIndex", new TableInfo.Column("isShowIndex", "TEXT", true, 0, null, 1));
            hashMap2.put("homeSort", new TableInfo.Column("homeSort", "TEXT", true, 0, null, 1));
            TableInfo tableInfo2 = new TableInfo("menu", hashMap2, new HashSet(0), new HashSet(0));
            TableInfo read2 = TableInfo.read(_db, "menu");
            if (!tableInfo2.equals(read2)) {
                return new RoomOpenHelper.ValidationResult(false, "menu(com.bxkj.student.v2.common.db.table.MenuDb).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
            HashMap hashMap3 = new HashMap(3);
            hashMap3.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
            hashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 2, null, 1));
            hashMap3.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new TableInfo.Index("index_sports_set_userId_type", true, Arrays.asList("userId", "type")));
            TableInfo tableInfo3 = new TableInfo("sports_set", hashMap3, hashSet, hashSet2);
            TableInfo read3 = TableInfo.read(_db, "sports_set");
            if (!tableInfo3.equals(read3)) {
                return new RoomOpenHelper.ValidationResult(false, "sports_set(com.bxkj.student.v2.common.db.table.SportsSetDb).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
            HashMap hashMap4 = new HashMap(4);
            hashMap4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
            hashMap4.put("identify", new TableInfo.Column("identify", "TEXT", true, 0, null, 1));
            hashMap4.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
            hashMap4.put("facePath", new TableInfo.Column("facePath", "TEXT", true, 0, null, 1));
            TableInfo tableInfo4 = new TableInfo("face", hashMap4, new HashSet(0), new HashSet(0));
            TableInfo read4 = TableInfo.read(_db, "face");
            if (!tableInfo4.equals(read4)) {
                return new RoomOpenHelper.ValidationResult(false, "face(com.bxkj.student.v2.common.db.table.FaceDb).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
            }
            return new RoomOpenHelper.ValidationResult(true, null);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `sports`");
            writableDatabase.execSQL("DELETE FROM `menu`");
            writableDatabase.execSQL("DELETE FROM `sports_set`");
            writableDatabase.execSQL("DELETE FROM `face`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "sports", "menu", "sports_set", "face");
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new C5485a(9), "4467e51910526b0735d285e48e82c955", "3844200b6a50250710fc8631a6d34af5")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(SportsDao.class, SportsDao_Impl.m39164s());
        hashMap.put(MenuDao.class, MenuDao_Impl.m39185t());
        hashMap.put(SportsSetDao.class, SportsSetDao_Impl.m39156e());
        hashMap.put(FaceDao.class, FaceDao_Impl.m39206g());
        return hashMap;
    }

    @Override // com.bxkj.student.p094v2.common.p095db.AppDatabase
    /* renamed from: j */
    public FaceDao mo39227j() {
        FaceDao faceDao;
        if (this.f19950p != null) {
            return this.f19950p;
        }
        synchronized (this) {
            if (this.f19950p == null) {
                this.f19950p = new FaceDao_Impl(this);
            }
            faceDao = this.f19950p;
        }
        return faceDao;
    }

    @Override // com.bxkj.student.p094v2.common.p095db.AppDatabase
    /* renamed from: k */
    public MenuDao mo39226k() {
        MenuDao menuDao;
        if (this.f19948n != null) {
            return this.f19948n;
        }
        synchronized (this) {
            if (this.f19948n == null) {
                this.f19948n = new MenuDao_Impl(this);
            }
            menuDao = this.f19948n;
        }
        return menuDao;
    }

    @Override // com.bxkj.student.p094v2.common.p095db.AppDatabase
    /* renamed from: l */
    public SportsDao mo39225l() {
        SportsDao sportsDao;
        if (this.f19947m != null) {
            return this.f19947m;
        }
        synchronized (this) {
            if (this.f19947m == null) {
                this.f19947m = new SportsDao_Impl(this);
            }
            sportsDao = this.f19947m;
        }
        return sportsDao;
    }

    @Override // com.bxkj.student.p094v2.common.p095db.AppDatabase
    /* renamed from: m */
    public SportsSetDao mo39224m() {
        SportsSetDao sportsSetDao;
        if (this.f19949o != null) {
            return this.f19949o;
        }
        synchronized (this) {
            if (this.f19949o == null) {
                this.f19949o = new SportsSetDao_Impl(this);
            }
            sportsSetDao = this.f19949o;
        }
        return sportsSetDao;
    }
}
