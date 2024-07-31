package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DlInfo;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;

/* renamed from: com.mbridge.msdk.foundation.db.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CampaignDAIDao extends BaseDao {

    /* renamed from: a */
    private static CampaignDAIDao f30330a;

    /* renamed from: b */
    private int f30331b;

    private CampaignDAIDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
        this.f30331b = 100;
    }

    /* renamed from: a */
    public static synchronized CampaignDAIDao m22789a(CommonAbsDBHelper commonAbsDBHelper) {
        CampaignDAIDao campaignDAIDao;
        synchronized (CampaignDAIDao.class) {
            if (f30330a == null) {
                synchronized (CampaignClickDao.class) {
                    if (f30330a == null) {
                        f30330a = new CampaignDAIDao(commonAbsDBHelper);
                    }
                }
            }
            campaignDAIDao = f30330a;
        }
        return campaignDAIDao;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r1.isClosed() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r1.isClosed() == false) goto L14;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m22771m(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d
            r0.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r1 = "SELECT id FROM campaignDAIDao WHERE unique_key='"
            r0.append(r1)     // Catch: java.lang.Throwable -> L5d
            r0.append(r4)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = "'"
            r0.append(r4)     // Catch: java.lang.Throwable -> L5d
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L5d
            r0 = 0
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r3.getReadableDatabase()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            android.database.Cursor r1 = r2.rawQuery(r4, r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r1 == 0) goto L2f
            int r4 = r1.getCount()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r4 <= 0) goto L2f
            r1.close()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r4 = 1
            r0 = 1
            goto L34
        L2f:
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
        L34:
            if (r1 == 0) goto L4f
            boolean r4 = r1.isClosed()     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L4f
        L3c:
            r1.close()     // Catch: java.lang.Throwable -> L5d
            goto L4f
        L40:
            r4 = move-exception
            goto L51
        L42:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L4f
            boolean r4 = r1.isClosed()     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L4f
            goto L3c
        L4f:
            monitor-exit(r3)
            return r0
        L51:
            if (r1 == 0) goto L5c
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L5d
            if (r0 != 0) goto L5c
            r1.close()     // Catch: java.lang.Throwable -> L5d
        L5c:
            throw r4     // Catch: java.lang.Throwable -> L5d
        L5d:
            r4 = move-exception
            monitor-exit(r3)
            goto L61
        L60:
            throw r4
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22771m(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (m22771m(r4) != false) goto L3;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m22783b(java.lang.String r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 > 0) goto L9
            boolean r0 = r3.m22771m(r4)     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L41
        L9:
            android.database.sqlite.SQLiteDatabase r0 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L11
            monitor-exit(r3)
            return
        L11:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L43
            r0.<init>()     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = "unique_key = '"
            r0.append(r1)     // Catch: java.lang.Throwable -> L43
            r0.append(r4)     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = "'"
            r0.append(r4)     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Throwable -> L43
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L43
            r0.<init>()     // Catch: java.lang.Throwable -> L43
            if (r5 <= 0) goto L41
            java.lang.String r1 = "progress"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L43
            r0.put(r1, r5)     // Catch: java.lang.Throwable -> L43
            android.database.sqlite.SQLiteDatabase r5 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = "campaignDAIDao"
            r2 = 0
            r5.update(r1, r0, r4, r2)     // Catch: java.lang.Throwable -> L43
        L41:
            monitor-exit(r3)
            return
        L43:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22783b(java.lang.String, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r0.isClosed() == false) goto L24;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22781c(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.m22771m(r11)     // Catch: java.lang.Throwable -> L6c
            r1 = 0
            if (r0 == 0) goto L6a
            android.database.sqlite.SQLiteDatabase r0 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L10
            monitor-exit(r10)
            return r1
        L10:
            r0 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r6 = "status"
            r5[r1] = r6     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r7[r1] = r11     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r11 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r11
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r0 == 0) goto L43
            int r11 = r0.getCount()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r11 <= 0) goto L43
            boolean r11 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r11 == 0) goto L43
            int r11 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r1 = r11
        L43:
            if (r0 == 0) goto L6a
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L6c
            if (r11 != 0) goto L6a
        L4b:
            r0.close()     // Catch: java.lang.Throwable -> L6c
            goto L6a
        L4f:
            r11 = move-exception
            goto L5e
        L51:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L6a
            boolean r11 = r0.isClosed()     // Catch: java.lang.Throwable -> L6c
            if (r11 != 0) goto L6a
            goto L4b
        L5e:
            if (r0 == 0) goto L69
            boolean r1 = r0.isClosed()     // Catch: java.lang.Throwable -> L6c
            if (r1 != 0) goto L69
            r0.close()     // Catch: java.lang.Throwable -> L6c
        L69:
            throw r11     // Catch: java.lang.Throwable -> L6c
        L6a:
            monitor-exit(r10)
            return r1
        L6c:
            r11 = move-exception
            monitor-exit(r10)
            goto L70
        L6f:
            throw r11
        L70:
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22781c(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22780d(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "rid"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22780d(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22779e(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "rid_n"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22779e(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22778f(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unitid"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22778f(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22777g(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "id"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22777g(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22776h(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "package_name"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22776h(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22775i(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "save_path"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22775i(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r1.isClosed() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r1.isClosed() == false) goto L23;
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22774j(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = -2
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L67
            if (r1 != 0) goto La
            monitor-exit(r11)
            return r0
        La:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r6 = "atat_type"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r6 = "package_name = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r7[r10] = r12     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r1 == 0) goto L3e
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r12 <= 0) goto L3e
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r12 == 0) goto L3e
            int r12 = r1.getInt(r10)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0 = r12
        L3e:
            if (r1 == 0) goto L59
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L67
            if (r12 != 0) goto L59
        L46:
            r1.close()     // Catch: java.lang.Throwable -> L67
            goto L59
        L4a:
            r12 = move-exception
            goto L5b
        L4c:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L59
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L67
            if (r12 != 0) goto L59
            goto L46
        L59:
            monitor-exit(r11)
            return r0
        L5b:
            if (r1 == 0) goto L66
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L67
            if (r0 != 0) goto L66
            r1.close()     // Catch: java.lang.Throwable -> L67
        L66:
            throw r12     // Catch: java.lang.Throwable -> L67
        L67:
            r12 = move-exception
            monitor-exit(r11)
            goto L6b
        L6a:
            throw r12
        L6b:
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22774j(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r1.isClosed() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        if (r1.isClosed() == false) goto L22;
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22773k(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto Lb
            monitor-exit(r11)
            return r0
        Lb:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r6 = "app_name"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r6 = "package_name = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r7[r10] = r12     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r1 == 0) goto L3f
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r12 <= 0) goto L3f
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r12 == 0) goto L3f
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r0 = r12
        L3f:
            if (r1 == 0) goto L5a
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r12 != 0) goto L5a
        L47:
            r1.close()     // Catch: java.lang.Throwable -> L68
            goto L5a
        L4b:
            r12 = move-exception
            goto L5c
        L4d:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L5a
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r12 != 0) goto L5a
            goto L47
        L5a:
            monitor-exit(r11)
            return r0
        L5c:
            if (r1 == 0) goto L67
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L67
            r1.close()     // Catch: java.lang.Throwable -> L68
        L67:
            throw r12     // Catch: java.lang.Throwable -> L68
        L68:
            r12 = move-exception
            monitor-exit(r11)
            goto L6c
        L6b:
            throw r12
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22773k(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r1.isClosed() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
        if (r1.isClosed() == false) goto L22;
     */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22772l(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto Lb
            monitor-exit(r11)
            return r0
        Lb:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r6 = "unique_key"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.String r6 = "package_name = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r7[r10] = r12     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r1 == 0) goto L3f
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r12 <= 0) goto L3f
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r12 == 0) goto L3f
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r0 = r12
        L3f:
            if (r1 == 0) goto L5a
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r12 != 0) goto L5a
        L47:
            r1.close()     // Catch: java.lang.Throwable -> L68
            goto L5a
        L4b:
            r12 = move-exception
            goto L5c
        L4d:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L5a
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r12 != 0) goto L5a
            goto L47
        L5a:
            monitor-exit(r11)
            return r0
        L5c:
            if (r1 == 0) goto L67
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L67
            r1.close()     // Catch: java.lang.Throwable -> L68
        L67:
            throw r12     // Catch: java.lang.Throwable -> L68
        L68:
            r12 = move-exception
            monitor-exit(r11)
            goto L6c
        L6b:
            throw r12
        L6c:
            goto L6b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22772l(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final synchronized void m22788a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (!m22771m(campaignEx.getAkdlui())) {
                if (getWritableDatabase() == null) {
                    return;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("unique_key", campaignEx.getAkdlui());
                contentValues.put("id", campaignEx.getId());
                contentValues.put(DomainCampaignEx.JSON_KEY_ATAT_TYPE, Integer.valueOf(campaignEx.getAtatType()));
                contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPASBL, Integer.valueOf(campaignEx.getNtbarpasbl()));
                contentValues.put(DomainCampaignEx.JSON_KEY_NTBARPT, Integer.valueOf(campaignEx.getNtbarpt()));
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("rid", campaignEx.getRequestId());
                contentValues.put("rid_n", campaignEx.getRequestIdNotice());
                contentValues.put("unitid", campaignEx.getCampaignUnitId());
                contentValues.put("url", campaignEx.getClickURL());
                contentValues.put("status", (Integer) (-1));
                contentValues.put(NotificationCompat.CATEGORY_PROGRESS, (Integer) (-1));
                contentValues.put("save_path", "");
                contentValues.put("app_name", campaignEx.getAppName());
                getWritableDatabase().insert("campaignDAIDao", null, contentValues);
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m22782b(String str, String str2) {
        if (m22771m(str)) {
            if (getWritableDatabase() == null) {
                return;
            }
            String str3 = "unique_key = '" + str + "'";
            ContentValues contentValues = new ContentValues();
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("save_path", str2);
            }
            getWritableDatabase().update("campaignDAIDao", contentValues, str3, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.isClosed() == false) goto L24;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m22784b(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = ""
            boolean r1 = r11.m22771m(r12)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L6c
            android.database.sqlite.SQLiteDatabase r1 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L6e
            if (r1 != 0) goto L11
            monitor-exit(r11)
            return r0
        L11:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r3 = "campaignDAIDao"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "url"
            r10 = 0
            r5[r10] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r6 = "unique_key = ?"
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r7[r10] = r12     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r12 = 0
            r8 = 0
            java.lang.String r9 = "unique_key"
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L45
            int r12 = r1.getCount()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 <= 0) goto L45
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r12 == 0) goto L45
            java.lang.String r12 = r1.getString(r10)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r12
        L45:
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
        L4d:
            r1.close()     // Catch: java.lang.Throwable -> L6e
            goto L6c
        L51:
            r12 = move-exception
            goto L60
        L53:
            r12 = move-exception
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L6c
            boolean r12 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r12 != 0) goto L6c
            goto L4d
        L60:
            if (r1 == 0) goto L6b
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L6e
            if (r0 != 0) goto L6b
            r1.close()     // Catch: java.lang.Throwable -> L6e
        L6b:
            throw r12     // Catch: java.lang.Throwable -> L6e
        L6c:
            monitor-exit(r11)
            return r0
        L6e:
            r12 = move-exception
            monitor-exit(r11)
            goto L72
        L71:
            throw r12
        L72:
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignDAIDao.m22784b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public final synchronized void m22785a(String str, String str2) {
        if (m22771m(str)) {
            if (getWritableDatabase() == null) {
                return;
            }
            String str3 = "unique_key = '" + str + "'";
            ContentValues contentValues = new ContentValues();
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("url", str2);
            }
            getWritableDatabase().update("campaignDAIDao", contentValues, str3, null);
        }
    }

    /* renamed from: a */
    public final synchronized void m22787a(String str) {
        m22786a(str, 10);
    }

    /* renamed from: a */
    public final synchronized void m22786a(String str, int i) {
        if (m22771m(str)) {
            if (getWritableDatabase() == null) {
                return;
            }
            String str2 = "unique_key = '" + str + "'";
            ContentValues contentValues = new ContentValues();
            if (i != 0) {
                contentValues.put("status", Integer.valueOf(i));
            }
            getWritableDatabase().update("campaignDAIDao", contentValues, str2, null);
        }
    }

    /* renamed from: a */
    public final synchronized DlInfo m22790a() {
        Cursor cursor;
        DlInfo dlInfo;
        DlInfo dlInfo2;
        Cursor query;
        if (getReadableDatabase() == null) {
            return null;
        }
        try {
            query = getReadableDatabase().query("campaignDAIDao", new String[]{"save_path", "url", "unique_key", "rid", "package_name", "rid_n", "id", "unitid"}, "status = ?", new String[]{Constants.VIA_REPORT_TYPE_SHARE_TO_QQ}, null, null, "unique_key");
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (query != null) {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    dlInfo = null;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        dlInfo2 = dlInfo;
                        return dlInfo2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (query.moveToFirst() && query.getCount() > 0) {
                    DlInfo dlInfo3 = new DlInfo();
                    try {
                        dlInfo3.m22577a(query.getString(0));
                        dlInfo3.m22575b(query.getString(1));
                        dlInfo3.m22573c(query.getString(2));
                        dlInfo3.m22571d(query.getString(3));
                        dlInfo3.m22569e(query.getString(4));
                        dlInfo3.m22567f(query.getString(5));
                        dlInfo3.m22563h(query.getString(6));
                        dlInfo3.m22565g(query.getString(7));
                        dlInfo2 = dlInfo3;
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = query;
                        dlInfo = dlInfo3;
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        dlInfo2 = dlInfo;
                        return dlInfo2;
                    }
                    return dlInfo2;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
        dlInfo2 = null;
        if (query != null) {
            query.close();
        }
        return dlInfo2;
    }
}
