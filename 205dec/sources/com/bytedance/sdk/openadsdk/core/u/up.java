package com.bytedance.sdk.openadsdk.core.u;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class up {

    /* renamed from: c  reason: collision with root package name */
    private int f34844c;

    /* renamed from: w  reason: collision with root package name */
    private int f34845w;
    private int xv;

    private int sr() {
        return com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.eq.xk.ux(com.bytedance.sdk.openadsdk.core.ls.getContext()));
    }

    public int c() {
        return this.f34844c;
    }

    public int w() {
        return this.f34845w;
    }

    public int xv() {
        return this.xv;
    }

    public void c(int i4) {
        if (i4 != 1 && i4 != 2) {
            i4 = 0;
        }
        this.f34844c = i4;
    }

    public void w(int i4) {
        if (i4 > 0 && i4 < sr()) {
            this.f34845w = i4;
            return;
        }
        int i5 = this.f34844c;
        if (i5 == 1) {
            this.f34845w = 90;
        } else if (i5 == 2) {
            this.f34845w = 150;
        }
    }

    public void xv(int i4) {
        if (i4 > 0 && i4 < sr()) {
            this.xv = i4;
            return;
        }
        int i5 = this.f34844c;
        if (i5 == 1) {
            this.xv = 90;
        } else if (i5 == 2) {
            this.xv = 150;
        }
    }
}
