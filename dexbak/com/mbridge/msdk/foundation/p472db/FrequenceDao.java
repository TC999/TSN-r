package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.Frequence;

/* renamed from: com.mbridge.msdk.foundation.db.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FrequenceDao extends BaseDao<Frequence> {

    /* renamed from: a */
    private static FrequenceDao f30361a;

    private FrequenceDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static FrequenceDao m22703a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30361a == null) {
            synchronized (FrequenceDao.class) {
                if (f30361a == null) {
                    f30361a = new FrequenceDao(commonAbsDBHelper);
                }
            }
        }
        return f30361a;
    }

    /* renamed from: b */
    public final synchronized void m22700b() {
        try {
            String str = "ts<" + (System.currentTimeMillis() - 86400000);
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("frequence", str, null);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public final synchronized void m22698b(String str) {
        if (m22701a(str)) {
            String str2 = "UPDATE frequence Set impression_count=impression_count+1 WHERE id=" + str;
            if (getReadableDatabase() != null) {
                getReadableDatabase().execSQL(str2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 != null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if (r0 == null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
        return null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long[] m22704a() {
        /*
            r7 = this;
            java.lang.String r0 = "SELECT id FROM frequence WHERE fc_a<impression_count"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.getReadableDatabase()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L44
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L44
            if (r0 == 0) goto L37
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r2 <= 0) goto L37
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            long[] r2 = new long[r2]     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r3 = 0
        L1a:
            boolean r4 = r0.moveToNext()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r4 == 0) goto L2f
            java.lang.String r4 = "id"
            int r4 = r0.getColumnIndexOrThrow(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            long r4 = r0.getLong(r4)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r2[r3] = r4     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            int r3 = r3 + 1
            goto L1a
        L2f:
            r0.close()
            return r2
        L33:
            r1 = move-exception
            goto L3e
        L35:
            goto L45
        L37:
            if (r0 == 0) goto L4a
            goto L47
        L3a:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L3e:
            if (r0 == 0) goto L43
            r0.close()
        L43:
            throw r1
        L44:
            r0 = r1
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.close()
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.FrequenceDao.m22704a():long[]");
    }

    /* renamed from: b */
    private synchronized long m22699b(Frequence frequence) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", frequence.m22554a());
            contentValues.put("fc_a", Integer.valueOf(frequence.m22550b()));
            contentValues.put("fc_b", Integer.valueOf(frequence.m22548c()));
            contentValues.put("ts", Long.valueOf(frequence.m22543f()));
            contentValues.put("impression_count", Integer.valueOf(frequence.m22546d()));
            contentValues.put("click_count", Integer.valueOf(frequence.m22544e()));
            contentValues.put("ts", Long.valueOf(frequence.m22543f()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            return getWritableDatabase().insert("frequence", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m22701a(String str) {
        Cursor cursor = null;
        try {
            try {
                synchronized (str) {
                    Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM frequence WHERE id='" + str + "'", null);
                    if (rawQuery != null && rawQuery.getCount() > 0) {
                        rawQuery.close();
                        return true;
                    }
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } catch (Exception unused) {
            if (0 != 0) {
                cursor.close();
            }
            return false;
        }
    }

    /* renamed from: a */
    public final synchronized void m22702a(Frequence frequence) {
        if (!m22701a(frequence.m22554a())) {
            m22699b(frequence);
        }
    }
}
