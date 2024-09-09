package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.openadsdk.core.eq;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.sr.c.w.c.w f32859c;

    public void c(com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar) {
        this.f32859c = wVar;
    }

    public void sr() {
        this.f32859c = null;
    }

    public void w() {
        com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar;
        if (eq.f33190w < 4700 || (wVar = this.f32859c) == null) {
            return;
        }
        wVar.onSplashCardClick();
    }

    public boolean xv() {
        return eq.f33190w < 4700 || this.f32859c == null;
    }

    public void c() {
        com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar;
        if (eq.f33190w < 4700 || (wVar = this.f32859c) == null) {
            return;
        }
        wVar.onSplashCardClose();
        this.f32859c = null;
    }

    public void c(com.bytedance.sdk.openadsdk.ys.w.w.w wVar) {
        com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar2;
        if (eq.f33190w < 4700 || (wVar2 = this.f32859c) == null) {
            return;
        }
        wVar2.onSplashCardReadyToShow(wVar);
    }
}
