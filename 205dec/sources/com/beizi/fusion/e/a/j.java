package com.beizi.fusion.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: VivoDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    private Context f14720b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14721c = false;

    /* renamed from: a  reason: collision with root package name */
    String f14719a = null;

    public j(Context context) {
        this.f14720b = context;
    }

    public String a() {
        Cursor query = this.f14720b.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        }
        return r1;
    }
}
