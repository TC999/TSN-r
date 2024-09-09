package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class t {
    private static t E = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38440a = "k";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38441b = "p";

    /* renamed from: c  reason: collision with root package name */
    public static final String f38442c = "v";

    /* renamed from: d  reason: collision with root package name */
    public static final String f38443d = "l";

    /* renamed from: e  reason: collision with root package name */
    public static final String f38444e = "i";

    /* renamed from: f  reason: collision with root package name */
    public static final String f38445f = "a";

    /* renamed from: g  reason: collision with root package name */
    public static final String f38446g = "s";

    /* renamed from: h  reason: collision with root package name */
    public static final String f38447h = "n";

    /* renamed from: i  reason: collision with root package name */
    public static final String f38448i = "u";

    /* renamed from: j  reason: collision with root package name */
    public static final String f38449j = "c";

    /* renamed from: k  reason: collision with root package name */
    public static final String f38450k = "r";

    /* renamed from: l  reason: collision with root package name */
    public static final String f38451l = "b";

    /* renamed from: m  reason: collision with root package name */
    public static final String f38452m = "m";

    /* renamed from: n  reason: collision with root package name */
    public static final String f38453n = "el";

    /* renamed from: o  reason: collision with root package name */
    public static final String f38454o = "ail";

    /* renamed from: p  reason: collision with root package name */
    public static final String f38455p = "aps";

    /* renamed from: q  reason: collision with root package name */
    public static final String f38456q = "dp";

    /* renamed from: r  reason: collision with root package name */
    public static final String f38457r = "pcn";

    /* renamed from: s  reason: collision with root package name */
    public static final String f38458s = "pst";

    /* renamed from: t  reason: collision with root package name */
    public static final String f38459t = "d";

    /* renamed from: u  reason: collision with root package name */
    public static final String f38460u = "at";

    /* renamed from: v  reason: collision with root package name */
    public static final String f38461v = "dm";

    /* renamed from: w  reason: collision with root package name */
    public static final String f38462w = "rm";

    /* renamed from: x  reason: collision with root package name */
    public static final String f38463x = "pc";

    /* renamed from: y  reason: collision with root package name */
    public static final String f38464y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;

    /* renamed from: z  reason: collision with root package name */
    private int f38465z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, "w.db", (SQLiteDatabase.CursorFactory) null, t.this.f38465z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            if (i4 >= 3 || i5 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.B = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "wp"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L42
            r4[r1] = r0     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L42
            r5.append(r11)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L42
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L42
            if (r11 == 0) goto L36
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L36
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L34
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L34
            r1 = r0
            goto L36
        L34:
            goto L43
        L36:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
        L3e:
            r11.close()
            goto L4c
        L42:
            r11 = 0
        L43:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
            goto L3e
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r12.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r12) {
        /*
            r11 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.C     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "wp"
            r10 = 1
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L44
            r4[r1] = r0     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L44
            r5.append(r12)     // Catch: java.lang.Throwable -> L44
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L44
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L44
            if (r12 == 0) goto L38
            boolean r2 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L38
            int r0 = r12.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36
            int r0 = r12.getInt(r0)     // Catch: java.lang.Throwable -> L36
            if (r0 != r10) goto L38
            r1 = 1
            goto L38
        L36:
            goto L45
        L38:
            if (r12 == 0) goto L4e
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L4e
        L40:
            r12.close()
            goto L4e
        L44:
            r12 = 0
        L45:
            if (r12 == 0) goto L4e
            boolean r0 = r12.isClosed()
            if (r0 != 0) goto L4e
            goto L40
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            if (E == null) {
                E = new t(context);
            }
            tVar = E;
        }
        return tVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r11) {
        /*
            r10 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.C     // Catch: java.lang.Throwable -> L3a
            r9 = 1
            java.lang.String[] r2 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "p"
            r2[r8] = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            r3.append(r11)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L3a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3a
            if (r11 == 0) goto L2e
            int r0 = r11.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L2e
            r8 = 1
            goto L2e
        L2c:
            goto L3b
        L2e:
            if (r11 == 0) goto L44
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L44
        L36:
            r11.close()
            goto L44
        L3a:
            r11 = 0
        L3b:
            if (r11 == 0) goto L44
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L44
            goto L36
        L44:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    public long a(s sVar) {
        long j4 = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.f38416b));
        contentValues.put("aps", Integer.valueOf(sVar.f38430p));
        contentValues.put("p", sVar.f38417c);
        contentValues.put("a", sVar.f38419e);
        contentValues.put("l", sVar.f38422h);
        contentValues.put("v", sVar.f38418d);
        contentValues.put("dp", sVar.f38428n);
        contentValues.put("a", sVar.f38419e);
        contentValues.put("pcn", sVar.f38429o);
        contentValues.put("pst", Long.valueOf(sVar.f38433s));
        contentValues.put("rm", Integer.valueOf(sVar.f38437w));
        contentValues.put("at", Integer.valueOf(sVar.f38431q));
        contentValues.put("pc", Integer.valueOf(sVar.f38438x));
        contentValues.put("cbl", Integer.valueOf(sVar.f38439y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.f38424j)) {
            contentValues.put("dm", sVar.f38424j);
        }
        try {
            if (b(sVar.f38415a)) {
                j4 = this.C.update("wp", contentValues, "k=" + sVar.f38415a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.f38415a));
                j4 = this.C.insert("wp", null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j4;
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.f38419e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r a4 = r.a();
            for (s sVar2 : arrayList) {
                if (a4 != null) {
                    a4.a(sVar2.f38419e);
                }
                SQLiteDatabase sQLiteDatabase = this.C;
                sQLiteDatabase.delete("wp", "k=" + sVar2.f38415a, null);
                List<Integer> list = r.f38407b;
                if (list != null && !list.contains(Integer.valueOf(sVar2.f38415a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + "/." + sVar2.f38415a);
                }
                if (a4.b() != null && a4.b().get(sVar2.f38417c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.f38417c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update("wp", contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.C.update("wp", contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i4, int i5) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pc", Integer.valueOf(i5));
            SQLiteDatabase sQLiteDatabase = this.C;
            sQLiteDatabase.update("wp", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00aa, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b4, code lost:
        if (r1.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b6, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p0.s> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.C     // Catch: java.lang.Throwable -> Lad
            java.lang.String r2 = "wp"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto La4
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> La2
            if (r2 == 0) goto La4
            com.kuaishou.weapon.p0.s r2 = new com.kuaishou.weapon.p0.s     // Catch: java.lang.Throwable -> La2
            r2.<init>()     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38415a = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38417c = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38419e = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38422h = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38418d = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38433s = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38434t = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38437w = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f38438x = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.f38439y = r4     // Catch: java.lang.Throwable -> La2
            r0.add(r2)     // Catch: java.lang.Throwable -> La2
            goto L15
        La2:
            goto Lae
        La4:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
            goto Lb6
        Lad:
            r1 = 0
        Lae:
            if (r1 == 0) goto Lb9
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb9
        Lb6:
            r1.close()
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public void b(int i4, int i5) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i5));
            SQLiteDatabase sQLiteDatabase = this.C;
            sQLiteDatabase.update("wp", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        r1 = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z3 = true;
            Cursor query = this.C.query("wp", null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f38415a = query.getInt(query.getColumnIndex("k"));
                            sVar.f38416b = query.getInt(query.getColumnIndex("n"));
                            sVar.f38417c = query.getString(query.getColumnIndex("p"));
                            sVar.f38419e = query.getString(query.getColumnIndex("a"));
                            sVar.f38422h = query.getString(query.getColumnIndex("l"));
                            sVar.f38418d = query.getString(query.getColumnIndex("v"));
                            sVar.f38428n = query.getString(query.getColumnIndex("dp"));
                            sVar.f38430p = query.getInt(query.getColumnIndex("aps"));
                            sVar.f38429o = query.getString(query.getColumnIndex("pcn"));
                            sVar.f38431q = query.getInt(query.getColumnIndex("at"));
                            sVar.f38433s = query.getLong(query.getColumnIndex("pst"));
                            sVar.f38434t = query.getInt(query.getColumnIndex("d"));
                            sVar.f38437w = query.getInt(query.getColumnIndex("rm"));
                            sVar.f38424j = query.getString(query.getColumnIndex("dm"));
                            sVar.f38438x = query.getInt(query.getColumnIndex("pc"));
                            if (query.getInt(query.getColumnIndex("cbl")) != 1) {
                                z3 = false;
                            }
                            sVar.f38439y = z3;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public s a(int i4) {
        s sVar;
        Cursor cursor = null;
        r0 = null;
        s sVar2 = null;
        try {
            Cursor query = this.C.query("wp", null, "k=" + i4, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.f38415a = i4;
                            sVar.f38416b = query.getInt(query.getColumnIndex("n"));
                            sVar.f38417c = query.getString(query.getColumnIndex("p"));
                            sVar.f38419e = query.getString(query.getColumnIndex("a"));
                            sVar.f38422h = query.getString(query.getColumnIndex("l"));
                            sVar.f38418d = query.getString(query.getColumnIndex("v"));
                            sVar.f38428n = query.getString(query.getColumnIndex("dp"));
                            sVar.f38430p = query.getInt(query.getColumnIndex("aps"));
                            sVar.f38429o = query.getString(query.getColumnIndex("pcn"));
                            sVar.f38431q = query.getInt(query.getColumnIndex("at"));
                            sVar.f38433s = query.getLong(query.getColumnIndex("pst"));
                            sVar.f38434t = query.getInt(query.getColumnIndex("d"));
                            sVar.f38437w = query.getInt(query.getColumnIndex("rm"));
                            sVar.f38424j = query.getString(query.getColumnIndex("dm"));
                            sVar.f38438x = query.getInt(query.getColumnIndex("pc"));
                            boolean z3 = true;
                            if (query.getInt(query.getColumnIndex("cbl")) != 1) {
                                z3 = false;
                            }
                            sVar.f38439y = z3;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (query == null || query.isClosed()) {
                return sVar2;
            }
            query.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete("wp", "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public int a(int i4, int i5) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i5));
            SQLiteDatabase sQLiteDatabase = this.C;
            return sQLiteDatabase.update("wp", contentValues, "k=" + i4, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
