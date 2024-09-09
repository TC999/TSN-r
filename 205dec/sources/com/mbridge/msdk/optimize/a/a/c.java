package com.mbridge.msdk.optimize.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: MeizuDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f40396a;

    public c(Context context) {
        this.f40396a = context;
    }

    public final void a(com.mbridge.msdk.optimize.a.b bVar) {
        try {
            this.f40396a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            Cursor query = this.f40396a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            if (query != null && !query.isClosed()) {
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
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
            if (bVar != null) {
                bVar.a(r2, false);
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
