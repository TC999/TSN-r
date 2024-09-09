package com.umeng.analytics.pro;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LenovoDeviceIdSupplier.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ba implements av {

    /* renamed from: a  reason: collision with root package name */
    private static final int f52621a = 1;

    /* renamed from: b  reason: collision with root package name */
    private org.repackage.com.zui.opendeviceidlibrary.b f52622b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f52623c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52624d = false;

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f52623c) {
            org.repackage.com.zui.opendeviceidlibrary.b bVar = new org.repackage.com.zui.opendeviceidlibrary.b();
            this.f52622b = bVar;
            this.f52624d = bVar.a(context, null) == 1;
            this.f52623c = true;
        }
        bh.a("getOAID", "isSupported", Boolean.valueOf(this.f52624d));
        if (this.f52624d && this.f52622b.j()) {
            return this.f52622b.b();
        }
        return null;
    }
}
