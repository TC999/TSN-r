package com.baidu.liantian.rp.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.liantian.ac.F;
import com.baidu.liantian.e;

/* compiled from: ReportDb.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f12245a;

    /* renamed from: b  reason: collision with root package name */
    private C0110a f12246b;

    /* renamed from: c  reason: collision with root package name */
    private e f12247c;

    /* renamed from: d  reason: collision with root package name */
    private SQLiteDatabase f12248d;

    /* renamed from: e  reason: collision with root package name */
    private Context f12249e;

    /* compiled from: ReportDb.java */
    /* renamed from: com.baidu.liantian.rp.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class C0110a extends SQLiteOpenHelper {
        public C0110a(Context context) {
            super(context, "liantian_d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
            if (i4 <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i4 <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }

    private a(Context context) {
        this.f12249e = context;
        this.f12246b = new C0110a(context);
        this.f12247c = new e(context);
        try {
            this.f12248d = this.f12246b.getWritableDatabase();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f12245a == null) {
                f12245a = new a(context);
            }
            aVar = f12245a;
        }
        return aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        if (r11 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(java.lang.String r11) {
        /*
            r10 = this;
            r0 = 1
            java.lang.String r4 = "b=?"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L27
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L27
            android.database.sqlite.SQLiteDatabase r1 = r10.f12248d     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = "c"
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L27
            if (r11 == 0) goto L1d
            int r1 = r11.getCount()     // Catch: java.lang.Throwable -> L28
            if (r1 <= 0) goto L1d
            r0 = 0
        L1d:
            if (r11 == 0) goto L2e
        L1f:
            r11.close()     // Catch: java.lang.Exception -> L23
            goto L2e
        L23:
            com.baidu.liantian.b.e.a()
            goto L2e
        L27:
            r11 = 0
        L28:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L2f
            if (r11 == 0) goto L2e
            goto L1f
        L2e:
            return r0
        L2f:
            r0 = move-exception
            if (r11 == 0) goto L39
            r11.close()     // Catch: java.lang.Exception -> L36
            goto L39
        L36:
            com.baidu.liantian.b.e.a()
        L39:
            goto L3b
        L3a:
            throw r0
        L3b:
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.b(java.lang.String):boolean");
    }

    public final int c() {
        e eVar = new e(this.f12249e);
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = eVar.f12232e.getInt("re_net_over", 7) * 86400000;
        try {
            return this.f12248d.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i4)});
        } catch (Exception unused) {
            com.baidu.liantian.b.e.a();
            return -1;
        }
    }

    public final long a(com.baidu.liantian.rp.c.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.f12252b);
        contentValues.put("c", Integer.valueOf(aVar.f12253c));
        contentValues.put("d", Long.valueOf(aVar.f12255e));
        contentValues.put("e", Integer.valueOf(aVar.f12257g));
        contentValues.put("g", Integer.valueOf(aVar.f12256f));
        contentValues.put("f", Integer.valueOf(aVar.f12258h));
        contentValues.put("i", Integer.valueOf(aVar.f12259i));
        contentValues.put("j", aVar.f12260j);
        String str = aVar.f12254d;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
        } catch (Exception unused) {
            com.baidu.liantian.b.e.a();
        }
        contentValues.put("h", str);
        try {
            return this.f12248d.insert("r", null, contentValues);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
            return -1L;
        }
    }

    private int b(int i4) {
        try {
            return this.f12248d.delete("r", "a=?", new String[]{String.valueOf(i4)});
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r0 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r0 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        com.baidu.liantian.b.e.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b() {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f12248d     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            java.lang.String r3 = "r"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            if (r0 == 0) goto L17
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
        L17:
            if (r0 == 0) goto L29
        L19:
            r0.close()     // Catch: java.lang.Exception -> L1d
            goto L29
        L1d:
            com.baidu.liantian.b.e.a()
            goto L29
        L21:
            r1 = move-exception
            goto L2a
        L23:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L21
            if (r0 == 0) goto L29
            goto L19
        L29:
            return r1
        L2a:
            if (r0 == 0) goto L33
            r0.close()     // Catch: java.lang.Exception -> L30
            goto L33
        L30:
            com.baidu.liantian.b.e.a()
        L33:
            goto L35
        L34:
            throw r1
        L35:
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.b():int");
    }

    public final long a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", str);
        try {
            return this.f12248d.insert("c", null, contentValues);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return -1L;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0033
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int a(java.util.List<java.lang.Integer> r2) {
        /*
            r1 = this;
            android.database.sqlite.SQLiteDatabase r0 = r1.f12248d     // Catch: java.lang.Throwable -> L25
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L25
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L25
        L9:
            boolean r0 = r2.hasNext()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L1d
            java.lang.Object r0 = r2.next()     // Catch: java.lang.Throwable -> L25
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> L25
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> L25
            r1.b(r0)     // Catch: java.lang.Throwable -> L25
            goto L9
        L1d:
            android.database.sqlite.SQLiteDatabase r2 = r1.f12248d     // Catch: java.lang.Throwable -> L25
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L25
            android.database.sqlite.SQLiteDatabase r2 = r1.f12248d     // Catch: java.lang.Exception -> L2e
            goto L2a
        L25:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L33
            android.database.sqlite.SQLiteDatabase r2 = r1.f12248d     // Catch: java.lang.Exception -> L2e
        L2a:
            r2.endTransaction()     // Catch: java.lang.Exception -> L2e
            goto L31
        L2e:
            com.baidu.liantian.b.e.a()
        L31:
            r2 = -1
            return r2
        L33:
            r2 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r1.f12248d     // Catch: java.lang.Exception -> L3a
            r0.endTransaction()     // Catch: java.lang.Exception -> L3a
            goto L3d
        L3a:
            com.baidu.liantian.b.e.a()
        L3d:
            goto L3f
        L3e:
            throw r2
        L3f:
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a(java.util.List):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x012c, code lost:
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0134, code lost:
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0136, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x013a, code lost:
        com.baidu.liantian.b.e.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a(int r19) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c1, code lost:
        if (r10 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c9, code lost:
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00cb, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00cf, code lost:
        com.baidu.liantian.b.e.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r4 = "i=5"
            java.lang.String r8 = "d desc"
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.f12248d     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "r"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r9 = "100"
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            if (r10 == 0) goto Lc1
        L1a:
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            if (r1 == 0) goto Lc1
            com.baidu.liantian.rp.c.a r1 = new com.baidu.liantian.rp.c.a     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "a"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12251a = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "b"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12252b = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "c"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12253c = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "d"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            long r2 = r10.getLong(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12255e = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "g"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12256f = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "e"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12257g = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "f"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12258h = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "i"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12259i = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "j"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r1.f12260j = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = "h"
            int r2 = r10.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            java.lang.String r2 = r10.getString(r2)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            com.baidu.liantian.ac.F r3 = com.baidu.liantian.ac.F.getInstance()     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            r4 = 0
            byte[] r4 = android.util.Base64.decode(r2, r4)     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            java.lang.String r5 = "xVOTuxgN3lkRN2v4"
            java.lang.String r6 = "utf-8"
            byte[] r5 = r5.getBytes(r6)     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            byte[] r3 = r3.ad(r4, r5)     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            r4.<init>(r3)     // Catch: java.lang.Exception -> Lb7 java.lang.Throwable -> Lc4
            r2 = r4
            goto Lba
        Lb7:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
        Lba:
            r1.f12254d = r2     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            r0.add(r1)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc6
            goto L1a
        Lc1:
            if (r10 == 0) goto Ld2
            goto Lcb
        Lc4:
            r0 = move-exception
            goto Ld3
        Lc6:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> Lc4
            if (r10 == 0) goto Ld2
        Lcb:
            r10.close()     // Catch: java.lang.Exception -> Lcf
            goto Ld2
        Lcf:
            com.baidu.liantian.b.e.a()
        Ld2:
            return r0
        Ld3:
            if (r10 == 0) goto Ldc
            r10.close()     // Catch: java.lang.Exception -> Ld9
            goto Ldc
        Ld9:
            com.baidu.liantian.b.e.a()
        Ldc:
            goto Lde
        Ldd:
            throw r0
        Lde:
            goto Ldd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0110, code lost:
        if (r11 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0118, code lost:
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x011a, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011e, code lost:
        com.baidu.liantian.b.e.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.baidu.liantian.rp.c.a> a(boolean r11, int r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.rp.b.a.a(boolean, int):java.util.List");
    }
}
