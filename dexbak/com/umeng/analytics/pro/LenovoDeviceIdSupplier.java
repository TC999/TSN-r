package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.zui.opendeviceidlibrary.C15421b;

/* renamed from: com.umeng.analytics.pro.ba */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LenovoDeviceIdSupplier implements IDeviceIdSupplier {

    /* renamed from: a */
    private static final int f37734a = 1;

    /* renamed from: b */
    private C15421b f37735b;

    /* renamed from: c */
    private boolean f37736c = false;

    /* renamed from: d */
    private boolean f37737d = false;

    @Override // com.umeng.analytics.pro.IDeviceIdSupplier
    /* renamed from: a */
    public String mo14666a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f37736c) {
            C15421b c15421b = new C15421b();
            this.f37735b = c15421b;
            this.f37737d = c15421b.m2678a(context, null) == 1;
            this.f37736c = true;
        }
        C13124bh.m14664a("getOAID", "isSupported", Boolean.valueOf(this.f37737d));
        if (this.f37737d && this.f37735b.m2669j()) {
            return this.f37735b.m2677b();
        }
        return null;
    }
}
