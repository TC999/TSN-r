package com.bytedance.sdk.openadsdk.core.component.splash.c.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.component.ux.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.eq.fp;
import com.bytedance.sdk.openadsdk.core.eq.ys;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements com.bytedance.sdk.openadsdk.core.component.splash.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private r f32869c = new r();

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f32870w = new AtomicBoolean(false);

    private void w(final com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<ev, r> xvVar) {
        if (wVar == null || xvVar == null) {
            return;
        }
        this.f32869c.w(wVar.ys());
        this.f32869c.c(wVar.w());
        if (ls.w().gd(wVar.gd()) == 4) {
            ev evVar = new ev(wVar.w(), wVar.ys());
            evVar.c(false);
            evVar.c(wVar.c());
            evVar.c(wVar.xv());
            xvVar.w(evVar);
            return;
        }
        com.bytedance.sdk.openadsdk.a.w ux = wVar.ux();
        if (ux == null) {
            this.f32869c.w(r.f33021m);
            this.f32869c.c(r.gw);
            this.f32869c.c(false);
            xvVar.c(this.f32869c);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u52a0\u8f7d\u56fe\u7247\u7d20\u6750 " + wVar.w().xq());
        final int f4 = wVar.f();
        int r3 = wVar.r();
        final String a4 = wVar.a();
        fp.c(ux, f4, r3, new fp.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.w.1
            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar2, k kVar) {
                ev evVar2 = new ev(wVar2, wVar.w(), wVar.ys());
                evVar2.c(false);
                evVar2.c(wVar.c());
                evVar2.ux(wVar.xv());
                if (kVar != null) {
                    evVar2.c(kVar.r());
                    evVar2.w(kVar.gd());
                    evVar2.w(ys.c(kVar.r()));
                    if (kVar.p() != null) {
                        evVar2.w(kVar.p().w());
                        evVar2.xv(kVar.p().c());
                        evVar2.sr(kVar.p().xv());
                    }
                }
                xvVar.w(evVar2);
                w.this.c(a4, f4, evVar2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c() {
                w.this.f32869c.w(r.f33027t);
                w.this.f32869c.c(r.ys);
                w.this.f32869c.c(false);
                xvVar.c(w.this.f32869c);
            }
        }, com.bytedance.sdk.openadsdk.n.ev.ux(), 4, new t() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.w.2
            @Override // com.bytedance.sdk.component.ux.t
            @ATSMethod(1)
            public void c(int i4, Object obj) {
                if (i4 == 3 && w.this.c(wVar)) {
                    ev evVar2 = new ev(wVar.w(), wVar.ys());
                    evVar2.c(false);
                    evVar2.c(wVar.c());
                    evVar2.c(wVar.xv());
                    evVar2.sr(true);
                    evVar2.w(false);
                    xvVar.xv(evVar2);
                }
            }
        }, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.c
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<ev, r> xvVar) {
        w(wVar, xvVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar) {
        me w3;
        return (wVar == null || (w3 = wVar.w()) == null || w3.ox() != 3) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i4, final ev evVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fp.c(new com.bytedance.sdk.openadsdk.a.w(str, ""), i4, i4, new fp.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.w.3
            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void c(com.bytedance.sdk.openadsdk.core.q.c.w wVar, k kVar) {
                if (wVar.sr()) {
                    evVar.c(wVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.fp.c
            public void w() {
            }
        }, com.bytedance.sdk.openadsdk.n.ev.ux());
    }
}
