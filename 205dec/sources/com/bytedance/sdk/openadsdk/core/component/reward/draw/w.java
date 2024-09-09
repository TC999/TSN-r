package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.ux.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.eq.n;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ux;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.video.w.c;
import com.bytedance.sdk.openadsdk.core.ys.c;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private long f32290a;
    private final AtomicBoolean bk = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    protected final TTBaseVideoActivity f32291c;
    private com.bytedance.sdk.openadsdk.core.w.c ev;

    /* renamed from: f  reason: collision with root package name */
    private f f32292f;
    private com.bytedance.sdk.openadsdk.core.p.w.xv gd;

    /* renamed from: k  reason: collision with root package name */
    private boolean f32293k;

    /* renamed from: p  reason: collision with root package name */
    private ViewGroup f32294p;

    /* renamed from: r  reason: collision with root package name */
    private ux f32295r;
    public boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f32296t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    protected final me f32297w;
    protected final String xv;
    private boolean ys;

    public w(final TTBaseVideoActivity tTBaseVideoActivity, me meVar, String str, boolean z3, boolean z4) {
        this.gd = null;
        this.f32291c = tTBaseVideoActivity;
        this.f32297w = meVar;
        this.xv = str;
        this.f32296t = z3;
        this.ys = z4;
        f fVar = new f(tTBaseVideoActivity, meVar, str, wv.c(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.w.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.f, com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, gd gdVar) {
                super.c(view, gdVar);
                tTBaseVideoActivity.c(2);
            }
        };
        this.f32292f = fVar;
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(tTBaseVideoActivity.gw());
        ux uxVar = new ux(tTBaseVideoActivity, meVar, str, wv.c(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.w.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ux, com.bytedance.sdk.openadsdk.core.w.w, com.bytedance.sdk.openadsdk.core.w.sr
            public void c(View view, gd gdVar) {
                super.c(view, gdVar);
                com.bytedance.sdk.openadsdk.core.w.c.w wVar = (com.bytedance.sdk.openadsdk.core.w.c.w) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.w.class);
                if (wVar == null || !wVar.w(view)) {
                    return;
                }
                tTBaseVideoActivity.c(2);
            }
        };
        this.f32295r = uxVar;
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(tTBaseVideoActivity.gw());
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(tTBaseVideoActivity, meVar, str, 7);
        this.ev = cVar;
        tTBaseVideoActivity.c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(tTBaseVideoActivity.gw());
        if (meVar.v() == 4) {
            this.gd = com.bytedance.sdk.openadsdk.core.p.xv.c(tTBaseVideoActivity, meVar, str);
            final String jr = c().jr();
            this.gd.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.w.3
                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c() {
                    c.C0525c.c(jr, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void w(long j4, long j5, String str2, String str3) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void xv(long j4, long j5, String str2, String str3) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, long j5, String str2, String str3) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 3, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, String str2, String str3) {
                    c.C0525c.c(jr, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(String str2, String str3) {
                    c.C0525c.c(jr, 6, 100);
                }
            });
        }
    }

    public long a() {
        return this.f32290a;
    }

    public void ev() {
        xk.c((View) this.f32294p, 0);
        this.f32291c.s();
    }

    public boolean f() {
        return this.sr;
    }

    public void gd() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.gd;
        if (xvVar != null) {
            xvVar.f();
        }
    }

    public com.bykv.vk.openvk.component.video.api.xv.sr k() {
        com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(1, this.f32297w);
        c4.w(this.f32297w.jr());
        c4.w(100);
        c4.xv(100);
        c4.xv(this.f32297w.cf());
        c4.w(this.sr);
        return c4;
    }

    public void p() {
        if (this.f32296t) {
            this.f32291c.c(this.f32297w, this.ev);
        }
    }

    public void r() {
        if (Build.VERSION.SDK_INT < 23 || this.ys) {
            return;
        }
        this.ys = true;
        com.bytedance.sdk.openadsdk.ys.w.xv.w c4 = n.c(7);
        if (ng.bk(this.f32297w) != null) {
            com.bykv.vk.openvk.component.video.api.xv.sr c5 = ng.c(1, this.f32297w);
            c5.c("material_meta", this.f32297w);
            c5.c("ad_slot", Integer.valueOf(c4 != null ? c4.q() : 0));
            com.bytedance.sdk.openadsdk.core.video.sr.w.c(c5, (c.InterfaceC0336c) null);
        }
    }

    public int sr() {
        if (this.f32293k) {
            int w3 = pr.w(this.f32297w) - this.ux;
            this.ux = pr.w(this.f32297w);
            return w3;
        } else if (this.ux < pr.w(this.f32297w)) {
            this.ux++;
            return 1;
        } else {
            return 0;
        }
    }

    public c.InterfaceC0520c ux() {
        return new c.InterfaceC0520c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.w.4
            @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
            public void c() {
                w.this.f32293k = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
            public void w() {
                w.this.ev();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
            public void xv() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
            public void c(int i4, String str) {
                w.this.ev();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
            public void c(long j4, long j5) {
                xk.c((View) w.this.f32294p, 8);
                w.this.f32290a = j4;
            }
        };
    }

    public String w() {
        return this.xv;
    }

    public com.bytedance.sdk.openadsdk.core.w.c xv() {
        return this.ev;
    }

    public void w(boolean z3) {
        this.f32297w.p(z3);
    }

    public me c() {
        return this.f32297w;
    }

    public void c(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.f32294p = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || c() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.gd;
        if (xvVar != null) {
            xvVar.sr();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.gd.c((Activity) fullRewardExpressView.getContext());
            }
        }
        this.f32292f.c(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.f32292f.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.gd);
        fullRewardExpressView.setClickListener(this.f32292f);
        this.f32295r.c(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.f32295r.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.gd);
        fullRewardExpressView.setClickCreativeListener(this.f32295r);
        this.ev.c(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.ev.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.gd);
        r();
        ImageView imageView = new ImageView(this.f32291c);
        com.bytedance.sdk.openadsdk.r.w.c(this.f32297w.nc().get(0)).c(imageView);
        this.f32294p.addView(imageView);
    }

    public void c(boolean z3) {
        this.sr = z3;
    }

    public void c(NativeExpressView nativeExpressView) {
        if (this.bk.getAndSet(true)) {
            return;
        }
        Map<String, Object> gw = this.f32291c.gw();
        ls.c(gw, this.f32297w, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.a.xv.c(this.f32297w, this.xv, gw, this.f32291c.vc());
    }
}
