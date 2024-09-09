package com.mbridge.msdk.optimize.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: VivoDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private Context f40415b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40416c = false;

    /* renamed from: a  reason: collision with root package name */
    String f40414a = null;

    public h(Context context) {
        this.f40415b = context;
    }

    public final String a() {
        try {
            Cursor query = this.f40415b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (query != null) {
                r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                query.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return r0;
    }
}
