package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ReportData;

/* renamed from: com.mbridge.msdk.foundation.db.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class ReportErrorDao extends BaseDao {

    /* renamed from: a */
    private static ReportErrorDao f30365a;

    private ReportErrorDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static ReportErrorDao m22686a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30365a == null) {
            synchronized (ReportErrorDao.class) {
                if (f30365a == null) {
                    f30365a = new ReportErrorDao(commonAbsDBHelper);
                }
            }
        }
        return f30365a;
    }

    /* renamed from: b */
    private synchronized int m22681b(int i) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return getWritableDatabase().rawQuery("DELETE from reporterror where count >= " + i, null).getCount();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 == null) goto L8;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22682b() {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            r1 = 1
            java.lang.String[] r4 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = " count(*) "
            r11 = 0
            r4[r11] = r1     // Catch: java.lang.Throwable -> L33
            android.database.sqlite.SQLiteDatabase r2 = r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            java.lang.String r3 = "reporterror"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            int r11 = r0.getCount()     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
        L1e:
            r0.close()     // Catch: java.lang.Throwable -> L33
            goto L2b
        L22:
            r1 = move-exception
            goto L2d
        L24:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L2b
            goto L1e
        L2b:
            monitor-exit(r12)
            return r11
        L2d:
            if (r0 == 0) goto L32
            r0.close()     // Catch: java.lang.Throwable -> L33
        L32:
            throw r1     // Catch: java.lang.Throwable -> L33
        L33:
            r0 = move-exception
            monitor-exit(r12)
            goto L37
        L36:
            throw r0
        L37:
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.ReportErrorDao.m22682b():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r0 == null) goto L17;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22688a() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3d
            java.lang.String r0 = " count(*) "
            r9 = 0
            r3[r9] = r0     // Catch: java.lang.Throwable -> L3d
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            java.lang.String r2 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r0 == 0) goto L26
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            if (r1 == 0) goto L26
            int r1 = r0.getInt(r9)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L2e
            r9 = r1
        L26:
            if (r0 == 0) goto L35
        L28:
            r0.close()     // Catch: java.lang.Throwable -> L3d
            goto L35
        L2c:
            r1 = move-exception
            goto L37
        L2e:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L35
            goto L28
        L35:
            monitor-exit(r10)
            return r9
        L37:
            if (r0 == 0) goto L3c
            r0.close()     // Catch: java.lang.Throwable -> L3d
        L3c:
            throw r1     // Catch: java.lang.Throwable -> L3d
        L3d:
            r0 = move-exception
            monitor-exit(r10)
            goto L41
        L40:
            throw r0
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.ReportErrorDao.m22688a():int");
    }

    /* renamed from: b */
    private synchronized boolean m22680b(String str, String str2, long j) {
        if (str == null) {
            str = "";
        }
        try {
            if (getWritableDatabase() == null) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("select * from reporterror where url='");
            sb.append(str2);
            sb.append("' and ");
            sb.append("data");
            sb.append("='");
            sb.append(str);
            sb.append("' and ");
            sb.append("time_stamp");
            sb.append("=");
            sb.append(j);
            return getReadableDatabase().rawQuery(sb.toString(), null).getCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final synchronized int m22684a(String str) {
        try {
            String[] strArr = {str};
            if (getWritableDatabase() == null) {
                return -1;
            }
            return getWritableDatabase().delete("reporterror", "url=?", strArr);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public final synchronized int m22683a(String str, String str2, long j) {
        if (str == null) {
            str = "";
        }
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            return getWritableDatabase().rawQuery("DELETE from reporterror where url='" + str2 + "' and data='" + str + "' and time_stamp=" + j + " or count > 5 ", null).getCount();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab A[Catch: all -> 0x00af, TRY_ENTER, TryCatch #5 {, blocks: (B:27:0x00a1, B:19:0x0092, B:34:0x00ab, B:35:0x00ae), top: B:46:0x0003 }] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.mbridge.msdk.foundation.entity.n>] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.ReportData> m22687a(int r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 5
            r1 = 0
            r12.m22681b(r0)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            android.database.sqlite.SQLiteDatabase r2 = r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.lang.String r3 = "reporterror"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r0.<init>()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r0.append(r13)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.lang.String r13 = ""
            r0.append(r13)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            if (r13 == 0) goto L90
            int r0 = r13.getCount()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> La7
            if (r0 <= 0) goto L90
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> La7
            r0.<init>()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> La7
        L34:
            boolean r1 = r13.moveToNext()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            if (r1 == 0) goto L87
            java.lang.String r1 = "url"
            int r1 = r13.getColumnIndex(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r1 = r13.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r2 = "data"
            int r2 = r13.getColumnIndex(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r2 = r13.getString(r2)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r3 = "method"
            int r3 = r13.getColumnIndex(r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r3 = r13.getString(r3)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r4 = "unitId"
            int r4 = r13.getColumnIndex(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r4 = r13.getString(r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r5 = "count"
            int r5 = r13.getColumnIndex(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            int r5 = r13.getInt(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            java.lang.String r6 = "time_stamp"
            int r6 = r13.getColumnIndex(r6)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            long r6 = r13.getLong(r6)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            com.mbridge.msdk.foundation.entity.n r8 = new com.mbridge.msdk.foundation.entity.n     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            r8.<init>(r1, r3, r2, r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            int r5 = r5 + 1
            r8.m22472a(r5)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            r8.m22471a(r6)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            r0.add(r8)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La7
            goto L34
        L87:
            r1 = r0
            goto L90
        L89:
            r1 = move-exception
            goto L9c
        L8b:
            r0 = move-exception
            r11 = r1
            r1 = r0
            r0 = r11
            goto L9c
        L90:
            if (r13 == 0) goto La5
            r13.close()     // Catch: java.lang.Throwable -> Laf
            goto La5
        L96:
            r0 = move-exception
            goto La9
        L98:
            r13 = move-exception
            r0 = r1
            r1 = r13
            r13 = r0
        L9c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> La7
            if (r13 == 0) goto La4
            r13.close()     // Catch: java.lang.Throwable -> Laf
        La4:
            r1 = r0
        La5:
            monitor-exit(r12)
            return r1
        La7:
            r0 = move-exception
            r1 = r13
        La9:
            if (r1 == 0) goto Lae
            r1.close()     // Catch: java.lang.Throwable -> Laf
        Lae:
            throw r0     // Catch: java.lang.Throwable -> Laf
        Laf:
            r13 = move-exception
            monitor-exit(r12)
            goto Lb3
        Lb2:
            throw r13
        Lb3:
            goto Lb2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.ReportErrorDao.m22687a(int):java.util.List");
    }

    /* renamed from: a */
    public final synchronized long m22685a(ReportData reportData) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", reportData.m22469b());
            contentValues.put("method", reportData.m22467c());
            contentValues.put("data", reportData.m22465d());
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, reportData.m22473a());
            contentValues.put("time_stamp", Long.valueOf(reportData.m22461g()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            if (m22680b(reportData.m22465d(), reportData.m22469b(), reportData.m22461g())) {
                return getWritableDatabase().rawQuery("UPDATE reporterror SET count = " + reportData.m22462f() + " where url='" + reportData.m22469b() + "' and data='" + reportData.m22465d() + "' and time_stamp=" + reportData.m22461g(), null).getCount();
            }
            contentValues.put("count", Integer.valueOf(reportData.m22462f()));
            return getWritableDatabase().insert("reporterror", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }
}
