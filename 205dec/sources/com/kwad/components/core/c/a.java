package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    private static volatile a IO;
    private final SQLiteDatabase IN;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class C0621a extends SQLiteOpenHelper {
        private static int IP = 1;
        private String IQ;
        private String IR;

        public C0621a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, IP);
            this.IQ = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.IR = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.IQ);
            sQLiteDatabase.execSQL(this.IR);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        }
    }

    private a(Context context) {
        this.IN = new C0621a(context).getWritableDatabase();
    }

    private <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.IN.beginTransaction();
                for (T t3 : list) {
                    try {
                        long insertWithOnConflict = this.IN.insertWithOnConflict(str, null, t3.mD(), 5);
                        com.kwad.sdk.core.e.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e4) {
                        com.kwad.sdk.core.e.c.printStackTrace(e4);
                    }
                }
                this.IN.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.IN;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e5) {
                        com.kwad.sdk.core.e.c.printStackTrace(e5);
                    }
                }
            } catch (Exception e6) {
                com.kwad.sdk.core.e.c.printStackTrace(e6);
                SQLiteDatabase sQLiteDatabase2 = this.IN;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e7) {
                        com.kwad.sdk.core.e.c.printStackTrace(e7);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.IN;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e8) {
                    com.kwad.sdk.core.e.c.printStackTrace(e8);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static a mu() {
        if (IO == null) {
            synchronized (a.class) {
                if (IO == null) {
                    try {
                        IO = new a(ServiceProvider.KO());
                    } catch (SQLiteException e4) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                        IO = null;
                    }
                }
            }
        }
        return IO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    @WorkerThread
    public final e X(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                cursor = this.IN.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
            try {
                List<e> a4 = e.a(cursor);
                if (a4 != null && a4.size() > 0) {
                    e eVar = a4.get(0);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return eVar;
                }
            } catch (Exception e5) {
                e = e5;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0096: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x0096 */
    @Nullable
    @WorkerThread
    public final List<h> a(String str, long j4, int i4) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.IN.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<h> a4 = h.a(cursor);
                if (a4 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i5 = 0;
                for (h hVar : a4) {
                    i5++;
                    if (i5 <= i4) {
                        if (hVar.mK() >= j4) {
                            arrayList.add(hVar);
                        }
                    } else {
                        sb.append(" creativeId = ");
                        sb.append(hVar.mM());
                        if (i5 == a4.size()) {
                            sb.append(")");
                        } else {
                            sb.append(" OR");
                        }
                    }
                }
                if (i5 > i4) {
                    this.IN.delete("ksad_ad_cache", sb.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e5) {
                e = e5;
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    public final void i(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void mv() {
        try {
            this.IN.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    @WorkerThread
    public final void r(long j4) {
        try {
            int delete = this.IN.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j4)});
            com.kwad.sdk.core.e.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    public final void a(e eVar) {
        b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
    }
}
