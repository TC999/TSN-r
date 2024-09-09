package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f51309a;

    /* renamed from: b  reason: collision with root package name */
    private static w f51310b;

    /* renamed from: c  reason: collision with root package name */
    private static x f51311c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private int f51313b = 4;

        /* renamed from: c  reason: collision with root package name */
        private v f51314c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f51315d;

        /* renamed from: e  reason: collision with root package name */
        private ContentValues f51316e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f51317f;

        /* renamed from: g  reason: collision with root package name */
        private String[] f51318g;

        /* renamed from: h  reason: collision with root package name */
        private String f51319h;

        /* renamed from: i  reason: collision with root package name */
        private String[] f51320i;

        /* renamed from: j  reason: collision with root package name */
        private String f51321j;

        /* renamed from: k  reason: collision with root package name */
        private String f51322k;

        /* renamed from: l  reason: collision with root package name */
        private String f51323l;

        /* renamed from: m  reason: collision with root package name */
        private String f51324m;

        /* renamed from: n  reason: collision with root package name */
        private String f51325n;

        /* renamed from: o  reason: collision with root package name */
        private String[] f51326o;

        /* renamed from: p  reason: collision with root package name */
        private int f51327p;

        /* renamed from: q  reason: collision with root package name */
        private String f51328q;

        /* renamed from: r  reason: collision with root package name */
        private byte[] f51329r;

        public a() {
        }

        public final void a(int i4, String str, byte[] bArr) {
            this.f51327p = i4;
            this.f51328q = str;
            this.f51329r = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f51313b) {
                case 1:
                    w.this.a(this.f51315d, this.f51316e, this.f51314c);
                    return;
                case 2:
                    w.this.a(this.f51315d, this.f51325n, this.f51326o, this.f51314c);
                    return;
                case 3:
                    Cursor a4 = w.this.a(this.f51317f, this.f51315d, this.f51318g, this.f51319h, this.f51320i, this.f51321j, this.f51322k, this.f51323l, this.f51324m, this.f51314c);
                    if (a4 != null) {
                        a4.close();
                        return;
                    }
                    return;
                case 4:
                    w.this.a(this.f51327p, this.f51328q, this.f51329r, this.f51314c);
                    return;
                case 5:
                    w.this.a(this.f51327p, this.f51314c);
                    return;
                case 6:
                    w.this.a(this.f51327p, this.f51328q, this.f51314c);
                    return;
                default:
                    return;
            }
        }
    }

    private w(Context context, List<o> list) {
        f51311c = new x(context, list);
    }

    private synchronized boolean b(y yVar) {
        ContentValues d4;
        SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
        if (writableDatabase != null && (d4 = d(yVar)) != null) {
            long replace = writableDatabase.replace("t_pf", "_id", d4);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_pf");
                yVar.f51334a = replace;
                if (f51309a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f51309a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f51309a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    private static ContentValues c(y yVar) {
        if (yVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j4 = yVar.f51334a;
            if (j4 > 0) {
                contentValues.put("_id", Long.valueOf(j4));
            }
            contentValues.put("_tp", Integer.valueOf(yVar.f51335b));
            contentValues.put("_pc", yVar.f51336c);
            contentValues.put("_th", yVar.f51337d);
            contentValues.put("_tm", Long.valueOf(yVar.f51338e));
            byte[] bArr = yVar.f51340g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ContentValues d(y yVar) {
        if (yVar != null && !ap.b(yVar.f51339f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j4 = yVar.f51334a;
                if (j4 > 0) {
                    contentValues.put("_id", Long.valueOf(j4));
                }
                contentValues.put("_tp", yVar.f51339f);
                contentValues.put("_tm", Long.valueOf(yVar.f51338e));
                byte[] bArr = yVar.f51340g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized w a(Context context, List<o> list) {
        w wVar;
        synchronized (w.class) {
            if (f51310b == null) {
                f51310b = new w(context, list);
            }
            wVar = f51310b;
        }
        return wVar;
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            wVar = f51310b;
        }
        return wVar;
    }

    public final Cursor a(String str, String[] strArr, String str2) {
        return a(str, strArr, str2, (String) null, (String) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
        if (r1 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00aa, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c5, code lost:
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.y> c(int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.c(int):java.util.List");
    }

    public final Cursor a(String str, String[] strArr, String str2, String str3, String str4) {
        return a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    public final int a(String str, String str2) {
        return a(str, str2, (String[]) null, (v) null);
    }

    public final synchronized long a(String str, ContentValues contentValues, v vVar) {
        long j4;
        j4 = -1;
        SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, "_id", contentValues);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", str);
            } else {
                al.d("[Database] replace %s error.", str);
            }
            j4 = replace;
        }
        if (f51309a && writableDatabase != null) {
            writableDatabase.close();
        }
        return j4;
    }

    public final synchronized void b(int i4) {
        SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
        if (writableDatabase != null) {
            al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", i4 >= 0 ? "_tp = ".concat(String.valueOf(i4)) : null, null)));
            if (f51309a) {
                writableDatabase.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z3, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, v vVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z3, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, v vVar) {
        int delete;
        SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
        delete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        if (f51309a && writableDatabase != null) {
            writableDatabase.close();
        }
        return delete;
    }

    private static y b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f51334a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f51338e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f51339f = cursor.getString(cursor.getColumnIndex("_tp"));
            yVar.f51340g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean a(int i4, String str, byte[] bArr, boolean z3) {
        if (!z3) {
            a aVar = new a();
            aVar.a(i4, str, bArr);
            ak.a().a(aVar);
            return true;
        }
        return a(i4, str, bArr, (v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i4, String str, byte[] bArr, v vVar) {
        try {
            y yVar = new y();
            yVar.f51334a = i4;
            yVar.f51339f = str;
            yVar.f51338e = System.currentTimeMillis();
            yVar.f51340g = bArr;
            return b(yVar);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final Map<String, byte[]> a(int i4, v vVar) {
        HashMap hashMap = null;
        try {
            List<y> c4 = c(i4);
            if (c4 != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (y yVar : c4) {
                        byte[] bArr = yVar.f51340g;
                        if (bArr != null) {
                            hashMap2.put(yVar.f51339f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (al.a(th)) {
                        return hashMap;
                    }
                    th.printStackTrace();
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(y yVar) {
        ContentValues c4;
        SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
        if (writableDatabase != null && (c4 = c(yVar)) != null) {
            long replace = writableDatabase.replace("t_lr", "_id", c4);
            if (replace >= 0) {
                al.c("[Database] insert %s success.", "t_lr");
                yVar.f51334a = replace;
                if (f51309a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f51309a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f51309a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad A[Catch: all -> 0x00bd, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: all -> 0x00cd, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.y> a(int r12) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.w.a(int):java.util.List");
    }

    public final synchronized void a(List<y> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (y yVar : list) {
                        sb.append(" or _id = ");
                        sb.append(yVar.f51334a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    al.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    if (f51309a) {
                        writableDatabase.close();
                    }
                }
            }
        }
    }

    private static y a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.f51334a = cursor.getLong(cursor.getColumnIndex("_id"));
            yVar.f51335b = cursor.getInt(cursor.getColumnIndex("_tp"));
            yVar.f51336c = cursor.getString(cursor.getColumnIndex("_pc"));
            yVar.f51337d = cursor.getString(cursor.getColumnIndex("_th"));
            yVar.f51338e = cursor.getLong(cursor.getColumnIndex("_tm"));
            yVar.f51340g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return yVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i4, String str, v vVar) {
        boolean z3;
        String str2;
        SQLiteDatabase sQLiteDatabase = null;
        z3 = false;
        try {
            SQLiteDatabase writableDatabase = f51311c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (ap.b(str)) {
                        str2 = "_id = ".concat(String.valueOf(i4));
                    } else {
                        str2 = "_id = " + i4 + " and _tp = \"" + str + "\"";
                    }
                    int delete = writableDatabase.delete("t_pf", str2, null);
                    al.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                    if (delete > 0) {
                        z3 = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (f51309a && sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z3;
                }
            }
            if (f51309a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z3;
    }
}
