package com.bytedance.sdk.component.xv.w.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class xv {
    public final com.bytedance.sdk.component.xv.c.f ev;
    final int gd;

    /* renamed from: r  reason: collision with root package name */
    public final com.bytedance.sdk.component.xv.c.f f30908r;

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.xv.c.f f30905c = com.bytedance.sdk.component.xv.c.f.c(":");

    /* renamed from: w  reason: collision with root package name */
    public static final com.bytedance.sdk.component.xv.c.f f30907w = com.bytedance.sdk.component.xv.c.f.c(":status");
    public static final com.bytedance.sdk.component.xv.c.f xv = com.bytedance.sdk.component.xv.c.f.c(":method");
    public static final com.bytedance.sdk.component.xv.c.f sr = com.bytedance.sdk.component.xv.c.f.c(":path");
    public static final com.bytedance.sdk.component.xv.c.f ux = com.bytedance.sdk.component.xv.c.f.c(":scheme");

    /* renamed from: f  reason: collision with root package name */
    public static final com.bytedance.sdk.component.xv.c.f f30906f = com.bytedance.sdk.component.xv.c.f.c(":authority");

    public xv(String str, String str2) {
        this(com.bytedance.sdk.component.xv.c.f.c(str), com.bytedance.sdk.component.xv.c.f.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof xv) {
            xv xvVar = (xv) obj;
            return this.f30908r.equals(xvVar.f30908r) && this.ev.equals(xvVar.ev);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f30908r.hashCode()) * 31) + this.ev.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.xv.w.c.xv.c("%s: %s", this.f30908r.c(), this.ev.c());
    }

    public xv(com.bytedance.sdk.component.xv.c.f fVar, String str) {
        this(fVar, com.bytedance.sdk.component.xv.c.f.c(str));
    }

    public xv(com.bytedance.sdk.component.xv.c.f fVar, com.bytedance.sdk.component.xv.c.f fVar2) {
        this.f30908r = fVar;
        this.ev = fVar2;
        this.gd = fVar.r() + 32 + fVar2.r();
    }
}
