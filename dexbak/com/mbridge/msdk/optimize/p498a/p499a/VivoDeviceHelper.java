package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.mbridge.msdk.optimize.a.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class VivoDeviceHelper {

    /* renamed from: b */
    private Context f31642b;

    /* renamed from: c */
    private boolean f31643c = false;

    /* renamed from: a */
    String f31641a = null;

    public VivoDeviceHelper(Context context) {
        this.f31642b = context;
    }

    /* renamed from: a */
    public final String m21354a() {
        try {
            Cursor query = this.f31642b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                r0 = query.moveToNext() ? query.getString(query.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE)) : null;
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return r0;
    }
}
