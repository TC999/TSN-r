package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.pro.C13131bm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.w */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12920w {

    /* renamed from: a */
    public static boolean f36943a;

    /* renamed from: b */
    private static C12920w f36944b;

    /* renamed from: c */
    private static C12922x f36945c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.w$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12921a extends Thread {

        /* renamed from: b */
        private int f36947b = 4;

        /* renamed from: c */
        private InterfaceC12919v f36948c = null;

        /* renamed from: d */
        private String f36949d;

        /* renamed from: e */
        private ContentValues f36950e;

        /* renamed from: f */
        private boolean f36951f;

        /* renamed from: g */
        private String[] f36952g;

        /* renamed from: h */
        private String f36953h;

        /* renamed from: i */
        private String[] f36954i;

        /* renamed from: j */
        private String f36955j;

        /* renamed from: k */
        private String f36956k;

        /* renamed from: l */
        private String f36957l;

        /* renamed from: m */
        private String f36958m;

        /* renamed from: n */
        private String f36959n;

        /* renamed from: o */
        private String[] f36960o;

        /* renamed from: p */
        private int f36961p;

        /* renamed from: q */
        private String f36962q;

        /* renamed from: r */
        private byte[] f36963r;

        public C12921a() {
        }

        /* renamed from: a */
        public final void m15481a(int i, String str, byte[] bArr) {
            this.f36961p = i;
            this.f36962q = str;
            this.f36963r = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f36947b) {
                case 1:
                    C12920w.this.m15494a(this.f36949d, this.f36950e, this.f36948c);
                    return;
                case 2:
                    C12920w.this.m15492a(this.f36949d, this.f36959n, this.f36960o, this.f36948c);
                    return;
                case 3:
                    Cursor m15488a = C12920w.this.m15488a(this.f36951f, this.f36949d, this.f36952g, this.f36953h, this.f36954i, this.f36955j, this.f36956k, this.f36957l, this.f36958m, this.f36948c);
                    if (m15488a != null) {
                        m15488a.close();
                        return;
                    }
                    return;
                case 4:
                    C12920w.this.m15505a(this.f36961p, this.f36962q, this.f36963r, this.f36948c);
                    return;
                case 5:
                    C12920w.this.m15507a(this.f36961p, this.f36948c);
                    return;
                case 6:
                    C12920w.this.m15506a(this.f36961p, this.f36962q, this.f36948c);
                    return;
                default:
                    return;
            }
        }
    }

    private C12920w(Context context, List<AbstractC12903o> list) {
        f36945c = new C12922x(context, list);
    }

    /* renamed from: b */
    private synchronized boolean m15485b(C12923y c12923y) {
        ContentValues m15482d;
        SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
        if (writableDatabase != null && (m15482d = m15482d(c12923y)) != null) {
            long replace = writableDatabase.replace("t_pf", C13131bm.f37927d, m15482d);
            if (replace >= 0) {
                C12820al.m15874c("[Database] insert %s success.", "t_pf");
                c12923y.f36968a = replace;
                if (f36943a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f36943a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f36943a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    /* renamed from: c */
    private static ContentValues m15483c(C12923y c12923y) {
        if (c12923y == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j = c12923y.f36968a;
            if (j > 0) {
                contentValues.put(C13131bm.f37927d, Long.valueOf(j));
            }
            contentValues.put(C13131bm.f37928e, Integer.valueOf(c12923y.f36969b));
            contentValues.put("_pc", c12923y.f36970c);
            contentValues.put("_th", c12923y.f36971d);
            contentValues.put("_tm", Long.valueOf(c12923y.f36972e));
            byte[] bArr = c12923y.f36974g;
            if (bArr != null) {
                contentValues.put("_dt", bArr);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: d */
    private static ContentValues m15482d(C12923y c12923y) {
        if (c12923y != null && !C12828ap.m15817b(c12923y.f36973f)) {
            try {
                ContentValues contentValues = new ContentValues();
                long j = c12923y.f36968a;
                if (j > 0) {
                    contentValues.put(C13131bm.f37927d, Long.valueOf(j));
                }
                contentValues.put(C13131bm.f37928e, c12923y.f36973f);
                contentValues.put("_tm", Long.valueOf(c12923y.f36972e));
                byte[] bArr = c12923y.f36974g;
                if (bArr != null) {
                    contentValues.put("_dt", bArr);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C12820al.m15877a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized C12920w m15503a(Context context, List<AbstractC12903o> list) {
        C12920w c12920w;
        synchronized (C12920w.class) {
            if (f36944b == null) {
                f36944b = new C12920w(context, list);
            }
            c12920w = f36944b;
        }
        return c12920w;
    }

    /* renamed from: a */
    public static synchronized C12920w m15509a() {
        C12920w c12920w;
        synchronized (C12920w.class) {
            c12920w = f36944b;
        }
        return c12920w;
    }

    /* renamed from: a */
    public final Cursor m15491a(String str, String[] strArr, String str2) {
        return m15490a(str, strArr, str2, (String) null, (String) null);
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
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.util.List<com.tencent.bugly.proguard.C12923y> m15484c(int r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12920w.m15484c(int):java.util.List");
    }

    /* renamed from: a */
    public final Cursor m15490a(String str, String[] strArr, String str2, String str3, String str4) {
        return m15488a(false, str, strArr, str2, null, null, null, str3, str4, null);
    }

    /* renamed from: a */
    public final int m15493a(String str, String str2) {
        return m15492a(str, str2, (String[]) null, (InterfaceC12919v) null);
    }

    /* renamed from: a */
    public final synchronized long m15494a(String str, ContentValues contentValues, InterfaceC12919v interfaceC12919v) {
        long j;
        j = -1;
        SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, C13131bm.f37927d, contentValues);
            if (replace >= 0) {
                C12820al.m15874c("[Database] insert %s success.", str);
            } else {
                C12820al.m15873d("[Database] replace %s error.", str);
            }
            j = replace;
        }
        if (f36943a && writableDatabase != null) {
            writableDatabase.close();
        }
        return j;
    }

    /* renamed from: b */
    public final synchronized void m15487b(int i) {
        SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
        if (writableDatabase != null) {
            C12820al.m15874c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", i >= 0 ? "_tp = ".concat(String.valueOf(i)) : null, null)));
            if (f36943a) {
                writableDatabase.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Cursor m15488a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, InterfaceC12919v interfaceC12919v) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
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
    /* renamed from: a */
    public synchronized int m15492a(String str, String str2, String[] strArr, InterfaceC12919v interfaceC12919v) {
        int delete;
        SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
        delete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        if (f36943a && writableDatabase != null) {
            writableDatabase.close();
        }
        return delete;
    }

    /* renamed from: b */
    private static C12923y m15486b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C12923y c12923y = new C12923y();
            c12923y.f36968a = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
            c12923y.f36972e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c12923y.f36973f = cursor.getString(cursor.getColumnIndex(C13131bm.f37928e));
            c12923y.f36974g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c12923y;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    public final boolean m15504a(int i, String str, byte[] bArr, boolean z) {
        if (!z) {
            C12921a c12921a = new C12921a();
            c12921a.m15481a(i, str, bArr);
            C12818ak.m15887a().m15886a(c12921a);
            return true;
        }
        return m15505a(i, str, bArr, (InterfaceC12919v) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15505a(int i, String str, byte[] bArr, InterfaceC12919v interfaceC12919v) {
        try {
            C12923y c12923y = new C12923y();
            c12923y.f36968a = i;
            c12923y.f36973f = str;
            c12923y.f36972e = System.currentTimeMillis();
            c12923y.f36974g = bArr;
            return m15485b(c12923y);
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public final Map<String, byte[]> m15507a(int i, InterfaceC12919v interfaceC12919v) {
        HashMap hashMap = null;
        try {
            List<C12923y> m15484c = m15484c(i);
            if (m15484c != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (C12923y c12923y : m15484c) {
                        byte[] bArr = c12923y.f36974g;
                        if (bArr != null) {
                            hashMap2.put(c12923y.f36973f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (C12820al.m15877a(th)) {
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

    /* renamed from: a */
    public final synchronized boolean m15495a(C12923y c12923y) {
        ContentValues m15483c;
        SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
        if (writableDatabase != null && (m15483c = m15483c(c12923y)) != null) {
            long replace = writableDatabase.replace("t_lr", C13131bm.f37927d, m15483c);
            if (replace >= 0) {
                C12820al.m15874c("[Database] insert %s success.", "t_lr");
                c12923y.f36968a = replace;
                if (f36943a) {
                    writableDatabase.close();
                }
                return true;
            }
            if (f36943a) {
                writableDatabase.close();
            }
            return false;
        }
        if (f36943a && writableDatabase != null) {
            writableDatabase.close();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad A[Catch: all -> 0x00bd, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2 A[Catch: all -> 0x00cd, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: all -> 0x00cd, TryCatch #4 {, blocks: (B:3:0x0001, B:14:0x002d, B:15:0x0030, B:17:0x0034, B:33:0x0097, B:35:0x009e, B:44:0x00b2, B:45:0x00b5, B:47:0x00b9, B:40:0x00a7, B:42:0x00ad), top: B:64:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.C12923y> m15508a(int r12) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C12920w.m15508a(int):java.util.List");
    }

    /* renamed from: a */
    public final synchronized void m15489a(List<C12923y> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (C12923y c12923y : list) {
                        sb.append(" or _id = ");
                        sb.append(c12923y.f36968a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    C12820al.m15874c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    if (f36943a) {
                        writableDatabase.close();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static C12923y m15502a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C12923y c12923y = new C12923y();
            c12923y.f36968a = cursor.getLong(cursor.getColumnIndex(C13131bm.f37927d));
            c12923y.f36969b = cursor.getInt(cursor.getColumnIndex(C13131bm.f37928e));
            c12923y.f36970c = cursor.getString(cursor.getColumnIndex("_pc"));
            c12923y.f36971d = cursor.getString(cursor.getColumnIndex("_th"));
            c12923y.f36972e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c12923y.f36974g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c12923y;
        } catch (Throwable th) {
            if (!C12820al.m15877a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized boolean m15506a(int i, String str, InterfaceC12919v interfaceC12919v) {
        boolean z;
        String str2;
        SQLiteDatabase sQLiteDatabase = null;
        z = false;
        try {
            SQLiteDatabase writableDatabase = f36945c.getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    if (C12828ap.m15817b(str)) {
                        str2 = "_id = ".concat(String.valueOf(i));
                    } else {
                        str2 = "_id = " + i + " and _tp = \"" + str + "\"";
                    }
                    int delete = writableDatabase.delete("t_pf", str2, null);
                    C12820al.m15874c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                    if (delete > 0) {
                        z = true;
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase = writableDatabase;
                    if (!C12820al.m15877a(th)) {
                        th.printStackTrace();
                    }
                    if (f36943a && sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    return z;
                }
            }
            if (f36943a && writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }
}
