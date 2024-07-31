package com.beizi.fusion.p068e.p069a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.beizi.fusion.e.a.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VivoDeviceIDHelper {

    /* renamed from: b */
    private Context f11202b;

    /* renamed from: c */
    private boolean f11203c = false;

    /* renamed from: a */
    String f11201a = null;

    public VivoDeviceIDHelper(Context context) {
        this.f11202b = context;
    }

    /* renamed from: a */
    public String m48551a() {
        Cursor query = this.f11202b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE)) : null;
            query.close();
        }
        return r1;
    }
}
