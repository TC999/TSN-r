package com.mbridge.msdk.foundation.p472db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.db.p */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SCDao extends BaseDao<Campaign> {

    /* renamed from: a */
    private static final String f30366a = "com.mbridge.msdk.foundation.db.p";

    /* renamed from: b */
    private static SCDao f30367b;

    private SCDao(CommonAbsDBHelper commonAbsDBHelper) {
        super(commonAbsDBHelper);
    }

    /* renamed from: a */
    public static SCDao m22679a(CommonAbsDBHelper commonAbsDBHelper) {
        if (f30367b == null) {
            synchronized (SCDao.class) {
                if (f30367b == null) {
                    f30367b = new SCDao(commonAbsDBHelper);
                }
            }
        }
        return f30367b;
    }

    /* renamed from: a */
    public final synchronized long m22678a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            if (getWritableDatabase() == null) {
                return -1L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("package_name", campaignEx.getPackageName());
            contentValues.put(DownloadModel.DOWNLOAD_URL, campaignEx.getClickURL());
            contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
            contentValues.put(DomainCampaignEx.JSON_KEY_PRE_CLICK, Boolean.valueOf(campaignEx.isPreClick()));
            contentValues.put("get_time", Long.valueOf(System.currentTimeMillis()));
            if (m22677a(campaignEx.getPackageName())) {
                return getWritableDatabase().update("sc", contentValues, "package_name = '" + campaignEx.getPackageName() + "'", null);
            }
            return getWritableDatabase().insert("sc", null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: a */
    public final synchronized void m22676a(final List<CampaignEx> list) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.db.p.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (CampaignEx campaignEx : list) {
                            SCDao.this.m22678a(campaignEx);
                        }
                    }
                }).start();
            }
        }
    }

    /* renamed from: a */
    private synchronized boolean m22677a(String str) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT get_time FROM sc WHERE package_name='" + str + "'", null);
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }
}
