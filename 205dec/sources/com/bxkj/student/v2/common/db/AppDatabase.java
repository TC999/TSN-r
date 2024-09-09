package com.bxkj.student.v2.common.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import c0.c;
import c0.d;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.db.dao.e;
import com.bxkj.student.v2.common.db.dao.g;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.p;
import kotlin.r;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppDatabase.kt */
@Database(entities = {c.class, c0.b.class, d.class, c0.a.class}, exportSchema = true, version = 11)
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/bxkj/student/v2/common/db/dao/e;", "n", "Lcom/bxkj/student/v2/common/db/dao/c;", "m", "Lcom/bxkj/student/v2/common/db/dao/g;", "o", "Lcom/bxkj/student/v2/common/db/dao/a;", "l", "<init>", "()V", "a", "b", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class AppDatabase extends RoomDatabase {
    @NotNull

    /* renamed from: a */
    public static final b f23168a = new b(null);
    @NotNull

    /* renamed from: b */
    private static final String f23169b = "TSNStudent.db";
    @NotNull

    /* renamed from: c */
    private static final byte[] f23170c;
    @NotNull

    /* renamed from: d */
    private static final SupportFactory f23171d;
    @NotNull

    /* renamed from: e */
    private static final p<AppDatabase> f23172e;
    @NotNull

    /* renamed from: f */
    private static final AppDatabase$Companion$MIGRATION_2_3$1 f23173f;
    @NotNull

    /* renamed from: g */
    private static final AppDatabase$Companion$MIGRATION_3_4$1 f23174g;
    @NotNull

    /* renamed from: h */
    private static final AppDatabase$Companion$MIGRATION_4_5$1 f23175h;
    @NotNull

    /* renamed from: i */
    private static final AppDatabase$Companion$MIGRATION_5_6$1 f23176i;
    @NotNull

    /* renamed from: j */
    private static final AppDatabase$Companion$MIGRATION_6_7$1 f23177j;
    @NotNull

    /* renamed from: k */
    private static final AppDatabase$Companion$MIGRATION_7_8$1 f23178k;
    @NotNull

    /* renamed from: l */
    private static final AppDatabase$Companion$MIGRATION_8_9$1 f23179l;
    @NotNull

    /* renamed from: m */
    private static final AppDatabase$Companion$MIGRATION_9_10$1 f23180m;
    @NotNull

    /* renamed from: n */
    private static final AppDatabase$Companion$MIGRATION_10_11$1 f23181n;

    /* compiled from: AppDatabase.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static final class a extends Lambda implements d2.a<AppDatabase> {

        /* renamed from: a */
        public static final a f23182a = new a();

        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final AppDatabase invoke() {
            RoomDatabase build = Room.databaseBuilder(BaseApp.b(), AppDatabase.class, "TSNStudent.db").openHelperFactory(AppDatabase.f23171d).addMigrations(AppDatabase.f23173f).addMigrations(AppDatabase.f23174g).addMigrations(AppDatabase.f23175h).addMigrations(AppDatabase.f23176i).addMigrations(AppDatabase.f23177j).addMigrations(AppDatabase.f23178k).addMigrations(AppDatabase.f23179l).addMigrations(AppDatabase.f23180m).addMigrations(AppDatabase.f23181n).fallbackToDestructiveMigration().build();
            f0.o(build, "databaseBuilder(App.getA\u2026\n                .build()");
            return (AppDatabase) build;
        }
    }

    /* compiled from: AppDatabase.kt */
    @Metadata(bv = {}, d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005*\t\u000b\u000e\u0011\u0014\u0017\u001a\u001d #\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006."}, d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase$b;", "", "Lcom/bxkj/student/v2/common/db/AppDatabase;", "instance$delegate", "Lkotlin/p;", "a", "()Lcom/bxkj/student/v2/common/db/AppDatabase;", "instance", "", "DATABASE_NAME", "Ljava/lang/String;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_10_11$1", "MIGRATION_10_11", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_10_11$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_2_3$1", "MIGRATION_2_3", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_2_3$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_3_4$1", "MIGRATION_3_4", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_3_4$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_4_5$1", "MIGRATION_4_5", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_4_5$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_5_6$1", "MIGRATION_5_6", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_5_6$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_6_7$1", "MIGRATION_6_7", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_6_7$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_7_8$1", "MIGRATION_7_8", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_7_8$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_8_9$1", "MIGRATION_8_9", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_8_9$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_9_10$1", "MIGRATION_9_10", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_9_10$1;", "Lnet/sqlcipher/database/SupportFactory;", "factory", "Lnet/sqlcipher/database/SupportFactory;", "", "passphrase", "[B", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @NotNull
        public final AppDatabase a() {
            return (AppDatabase) AppDatabase.f23172e.getValue();
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_7_8$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_8_9$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_9_10$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_10_11$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_3_4$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_4_5$1] */
    static {
        p<AppDatabase> c4;
        TsnSecret tsnSecret = TsnSecret.f16433a;
        Context o4 = App.o();
        f0.o(o4, "getMyApplicationContext()");
        char[] charArray = tsnSecret.getKey(o4).toCharArray();
        f0.o(charArray, "this as java.lang.String).toCharArray()");
        byte[] bytes = SQLiteDatabase.getBytes(charArray);
        f0.o(bytes, "getBytes(TsnSecret.getKe\u2026Context()).toCharArray())");
        f23170c = bytes;
        f23171d = new SupportFactory(bytes);
        c4 = r.c(LazyThreadSafetyMode.SYNCHRONIZED, a.f23182a);
        f23172e = c4;
        f23173f = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_2_3$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
            }
        };
        f23174g = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_3_4$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isException` TEXT NOT NULL  DEFAULT ''");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `startFace` TEXT NOT NULL  DEFAULT ''");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `midFace` TEXT NOT NULL  DEFAULT ''");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `endFace` TEXT NOT NULL  DEFAULT ''");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isValid` TEXT NOT NULL  DEFAULT '0'");
            }
        };
        f23175h = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_4_5$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `gpsDistance` TEXT NOT NULL  DEFAULT ''");
            }
        };
        f23176i = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_5_6$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL)");
            }
        };
        f23177j = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_6_7$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("CREATE TABLE IF NOT EXISTS `sports_set` ( `userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`),UNIQUE(`userId`, `type`))");
                database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set`(`userId`, `type`)");
            }
        };
        f23178k = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_7_8$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `faceCheckingDistance` TEXT NOT NULL  DEFAULT '0.0'");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `pauseLatLng` TEXT NOT NULL  DEFAULT ''");
            }
        };
        f23179l = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_8_9$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isOpenDevelop` TEXT NOT NULL  DEFAULT '0'");
            }
        };
        f23180m = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_9_10$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `confirmCount` INTEGER NOT NULL  DEFAULT 0");
            }
        };
        f23181n = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_10_11$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                f0.p(database, "database");
                database.execSQL("ALTER  TABLE  `menu` ADD COLUMN  `isShowH5Title` TEXT NOT NULL  DEFAULT '1'");
            }
        };
    }

    public static final /* synthetic */ AppDatabase$Companion$MIGRATION_9_10$1 k() {
        return f23180m;
    }

    @Nullable
    public abstract com.bxkj.student.v2.common.db.dao.a l();

    @Nullable
    public abstract com.bxkj.student.v2.common.db.dao.c m();

    @Nullable
    public abstract e n();

    @Nullable
    public abstract g o();
}
