package com.mbridge.msdk.foundation.p472db;

import com.mbridge.msdk.foundation.entity.ClickTime;

/* renamed from: com.mbridge.msdk.foundation.db.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class CampaignClickTimeDao extends BaseDao<ClickTime> {

    /* renamed from: a */
    private static CampaignClickTimeDao f30329a;

    private CampaignClickTimeDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static CampaignClickTimeDao m22791a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30329a == null) {
            synchronized (CampaignClickTimeDao.class) {
                if (f30329a == null) {
                    f30329a = new CampaignClickTimeDao(commonAbsDBHelper);
                }
            }
        }
        return f30329a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0131, code lost:
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0133, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013e, code lost:
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0142, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0147 A[Catch: all -> 0x014b, TRY_ENTER, TryCatch #4 {, blocks: (B:4:0x0003, B:20:0x012a, B:26:0x0133, B:40:0x0147, B:41:0x014a), top: B:50:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.ClickTime> m22792a(int r28) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignClickTimeDao.m22792a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != null) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22793a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from click_time"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r0 == 0) goto L19
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r2 == 0) goto L19
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
        L19:
            if (r0 == 0) goto L28
        L1b:
            r0.close()     // Catch: java.lang.Throwable -> L30
            goto L28
        L1f:
            r1 = move-exception
            goto L2a
        L21:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L28
            goto L1b
        L28:
            monitor-exit(r4)
            return r1
        L2a:
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L30
        L2f:
            throw r1     // Catch: java.lang.Throwable -> L30
        L30:
            r0 = move-exception
            monitor-exit(r4)
            goto L34
        L33:
            throw r0
        L34:
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.CampaignClickTimeDao.m22793a():int");
    }
}
