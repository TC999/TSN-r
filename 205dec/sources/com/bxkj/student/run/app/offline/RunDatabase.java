package com.bxkj.student.run.app.offline;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.bjtsn.secret.TsnSecret;
import com.bxkj.base.BaseApp;
import com.bxkj.student.App;
import com.bxkj.student.run.app.offline.dao.RunDao;
import com.bxkj.student.run.app.offline.table.RunDb;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.o;
import kotlin.q;
import l1.a;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RunDatabase.kt */
@Database(entities = {RunDb.class}, exportSchema = true, version = 2)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/bxkj/student/run/app/offline/RunDatabase;", "Landroidx/room/RoomDatabase;", "()V", "runDao", "Lcom/bxkj/student/run/app/offline/dao/RunDao;", "Companion", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class RunDatabase extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String DATABASE_NAME = "TSNRun.db";
    @NotNull
    private static final SupportFactory factory;
    @NotNull
    private static final o<RunDatabase> instance$delegate;
    @NotNull
    private static final byte[] passphrase;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RunDatabase.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/run/app/offline/RunDatabase$Companion;", "", "Lcom/bxkj/student/run/app/offline/RunDatabase;", "instance$delegate", "Lkotlin/o;", "getInstance", "()Lcom/bxkj/student/run/app/offline/RunDatabase;", "instance", "", "DATABASE_NAME", "Ljava/lang/String;", "Lnet/sqlcipher/database/SupportFactory;", "factory", "Lnet/sqlcipher/database/SupportFactory;", "", "passphrase", "[B", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        @NotNull
        public final RunDatabase getInstance() {
            return (RunDatabase) RunDatabase.instance$delegate.getValue();
        }
    }

    static {
        TsnSecret tsnSecret = TsnSecret.f16433a;
        Context o4 = App.o();
        f0.o(o4, "getMyApplicationContext()");
        String key = tsnSecret.getKey(o4);
        if (key != null) {
            char[] charArray = key.toCharArray();
            f0.o(charArray, "(this as java.lang.String).toCharArray()");
            byte[] bytes = SQLiteDatabase.getBytes(charArray);
            f0.o(bytes, "getBytes(TsnSecret.getKe\u2026Context()).toCharArray())");
            passphrase = bytes;
            factory = new SupportFactory(bytes);
            instance$delegate = q.b(LazyThreadSafetyMode.SYNCHRONIZED, new a<RunDatabase>() { // from class: com.bxkj.student.run.app.offline.RunDatabase$Companion$instance$2
                @NotNull
                /* renamed from: invoke */
                public final RunDatabase m58invoke() {
                    SupportFactory supportFactory;
                    RoomDatabase.Builder databaseBuilder = Room.databaseBuilder(BaseApp.b(), RunDatabase.class, "TSNRun.db");
                    supportFactory = RunDatabase.factory;
                    RoomDatabase build = databaseBuilder.openHelperFactory(supportFactory).build();
                    f0.o(build, "databaseBuilder(App.getA\u2026\n                .build()");
                    return (RunDatabase) build;
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Nullable
    public abstract RunDao runDao();
}
