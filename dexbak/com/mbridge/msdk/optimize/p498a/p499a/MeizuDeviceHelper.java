package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.optimize.p498a.OaidCallback;

/* renamed from: com.mbridge.msdk.optimize.a.a.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MeizuDeviceHelper {

    /* renamed from: a */
    private Context f31623a;

    public MeizuDeviceHelper(Context context) {
        this.f31623a = context;
    }

    /* renamed from: a */
    public final void m21361a(OaidCallback oaidCallback) {
        try {
            this.f31623a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Cursor query = this.f31623a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (query != null && !query.isClosed()) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE);
                r2 = columnIndex > 0 ? query.getString(columnIndex) : null;
                int columnIndex2 = query.getColumnIndex("code");
                if (columnIndex2 > 0) {
                    query.getInt(columnIndex2);
                }
                int columnIndex3 = query.getColumnIndex("expired");
                if (columnIndex3 > 0) {
                    query.getLong(columnIndex3);
                }
            }
            if (oaidCallback != null) {
                oaidCallback.mo21350a(r2, false);
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
