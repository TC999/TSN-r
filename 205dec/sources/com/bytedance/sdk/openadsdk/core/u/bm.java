package com.bytedance.sdk.openadsdk.core.u;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bm {

    /* renamed from: c  reason: collision with root package name */
    private int f34623c;
    private int sr = 1;

    /* renamed from: w  reason: collision with root package name */
    private int f34624w;
    private int xv;

    private int f() {
        return com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext()));
    }

    private int ux() {
        return com.bytedance.sdk.openadsdk.core.eq.xk.sr(com.bytedance.sdk.openadsdk.core.ls.getContext(), com.bytedance.sdk.openadsdk.core.eq.xk.ux(com.bytedance.sdk.openadsdk.core.ls.getContext()));
    }

    public int c() {
        return this.f34623c;
    }

    public int sr() {
        return this.sr == 2 ? 2 : 1;
    }

    public int w() {
        return this.f34624w;
    }

    public int xv() {
        return this.xv;
    }

    public void c(int i4) {
        if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4) {
            this.f34623c = 2;
        } else {
            this.f34623c = i4;
        }
    }

    public void sr(int i4) {
        this.sr = i4;
    }

    public void w(int i4) {
        if (i4 > 0 && i4 < f()) {
            this.f34624w = i4;
        } else {
            this.f34624w = 16;
        }
    }

    public void xv(int i4) {
        if (i4 > 0 && i4 < ux()) {
            this.xv = i4;
            return;
        }
        int i5 = this.f34623c;
        if (i5 != 3 && i5 != 4) {
            this.xv = 16;
        } else {
            this.xv = 30;
        }
    }
}
