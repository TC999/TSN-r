package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.FqInfo;
import com.mbridge.msdk.foundation.same.CommonConst;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* renamed from: com.mbridge.msdk.foundation.db.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FqInfoDao extends BaseDao<FqInfo> {

    /* renamed from: a */
    private static FqInfoDao f30360a;

    private FqInfoDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static FqInfoDao m22708a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30360a == null) {
            synchronized (FqInfoDao.class) {
                if (f30360a == null) {
                    f30360a = new FqInfoDao(commonAbsDBHelper);
                }
            }
        }
        return f30360a;
    }

    /* renamed from: a */
    public final synchronized void m22707a(FqInfo fqInfo) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getWritableDatabase() == null) {
            return;
        }
        if (fqInfo != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", fqInfo.m22562a());
            contentValues.put(RtspHeaders.Values.TIME, Long.valueOf(fqInfo.m22555d()));
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, fqInfo.m22558b());
            contentValues.put("type", Integer.valueOf(fqInfo.m22556c()));
            if (m22705a(fqInfo.m22558b(), fqInfo.m22562a())) {
                getWritableDatabase().update("fq_info", contentValues, "id = " + fqInfo.m22562a() + " AND " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + " = " + fqInfo.m22558b(), null);
            } else {
                getWritableDatabase().insert("fq_info", null, contentValues);
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m22705a(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("select id from fq_info where unitId='" + str + "' and id='" + str2 + "'", null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final synchronized void m22706a(String str) {
        try {
            String str2 = "time<" + (System.currentTimeMillis() - 86400000) + " and " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + "=? and type <> " + CommonConst.f30563D;
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("fq_info", str2, strArr);
            }
        } catch (Exception unused) {
        }
    }
}
