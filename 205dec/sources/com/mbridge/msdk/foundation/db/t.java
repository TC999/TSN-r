package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.x;
import java.net.URLEncoder;

/* compiled from: VideoReportDataDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class t extends a<com.mbridge.msdk.foundation.entity.p> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39200a = "com.mbridge.msdk.foundation.db.t";

    /* renamed from: b  reason: collision with root package name */
    private static t f39201b;

    private t(h hVar) {
        super(hVar);
    }

    public static t a(h hVar) {
        if (f39201b == null) {
            synchronized (t.class) {
                if (f39201b == null) {
                    f39201b = new t(hVar);
                }
            }
        }
        return f39201b;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0344 A[Catch: Exception -> 0x0350, all -> 0x0353, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0350, blocks: (B:100:0x0344, B:92:0x032d), top: B:119:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.p> a(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.t.a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from reward_report"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r0 == 0) goto L19
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            if (r2 == 0) goto L19
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
        L19:
            if (r0 == 0) goto L28
        L1b:
            r0.close()     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L30
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
            r0.close()     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L30
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.t.a():int");
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.p pVar) {
        if (pVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DomainCampaignEx.LOOPBACK_KEY, pVar.o());
                contentValues.put("networkType", Integer.valueOf(pVar.v()));
                contentValues.put("network_str", pVar.w());
                contentValues.put("isCompleteView", Integer.valueOf(pVar.x()));
                contentValues.put("watchedMillis", Integer.valueOf(pVar.p()));
                contentValues.put("videoLength", Integer.valueOf(pVar.q()));
                if (!TextUtils.isEmpty(pVar.r())) {
                    contentValues.put("offerUrl", pVar.r());
                }
                if (!TextUtils.isEmpty(pVar.s())) {
                    contentValues.put("reason", URLEncoder.encode(pVar.s(), "utf-8"));
                }
                contentValues.put("result", Integer.valueOf(pVar.y()));
                contentValues.put("duration", pVar.t());
                contentValues.put("videoSize", Long.valueOf(pVar.u()));
                contentValues.put("type", pVar.g());
                String f4 = pVar.f();
                if (!TextUtils.isEmpty(f4)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, f4);
                }
                String e4 = pVar.e();
                if (!TextUtils.isEmpty(e4)) {
                    contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, e4);
                }
                String k4 = pVar.k();
                if (!TextUtils.isEmpty(k4)) {
                    contentValues.put("rid", k4);
                }
                String l4 = pVar.l();
                if (!TextUtils.isEmpty(l4)) {
                    contentValues.put("rid_n", l4);
                }
                String i4 = pVar.i();
                if (!TextUtils.isEmpty(i4)) {
                    contentValues.put("template_url", i4);
                }
                String d4 = pVar.d();
                if (!TextUtils.isEmpty(d4)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, d4);
                }
                String h4 = pVar.h();
                if (!TextUtils.isEmpty(h4)) {
                    contentValues.put("ad_type", URLEncoder.encode(h4, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, pVar.m());
                contentValues.put("campaignId", pVar.n());
                if ("2000039".equals(pVar.o())) {
                    String f5 = com.mbridge.msdk.foundation.entity.p.f(pVar);
                    if (ag.b(f5)) {
                        contentValues.put("h5_click_data", f5);
                    }
                }
                String a4 = pVar.a();
                if (!TextUtils.isEmpty(a4)) {
                    contentValues.put("resource_type", URLEncoder.encode(a4, "utf-8"));
                }
                String b4 = pVar.b();
                if (!TextUtils.isEmpty(b4)) {
                    contentValues.put("device_id", URLEncoder.encode(b4, "utf-8"));
                }
                String c4 = pVar.c();
                if (!TextUtils.isEmpty(c4)) {
                    contentValues.put("creative", URLEncoder.encode(c4, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(pVar.j()));
                return getWritableDatabase().insert("reward_report", null, contentValues);
            } catch (Exception e5) {
                e5.printStackTrace();
                x.d(f39200a, e5.getMessage());
            }
        }
        return -1L;
    }
}
