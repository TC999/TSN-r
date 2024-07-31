package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.C15410b;

/* renamed from: com.umeng.analytics.pro.bb */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class MeizuDeviceIdSupplier implements IDeviceIdSupplier {
    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        if (context == null) {
            return null;
        }
        boolean m2785c = C15410b.m2785c();
        C13124bh.m14664a("getOAID", "isSupported", Boolean.valueOf(m2785c));
        if (m2785c) {
            return C15410b.m2784d(context);
        }
        return null;
    }
}
