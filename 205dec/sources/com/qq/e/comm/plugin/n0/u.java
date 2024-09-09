package com.qq.e.comm.plugin.n0;

import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.plugin.n0.o;
import com.qq.e.comm.plugin.util.d1;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class u<DataType extends o> {

    /* renamed from: a  reason: collision with root package name */
    private final String f44812a;

    /* renamed from: b  reason: collision with root package name */
    private final String f44813b;

    /* renamed from: c  reason: collision with root package name */
    private final String f44814c;

    /* renamed from: d  reason: collision with root package name */
    private int f44815d = 0;

    /* renamed from: e  reason: collision with root package name */
    private j f44816e;

    /* renamed from: f  reason: collision with root package name */
    private a<DataType> f44817f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a<DataType> {
        DataType a(int i4, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(String str, a<DataType> aVar) {
        this.f44812a = str;
        this.f44813b = "create table " + str + "(id integer primary key autoincrement,content text not null,ts long not null)";
        this.f44814c = "id not in (select id from " + str + " order by ts desc limit 1000)";
        this.f44817f = aVar;
    }

    public void a(j jVar) {
        this.f44816e = jVar;
        this.f44815d = b().size();
        d1.a("Stat db init: total " + this.f44812a + " count=" + this.f44815d, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (r5 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0081, code lost:
        if (r5 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
        r5.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<DataType> b() {
        /*
            r14 = this;
            java.lang.String r0 = "content"
            java.lang.String r1 = "id"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            r4 = 0
            com.qq.e.comm.plugin.n0.j r5 = r14.f44816e     // Catch: java.lang.Throwable -> L75
            android.database.sqlite.SQLiteDatabase r5 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L75
            java.lang.String r7 = r14.f44812a     // Catch: java.lang.Throwable -> L73
            r6 = 2
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L73
            r8[r4] = r1     // Catch: java.lang.Throwable -> L73
            r6 = 1
            r8[r6] = r0     // Catch: java.lang.Throwable -> L73
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r13 = "ts"
            r6 = r5
            android.database.Cursor r3 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L73
            if (r3 == 0) goto L53
            int r6 = r3.getCount()     // Catch: java.lang.Throwable -> L73
            if (r6 > 0) goto L2f
            goto L53
        L2f:
            boolean r6 = r3.moveToNext()     // Catch: java.lang.Throwable -> L73
            if (r6 == 0) goto L6b
            int r6 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L73
            int r6 = r3.getInt(r6)     // Catch: java.lang.Throwable -> L73
            int r7 = r3.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73
            java.lang.String r7 = r3.getString(r7)     // Catch: java.lang.Throwable -> L73
            com.qq.e.comm.plugin.n0.u$a<DataType extends com.qq.e.comm.plugin.n0.o> r8 = r14.f44817f     // Catch: java.lang.Throwable -> L73
            java.lang.Object r6 = r8.a(r6, r7)     // Catch: java.lang.Throwable -> L73
            com.qq.e.comm.plugin.n0.o r6 = (com.qq.e.comm.plugin.n0.o) r6     // Catch: java.lang.Throwable -> L73
            if (r6 == 0) goto L2f
            r2.add(r6)     // Catch: java.lang.Throwable -> L73
            goto L2f
        L53:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r0.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = "Read stat 0 from table: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r14.f44812a     // Catch: java.lang.Throwable -> L73
            r0.append(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L73
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L73
            com.qq.e.comm.plugin.util.d1.a(r0, r1)     // Catch: java.lang.Throwable -> L73
        L6b:
            if (r3 == 0) goto L70
            r3.close()
        L70:
            if (r5 == 0) goto L86
            goto L83
        L73:
            r0 = move-exception
            goto L77
        L75:
            r0 = move-exception
            r5 = r3
        L77:
            java.lang.String r1 = "Read stat db failed"
            com.qq.e.comm.plugin.util.d1.a(r1, r0)     // Catch: java.lang.Throwable -> Lab
            if (r3 == 0) goto L81
            r3.close()
        L81:
            if (r5 == 0) goto L86
        L83:
            r5.close()     // Catch: java.lang.Throwable -> L86
        L86:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Read stat data: "
            r0.append(r1)
            int r1 = r2.size()
            r0.append(r1)
            java.lang.String r1 = " from table: "
            r0.append(r1)
            java.lang.String r1 = r14.f44812a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.qq.e.comm.plugin.util.d1.a(r0, r1)
            return r2
        Lab:
            r0 = move-exception
            if (r3 == 0) goto Lb1
            r3.close()
        Lb1:
            if (r5 == 0) goto Lb6
            r5.close()     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            goto Lb8
        Lb7:
            throw r0
        Lb8:
            goto Lb7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.n0.u.b():java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<DataType> list) {
        SQLiteDatabase sQLiteDatabase;
        if (list == null || list.size() <= 0) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = this.f44816e.getWritableDatabase();
            } catch (Throwable th) {
                th = th;
            }
            try {
                sQLiteDatabase.beginTransaction();
                StringBuilder sb = new StringBuilder("insert into ");
                sb.append(this.f44812a);
                sb.append(" (");
                sb.append("content");
                sb.append(", ");
                sb.append("ts");
                sb.append(") ");
                DataType datatype = list.get(0);
                sb.append("select '");
                sb.append(datatype.getContent());
                sb.append("', ");
                sb.append(datatype.a());
                int size = list.size();
                for (int i4 = 1; i4 < size; i4++) {
                    DataType datatype2 = list.get(i4);
                    sb.append(" union all select '");
                    sb.append(datatype2.getContent());
                    sb.append("', ");
                    sb.append(datatype2.a());
                }
                sQLiteDatabase.execSQL(sb.toString());
                int delete = sQLiteDatabase.delete(this.f44812a, this.f44814c, null);
                int size2 = list.size() - delete;
                d1.a("Insert stat:" + list.size() + ", delete stat: " + delete + " from table: " + this.f44812a, new Object[0]);
                sQLiteDatabase.setTransactionSuccessful();
                this.f44815d = this.f44815d + size2;
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase2 = sQLiteDatabase;
                try {
                    d1.a("Insert stat db failed", th);
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                        sQLiteDatabase = sQLiteDatabase2;
                        sQLiteDatabase.close();
                    }
                    return;
                } catch (Throwable th3) {
                    if (sQLiteDatabase2 != null) {
                        try {
                            sQLiteDatabase2.endTransaction();
                            sQLiteDatabase2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    throw th3;
                }
            }
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
                sQLiteDatabase.close();
            }
        } catch (Throwable unused2) {
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL("drop table if exists " + this.f44812a);
        this.f44815d = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Set<Integer> set) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (set == null || set.size() == 0) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(",");
            sb.append(it.next());
        }
        sb.append(")");
        try {
            sQLiteDatabase = this.f44816e.getWritableDatabase();
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            int delete = sQLiteDatabase.delete(this.f44812a, "id in " + sb.toString(), null);
            d1.a("Delete stat count: " + delete + " from table: " + this.f44812a, new Object[0]);
            int i4 = this.f44815d - delete;
            this.f44815d = i4;
            if (i4 < 0) {
                this.f44815d = 0;
            }
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                d1.a("Delete stat db failed", th);
                if (sQLiteDatabase == null) {
                    return;
                }
                sQLiteDatabase.close();
            } catch (Throwable th4) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th4;
            }
        }
        try {
            sQLiteDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    public long a() {
        return this.f44815d;
    }

    public void a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL(this.f44813b);
        this.f44815d = 0;
    }
}
