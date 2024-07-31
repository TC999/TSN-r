package com.kuaishou.weapon.p205p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7304t {

    /* renamed from: E */
    private static C7304t f25044E = null;

    /* renamed from: a */
    public static final String f25045a = "k";

    /* renamed from: b */
    public static final String f25046b = "p";

    /* renamed from: c */
    public static final String f25047c = "v";

    /* renamed from: d */
    public static final String f25048d = "l";

    /* renamed from: e */
    public static final String f25049e = "i";

    /* renamed from: f */
    public static final String f25050f = "a";

    /* renamed from: g */
    public static final String f25051g = "s";

    /* renamed from: h */
    public static final String f25052h = "n";

    /* renamed from: i */
    public static final String f25053i = "u";

    /* renamed from: j */
    public static final String f25054j = "c";

    /* renamed from: k */
    public static final String f25055k = "r";

    /* renamed from: l */
    public static final String f25056l = "b";

    /* renamed from: m */
    public static final String f25057m = "m";

    /* renamed from: n */
    public static final String f25058n = "el";

    /* renamed from: o */
    public static final String f25059o = "ail";

    /* renamed from: p */
    public static final String f25060p = "aps";

    /* renamed from: q */
    public static final String f25061q = "dp";

    /* renamed from: r */
    public static final String f25062r = "pcn";

    /* renamed from: s */
    public static final String f25063s = "pst";

    /* renamed from: t */
    public static final String f25064t = "d";

    /* renamed from: u */
    public static final String f25065u = "at";

    /* renamed from: v */
    public static final String f25066v = "dm";

    /* renamed from: w */
    public static final String f25067w = "rm";

    /* renamed from: x */
    public static final String f25068x = "pc";

    /* renamed from: y */
    public static final String f25069y = "cbl";

    /* renamed from: B */
    private C7305a f25071B;

    /* renamed from: C */
    private SQLiteDatabase f25072C;

    /* renamed from: D */
    private Context f25073D;

    /* renamed from: z */
    private int f25074z = 1;

    /* renamed from: A */
    private String f25070A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    /* renamed from: com.kuaishou.weapon.p0.t$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class C7305a extends SQLiteOpenHelper {
        public C7305a(Context context) {
            super(context, C7193bi.f24581p, (SQLiteDatabase.CursorFactory) null, C7304t.this.f25074z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(C7304t.this.f25070A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i >= 3 || i2 < 3) {
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

    private C7304t(Context context) {
        this.f25073D = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f25071B = new C7305a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.f25072C = this.f25071B.getWritableDatabase();
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
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m33750c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f25072C     // Catch: java.lang.Throwable -> L42
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7304t.m33750c(int):int");
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
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m33747d(int r12) {
        /*
            r11 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f25072C     // Catch: java.lang.Throwable -> L44
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7304t.m33747d(int):boolean");
    }

    /* renamed from: a */
    public static synchronized C7304t m33760a(Context context) {
        C7304t c7304t;
        synchronized (C7304t.class) {
            if (f25044E == null) {
                f25044E = new C7304t(context);
            }
            c7304t = f25044E;
        }
        return c7304t;
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
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m33755b(int r11) {
        /*
            r10 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r10.f25072C     // Catch: java.lang.Throwable -> L3a
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7304t.m33755b(int):boolean");
    }

    /* renamed from: a */
    public long m33759a(C7303s c7303s) {
        long j = 0;
        if (c7303s == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(c7303s.f25020b));
        contentValues.put(f25060p, Integer.valueOf(c7303s.f25034p));
        contentValues.put("p", c7303s.f25021c);
        contentValues.put("a", c7303s.f25023e);
        contentValues.put(f25048d, c7303s.f25026h);
        contentValues.put("v", c7303s.f25022d);
        contentValues.put(f25061q, c7303s.f25032n);
        contentValues.put("a", c7303s.f25023e);
        contentValues.put(f25062r, c7303s.f25033o);
        contentValues.put(f25063s, Long.valueOf(c7303s.f25037s));
        contentValues.put(f25067w, Integer.valueOf(c7303s.f25041w));
        contentValues.put("at", Integer.valueOf(c7303s.f25035q));
        contentValues.put(f25068x, Integer.valueOf(c7303s.f25042x));
        contentValues.put(f25069y, Integer.valueOf(c7303s.f25043y ? 1 : 0));
        if (!TextUtils.isEmpty(c7303s.f25028j)) {
            contentValues.put(f25066v, c7303s.f25028j);
        }
        try {
            if (m33755b(c7303s.f25019a)) {
                j = this.f25072C.update(C7193bi.f24582q, contentValues, "k=" + c7303s.f25019a, null);
            } else {
                contentValues.put("k", Integer.valueOf(c7303s.f25019a));
                j = this.f25072C.insert(C7193bi.f24582q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    /* renamed from: b */
    public void m33756b() {
        ArrayList<C7303s> arrayList = new ArrayList();
        for (C7303s c7303s : m33763a()) {
            if (!C7271dn.m33938a(c7303s.f25023e)) {
                arrayList.add(c7303s);
            }
        }
        try {
            C7302r m33776a = C7302r.m33776a();
            for (C7303s c7303s2 : arrayList) {
                if (m33776a != null) {
                    m33776a.m33770a(c7303s2.f25023e);
                }
                SQLiteDatabase sQLiteDatabase = this.f25072C;
                sQLiteDatabase.delete(C7193bi.f24582q, "k=" + c7303s2.f25019a, null);
                List<Integer> list = C7302r.f25011b;
                if (list != null && !list.contains(Integer.valueOf(c7303s2.f25019a))) {
                    C7271dn.m33933c(this.f25073D.getFilesDir().getCanonicalPath() + C7193bi.f24575j + c7303s2.f25019a);
                }
                if (m33776a.m33768b() != null && m33776a.m33768b().get(c7303s2.f25021c) != null) {
                    C7271dn.m33933c(this.f25073D.getFileStreamPath(c7303s2.f25021c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void m33751c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.f25072C.update(C7193bi.f24582q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: d */
    public void m33748d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("u", (Integer) 0);
        try {
            this.f25072C.update(C7193bi.f24582q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public void m33749c(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f25068x, Integer.valueOf(i2));
            SQLiteDatabase sQLiteDatabase = this.f25072C;
            sQLiteDatabase.update(C7193bi.f24582q, contentValues, "k=" + i, null);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p205p0.C7303s> m33763a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.f25072C     // Catch: java.lang.Throwable -> Lad
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
            r2.f25019a = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25021c = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25023e = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25026h = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25022d = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25037s = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25038t = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25041w = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r2.f25042x = r3     // Catch: java.lang.Throwable -> La2
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> La2
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La2
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.f25043y = r4     // Catch: java.lang.Throwable -> La2
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7304t.m33763a():java.util.List");
    }

    /* renamed from: b */
    public void m33754b(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i2));
            SQLiteDatabase sQLiteDatabase = this.f25072C;
            sQLiteDatabase.update(C7193bi.f24582q, contentValues, "k=" + i, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public C7303s m33752b(String str) {
        C7303s c7303s;
        Cursor cursor = null;
        r1 = null;
        C7303s c7303s2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z = true;
            Cursor query = this.f25072C.query(C7193bi.f24582q, null, "p=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c7303s = new C7303s();
                        try {
                            c7303s.f25019a = query.getInt(query.getColumnIndex("k"));
                            c7303s.f25020b = query.getInt(query.getColumnIndex("n"));
                            c7303s.f25021c = query.getString(query.getColumnIndex("p"));
                            c7303s.f25023e = query.getString(query.getColumnIndex("a"));
                            c7303s.f25026h = query.getString(query.getColumnIndex(f25048d));
                            c7303s.f25022d = query.getString(query.getColumnIndex("v"));
                            c7303s.f25032n = query.getString(query.getColumnIndex(f25061q));
                            c7303s.f25034p = query.getInt(query.getColumnIndex(f25060p));
                            c7303s.f25033o = query.getString(query.getColumnIndex(f25062r));
                            c7303s.f25035q = query.getInt(query.getColumnIndex("at"));
                            c7303s.f25037s = query.getLong(query.getColumnIndex(f25063s));
                            c7303s.f25038t = query.getInt(query.getColumnIndex("d"));
                            c7303s.f25041w = query.getInt(query.getColumnIndex(f25067w));
                            c7303s.f25028j = query.getString(query.getColumnIndex(f25066v));
                            c7303s.f25042x = query.getInt(query.getColumnIndex(f25068x));
                            if (query.getInt(query.getColumnIndex(f25069y)) != 1) {
                                z = false;
                            }
                            c7303s.f25043y = z;
                            c7303s2 = c7303s;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return c7303s;
                        }
                    }
                } catch (Throwable unused2) {
                    c7303s = null;
                }
            }
            if (query == null || query.isClosed()) {
                return c7303s2;
            }
            query.close();
            return c7303s2;
        } catch (Throwable unused3) {
            c7303s = null;
        }
    }

    /* renamed from: a */
    public C7303s m33762a(int i) {
        C7303s c7303s;
        Cursor cursor = null;
        r0 = null;
        C7303s c7303s2 = null;
        try {
            Cursor query = this.f25072C.query(C7193bi.f24582q, null, "k=" + i, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        c7303s = new C7303s();
                        try {
                            c7303s.f25019a = i;
                            c7303s.f25020b = query.getInt(query.getColumnIndex("n"));
                            c7303s.f25021c = query.getString(query.getColumnIndex("p"));
                            c7303s.f25023e = query.getString(query.getColumnIndex("a"));
                            c7303s.f25026h = query.getString(query.getColumnIndex(f25048d));
                            c7303s.f25022d = query.getString(query.getColumnIndex("v"));
                            c7303s.f25032n = query.getString(query.getColumnIndex(f25061q));
                            c7303s.f25034p = query.getInt(query.getColumnIndex(f25060p));
                            c7303s.f25033o = query.getString(query.getColumnIndex(f25062r));
                            c7303s.f25035q = query.getInt(query.getColumnIndex("at"));
                            c7303s.f25037s = query.getLong(query.getColumnIndex(f25063s));
                            c7303s.f25038t = query.getInt(query.getColumnIndex("d"));
                            c7303s.f25041w = query.getInt(query.getColumnIndex(f25067w));
                            c7303s.f25028j = query.getString(query.getColumnIndex(f25066v));
                            c7303s.f25042x = query.getInt(query.getColumnIndex(f25068x));
                            boolean z = true;
                            if (query.getInt(query.getColumnIndex(f25069y)) != 1) {
                                z = false;
                            }
                            c7303s.f25043y = z;
                            c7303s2 = c7303s;
                        } catch (Throwable unused) {
                            cursor = query;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return c7303s;
                        }
                    }
                } catch (Throwable unused2) {
                    c7303s = null;
                }
            }
            if (query == null || query.isClosed()) {
                return c7303s2;
            }
            query.close();
            return c7303s2;
        } catch (Throwable unused3) {
            c7303s = null;
        }
    }

    /* renamed from: a */
    public void m33757a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f25072C.delete(C7193bi.f24582q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public int m33761a(int i, int i2) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", Integer.valueOf(i2));
            SQLiteDatabase sQLiteDatabase = this.f25072C;
            return sQLiteDatabase.update(C7193bi.f24582q, contentValues, "k=" + i, null);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
