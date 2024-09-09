package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.Campaign;

/* compiled from: VideoDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class s extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static s f39199a;

    private s(h hVar) {
        super(hVar);
    }

    public static s a(h hVar) {
        if (f39199a == null) {
            synchronized (s.class) {
                if (f39199a == null) {
                    f39199a = new s(hVar);
                }
            }
        }
        return f39199a;
    }

    public final synchronized void b(String str) {
        String str2;
        try {
            str2 = "video_url = '" + str + "'";
        } catch (Exception unused) {
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("video", str2, null);
    }

    private synchronized boolean b(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "'";
        } else {
            str3 = "SELECT id FROM video WHERE video_url = '" + str + "' AND id = " + str2;
        }
        Cursor rawQuery = getReadableDatabase().rawQuery(str3, null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.mbridge.msdk.foundation.entity.o] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.mbridge.msdk.foundation.entity.o a(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lbc
            r1 = 0
            if (r0 == 0) goto La
            monitor-exit(r6)
            return r1
        La:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            r0.<init>()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            java.lang.String r2 = "SELECT * FROM video WHERE video_url = '"
            r0.append(r2)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            r0.append(r7)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            java.lang.String r7 = "'"
            r0.append(r7)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            android.database.sqlite.SQLiteDatabase r0 = r6.getReadableDatabase()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            android.database.Cursor r7 = r0.rawQuery(r7, r1)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            if (r7 == 0) goto L97
            int r0 = r7.getCount()     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Lb4
            if (r0 <= 0) goto L97
            com.mbridge.msdk.foundation.entity.o r0 = new com.mbridge.msdk.foundation.entity.o     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Lb4
            r0.<init>()     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Lb4
        L35:
            boolean r1 = r7.moveToNext()     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            if (r1 == 0) goto L8e
            java.lang.String r1 = "video_url"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r0.a(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = "video_state"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            int r1 = r7.getInt(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r0.b(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = "pregeress_size"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            long r1 = r7.getLong(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r0.b(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = "total_size"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            int r1 = r7.getInt(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r0.a(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = "video_path"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = r7.getString(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r0.b(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            java.lang.String r1 = "video_download_start"
            int r1 = r7.getColumnIndex(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            long r1 = r7.getLong(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r0.a(r1)     // Catch: java.lang.Exception -> L90 java.lang.Throwable -> Lb4
            goto L35
        L8e:
            r1 = r0
            goto L97
        L90:
            r1 = move-exception
            goto La3
        L92:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto La3
        L97:
            if (r7 == 0) goto Lb2
            r7.close()     // Catch: java.lang.Exception -> Lb2 java.lang.Throwable -> Lbc
            goto Lb2
        L9d:
            r0 = move-exception
            goto Lb6
        L9f:
            r7 = move-exception
            r0 = r1
            r1 = r7
            r7 = r0
        La3:
            java.lang.String r2 = "VideoDao"
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch: java.lang.Throwable -> Lb4
            com.mbridge.msdk.foundation.tools.x.d(r2, r1)     // Catch: java.lang.Throwable -> Lb4
            if (r7 == 0) goto Lb1
            r7.close()     // Catch: java.lang.Exception -> Lb1 java.lang.Throwable -> Lbc
        Lb1:
            r1 = r0
        Lb2:
            monitor-exit(r6)
            return r1
        Lb4:
            r0 = move-exception
            r1 = r7
        Lb6:
            if (r1 == 0) goto Lbb
            r1.close()     // Catch: java.lang.Exception -> Lbb java.lang.Throwable -> Lbc
        Lbb:
            throw r0     // Catch: java.lang.Throwable -> Lbc
        Lbc:
            r7 = move-exception
            monitor-exit(r6)
            goto Lc0
        Lbf:
            throw r7
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.s.a(java.lang.String):com.mbridge.msdk.foundation.entity.o");
    }

    public final synchronized long b(String str, long j4) {
        int i4 = -1;
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("total_size", Long.valueOf(j4));
        if (b(str, "")) {
            String str2 = "video_url = '" + str + "'";
            synchronized (new Object()) {
                i4 = getWritableDatabase().update("video", contentValues, str2, null);
            }
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009f, code lost:
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a1, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.mbridge.msdk.foundation.entity.o a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> Lb2
            r0 = 0
            if (r7 == 0) goto La
            monitor-exit(r5)
            return r0
        La:
            com.mbridge.msdk.foundation.entity.o r7 = new com.mbridge.msdk.foundation.entity.o     // Catch: java.lang.Throwable -> Lb2
            r7.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r1.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = " WHERE video_url = '"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb2
            r1.append(r6)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r6 = "'"
            r1.append(r6)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r1.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "SELECT * FROM video"
            r1.append(r2)     // Catch: java.lang.Throwable -> Lb2
            r1.append(r6)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Lb2
            android.database.sqlite.SQLiteDatabase r1 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            android.database.Cursor r0 = r1.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            if (r0 == 0) goto L9f
            int r6 = r0.getCount()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            if (r6 <= 0) goto L9f
        L46:
            boolean r6 = r0.moveToNext()     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            if (r6 == 0) goto L9f
            java.lang.String r6 = "video_url"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = r0.getString(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r7.a(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = "video_state"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            int r6 = r0.getInt(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r7.b(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = "pregeress_size"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            long r1 = r0.getLong(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r7.b(r1)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = "total_size"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            int r6 = r0.getInt(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r7.a(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = "video_path"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = r0.getString(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r7.b(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            java.lang.String r6 = "video_download_start"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            long r1 = r0.getLong(r6)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r7.a(r1)     // Catch: java.lang.Throwable -> La5 java.lang.Exception -> Lac
            goto L46
        L9f:
            if (r0 == 0) goto Lb0
        La1:
            r0.close()     // Catch: java.lang.Exception -> Lb0 java.lang.Throwable -> Lb2
            goto Lb0
        La5:
            r6 = move-exception
            if (r0 == 0) goto Lab
            r0.close()     // Catch: java.lang.Exception -> Lab java.lang.Throwable -> Lb2
        Lab:
            throw r6     // Catch: java.lang.Throwable -> Lb2
        Lac:
            if (r0 == 0) goto Lb0
            goto La1
        Lb0:
            monitor-exit(r5)
            return r7
        Lb2:
            r6 = move-exception
            monitor-exit(r5)
            goto Lb6
        Lb5:
            throw r6
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.s.a(java.lang.String, java.lang.String):com.mbridge.msdk.foundation.entity.o");
    }

    public final synchronized void a(String str, long j4) {
        if (j4 == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j4 / 1000));
            if (b(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = '" + str + "'", null);
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized long a(CampaignEx campaignEx, long j4, String str, int i4) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("unitid", campaignEx.getCampaignUnitId());
            contentValues.put("id", campaignEx.getId());
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put("app_name", campaignEx.getAppName());
            contentValues.put("app_desc", campaignEx.getAppDesc());
            contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
            contentValues.put(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMAGE_URL, campaignEx.getImageUrl());
            contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
            contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
            contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
            contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
            contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
            contentValues.put("star", Double.valueOf(campaignEx.getRating()));
            contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
            contentValues.put("cpti", Integer.valueOf(campaignEx.getPreClickInterval()));
            contentValues.put("preclick", Boolean.valueOf(campaignEx.isPreClick()));
            contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
            contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
            contentValues.put("ad_call", campaignEx.getAdCall());
            contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
            contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
            contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
            contentValues.put("total_size", Long.valueOf(j4));
            contentValues.put("video_state", Integer.valueOf(i4));
            contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("ad_bid_token", campaignEx.getBidToken());
            if (!TextUtils.isEmpty(str)) {
                contentValues.put("video_path", str);
            }
            if (b(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                return 0L;
            }
            return getWritableDatabase().insert("video", null, contentValues);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final synchronized long a(String str, long j4, int i4) {
        int i5 = -1;
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pregeress_size", Long.valueOf(j4));
        contentValues.put("video_state", Integer.valueOf(i4));
        if (b(str, "")) {
            String str2 = "video_url = '" + str + "'";
            synchronized (new Object()) {
                i5 = getWritableDatabase().update("video", contentValues, str2, null);
            }
        }
        return i5;
    }
}
