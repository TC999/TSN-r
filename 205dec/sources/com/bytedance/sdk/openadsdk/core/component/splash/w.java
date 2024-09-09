package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.eq;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sr.c.w.c.xv f32999c;

    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar) {
        this.f32999c = xvVar;
    }

    public void w() {
        com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar;
        if (eq.f33190w < 4700 || (xvVar = this.f32999c) == null) {
            return;
        }
        xvVar.onSplashClickEyeClick();
    }

    public void xv() {
        this.f32999c = null;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar;
        if (eq.f33190w < 4700 || (xvVar = this.f32999c) == null) {
            return;
        }
        xvVar.onSplashClickEyeReadyToShow(wVar);
    }

    public void c() {
        com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar;
        if (eq.f33190w < 4700 || (xvVar = this.f32999c) == null) {
            return;
        }
        xvVar.onSplashClickEyeClose();
    }
}
