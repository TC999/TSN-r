package com.bxkj.student.p094v2.common.p095db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.p021db.SupportSQLiteDatabase;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import com.bxkj.student.p094v2.common.p095db.dao.FaceDao;
import com.bxkj.student.p094v2.common.p095db.dao.MenuDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsDao;
import com.bxkj.student.p094v2.common.p095db.dao.SportsSetDao;
import com.kuaishou.weapon.p205p0.C7304t;
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p027c0.FaceDb;
import p027c0.MenuDb;
import p027c0.SportsDb;
import p027c0.SportsSetDb;
import p617l1.InterfaceC15269a;

/* compiled from: AppDatabase.kt */
@Database(entities = {SportsDb.class, MenuDb.class, SportsSetDb.class, FaceDb.class}, exportSchema = true, version = 9)
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&¨\u0006\u000e"}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/bxkj/student/v2/common/db/dao/e;", C7304t.f25048d, "Lcom/bxkj/student/v2/common/db/dao/c;", "k", "Lcom/bxkj/student/v2/common/db/dao/g;", "m", "Lcom/bxkj/student/v2/common/db/dao/a;", "j", "<init>", "()V", "a", "b", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.common.db.AppDatabase */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AppDatabase extends RoomDatabase {
    @NotNull

    /* renamed from: a */
    public static final C5484b f19934a = new C5484b(null);
    @NotNull

    /* renamed from: b */
    private static final String f19935b = "TSNStudent.db";
    @NotNull

    /* renamed from: c */
    private static final byte[] f19936c;
    @NotNull

    /* renamed from: d */
    private static final SupportFactory f19937d;
    @NotNull

    /* renamed from: e */
    private static final InterfaceC14378o<AppDatabase> f19938e;
    @NotNull

    /* renamed from: f */
    private static final AppDatabase$Companion$MIGRATION_2_3$1 f19939f;
    @NotNull

    /* renamed from: g */
    private static final AppDatabase$Companion$MIGRATION_3_4$1 f19940g;
    @NotNull

    /* renamed from: h */
    private static final AppDatabase$Companion$MIGRATION_4_5$1 f19941h;
    @NotNull

    /* renamed from: i */
    private static final AppDatabase$Companion$MIGRATION_5_6$1 f19942i;
    @NotNull

    /* renamed from: j */
    private static final AppDatabase$Companion$MIGRATION_6_7$1 f19943j;
    @NotNull

    /* renamed from: k */
    private static final AppDatabase$Companion$MIGRATION_7_8$1 f19944k;
    @NotNull

    /* renamed from: l */
    private static final AppDatabase$Companion$MIGRATION_8_9$1 f19945l;

    /* compiled from: AppDatabase.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.db.AppDatabase$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    static final class C5483a extends Lambda implements InterfaceC15269a<AppDatabase> {

        /* renamed from: a */
        public static final C5483a f19946a = new C5483a();

        C5483a() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        @NotNull
        /* renamed from: a */
        public final AppDatabase invoke() {
            RoomDatabase build = Room.databaseBuilder(BaseApp.m44341b(), AppDatabase.class, AppDatabase.f19935b).openHelperFactory(AppDatabase.f19937d).addMigrations(AppDatabase.f19939f).addMigrations(AppDatabase.f19940g).addMigrations(AppDatabase.f19941h).addMigrations(AppDatabase.f19942i).addMigrations(AppDatabase.f19943j).addMigrations(AppDatabase.f19944k).addMigrations(AppDatabase.f19945l).fallbackToDestructiveMigration().build();
            C14342f0.m8185o(build, "databaseBuilder(App.getA…\n                .build()");
            return (AppDatabase) build;
        }
    }

    /* compiled from: AppDatabase.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005*\u0007\u000b\u000e\u0011\u0014\u0017\u001a\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, m12616d2 = {"Lcom/bxkj/student/v2/common/db/AppDatabase$b;", "", "Lcom/bxkj/student/v2/common/db/AppDatabase;", "instance$delegate", "Lkotlin/o;", "a", "()Lcom/bxkj/student/v2/common/db/AppDatabase;", "instance", "", "DATABASE_NAME", "Ljava/lang/String;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_2_3$1", "MIGRATION_2_3", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_2_3$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_3_4$1", "MIGRATION_3_4", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_3_4$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_4_5$1", "MIGRATION_4_5", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_4_5$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_5_6$1", "MIGRATION_5_6", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_5_6$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_6_7$1", "MIGRATION_6_7", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_6_7$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_7_8$1", "MIGRATION_7_8", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_7_8$1;", "com/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_8_9$1", "MIGRATION_8_9", "Lcom/bxkj/student/v2/common/db/AppDatabase$Companion$MIGRATION_8_9$1;", "Lnet/sqlcipher/database/SupportFactory;", "factory", "Lnet/sqlcipher/database/SupportFactory;", "", "passphrase", "[B", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.db.AppDatabase$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5484b {
        private C5484b() {
        }

        public /* synthetic */ C5484b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final AppDatabase m39228a() {
            return (AppDatabase) AppDatabase.f19938e.getValue();
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_4_5$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_7_8$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_8_9$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_3_4$1] */
    static {
        InterfaceC14378o<AppDatabase> m7720b;
        TsnSecret tsnSecret = TsnSecret.f13210a;
        Context m43005o = App.m43005o();
        C14342f0.m8185o(m43005o, "getMyApplicationContext()");
        String key = tsnSecret.getKey(m43005o);
        if (key != null) {
            char[] charArray = key.toCharArray();
            C14342f0.m8185o(charArray, "(this as java.lang.String).toCharArray()");
            byte[] bytes = SQLiteDatabase.getBytes(charArray);
            C14342f0.m8185o(bytes, "getBytes(TsnSecret.getKe…Context()).toCharArray())");
            f19936c = bytes;
            f19937d = new SupportFactory(bytes);
            m7720b = C14389r.m7720b(LazyThreadSafetyMode.SYNCHRONIZED, C5483a.f19946a);
            f19938e = m7720b;
            f19939f = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_2_3$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("CREATE TABLE IF NOT EXISTS `menu` (`mkey` TEXT NOT NULL, `name` TEXT NOT NULL, `icon` TEXT NOT NULL, `iconS` TEXT NOT NULL, `isShow` TEXT NOT NULL, `isEnabled` TEXT NOT NULL, `isLogin` INTEGER NOT NULL, `linkUrl` TEXT NOT NULL, `type` TEXT NOT NULL, `lastUploadTime` TEXT NOT NULL, `sort` TEXT NOT NULL, `isShowIndex` TEXT NOT NULL, `homeSort` TEXT NOT NULL, PRIMARY KEY(`mkey`))");
                }
            };
            f19940g = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_3_4$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isException` TEXT NOT NULL  DEFAULT ''");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `startFace` TEXT NOT NULL  DEFAULT ''");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `midFace` TEXT NOT NULL  DEFAULT ''");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `endFace` TEXT NOT NULL  DEFAULT ''");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isValid` TEXT NOT NULL  DEFAULT '0'");
                }
            };
            f19941h = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_4_5$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `gpsDistance` TEXT NOT NULL  DEFAULT ''");
                }
            };
            f19942i = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_5_6$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("CREATE TABLE IF NOT EXISTS `face` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `identify` TEXT NOT NULL, `type` TEXT NOT NULL, `facePath` TEXT NOT NULL)");
                }
            };
            f19943j = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_6_7$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("CREATE TABLE IF NOT EXISTS `sports_set` ( `userId` TEXT NOT NULL, `type` TEXT NOT NULL, `content` TEXT NOT NULL, PRIMARY KEY(`userId`, `type`),UNIQUE(`userId`, `type`))");
                    database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sports_set_userId_type` ON `sports_set`(`userId`, `type`)");
                }
            };
            f19944k = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_7_8$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `faceCheckingDistance` TEXT NOT NULL  DEFAULT '0.0'");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `pauseLatLng` TEXT NOT NULL  DEFAULT ''");
                }
            };
            f19945l = new Migration() { // from class: com.bxkj.student.v2.common.db.AppDatabase$Companion$MIGRATION_8_9$1
                @Override // androidx.room.migration.Migration
                public void migrate(@NotNull SupportSQLiteDatabase database) {
                    C14342f0.m8184p(database, "database");
                    database.execSQL("ALTER  TABLE  `sports` ADD COLUMN  `isOpenDevelop` TEXT NOT NULL  DEFAULT '0'");
                }
            };
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Nullable
    /* renamed from: j */
    public abstract FaceDao mo39227j();

    @Nullable
    /* renamed from: k */
    public abstract MenuDao mo39226k();

    @Nullable
    /* renamed from: l */
    public abstract SportsDao mo39225l();

    @Nullable
    /* renamed from: m */
    public abstract SportsSetDao mo39224m();
}
