package com.bytedance.sdk.openadsdk.core.component.splash.w.c;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f33045a;
    private int ev = 1;

    /* renamed from: f  reason: collision with root package name */
    private Context f33046f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private String f33047k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.xv.w f33048p;

    /* renamed from: r  reason: collision with root package name */
    private String f33049r;
    private f sr;
    private ev ux;

    public xv(Context context, String str, f fVar, ev evVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        this.f33046f = context;
        this.f33049r = str;
        this.sr = fVar;
        this.f33045a = fVar.ux();
        this.f33001w = fVar.w();
        this.ux = evVar;
        this.f33048p = wVar;
        if (evVar == null || TextUtils.isEmpty(evVar.a())) {
            return;
        }
        this.f33047k = evVar.a();
    }

    public int ev() {
        return this.gd;
    }

    public String f() {
        return this.f33049r;
    }

    public boolean gd() {
        return this.f33045a;
    }

    public Context getContext() {
        return this.f33046f;
    }

    public com.bytedance.sdk.openadsdk.ys.w.xv.w r() {
        return this.f33048p;
    }

    public f sr() {
        return this.sr;
    }

    public ev ux() {
        return this.ux;
    }
}
