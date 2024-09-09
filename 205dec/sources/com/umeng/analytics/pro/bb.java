package com.umeng.analytics.pro;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MeizuDeviceIdSupplier.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class bb implements av {
    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean c4 = org.repackage.com.meizu.flyme.openidsdk.b.c();
        bh.a("getOAID", "isSupported", Boolean.valueOf(c4));
        if (c4) {
            return org.repackage.com.meizu.flyme.openidsdk.b.d(context);
        }
        return null;
    }
}
