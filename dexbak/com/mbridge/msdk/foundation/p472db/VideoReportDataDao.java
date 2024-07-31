package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.VideoReportData;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.tencent.connect.share.QzonePublish;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.net.URLEncoder;

/* renamed from: com.mbridge.msdk.foundation.db.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class VideoReportDataDao extends BaseDao<VideoReportData> {

    /* renamed from: a */
    private static final String f30373a = "com.mbridge.msdk.foundation.db.t";

    /* renamed from: b */
    private static VideoReportDataDao f30374b;

    private VideoReportDataDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static VideoReportDataDao m22654a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30374b == null) {
            synchronized (VideoReportDataDao.class) {
                if (f30374b == null) {
                    f30374b = new VideoReportDataDao(commonAbsDBHelper);
                }
            }
        }
        return f30374b;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0344 A[Catch: Exception -> 0x0350, all -> 0x0353, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0350, blocks: (B:100:0x0344, B:92:0x032d), top: B:119:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x034c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.mbridge.msdk.foundation.entity.VideoReportData> m22652a(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.VideoReportDataDao.m22652a(java.lang.String):java.util.List");
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int m22655a() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.VideoReportDataDao.m22655a():int");
    }

    /* renamed from: a */
    public final synchronized long m22653a(VideoReportData videoReportData) {
        if (videoReportData != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(DomainCampaignEx.LOOPBACK_KEY, videoReportData.m22403o());
                contentValues.put("networkType", Integer.valueOf(videoReportData.m22392v()));
                contentValues.put("network_str", videoReportData.m22391w());
                contentValues.put("isCompleteView", Integer.valueOf(videoReportData.m22390x()));
                contentValues.put("watchedMillis", Integer.valueOf(videoReportData.m22401p()));
                contentValues.put("videoLength", Integer.valueOf(videoReportData.m22399q()));
                if (!TextUtils.isEmpty(videoReportData.m22397r())) {
                    contentValues.put("offerUrl", videoReportData.m22397r());
                }
                if (!TextUtils.isEmpty(videoReportData.m22395s())) {
                    contentValues.put(MediationConstant.KEY_REASON, URLEncoder.encode(videoReportData.m22395s(), "utf-8"));
                }
                contentValues.put(CommonNetImpl.RESULT, Integer.valueOf(videoReportData.m22389y()));
                contentValues.put("duration", videoReportData.m22394t());
                contentValues.put(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, Long.valueOf(videoReportData.m22393u()));
                contentValues.put("type", videoReportData.m22421g());
                String m22425f = videoReportData.m22425f();
                if (!TextUtils.isEmpty(m22425f)) {
                    contentValues.put(CampaignEx.ENDCARD_URL, m22425f);
                }
                String m22429e = videoReportData.m22429e();
                if (!TextUtils.isEmpty(m22429e)) {
                    contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, m22429e);
                }
                String m22411k = videoReportData.m22411k();
                if (!TextUtils.isEmpty(m22411k)) {
                    contentValues.put("rid", m22411k);
                }
                String m22409l = videoReportData.m22409l();
                if (!TextUtils.isEmpty(m22409l)) {
                    contentValues.put("rid_n", m22409l);
                }
                String m22415i = videoReportData.m22415i();
                if (!TextUtils.isEmpty(m22415i)) {
                    contentValues.put("template_url", m22415i);
                }
                String m22434d = videoReportData.m22434d();
                if (!TextUtils.isEmpty(m22434d)) {
                    contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, m22434d);
                }
                String m22418h = videoReportData.m22418h();
                if (!TextUtils.isEmpty(m22418h)) {
                    contentValues.put("ad_type", URLEncoder.encode(m22418h, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, videoReportData.m22407m());
                contentValues.put("campaignId", videoReportData.m22405n());
                if ("2000039".equals(videoReportData.m22403o())) {
                    String m22424f = VideoReportData.m22424f(videoReportData);
                    if (StringUtils.m21956b(m22424f)) {
                        contentValues.put("h5_click_data", m22424f);
                    }
                }
                String m22449a = videoReportData.m22449a();
                if (!TextUtils.isEmpty(m22449a)) {
                    contentValues.put("resource_type", URLEncoder.encode(m22449a, "utf-8"));
                }
                String m22444b = videoReportData.m22444b();
                if (!TextUtils.isEmpty(m22444b)) {
                    contentValues.put("device_id", URLEncoder.encode(m22444b, "utf-8"));
                }
                String m22439c = videoReportData.m22439c();
                if (!TextUtils.isEmpty(m22439c)) {
                    contentValues.put("creative", URLEncoder.encode(m22439c, "utf-8"));
                }
                contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(videoReportData.m22413j()));
                return getWritableDatabase().insert("reward_report", null, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                SameLogTool.m21733d(f30373a, e.getMessage());
            }
        }
        return -1L;
    }
}
