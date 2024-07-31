package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.out.Campaign;

/* renamed from: com.mbridge.msdk.foundation.db.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DailyPlayCapDao extends BaseDao<Campaign> {

    /* renamed from: a */
    private static final String f30358a = "com.mbridge.msdk.foundation.db.j";

    /* renamed from: b */
    private static DailyPlayCapDao f30359b;

    private DailyPlayCapDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static DailyPlayCapDao m22713a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30359b == null) {
            synchronized (DailyPlayCapDao.class) {
                if (f30359b == null) {
                    f30359b = new DailyPlayCapDao(commonAbsDBHelper);
                }
            }
        }
        return f30359b;
    }

    /* renamed from: b */
    private synchronized void m22710b(String str) {
        try {
        } catch (Throwable unused) {
            SameLogTool.m21736b(f30358a, "resetTimeAndTimestamp error");
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_insert_timestamp", (Integer) 0);
        contentValues.put("play_time", (Integer) 0);
        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = '" + str + "'", null);
    }

    /* renamed from: c */
    private synchronized boolean m22709c(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id='" + str + "'", null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
        return r1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m22711a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r2.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "SELECT * FROM dailyplaycap where unit_id ='"
            r2.append(r3)     // Catch: java.lang.Throwable -> L68
            r2.append(r11)     // Catch: java.lang.Throwable -> L68
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch: java.lang.Throwable -> L68
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L68
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L68
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L62
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L68
            if (r2 <= 0) goto L62
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto L62
            java.lang.String r2 = "first_insert_timestamp"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L68
            long r2 = r0.getLong(r2)     // Catch: java.lang.Throwable -> L68
            java.lang.String r4 = "play_time"
            int r4 = r0.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L68
            int r4 = r0.getInt(r4)     // Catch: java.lang.Throwable -> L68
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L68
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L62
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L68
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 - r8
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 <= 0) goto L59
            r10.m22710b(r11)     // Catch: java.lang.Throwable -> L68
            goto L62
        L59:
            if (r12 <= 0) goto L62
            long r11 = (long) r12
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 < 0) goto L62
            r11 = 1
            r1 = 1
        L62:
            if (r0 == 0) goto L82
        L64:
            r0.close()     // Catch: java.lang.Throwable -> L82
            goto L82
        L68:
            r11 = move-exception
            java.lang.String r12 = com.mbridge.msdk.foundation.p472db.DailyPlayCapDao.f30358a     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = "isOverCap is error"
            r2.append(r3)     // Catch: java.lang.Throwable -> L83
            r2.append(r11)     // Catch: java.lang.Throwable -> L83
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Throwable -> L83
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r12, r11)     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L82
            goto L64
        L82:
            return r1
        L83:
            r11 = move-exception
            if (r0 == 0) goto L89
            r0.close()     // Catch: java.lang.Throwable -> L89
        L89:
            goto L8b
        L8a:
            throw r11
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.DailyPlayCapDao.m22711a(java.lang.String, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cc, code lost:
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ce, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d8, code lost:
        if (r1 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[Catch: all -> 0x006b, Exception -> 0x006f, TryCatch #7 {Exception -> 0x006f, all -> 0x006b, blocks: (B:14:0x003f, B:16:0x0045, B:18:0x0066, B:26:0x0078, B:27:0x0081), top: B:59:0x003f }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m22712a(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.DailyPlayCapDao.m22712a(java.lang.String):void");
    }
}
