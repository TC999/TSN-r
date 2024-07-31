package com.amap.api.col.p0463l;

import android.content.Context;

/* renamed from: com.amap.api.col.3l.w7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WiFiUplateStrategy extends UpdateStrategy {

    /* renamed from: b */
    private Context f5639b;

    /* renamed from: c */
    private boolean f5640c;

    public WiFiUplateStrategy(Context context, boolean z) {
        this.f5639b = context;
        this.f5640c = z;
    }

    @Override // com.amap.api.col.p0463l.UpdateStrategy
    /* renamed from: d */
    protected final boolean mo53576d() {
        return DeviceInfo.m54809M(this.f5639b) == 1 || this.f5640c;
    }
}
