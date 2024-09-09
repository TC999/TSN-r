package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.splash.k;
import com.bytedance.sdk.openadsdk.core.u.me;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr {

    /* renamed from: c  reason: collision with root package name */
    protected Context f32977c;
    protected k.c sr;

    /* renamed from: w  reason: collision with root package name */
    protected ViewGroup f32978w;
    protected me xv;

    public abstract String c();

    public void c(Context context, ViewGroup viewGroup, me meVar) {
        this.f32977c = context;
        this.f32978w = viewGroup;
        this.xv = meVar;
    }

    public abstract void c(com.bytedance.sdk.openadsdk.core.w.c cVar);

    public void c(boolean z3) {
    }

    public void w() {
        k.c cVar = this.sr;
        if (cVar != null) {
            cVar.w();
        }
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, "splash_ad", "close_splash_icon");
    }

    public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar, k.c cVar) {
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.xv, "splash_ad", c());
        this.f32978w.setVisibility(0);
        this.sr = cVar;
    }
}
