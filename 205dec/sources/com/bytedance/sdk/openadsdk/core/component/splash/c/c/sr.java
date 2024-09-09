package com.bytedance.sdk.openadsdk.core.component.splash.c.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.ux;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.ev;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr implements com.bytedance.sdk.openadsdk.core.component.splash.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private r f32866c = new r();

    private void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<ev, r> xvVar) {
        com.bykv.vk.openvk.component.video.api.xv.sr c4;
        if (wVar == null || xvVar == null) {
            return;
        }
        this.f32866c.w(wVar.ys());
        this.f32866c.c(wVar.w());
        int gd = wVar.gd();
        com.bykv.vk.openvk.component.video.api.xv.xv ev = wVar.ev();
        this.f32866c.c(true);
        if (ev == null) {
            this.f32866c.w(r.fp);
            this.f32866c.c(r.ia);
            xvVar.c(this.f32866c);
            return;
        }
        String a4 = ev.a();
        if (TextUtils.isEmpty(a4)) {
            this.f32866c.w(r.f33026s);
            this.f32866c.c(r.fz);
            xvVar.c(this.f32866c);
            return;
        }
        String ys = ev.ys();
        if (TextUtils.isEmpty(ys)) {
            ys = ux.w(a4);
        }
        if (TextUtils.isEmpty(ys)) {
            this.f32866c.w(r.f33028u);
            this.f32866c.c(r.f33018i);
            xvVar.c(this.f32866c);
            return;
        }
        com.bytedance.sdk.openadsdk.core.ux.c.w("Splash_FullLink", "\u52a0\u8f7d\u89c6\u9891\u7d20\u6750");
        me w3 = wVar.w();
        if (w3 == null) {
            return;
        }
        boolean p3 = wVar.p();
        ev.ux(1);
        if (ev.fp() == 0) {
            ev.sr(307200);
        }
        if (p3) {
            c4 = ng.c(2, w3);
        } else {
            c4 = ng.c(3, w3);
        }
        c4.c("material_meta", w3);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.bytedance.sdk.openadsdk.n.ev.c(w3.ou()).c(c4)) {
            ev evVar = new ev(wVar.w(), wVar.ys());
            evVar.c(true);
            evVar.xv(true);
            evVar.c(wVar.c());
            evVar.ux(wVar.xv());
            xvVar.w(evVar);
            c4.gd(1);
            com.bytedance.sdk.openadsdk.core.video.sr.w.c(c4, w3, SystemClock.elapsedRealtime() - elapsedRealtime);
        } else if (ls.w().gd(String.valueOf(gd)) && !ys.sr(ls.getContext())) {
            this.f32866c.w(r.f33024q);
            this.f32866c.c(r.f33019j);
            xvVar.c(this.f32866c);
        } else if (wVar.w() != null && wVar.w().b() == 3) {
            ev evVar2 = new ev(wVar.w(), wVar.ys());
            evVar2.c(true);
            evVar2.xv(false);
            evVar2.c(wVar.c());
            evVar2.ux(wVar.xv());
            evVar2.c(ng.c(wVar.w()));
            xvVar.w(evVar2);
        } else {
            com.bykv.vk.openvk.component.video.c.c.c();
            c(c4, wVar, wVar.w(), xvVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.w.w.c
    public void c(com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<ev, r> xvVar) {
        w(wVar, xvVar);
    }

    private void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.c.w wVar, me meVar, final com.bytedance.sdk.openadsdk.core.component.splash.w.xv.xv<ev, r> xvVar) {
        if (meVar == null || xvVar == null || wVar == null || srVar == null || ng.bk(meVar) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.sr.w.c(srVar, new com.bykv.vk.openvk.component.video.api.ux.w() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.c.sr.1
            @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
            public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar2, int i4) {
                if (xvVar != null) {
                    ev evVar = new ev(wVar.w(), wVar.ys());
                    evVar.c(true);
                    evVar.xv(false);
                    evVar.c((com.bytedance.sdk.component.ev.w) null);
                    evVar.c(wVar.c());
                    evVar.ux(wVar.xv());
                    xvVar.w(evVar);
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.ux.c.InterfaceC0336c
            public void c(com.bykv.vk.openvk.component.video.api.xv.sr srVar2, int i4, String str) {
                if (xvVar != null) {
                    sr.this.f32866c.w(r.ls);
                    sr.this.f32866c.c(r.gb);
                    xvVar.c(sr.this.f32866c);
                }
            }
        });
    }
}
