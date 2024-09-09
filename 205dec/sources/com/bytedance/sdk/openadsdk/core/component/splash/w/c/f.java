package com.bytedance.sdk.openadsdk.core.component.splash.w.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private long f33010f;
    private long gd;

    /* renamed from: r  reason: collision with root package name */
    private long f33011r;
    private com.bytedance.sdk.openadsdk.core.u.c sr;
    private boolean ux;

    public f(com.bytedance.sdk.openadsdk.core.u.c cVar, boolean z3) {
        this.sr = cVar;
        if (cVar != null && cVar.w() != null && !this.sr.w().isEmpty()) {
            this.f33001w = this.sr.w().get(0);
        }
        this.ux = z3;
    }

    public long ev() {
        return this.ev;
    }

    public long f() {
        return this.f33010f;
    }

    public long gd() {
        return this.gd;
    }

    public long r() {
        return this.f33011r;
    }

    public com.bytedance.sdk.openadsdk.core.u.c sr() {
        return this.sr;
    }

    public boolean ux() {
        return this.ux;
    }

    public void w(long j4) {
        this.f33010f = j4;
    }

    public void xv(long j4) {
        this.f33011r = j4;
    }

    public void sr(long j4) {
        this.ev = j4;
    }

    public void ux(long j4) {
        this.gd = j4;
    }
}
