package com.bytedance.sdk.component.ux.w;

import com.bytedance.sdk.component.ux.r;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements r {

    /* renamed from: c  reason: collision with root package name */
    private long f30249c;

    /* renamed from: w  reason: collision with root package name */
    private long f30250w;
    private long xv;

    @Override // com.bytedance.sdk.component.ux.r
    @ATSMethod(1)
    public long c() {
        return this.f30249c;
    }

    @Override // com.bytedance.sdk.component.ux.r
    @ATSMethod(2)
    public long w() {
        return this.f30250w;
    }

    @Override // com.bytedance.sdk.component.ux.r
    @ATSMethod(3)
    public long xv() {
        return this.xv;
    }

    public void c(long j4) {
        this.f30249c = j4;
    }

    public void w(long j4) {
        this.f30250w = j4;
    }

    public void xv(long j4) {
        this.xv = j4;
    }
}
