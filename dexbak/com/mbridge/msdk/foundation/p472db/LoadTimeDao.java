package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.LoadTime;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.db.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class LoadTimeDao extends BaseDao<LoadTime> {

    /* renamed from: a */
    private static LoadTimeDao f30362a;

    private LoadTimeDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static LoadTimeDao m22695a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30362a == null) {
            synchronized (LoadTimeDao.class) {
                if (f30362a == null) {
                    f30362a = new LoadTimeDao(commonAbsDBHelper);
                }
            }
        }
        return f30362a;
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
    public final synchronized int m22697a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from load_stat"
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.p472db.LoadTimeDao.m22697a():int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List<com.mbridge.msdk.foundation.entity.j>] */
    /* renamed from: a */
    public final synchronized List<LoadTime> m22696a(int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = 0;
        try {
            try {
                Cursor rawQuery = getReadableDatabase().rawQuery("select * from load_stat LIMIT " + i, null);
                if (rawQuery != null) {
                    try {
                        try {
                            if (rawQuery.getCount() > 0) {
                                arrayList2 = new ArrayList();
                                int i2 = 0;
                                while (rawQuery.moveToNext() && i2 < i) {
                                    try {
                                        i2++;
                                        int i3 = rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_AD_SOURCE_ID));
                                        String string = rawQuery.getString(rawQuery.getColumnIndex(RtspHeaders.Values.TIME));
                                        int i4 = rawQuery.getInt(rawQuery.getColumnIndex("adNum"));
                                        String string2 = rawQuery.getString(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        int i5 = rawQuery.getInt(rawQuery.getColumnIndex("fb"));
                                        int i6 = rawQuery.getInt(rawQuery.getColumnIndex("timeout"));
                                        int i7 = rawQuery.getInt(rawQuery.getColumnIndex(UMCommonContent.f37763T));
                                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("network_type_str"));
                                        int i8 = rawQuery.getInt(rawQuery.getColumnIndex(CampaignEx.JSON_KEY_HB));
                                        LoadTime loadTime = new LoadTime(i3, string, i4, string2, i5, i6, i7);
                                        loadTime.m22529c(string3);
                                        loadTime.m22536a(i8);
                                        arrayList2.add(loadTime);
                                        int i9 = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                                        if (getWritableDatabase() != null) {
                                            getWritableDatabase().delete("load_stat", "id = ?", new String[]{i9 + ""});
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        arrayList = rawQuery;
                                        e.printStackTrace();
                                        if (arrayList != null) {
                                            arrayList.close();
                                        }
                                        arrayList = arrayList2;
                                        return arrayList;
                                    }
                                }
                                arrayList = arrayList2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            arrayList = rawQuery;
                            if (arrayList != null) {
                                arrayList.close();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        arrayList2 = null;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e3) {
                e = e3;
                arrayList2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return arrayList;
    }

    /* renamed from: a */
    public final synchronized void m22694a(LoadTime loadTime) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(RtspHeaders.Values.TIME, loadTime.m22531c());
        contentValues.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, Integer.valueOf(loadTime.m22534b()));
        contentValues.put("adNum", Integer.valueOf(loadTime.m22528d()));
        contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, loadTime.m22526e());
        contentValues.put("fb", Integer.valueOf(loadTime.m22524f()));
        contentValues.put(CampaignEx.JSON_KEY_HB, Integer.valueOf(loadTime.m22537a()));
        contentValues.put("timeout", Integer.valueOf(loadTime.m22523g()));
        contentValues.put(UMCommonContent.f37763T, Integer.valueOf(loadTime.m22522h()));
        contentValues.put("network_type_str", loadTime.m22521i());
        getWritableDatabase().insert("load_stat", null, contentValues);
    }
}
