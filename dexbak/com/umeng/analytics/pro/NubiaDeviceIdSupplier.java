package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: com.umeng.analytics.pro.bc */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class NubiaDeviceIdSupplier implements IDeviceIdSupplier {

    /* renamed from: a */
    private static final String f37738a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(f37738a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}
