package com.bytedance.sdk.openadsdk.core.component.splash.c.c;

import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.component.splash.p;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.f;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ux;
import com.bytedance.sdk.openadsdk.core.component.splash.xv;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.xv f32860c;
    private r sr = new r();
    private boolean ux = ls.w().up();

    /* renamed from: w  reason: collision with root package name */
    private String f32861w;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w xv;

    public c(com.bytedance.sdk.openadsdk.core.component.splash.xv xvVar) {
        this.f32860c = xvVar;
    }

    public void c(ux uxVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w<f, r> wVar) {
        if (uxVar == null || wVar == null) {
            return;
        }
        this.sr.w(true);
        this.xv = uxVar.sr();
        this.f32861w = uxVar.f();
        if (c()) {
            c(this.f32861w, wVar);
        } else {
            wVar.c(this.sr);
        }
    }

    private boolean c() {
        if (!this.f32860c.c(this.f32861w)) {
            this.sr.xv(0);
            this.sr.w(r.f33016f);
            this.sr.c(r.f33025r);
            return false;
        } else if (this.f32860c.c(this.xv, true)) {
            this.sr.xv(2);
            this.sr.w(r.ev);
            this.sr.c(r.gd);
            return false;
        } else {
            return true;
        }
    }

    private void c(String str, final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w<f, r> wVar) {
        this.f32860c.c(str, new xv.InterfaceC0489xv() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.c.1
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.InterfaceC0489xv
            public void c(f fVar) {
                if (c.this.ux) {
                    c.this.c(fVar, wVar);
                    return;
                }
                if (fVar == null || fVar.w() == null) {
                    if (fVar == null) {
                        c.this.sr.w(r.wo);
                        c.this.sr.c(r.ox);
                        wVar.c(c.this.sr);
                        return;
                    } else if (fVar.w() == null) {
                        c.this.sr.w(r.xu);
                        c.this.sr.c(r.ng);
                        wVar.c(c.this.sr);
                        return;
                    }
                }
                wVar.w(fVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.InterfaceC0489xv
            public void c() {
                c.this.sr.w(r.f33014a);
                c.this.sr.c(r.bk);
                wVar.c(c.this.sr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final f fVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.w<f, r> wVar) {
        if (wVar == null) {
            return;
        }
        if (fVar != null && fVar.w() != null) {
            me w3 = fVar.w();
            ls.c().c(w3.jr(), w3.cf(), new ck.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.c.2
                @Override // com.bytedance.sdk.openadsdk.core.ck.c
                public void c(boolean z3, long j4, long j5) {
                    p.c(c.this.xv, z3, j4, j5);
                    if (z3) {
                        wVar.w(fVar);
                        return;
                    }
                    c.this.sr.w(r.au);
                    c.this.sr.c(r.bj);
                    c.this.sr.c(j4);
                    wVar.c(c.this.sr);
                }
            });
            return;
        }
        this.sr.w(r.f33023p);
        this.sr.c(r.f33020k);
        wVar.c(this.sr);
    }
}
