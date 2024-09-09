package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.i;
import com.bytedance.sdk.component.xv.w.y;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ev extends y {

    /* renamed from: c  reason: collision with root package name */
    private final String f30951c;

    /* renamed from: w  reason: collision with root package name */
    private final long f30952w;
    private final com.bytedance.sdk.component.xv.c.ux xv;

    public ev(String str, long j4, com.bytedance.sdk.component.xv.c.ux uxVar) {
        this.f30951c = str;
        this.f30952w = j4;
        this.xv = uxVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.y
    public i c() {
        String str = this.f30951c;
        if (str != null) {
            return i.c(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.xv.w.y
    public long w() {
        return this.f30952w;
    }

    @Override // com.bytedance.sdk.component.xv.w.y
    public com.bytedance.sdk.component.xv.c.ux xv() {
        return this.xv;
    }
}
