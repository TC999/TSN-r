package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.out.Campaign;
import java.util.List;

/* compiled from: SCDao.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class p extends a<Campaign> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f39193a = "com.mbridge.msdk.foundation.db.p";

    /* renamed from: b  reason: collision with root package name */
    private static p f39194b;

    private p(h hVar) {
        super(hVar);
    }

    public static p a(h hVar) {
        if (f39194b == null) {
            synchronized (p.class) {
                if (f39194b == null) {
                    f39194b = new p(hVar);
                }
            }
        }
        return f39194b;
    }

    public final synchronized long a(CampaignEx campaignEx) {
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
            if (a(campaignEx.getPackageName())) {
                return getWritableDatabase().update("sc", contentValues, "package_name = '" + campaignEx.getPackageName() + "'", null);
            }
            return getWritableDatabase().insert("sc", null, contentValues);
        } catch (Exception e4) {
            e4.printStackTrace();
            return -1L;
        }
    }

    public final synchronized void a(final List<CampaignEx> list) {
        if (list != null) {
            if (list.size() != 0) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.db.p.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (CampaignEx campaignEx : list) {
                            p.this.a(campaignEx);
                        }
                    }
                }).start();
            }
        }
    }

    private synchronized boolean a(String str) {
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
