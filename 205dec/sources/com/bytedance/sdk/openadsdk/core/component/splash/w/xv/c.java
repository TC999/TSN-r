package com.bytedance.sdk.openadsdk.core.component.splash.w.xv;

import com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.xv.w f33050c;
    private com.bytedance.sdk.openadsdk.ys.w.w.w sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv f33051w;
    private sr<gd, r> xv;

    public c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv xvVar, sr<gd, r> srVar) {
        if (xvVar == null || srVar == null) {
            return;
        }
        this.f33051w = xvVar;
        this.xv = srVar;
        com.bytedance.sdk.openadsdk.core.component.splash.xv.w wVar = new com.bytedance.sdk.openadsdk.core.component.splash.xv.w(xvVar.getContext(), xvVar.r(), xvVar.f(), this.f33051w.ev(), xvVar, srVar);
        this.f33050c = wVar;
        this.sr = wVar;
    }

    public void c(int i4) {
        com.bytedance.sdk.openadsdk.core.component.splash.xv.w wVar = this.f33050c;
        if (wVar != null) {
            wVar.c(i4);
        }
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.component.splash.xv.w wVar = this.f33050c;
        if (wVar != null) {
            wVar.w(this.f33051w, this.xv);
        }
    }

    public com.bytedance.sdk.openadsdk.ys.w.w.w c() {
        return this.sr;
    }
}
