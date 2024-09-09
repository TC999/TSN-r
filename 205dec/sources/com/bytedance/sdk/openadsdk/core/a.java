package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f31656c;

    /* renamed from: f  reason: collision with root package name */
    private View f31657f;

    /* renamed from: r  reason: collision with root package name */
    private String f31658r;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.f sr;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.ux ux;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.u.me f31659w;
    private com.bytedance.sdk.openadsdk.core.p.w.xv xv;

    public a(Context context, com.bytedance.sdk.openadsdk.core.u.me meVar, View view, String str) {
        this.f31658r = "rewarded_video";
        this.f31659w = meVar;
        this.f31656c = context;
        this.f31657f = view;
        if (TextUtils.isEmpty(str)) {
            this.f31658r = com.bytedance.sdk.openadsdk.core.eq.wv.w(com.bytedance.sdk.openadsdk.core.eq.wv.ev(meVar));
        } else {
            this.f31658r = str;
        }
        if (meVar.v() == 4) {
            this.xv = com.bytedance.sdk.openadsdk.core.p.xv.c(context, meVar, this.f31658r);
        }
        String str2 = this.f31658r;
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.f(context, meVar, str2, com.bytedance.sdk.openadsdk.core.eq.wv.c(str2));
        this.sr = fVar;
        fVar.c(this.f31657f);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.sr.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        String str3 = this.f31658r;
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.ux(context, meVar, str3, com.bytedance.sdk.openadsdk.core.eq.wv.c(str3));
        this.ux = uxVar;
        uxVar.c(this.f31657f);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.ux.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
    }

    public void c(int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.ux uxVar;
        if (i4 == -1 || uVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.gd gdVar = new com.bytedance.sdk.openadsdk.core.u.gd();
        gdVar.c(uVar.f34827c);
        gdVar.w(uVar.f34834w);
        gdVar.xv(uVar.xv);
        gdVar.sr(uVar.sr);
        gdVar.c(uVar.ys);
        gdVar.c(uVar.fp);
        if (i4 != 1) {
            if (i4 == 2 && (uxVar = this.ux) != null) {
                uxVar.c(uVar);
                this.ux.c(gdVar);
                this.ux.c(this.f31657f, gdVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVar = this.sr;
        if (fVar != null) {
            fVar.c(uVar);
            this.sr.c(gdVar);
            this.sr.c(this.f31657f, gdVar);
        }
    }
}
