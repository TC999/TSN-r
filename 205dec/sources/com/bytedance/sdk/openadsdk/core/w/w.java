package com.bytedance.sdk.openadsdk.core.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.w.gd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends sr {
    protected final int sr;
    protected com.bytedance.sdk.openadsdk.core.w.c.xv ux;

    /* renamed from: w  reason: collision with root package name */
    protected final me f35369w;
    protected final String xv;

    public w(Context context, me meVar, String str, int i4) {
        super(context);
        this.f35369w = meVar;
        this.xv = str;
        this.sr = i4;
        xv();
    }

    private void xv() {
        com.bytedance.sdk.openadsdk.core.w.c.xv c4 = this.ev.c(this.f35369w, this.f35365f, this, c());
        this.ux = c4;
        c4.c(this.f35366r);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.xv) c(com.bytedance.sdk.openadsdk.core.w.c.xv.xv.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.sr);
        ((gd) c(gd.class)).c(this.xv);
        ((gd) c(gd.class)).c(this.sr);
        ((com.bytedance.sdk.openadsdk.core.w.c.w.xv) c(com.bytedance.sdk.openadsdk.core.w.c.w.xv.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.w.f) c(com.bytedance.sdk.openadsdk.core.w.c.w.f.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.w.ux) c(com.bytedance.sdk.openadsdk.core.w.c.w.ux.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.w.ux) c(com.bytedance.sdk.openadsdk.core.w.c.w.ux.class)).c(this.sr);
        if (c()) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).sr(true);
            ((gd) c(gd.class)).c(true);
            ((com.bytedance.sdk.openadsdk.core.w.c.w.r) c(com.bytedance.sdk.openadsdk.core.w.c.w.r.class)).c(this);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
        this.f35366r = gdVar;
    }

    protected boolean c() {
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.u.gd w() {
        return this.f35366r;
    }

    public void c(View view) {
        this.f35366r.w(view);
    }

    public void w(View view) {
        this.f35366r.c(view);
    }

    public void c(int i4) {
        this.f35366r.xv(i4);
    }

    public void w(int i4) {
        this.f35366r.w(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.sr
    public void c(View view, com.bytedance.sdk.openadsdk.core.u.gd gdVar) {
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w(((com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).ux());
        ((com.bytedance.sdk.openadsdk.core.w.c.w.ux) c(com.bytedance.sdk.openadsdk.core.w.c.w.ux.class)).w(((com.bytedance.sdk.openadsdk.core.w.c.xv.c) c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).ux());
        this.ux.c(view);
        if (gdVar == null) {
            gdVar = new com.bytedance.sdk.openadsdk.core.u.gd();
        }
        this.ux.c(gdVar);
        this.ux.c();
    }

    public void xv(int i4) {
        this.f35366r.c(i4);
    }
}
