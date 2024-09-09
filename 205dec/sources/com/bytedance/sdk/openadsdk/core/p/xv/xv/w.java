package com.bytedance.sdk.openadsdk.core.p.xv.xv;

import com.bytedance.sdk.openadsdk.core.u.ia;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    private boolean ux = false;

    /* renamed from: f  reason: collision with root package name */
    private int f34387f = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f34388r = false;

    public void c(int i4) {
        this.f34387f = i4;
    }

    public void w(boolean z3) {
        this.ux = z3;
    }

    public void xv(boolean z3) {
        this.f34388r = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.xv.xv.c
    protected boolean xv() {
        this.xv = 1;
        boolean z3 = f.sr;
        int p3 = ia.p(this.f34384w);
        if (z3) {
            f.sr = false;
            p3 = 0;
        }
        if (this.f34388r) {
            return sr();
        }
        if (this.ux) {
            int i4 = this.f34387f;
            if (i4 == 2) {
                return sr();
            }
            if (p3 == 2 && i4 == 1) {
                return sr();
            }
        }
        if (p3 == 0) {
            return sr();
        }
        return true;
    }
}
