package com.amap.api.col.s;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WiFiUplateStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w3 extends v3 {

    /* renamed from: b  reason: collision with root package name */
    private Context f10372b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10373c = false;

    public w3(Context context) {
        this.f10372b = context;
    }

    @Override // com.amap.api.col.s.v3
    protected final boolean c() {
        return c1.D(this.f10372b) == 1 || this.f10373c;
    }
}
