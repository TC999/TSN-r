package com.bxkj.student.v2.common.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bxkj.student.v2.common.db.dao.b;
import com.bxkj.student.v2.common.db.dao.c;
import com.bxkj.student.v2.common.db.dao.d;
import com.bxkj.student.v2.common.db.dao.e;
import com.bxkj.student.v2.common.db.dao.f;
import com.bxkj.student.v2.common.db.dao.g;
import com.bxkj.student.v2.common.db.dao.h;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: o  reason: collision with root package name */
    private volatile e f23183o;

    /* renamed from: p  reason: collision with root package name */
    private volatile c f23184p;

    /* renamed from: q  reason: collision with root package name */
    private volatile g f23185q;

    /* renamed from: r  reason: collision with root package name */
    private volatile com.bxkj.student.v2.common.db.dao.a f23186r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a extends RoomOpenHelper.Delegate {
        a(int version) {
            super(version);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("CREATE TABLE IF NOT EXISTS `sports` (`identify` TEXT NOT NULL, `userNumber` TEXT NOT NULL, `sportsType` TEXT NOT NULL, `sportsSet` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `countTime` TEXT NOT NULL, `distance` TEXT NOT NULL, `gpsDistance` TEXT NOT NULL, `latLngList` TEXT NOT NULL, `stepList` TEXT NOT NULL, `passLatLngList` TEXT NOT NULL, `isFaceOut` TEXT NOT NULL, `faceDetectCount` TEXT NOT NULL, `uploadType` TEXT NOT NULL, `isException` TEXT NOT NULL, `startFace` TEXT NOT NULL, `midFace` TEXT NOT NULL, `endFace` TEXT NOT NULL, `isValid` TEXT NOT NULL DEFAULT '0', `faceCheckingDistance` TEXT NOT NULL, `pauseLatLng` TEXT NOT NULL, `isOpenDevelop` TEXT NOT NULL DEFAULT '0', `confirmCount` INTEGER NOT NULL, PRIMARY KEY(`identify`))");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, `isShowH5Title` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `sports_set` (`userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`))");
            _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set` (`userId`, `type`)");
            _db.execSQL("CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL)");
            _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '85e95fbee244b1c081b018b58df1b847')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase _db) {
            _db.execSQL("DROP TABLE IF EXISTS `sports`");
            _db.execSQL("DROP TABLE IF EXISTS `menu`");
            _db.execSQL("DROP TABLE IF EXISTS `sports_set`");
            _db.execSQL("DROP TABLE IF EXISTS `face`");
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i4)).onDestructiveMigration(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        protected void onCreate(SupportSQLiteDatabase _db) {
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i4)).onCreate(_db);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase _db) {
            ((RoomDatabase) AppDatabase_Impl.this).mDatabase = _db;
            AppDatabase_Impl.this.internalInitInvalidationTracker(_db);
            if (((RoomDatabase) AppDatabase_Impl.this).mCallbacks != null) {
                int size = ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((RoomDatabase.Callback) ((RoomDatabase) AppDatabase_Impl.this).mCallbacks.get(i4)).onOpen(_db);
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
            HashMap hashMap = new HashMap(24);
            hashMap.put("identify", new TableInfo.Column("identify", "TEXT", true, 1, null, 1));
            hashMap.put("userNumber", new TableInfo.Column("userNumber", "TEXT", true, 0, null, 1));
            hashMap.put("sportsType", new TableInfo.Column("sportsType", "TEXT", true, 0, null, 1));
            hashMap.put("sportsSet", new TableInfo.Column("sportsSet", "TEXT", true, 0, null, 1));
            hashMap.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, null, 1));
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
            hashMap.put("confirmCount", new TableInfo.Column("confirmCount", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("sports", hashMap, new HashSet(0), new HashSet(0));
            TableInfo read = TableInfo.read(_db, "sports");
            if (!tableInfo.equals(read)) {
                return new RoomOpenHelper.ValidationResult(false, "sports(com.bxkj.student.v2.common.db.table.SportsDb).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
            HashMap hashMap2 = new HashMap(14);
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
            hashMap2.put("isShowH5Title", new TableInfo.Column("isShowH5Title", "TEXT", true, 0, null, 1));
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
        return configuration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(new RoomOpenHelper(configuration, new a(11), "85e95fbee244b1c081b018b58df1b847", "0252b11c6deef638f628ad89f38b459c")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(e.class, f.w());
        hashMap.put(c.class, d.t());
        hashMap.put(g.class, h.e());
        hashMap.put(com.bxkj.student.v2.common.db.dao.a.class, b.g());
        return hashMap;
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    public com.bxkj.student.v2.common.db.dao.a l() {
        com.bxkj.student.v2.common.db.dao.a aVar;
        if (this.f23186r != null) {
            return this.f23186r;
        }
        synchronized (this) {
            if (this.f23186r == null) {
                this.f23186r = new b(this);
            }
            aVar = this.f23186r;
        }
        return aVar;
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    public c m() {
        c cVar;
        if (this.f23184p != null) {
            return this.f23184p;
        }
        synchronized (this) {
            if (this.f23184p == null) {
                this.f23184p = new d(this);
            }
            cVar = this.f23184p;
        }
        return cVar;
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    public e n() {
        e eVar;
        if (this.f23183o != null) {
            return this.f23183o;
        }
        synchronized (this) {
            if (this.f23183o == null) {
                this.f23183o = new f(this);
            }
            eVar = this.f23183o;
        }
        return eVar;
    }

    @Override // com.bxkj.student.v2.common.db.AppDatabase
    public g o() {
        g gVar;
        if (this.f23185q != null) {
            return this.f23185q;
        }
        synchronized (this) {
            if (this.f23185q == null) {
                this.f23185q = new h(this);
            }
            gVar = this.f23185q;
        }
        return gVar;
    }
}
