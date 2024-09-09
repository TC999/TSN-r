package com.baidu.liantian.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: D.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f12102d;

    /* renamed from: a  reason: collision with root package name */
    int f12103a = 5;

    /* renamed from: b  reason: collision with root package name */
    String f12104b = "create table tbchliantian(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,a TEXT)";

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f12105c;

    /* renamed from: e  reason: collision with root package name */
    private C0109a f12106e;

    /* renamed from: f  reason: collision with root package name */
    private Context f12107f;

    /* compiled from: D.java */
    /* renamed from: com.baidu.liantian.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class C0109a extends SQLiteOpenHelper {
        public C0109a(Context context) {
            super(context, "bliantianh.db", (SQLiteDatabase.CursorFactory) null, a.this.f12103a);
            b.a();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(a.this.f12104b);
            } catch (Throwable unused) {
                e.a();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            try {
                b.a();
                if (i4 < 3 && i5 >= 3) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE tbchliantian ADD COLUMN pr INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused) {
                        e.a();
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i4 < 5 && i5 >= 5) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE tbchliantian ADD COLUMN pdld INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused2) {
                        e.a();
                    }
                    sQLiteDatabase.endTransaction();
                }
                if (i4 >= 4 || i5 < 4) {
                    return;
                }
                sQLiteDatabase.execSQL("drop table if exists pgnliantian");
            } catch (Throwable unused3) {
                e.a();
            }
        }
    }

    private a(Context context) {
        b.a();
        this.f12107f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        C0109a c0109a = new C0109a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f12106e = c0109a;
        try {
            this.f12105c = c0109a.getWritableDatabase();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            f4.a(f12102d);
            b.a();
            if (f12102d == null) {
                f12102d = new a(context);
            }
            aVar = f12102d;
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (r2.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r2.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005e, code lost:
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.lang.String> b() {
        /*
            r10 = this;
            java.lang.String r0 = "'"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r10.f12105c     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "tbchliantian"
            r4 = 0
            java.lang.String r5 = "n=1"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L49
        L18:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L53
            if (r3 == 0) goto L49
            java.lang.String r3 = "k"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L53
            int r3 = r2.getInt(r3)     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = "v"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> L53
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L53
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L53
            r5.append(r4)     // Catch: java.lang.Throwable -> L53
            r5.append(r0)     // Catch: java.lang.Throwable -> L53
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L53
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L53
            goto L18
        L49:
            if (r2 == 0) goto L65
            boolean r0 = r2.isClosed()     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L65
            goto L5e
        L52:
            r2 = 0
        L53:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L65
            boolean r0 = r2.isClosed()     // Catch: java.lang.Throwable -> L62
            if (r0 != 0) goto L65
        L5e:
            r2.close()     // Catch: java.lang.Throwable -> L62
            goto L65
        L62:
            com.baidu.liantian.b.e.a()
        L65:
            return r1
        L66:
            r0 = move-exception
            if (r2 == 0) goto L76
            boolean r1 = r2.isClosed()     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L76
            r2.close()     // Catch: java.lang.Throwable -> L73
            goto L76
        L73:
            com.baidu.liantian.b.e.a()
        L76:
            goto L78
        L77:
            throw r0
        L78:
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.b():java.util.Map");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.lang.String> c() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.f12105c     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = "tbchliantian"
            r3 = 0
            java.lang.String r4 = "n=1"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L38
        L16:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L38
            java.lang.String r2 = "k"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L42
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L42
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L42
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L42
            goto L16
        L38:
            if (r1 == 0) goto L54
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L54
            goto L4d
        L41:
            r1 = 0
        L42:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L54
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L54
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L51
            goto L54
        L51:
            com.baidu.liantian.b.e.a()
        L54:
            return r0
        L55:
            r0 = move-exception
            if (r1 == 0) goto L65
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L65
            r1.close()     // Catch: java.lang.Throwable -> L62
            goto L65
        L62:
            com.baidu.liantian.b.e.a()
        L65:
            goto L67
        L66:
            throw r0
        L67:
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.c():java.util.Map");
    }

    public final void d() {
        List<Integer> list;
        try {
            ArrayList<ApkInfo> arrayList = new ArrayList();
            for (ApkInfo apkInfo : a()) {
                if (!e.c(apkInfo.pkgPath) && (list = g.f12209b) != null && !list.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            g a4 = g.a();
            for (ApkInfo apkInfo2 : arrayList) {
                if (a4 != null) {
                    a4.b(apkInfo2.packageName);
                }
                SQLiteDatabase sQLiteDatabase = this.f12105c;
                sQLiteDatabase.delete("tbchliantian", "k=" + apkInfo2.key, null);
                b.a();
                e.d(this.f12107f.getFilesDir().getCanonicalPath() + "/.liantian_" + apkInfo2.key);
                Context context = this.f12107f;
                if (context != null) {
                    e.d(context.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(int r12) {
        /*
            r11 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f12105c     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "tbchliantian"
            r10 = 1
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L45
            r4[r1] = r0     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L45
            r5.append(r12)     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L45
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L45
            if (r12 == 0) goto L35
            boolean r2 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L35
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L46
            int r0 = r12.getInt(r0)     // Catch: java.lang.Throwable -> L46
            if (r0 != r10) goto L35
            r1 = 1
        L35:
            if (r12 == 0) goto L52
            boolean r0 = r12.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
        L3d:
            r12.close()     // Catch: java.lang.Throwable -> L41
            goto L52
        L41:
            com.baidu.liantian.b.e.a()
            goto L52
        L45:
            r12 = 0
        L46:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L53
            if (r12 == 0) goto L52
            boolean r0 = r12.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
            goto L3d
        L52:
            return r1
        L53:
            r0 = move-exception
            if (r12 == 0) goto L63
            boolean r1 = r12.isClosed()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L63
            r12.close()     // Catch: java.lang.Throwable -> L60
            goto L63
        L60:
            com.baidu.liantian.b.e.a()
        L63:
            goto L65
        L64:
            throw r0
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.e(int):boolean");
    }

    public final void f(int i4) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) (-1));
            SQLiteDatabase sQLiteDatabase = this.f12105c;
            sQLiteDatabase.update("tbchliantian", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int g(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "pdld"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f12105c     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "tbchliantian"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L43
            r4[r1] = r0     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L43
            r5.append(r11)     // Catch: java.lang.Throwable -> L43
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L43
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L43
            if (r11 == 0) goto L33
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L33
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L44
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L44
            r1 = r0
        L33:
            if (r11 == 0) goto L50
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto L50
        L3b:
            r11.close()     // Catch: java.lang.Throwable -> L3f
            goto L50
        L3f:
            com.baidu.liantian.b.e.a()
            goto L50
        L43:
            r11 = 0
        L44:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L51
            if (r11 == 0) goto L50
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto L50
            goto L3b
        L50:
            return r1
        L51:
            r0 = move-exception
            if (r11 == 0) goto L61
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L61
            r11.close()     // Catch: java.lang.Throwable -> L5e
            goto L61
        L5e:
            com.baidu.liantian.b.e.a()
        L61:
            goto L63
        L62:
            throw r0
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.g(int):int");
    }

    public final void h(int i4) {
        b.a();
        if (i4 <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.f12105c;
            sQLiteDatabase.delete("tbchliantian", "k=" + i4, null);
            b.a();
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final long a(ApkInfo apkInfo) {
        long j4 = 0;
        if (apkInfo == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(apkInfo.initStatus));
        contentValues.put("p", apkInfo.packageName);
        contentValues.put("a", apkInfo.pkgPath);
        contentValues.put("l", apkInfo.libPath);
        contentValues.put("v", apkInfo.versionName);
        contentValues.put("apk", apkInfo.dexPath);
        contentValues.put("ap", Integer.valueOf(apkInfo.apkParseSuc));
        contentValues.put("cl", apkInfo.className);
        contentValues.put("st", Long.valueOf(apkInfo.startTime));
        contentValues.put("du", Integer.valueOf(apkInfo.duration));
        contentValues.put("m5", apkInfo.apkMD5);
        contentValues.put("th", Integer.valueOf(apkInfo.applicationTheme));
        contentValues.put("pr", Integer.valueOf(apkInfo.priority));
        ActivityInfo[] activityInfoArr = apkInfo.activities;
        if (activityInfoArr != null) {
            contentValues.put("ac", new com.baidu.liantian.core.a(activityInfoArr).a());
        }
        try {
            if (b(apkInfo.key)) {
                j4 = this.f12105c.update("tbchliantian", contentValues, "k=" + apkInfo.key, null);
            } else {
                contentValues.put("k", Integer.valueOf(apkInfo.key));
                j4 = this.f12105c.insert("tbchliantian", null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(int r11) {
        /*
            r10 = this;
            java.lang.String r1 = "tbchliantian"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.f12105c     // Catch: java.lang.Throwable -> L3b
            r9 = 1
            java.lang.String[] r2 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "p"
            r2[r8] = r3     // Catch: java.lang.Throwable -> L3b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3b
            r3.append(r11)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3b
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L2b
            int r0 = r11.getCount()     // Catch: java.lang.Throwable -> L3c
            if (r0 <= 0) goto L2b
            r8 = 1
        L2b:
            if (r11 == 0) goto L48
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L48
        L33:
            r11.close()     // Catch: java.lang.Throwable -> L37
            goto L48
        L37:
            com.baidu.liantian.b.e.a()
            goto L48
        L3b:
            r11 = 0
        L3c:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L49
            if (r11 == 0) goto L48
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L37
            if (r0 != 0) goto L48
            goto L33
        L48:
            return r8
        L49:
            r0 = move-exception
            if (r11 == 0) goto L59
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L56
            if (r1 != 0) goto L59
            r11.close()     // Catch: java.lang.Throwable -> L56
            goto L59
        L56:
            com.baidu.liantian.b.e.a()
        L59:
            goto L5b
        L5a:
            throw r0
        L5b:
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.b(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (r11.isClosed() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f12105c     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = "tbchliantian"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L43
            r4[r1] = r0     // Catch: java.lang.Throwable -> L43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L43
            r5.append(r11)     // Catch: java.lang.Throwable -> L43
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L43
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L43
            if (r11 == 0) goto L33
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L33
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L44
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L44
            r1 = r0
        L33:
            if (r11 == 0) goto L50
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto L50
        L3b:
            r11.close()     // Catch: java.lang.Throwable -> L3f
            goto L50
        L3f:
            com.baidu.liantian.b.e.a()
            goto L50
        L43:
            r11 = 0
        L44:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L51
            if (r11 == 0) goto L50
            boolean r0 = r11.isClosed()     // Catch: java.lang.Throwable -> L3f
            if (r0 != 0) goto L50
            goto L3b
        L50:
            return r1
        L51:
            r0 = move-exception
            if (r11 == 0) goto L61
            boolean r1 = r11.isClosed()     // Catch: java.lang.Throwable -> L5e
            if (r1 != 0) goto L61
            r11.close()     // Catch: java.lang.Throwable -> L5e
            goto L61
        L5e:
            com.baidu.liantian.b.e.a()
        L61:
            goto L63
        L62:
            throw r0
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.c(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(int r12) {
        /*
            r11 = this;
            java.lang.String r0 = "u"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f12105c     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "tbchliantian"
            r10 = 1
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L45
            r4[r1] = r0     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L45
            r5.append(r12)     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L45
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L45
            if (r12 == 0) goto L35
            boolean r2 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L35
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L46
            int r0 = r12.getInt(r0)     // Catch: java.lang.Throwable -> L46
            if (r0 != r10) goto L35
            r1 = 1
        L35:
            if (r12 == 0) goto L52
            boolean r0 = r12.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
        L3d:
            r12.close()     // Catch: java.lang.Throwable -> L41
            goto L52
        L41:
            com.baidu.liantian.b.e.a()
            goto L52
        L45:
            r12 = 0
        L46:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L53
            if (r12 == 0) goto L52
            boolean r0 = r12.isClosed()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L52
            goto L3d
        L52:
            return r1
        L53:
            r0 = move-exception
            if (r12 == 0) goto L63
            boolean r1 = r12.isClosed()     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L63
            r12.close()     // Catch: java.lang.Throwable -> L60
            goto L63
        L60:
            com.baidu.liantian.b.e.a()
        L63:
            goto L65
        L64:
            throw r0
        L65:
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.d(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x008a, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0097, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0099, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.core.ApkInfo> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.f12105c     // Catch: java.lang.Throwable -> L8d
            java.lang.String r2 = "tbchliantian"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto L84
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L84
            com.baidu.liantian.core.ApkInfo r2 = new com.baidu.liantian.core.ApkInfo     // Catch: java.lang.Throwable -> L8e
            r2.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8e
            r2.key = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8e
            r2.packageName = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8e
            r2.pkgPath = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8e
            r2.libPath = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8e
            r2.versionName = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "st"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L8e
            r2.startTime = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "du"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8e
            r2.duration = r3     // Catch: java.lang.Throwable -> L8e
            java.lang.String r3 = "pr"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L8e
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8e
            r2.priority = r3     // Catch: java.lang.Throwable -> L8e
            r0.add(r2)     // Catch: java.lang.Throwable -> L8e
            goto L15
        L84:
            if (r1 == 0) goto La0
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L9d
            if (r2 != 0) goto La0
            goto L99
        L8d:
            r1 = 0
        L8e:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> La1
            if (r1 == 0) goto La0
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L9d
            if (r2 != 0) goto La0
        L99:
            r1.close()     // Catch: java.lang.Throwable -> L9d
            goto La0
        L9d:
            com.baidu.liantian.b.e.a()
        La0:
            return r0
        La1:
            r0 = move-exception
            if (r1 == 0) goto Lb1
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> Lae
            if (r2 != 0) goto Lb1
            r1.close()     // Catch: java.lang.Throwable -> Lae
            goto Lb1
        Lae:
            com.baidu.liantian.b.e.a()
        Lb1:
            goto Lb3
        Lb2:
            throw r0
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.a.a.a():java.util.List");
    }

    public final String[] b(String str) {
        String[] strArr;
        Cursor cursor = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        r3 = null;
        String[] strArr2 = null;
        try {
            Cursor query = this.f12105c.query("tbchliantian", new String[]{"r", "b", "t"}, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        boolean z3 = query.getInt(query.getColumnIndex("r")) == 1;
                        String string = query.getString(query.getColumnIndex("b"));
                        String string2 = query.getString(query.getColumnIndex("t"));
                        if (z3 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            strArr2 = new String[]{string, string2};
                        }
                    }
                } catch (Throwable unused) {
                    strArr = strArr2;
                    cursor = query;
                    try {
                        e.a();
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable unused2) {
                                e.a();
                            }
                        }
                        return strArr;
                    } catch (Throwable th) {
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable unused3) {
                                e.a();
                            }
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return strArr2;
                    }
                    query.close();
                    return strArr2;
                } catch (Throwable unused4) {
                    e.a();
                    return strArr2;
                }
            }
            return strArr2;
        } catch (Throwable unused5) {
            strArr = null;
        }
    }

    public final void c(int i4, int i5) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pr", Integer.valueOf(i5));
            SQLiteDatabase sQLiteDatabase = this.f12105c;
            sQLiteDatabase.update("tbchliantian", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final ApkInfo c(String str) {
        ApkInfo apkInfo;
        ArrayList<com.baidu.liantian.core.b> a4;
        int size;
        Cursor cursor = null;
        r1 = null;
        ApkInfo apkInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cursor query = this.f12105c.query("tbchliantian", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = query.getInt(query.getColumnIndex("k"));
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex("cl"));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a4 = com.baidu.liantian.core.a.a(blob)) != null && (size = a4.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i4 = 0; i4 < size; i4++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a4.get(i4).f12155a;
                                    activityInfo.name = a4.get(i4).f12164j;
                                    activityInfo.configChanges = a4.get(i4).f12162h;
                                    activityInfo.flags = a4.get(i4).f12160f;
                                    activityInfo.labelRes = a4.get(i4).f12166l;
                                    activityInfo.launchMode = a4.get(i4).f12156b;
                                    activityInfo.nonLocalizedLabel = a4.get(i4).f12167m;
                                    activityInfo.packageName = a4.get(i4).f12165k;
                                    activityInfo.permission = a4.get(i4).f12157c;
                                    activityInfo.screenOrientation = a4.get(i4).f12161g;
                                    activityInfo.softInputMode = a4.get(i4).f12163i;
                                    activityInfo.targetActivity = a4.get(i4).f12159e;
                                    activityInfo.taskAffinity = a4.get(i4).f12158d;
                                    apkInfo.activities[i4] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                e.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    e.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final void b(int i4, int i5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i5));
        try {
            SQLiteDatabase sQLiteDatabase = this.f12105c;
            sQLiteDatabase.update("tbchliantian", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final ApkInfo a(int i4) {
        ApkInfo apkInfo;
        ArrayList<com.baidu.liantian.core.b> a4;
        int size;
        Cursor cursor = null;
        r0 = null;
        ApkInfo apkInfo2 = null;
        try {
            Cursor query = this.f12105c.query("tbchliantian", null, "k=" + i4, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        apkInfo = new ApkInfo();
                        try {
                            apkInfo.key = i4;
                            apkInfo.initStatus = query.getInt(query.getColumnIndex("n"));
                            apkInfo.packageName = query.getString(query.getColumnIndex("p"));
                            apkInfo.pkgPath = query.getString(query.getColumnIndex("a"));
                            apkInfo.libPath = query.getString(query.getColumnIndex("l"));
                            apkInfo.versionName = query.getString(query.getColumnIndex("v"));
                            apkInfo.dexPath = query.getString(query.getColumnIndex("apk"));
                            apkInfo.apkParseSuc = query.getInt(query.getColumnIndex("ap"));
                            apkInfo.className = query.getString(query.getColumnIndex("cl"));
                            apkInfo.applicationTheme = query.getInt(query.getColumnIndex("th"));
                            apkInfo.startTime = query.getLong(query.getColumnIndex("st"));
                            apkInfo.duration = query.getInt(query.getColumnIndex("du"));
                            apkInfo.apkMD5 = query.getString(query.getColumnIndex("m5"));
                            apkInfo.priority = query.getInt(query.getColumnIndex("pr"));
                            byte[] blob = query.getBlob(query.getColumnIndex("ac"));
                            if (blob != null && (a4 = com.baidu.liantian.core.a.a(blob)) != null && (size = a4.size()) > 0) {
                                apkInfo.activities = new ActivityInfo[size];
                                for (int i5 = 0; i5 < size; i5++) {
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.theme = a4.get(i5).f12155a;
                                    activityInfo.name = a4.get(i5).f12164j;
                                    activityInfo.configChanges = a4.get(i5).f12162h;
                                    activityInfo.flags = a4.get(i5).f12160f;
                                    activityInfo.labelRes = a4.get(i5).f12166l;
                                    activityInfo.launchMode = a4.get(i5).f12156b;
                                    activityInfo.nonLocalizedLabel = a4.get(i5).f12167m;
                                    activityInfo.packageName = a4.get(i5).f12165k;
                                    activityInfo.permission = a4.get(i5).f12157c;
                                    activityInfo.screenOrientation = a4.get(i5).f12161g;
                                    activityInfo.softInputMode = a4.get(i5).f12163i;
                                    activityInfo.targetActivity = a4.get(i5).f12159e;
                                    activityInfo.taskAffinity = a4.get(i5).f12158d;
                                    apkInfo.activities[i5] = activityInfo;
                                }
                            }
                            apkInfo2 = apkInfo;
                        } catch (Throwable unused) {
                            cursor = query;
                            try {
                                e.a();
                                return apkInfo;
                            } finally {
                                if (cursor != null) {
                                    try {
                                        if (!cursor.isClosed()) {
                                            cursor.close();
                                        }
                                    } catch (Throwable unused2) {
                                        e.a();
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    apkInfo = null;
                }
            }
            if (query != null) {
                try {
                    if (query.isClosed()) {
                        return apkInfo2;
                    }
                    query.close();
                    return apkInfo2;
                } catch (Throwable unused4) {
                    e.a();
                    return apkInfo2;
                }
            }
            return apkInfo2;
        } catch (Throwable unused5) {
            apkInfo = null;
        }
    }

    public final void a(String str) {
        b.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f12105c.delete("tbchliantian", "p=?", new String[]{str});
        } catch (Throwable unused) {
            e.a();
        }
    }

    public final int a(int i4, int i5) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i5));
            SQLiteDatabase sQLiteDatabase = this.f12105c;
            return sQLiteDatabase.update("tbchliantian", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
