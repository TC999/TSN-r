package com.kwad.components.core.p287c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.kwad.components.core.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8544a {

    /* renamed from: IO */
    private static volatile C8544a f28081IO;

    /* renamed from: IN */
    private final SQLiteDatabase f28082IN;

    /* renamed from: com.kwad.components.core.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8545a extends SQLiteOpenHelper {

        /* renamed from: IP */
        private static int f28083IP = 1;

        /* renamed from: IQ */
        private String f28084IQ;

        /* renamed from: IR */
        private String f28085IR;

        public C8545a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, f28083IP);
            this.f28084IQ = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.f28085IR = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.f28084IQ);
            sQLiteDatabase.execSQL(this.f28085IR);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private C8544a(Context context) {
        this.f28082IN = new C8545a(context).getWritableDatabase();
    }

    /* renamed from: b */
    private <T extends InterfaceC8556i> void m30403b(List<T> list, String str) {
        try {
            try {
                this.f28082IN.beginTransaction();
                for (T t : list) {
                    try {
                        long insertWithOnConflict = this.f28082IN.insertWithOnConflict(str, null, t.mo30359mD(), 5);
                        C10331c.m26254d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e) {
                        C10331c.printStackTrace(e);
                    }
                }
                this.f28082IN.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.f28082IN;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        C10331c.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                C10331c.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.f28082IN;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        C10331c.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.f28082IN;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    C10331c.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    @Nullable
    /* renamed from: mu */
    public static C8544a m30401mu() {
        if (f28081IO == null) {
            synchronized (C8544a.class) {
                if (f28081IO == null) {
                    try {
                        f28081IO = new C8544a(ServiceProvider.m24363KO());
                    } catch (SQLiteException e) {
                        C10331c.printStackTraceOnly(e);
                        f28081IO = null;
                    }
                }
            }
        }
        return f28081IO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    /* renamed from: X */
    public final C8551e m30406X(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.f28082IN.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e) {
                e = e;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                C10738b.closeQuietly((Closeable) str);
                throw th;
            }
            try {
                List<C8551e> m30388a = C8551e.m30388a(cursor);
                if (m30388a != null && m30388a.size() > 0) {
                    C8551e c8551e = m30388a.get(0);
                    C10738b.closeQuietly(cursor);
                    return c8551e;
                }
            } catch (Exception e2) {
                e = e2;
                C10331c.printStackTraceOnly(e);
                C10738b.closeQuietly(cursor);
                return null;
            }
            C10738b.closeQuietly(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C10738b.closeQuietly((Closeable) str);
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0096: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x0096 */
    @Nullable
    @WorkerThread
    /* renamed from: a */
    public final List<C8555h> m30404a(String str, long j, int i) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.f28082IN.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e) {
                e = e;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                C10738b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<C8555h> m30372a = C8555h.m30372a(cursor);
                if (m30372a == null) {
                    C10738b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (C8555h c8555h : m30372a) {
                    i2++;
                    if (i2 <= i) {
                        if (c8555h.m30362mK() >= j) {
                            arrayList.add(c8555h);
                        }
                    } else {
                        sb.append(" creativeId = ");
                        sb.append(c8555h.m30360mM());
                        if (i2 == m30372a.size()) {
                            sb.append(")");
                        } else {
                            sb.append(" OR");
                        }
                    }
                }
                if (i2 > i) {
                    this.f28082IN.delete("ksad_ad_cache", sb.toString(), new String[0]);
                }
                C10738b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                C10331c.printStackTraceOnly(e);
                C10738b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            C10738b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    /* renamed from: i */
    public final void m30402i(List<C8555h> list) {
        m30403b(list, "ksad_ad_cache");
    }

    @WorkerThread
    /* renamed from: mv */
    public final void m30400mv() {
        try {
            this.f28082IN.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @WorkerThread
    /* renamed from: r */
    public final void m30399r(long j) {
        try {
            int delete = this.f28082IN.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
            C10331c.m26254d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: a */
    public final void m30405a(C8551e c8551e) {
        m30403b(Collections.singletonList(c8551e), "ksad_ad_cache_strategy");
    }
}
