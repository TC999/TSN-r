package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: FqInfoDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class k extends a<com.mbridge.msdk.foundation.entity.g> {

    /* renamed from: a  reason: collision with root package name */
    private static k f39187a;

    private k(h hVar) {
        super(hVar);
    }

    public static k a(h hVar) {
        if (f39187a == null) {
            synchronized (k.class) {
                if (f39187a == null) {
                    f39187a = new k(hVar);
                }
            }
        }
        return f39187a;
    }

    public final synchronized void a(com.mbridge.msdk.foundation.entity.g gVar) {
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (getWritableDatabase() == null) {
            return;
        }
        if (gVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", gVar.a());
            contentValues.put("time", Long.valueOf(gVar.d()));
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, gVar.b());
            contentValues.put("type", Integer.valueOf(gVar.c()));
            if (a(gVar.b(), gVar.a())) {
                getWritableDatabase().update("fq_info", contentValues, "id = " + gVar.a() + " AND " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + " = " + gVar.b(), null);
            } else {
                getWritableDatabase().insert("fq_info", null, contentValues);
            }
        }
    }

    private synchronized boolean a(String str, String str2) {
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
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final synchronized void a(String str) {
        try {
            String str2 = "time<" + (System.currentTimeMillis() - 86400000) + " and " + CampaignEx.JSON_KEY_CAMPAIGN_UNITID + "=? and type <> " + com.mbridge.msdk.foundation.same.a.D;
            String[] strArr = {str};
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("fq_info", str2, strArr);
            }
        } catch (Exception unused) {
        }
    }
}
