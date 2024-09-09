package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd implements com.bytedance.adsdk.ugeno.w.f, com.bytedance.sdk.component.adexpress.w.gd {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ux.c f34074c;

    /* renamed from: f  reason: collision with root package name */
    private long f34075f;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.bk.ev f34076r;
    private String sr;
    private long ux;

    /* renamed from: w  reason: collision with root package name */
    private String f34077w;
    private me xv;

    public gd(com.bytedance.sdk.openadsdk.ux.c cVar, String str, me meVar, String str2) {
        this.f34074c = cVar;
        this.f34077w = str;
        this.sr = str2;
        this.xv = meVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void a() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "WebView start load");
        com.bytedance.sdk.openadsdk.bk.ev evVar = this.f34076r;
        if (evVar == null) {
            return;
        }
        evVar.r(ls.c(this.xv));
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void bk() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "webview render success");
        this.f34074c.w();
        com.bytedance.sdk.openadsdk.bk.ev evVar = this.f34076r;
        if (evVar == null) {
            return;
        }
        evVar.ev(ls.c(this.xv));
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void ev() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void f() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void f(int i4) {
        final String str;
        this.f34075f = System.currentTimeMillis();
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "dynamic render success render type: " + i4 + "; ****cost time(ms): " + (this.f34075f - this.ux) + "****");
        if (i4 == 3) {
            this.f34074c.xv("dynamic_render2_success");
            str = "dynamic2_render";
        } else {
            this.f34074c.xv("dynamic_render_success");
            str = "dynamic_backup_native_render";
        }
        this.f34074c.c(true);
        com.bytedance.sdk.component.gd.ev.xv(new com.bytedance.sdk.component.gd.p("dynamic_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.gd.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.a.xv.r(gd.this.xv, gd.this.f34077w, str, null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void fp() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "no native render");
        this.f34074c.c(true);
        this.f34074c.bk();
    }

    public void fz() {
        this.f34074c.ys();
        this.f34074c.fp();
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void gd() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void ia() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "render fail");
        this.f34074c.t();
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void k() {
        this.f34074c.c();
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "start render ");
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void p() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void r() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void s() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "render success");
        this.f34074c.w();
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void sr() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void sr(int i4) {
        if (i4 == 3) {
            this.f34074c.w("dynamic_sub_render2_start");
        } else {
            this.f34074c.w("dynamic_sub_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void t() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "native render start");
        this.f34074c.xv();
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void ux() {
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void ux(int i4) {
        if (i4 == 3) {
            this.f34074c.w("dynamic_sub_render2_end");
        } else {
            this.f34074c.w("dynamic_sub_render_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void ys() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "native success");
        this.f34074c.c(true);
        this.f34074c.ux();
        com.bytedance.sdk.component.gd.ev.xv(new com.bytedance.sdk.component.gd.p("native_success") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.gd.2
            @Override // java.lang.Runnable
            public void run() {
                ev.c(gd.this.f34077w, gd.this.sr, gd.this.xv);
                com.bytedance.sdk.openadsdk.core.a.xv.r(gd.this.xv, gd.this.f34077w, "dynamic_backup_render", null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void c(boolean z3) {
        this.f34074c.w(z3 ? 1 : 0);
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "webview start request");
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void w(int i4) {
        if (i4 == 3) {
            this.f34074c.w("dynamic_sub_analysis2_start");
        } else {
            this.f34074c.w("dynamic_sub_analysis_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void xv(int i4) {
        if (i4 == 3) {
            this.f34074c.w("dynamic_sub_analysis2_end");
        } else {
            this.f34074c.w("dynamic_sub_analysis_end");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void c(int i4, String str) {
        this.f34074c.c(i4);
        ev.c(i4, this.f34077w, this.sr, this.xv);
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "WebView render fail");
        com.bytedance.sdk.openadsdk.bk.ev evVar = this.f34076r;
        if (evVar == null) {
            return;
        }
        evVar.c(true, ls.c(this.xv), 105);
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void w() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "ugen parse end");
        this.f34074c.sr("ugen_sub_analysis_end");
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void xv() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "ugen real render start ");
        this.f34074c.sr("ugen_sub_render_start");
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void c(int i4) {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "dynamic start render");
        this.ux = System.currentTimeMillis();
        if (i4 == 3) {
            this.f34074c.c("dynamic_render2_start");
        } else {
            this.f34074c.c("dynamic_render_start");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.gd
    public void c(int i4, int i5, String str, boolean z3) {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "dynamic fail");
        this.f34074c.c(true);
        if (i4 == 3) {
            this.f34074c.w(i5, "dynamic_render2_error");
        } else {
            this.f34074c.w(i5, "dynamic_render_error");
        }
        ev.c(i5, this.f34077w, this.sr, this.xv);
    }

    public void c(com.bytedance.sdk.openadsdk.bk.ev evVar) {
        this.f34076r = evVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void c() {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "ugen parse start");
        this.f34074c.sr("ugen_render_start");
        this.f34074c.sr("ugen_sub_analysis_start");
    }

    @Override // com.bytedance.adsdk.ugeno.w.f
    public void c(com.bytedance.adsdk.ugeno.w.p pVar) {
        com.bytedance.sdk.component.utils.a.w("ExpressRenderEvent", "ugen real render end ");
        if (pVar.a() == 0) {
            this.f34074c.sr("ugen_sub_render_end");
            this.f34074c.ux("ugen_render_success");
        } else {
            this.f34074c.xv(pVar.a(), "ugen_render_error");
        }
        this.f34074c.c(true);
    }
}
