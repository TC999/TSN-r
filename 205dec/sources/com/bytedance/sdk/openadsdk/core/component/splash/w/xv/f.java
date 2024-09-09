package com.bytedance.sdk.openadsdk.core.component.splash.w.xv;

import com.bytedance.sdk.openadsdk.core.component.splash.p;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.w.c f33052c;
    private com.bytedance.sdk.openadsdk.core.component.splash.xv sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.w.c.w f33053w;
    private xv<ev, r> xv;

    public f(com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, xv<ev, r> xvVar, com.bytedance.sdk.openadsdk.core.component.splash.xv xvVar2) {
        if (wVar == null || xvVar == null) {
            return;
        }
        this.f33053w = wVar;
        this.xv = xvVar;
        if (wVar.k() == 1) {
            this.f33052c = new com.bytedance.sdk.openadsdk.core.component.splash.c.c.w();
        } else {
            this.f33052c = new com.bytedance.sdk.openadsdk.core.component.splash.c.c.sr();
        }
        this.sr = xvVar2;
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar = this.f33053w;
        if (wVar == null || this.xv == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.w.w.c cVar = this.f33052c;
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.component.splash.c.c.w) {
            cVar.c(wVar, new xv<ev, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f.1
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                /* renamed from: c */
                public void xv(ev evVar) {
                    if (evVar != null) {
                        evVar.ux(false);
                    }
                    f.this.xv.xv(evVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                public void w(ev evVar) {
                    if (evVar != null) {
                        evVar.ux(true);
                    }
                    f.this.xv.w(evVar);
                    p.c(f.this.sr, f.this.f33053w.bk());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                public void c(r rVar) {
                    f.this.xv.c(rVar);
                }
            });
        } else {
            cVar.c(wVar, new xv<ev, r>() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.w.xv.f.2
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                /* renamed from: c */
                public void xv(ev evVar) {
                    if (evVar != null) {
                        evVar.ux(false);
                    }
                    f.this.xv.xv(evVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                public void w(ev evVar) {
                    if (evVar != null) {
                        evVar.ux(true);
                    }
                    f.this.xv.w(evVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv
                public void c(r rVar) {
                    if (f.this.f33053w.t() && f.this.f33053w.w() != null) {
                        f.this.f33053w.w().ev(1);
                    }
                    new com.bytedance.sdk.openadsdk.core.component.splash.c.c.w().c(f.this.f33053w, f.this.xv);
                }
            });
        }
    }
}
