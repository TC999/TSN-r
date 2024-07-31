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
import kotlin.C14389r;
import kotlin.InterfaceC14378o;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: RunDatabase.kt */
@Database(entities = {RunDb.class}, exportSchema = true, version = 2)
@Metadata(m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u0006"}, m12616d2 = {"Lcom/bxkj/student/run/app/offline/RunDatabase;", "Landroidx/room/RoomDatabase;", "()V", "runDao", "Lcom/bxkj/student/run/app/offline/dao/RunDao;", "Companion", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1}, m12612xi = 48)
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class RunDatabase extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String DATABASE_NAME = "TSNRun.db";
    @NotNull
    private static final SupportFactory factory;
    @NotNull
    private static final InterfaceC14378o<RunDatabase> instance$delegate;
    @NotNull
    private static final byte[] passphrase;

    /* compiled from: RunDatabase.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m12616d2 = {"Lcom/bxkj/student/run/app/offline/RunDatabase$Companion;", "", "Lcom/bxkj/student/run/app/offline/RunDatabase;", "instance$delegate", "Lkotlin/o;", "getInstance", "()Lcom/bxkj/student/run/app/offline/RunDatabase;", "instance", "", "DATABASE_NAME", "Ljava/lang/String;", "Lnet/sqlcipher/database/SupportFactory;", "factory", "Lnet/sqlcipher/database/SupportFactory;", "", "passphrase", "[B", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RunDatabase getInstance() {
            return (RunDatabase) RunDatabase.instance$delegate.getValue();
        }
    }

    static {
        InterfaceC14378o<RunDatabase> m7720b;
        TsnSecret tsnSecret = TsnSecret.f13210a;
        Context m43005o = App.m43005o();
        C14342f0.m8185o(m43005o, "getMyApplicationContext()");
        String key = tsnSecret.getKey(m43005o);
        if (key != null) {
            char[] charArray = key.toCharArray();
            C14342f0.m8185o(charArray, "(this as java.lang.String).toCharArray()");
            byte[] bytes = SQLiteDatabase.getBytes(charArray);
            C14342f0.m8185o(bytes, "getBytes(TsnSecret.getKe…Context()).toCharArray())");
            passphrase = bytes;
            factory = new SupportFactory(bytes);
            m7720b = C14389r.m7720b(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC15269a<RunDatabase>() { // from class: com.bxkj.student.run.app.offline.RunDatabase$Companion$instance$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // p617l1.InterfaceC15269a
                @NotNull
                public final RunDatabase invoke() {
                    SupportFactory supportFactory;
                    RoomDatabase.Builder databaseBuilder = Room.databaseBuilder(BaseApp.m44341b(), RunDatabase.class, "TSNRun.db");
                    supportFactory = RunDatabase.factory;
                    RoomDatabase build = databaseBuilder.openHelperFactory(supportFactory).build();
                    C14342f0.m8185o(build, "databaseBuilder(App.getA…\n                .build()");
                    return (RunDatabase) build;
                }
            });
            instance$delegate = m7720b;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Nullable
    public abstract RunDao runDao();
}
