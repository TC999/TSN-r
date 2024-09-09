package com.bytedance.sdk.openadsdk.core.component.splash.xv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.gd;
import com.bytedance.sdk.openadsdk.core.component.splash.w.c.r;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xv.sr;
import com.bytedance.sdk.openadsdk.core.component.splash.xv.c;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.f;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.ux;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c implements xv.sr, xv.InterfaceC0335xv, c.w, c.InterfaceC0499c {
    private int bw;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f33120m;
    private String pr;
    private com.bytedance.sdk.openadsdk.ys.w.xv.w wx;

    /* renamed from: x  reason: collision with root package name */
    private AtomicBoolean f33121x = new AtomicBoolean(false);
    private NativeExpressView xk;
    private Context yu;

    public w(Context context, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, int i4, com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv xvVar, sr<gd, r> srVar) {
        this.yu = context;
        this.wx = wVar;
        this.pr = str;
        this.bw = i4;
        c((c.w) this);
        c(xvVar, srVar);
    }

    private void fz() {
        if (this.f33094w.fh() == 2) {
            this.xk = new NativeExpressVideoView(true, this.yu, this.f33094w, this.wx, this.pr);
        } else {
            this.xk = new NativeExpressVideoView(false, this.yu, this.f33094w, this.wx, this.pr);
        }
        if (this.xk.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) {
            this.ba = (com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.xk.getVideoController();
        }
        this.xk.setVideoAdListener(this);
        this.xk.setVideoAdInteractionListener(this);
    }

    private void s() {
        if (this.f33094w.fh() == 2) {
            this.xk = new NativeExpressView(true, this.yu, this.f33094w, this.wx, this.pr, true);
        } else {
            this.xk = new NativeExpressView(false, this.yu, this.f33094w, this.wx, this.pr, true);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void B_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void C_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void D_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void E_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void F_() {
        this.f33083i = false;
        com.bytedance.sdk.openadsdk.core.a.xv.w(this.f33092t, this.f33094w);
        com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar = this.ev;
        if (cVar != null) {
            this.f33088p = true;
            cVar.onSplashAdClose(this, 4);
            a();
        }
        ys();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c.w
    public void H_() {
        me meVar = this.f33094w;
        if (meVar == null || this.ia == null) {
            return;
        }
        if (meVar.y() == 2) {
            if (this.f33121x.get()) {
                NativeExpressView nativeExpressView = this.xk;
                if (nativeExpressView != null) {
                    nativeExpressView.ys();
                    if (u.sr(this.f33094w)) {
                        this.ia.put("openPlayableLandingPage", this.xk.i());
                    }
                    ls.c(this.ia, this.f33094w, this.xk);
                }
                this.ia.put("splash_show_type", 3);
            }
        } else if (!this.ck) {
            this.ia.put("splash_show_type", 0);
        } else {
            if (TextUtils.isEmpty(ng.c(this.f33094w))) {
                this.ia.put("splash_show_type", 2);
            }
            this.ia.put("splash_show_type", 1);
        }
        w(this.f33094w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c.w
    public void I_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c.w
    public void J_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c.w
    public void K_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public boolean ba() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void c(long j4, long j5) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public com.bytedance.sdk.openadsdk.core.multipro.w.c eq() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
        xv xvVar = this.ba;
        if (xvVar == null && (nativeExpressView = this.xk) != null) {
            xvVar = nativeExpressView.getVideoController();
        }
        if (xvVar != null) {
            cVar.f33979r = xvVar.k();
            cVar.f33977c = xvVar.u();
            cVar.ev = xvVar.fz();
        }
        return cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c.w
    public void ev() {
    }

    public void ia() {
        NativeExpressView nativeExpressView = this.xk;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.ux(this.bw);
        this.xk.fp();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c, com.bytedance.sdk.openadsdk.core.component.splash.TsView.c
    public void k() {
        super.k();
        NativeExpressView nativeExpressView = this.xk;
        if (nativeExpressView != null) {
            nativeExpressView.a();
        }
        this.xk = null;
        this.f33090r = null;
        this.f33081f = null;
        Map<String, Object> map = this.gd;
        if (map != null) {
            map.clear();
        }
        a();
        ys();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (((c) this).f33080c.getParent() != null) {
            ((ViewGroup) ((c) this).f33080c.getParent()).removeView(((c) this).f33080c);
        }
        viewGroup.addView(((c) this).f33080c);
    }

    public void w(com.bytedance.sdk.openadsdk.core.component.splash.w.c.xv xvVar, sr<gd, r> srVar) {
        this.f33085k = 3;
        c(srVar);
        ia();
    }

    public void c(int i4) {
        this.bw = i4;
    }

    private void c(final sr<gd, r> srVar) {
        if (srVar == null || this.f33094w == null) {
            return;
        }
        if (this.ck) {
            this.fz = true;
            fz();
        } else {
            this.fz = false;
            s();
        }
        this.f33084j.c(this);
        NativeExpressView nativeExpressView = this.xk;
        if (nativeExpressView == null) {
            this.f33084j.w(r.bm);
            this.f33084j.c(r.f33015b);
            srVar.c(this.f33084j);
            return;
        }
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.w.1
            @Override // com.bytedance.sdk.component.adexpress.w.xv
            public boolean c(ViewGroup viewGroup, int i4) {
                try {
                    SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(w.this.yu);
                    w wVar = w.this;
                    splashExpressBackupView.c(wVar.f33087n, wVar.f33094w, (NativeExpressView) viewGroup);
                    if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) {
                        w.this.ba = (com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) splashExpressBackupView.getVideoController();
                    }
                    splashExpressBackupView.setVideoAdListener(w.this);
                    w.this.t();
                    TsView tsView = ((c) w.this).f33080c;
                    if (tsView != null) {
                        tsView.c();
                        return true;
                    }
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        this.f33085k = 3;
        this.xk.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xv.w.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                w wVar = w.this;
                com.bytedance.sdk.openadsdk.core.a.xv.w(wVar.f33092t, wVar.f33094w);
                w wVar2 = w.this;
                com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar = wVar2.ev;
                if (cVar != null) {
                    cVar.onSplashAdClick(wVar2);
                }
                w.this.bk();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, String str, int i4) {
                a.f("splash", "onRenderFail:" + str);
                w.this.f33084j.w(r.wx);
                w.this.f33084j.c(r.pr);
                srVar.c(w.this.f33084j);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                if (view != null && f4 > 0.0f && f5 > 0.0f) {
                    gd gdVar = new gd(w.this.wv.get(), w.this);
                    if (w.this.xk != null && !w.this.xk.fz()) {
                        ((c) w.this).f33080c.setComplianceBarVisibility(8);
                    }
                    gdVar.c(w.this.xk.fz());
                    w.this.ls.set(true);
                    w wVar = w.this;
                    ((c) wVar).f33080c.setExpressView(wVar.xk);
                    w.this.f33121x.set(true);
                    if (w.this.gb.get()) {
                        w wVar2 = w.this;
                        wVar2.xv(wVar2.f33120m);
                        w.this.gb.set(false);
                    }
                    srVar.w(gdVar);
                    return;
                }
                w.this.f33084j.w(r.bw);
                w.this.f33084j.c(r.f33029x);
                srVar.c(w.this.f33084j);
            }
        });
    }

    private void w(me meVar) {
        if (this.xk == null || meVar == null) {
            return;
        }
        Context context = this.yu;
        String str = this.pr;
        f fVar = new f(context, meVar, str, wv.c(str));
        fVar.c(this.xk);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) fVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(this.gd);
        this.xk.setClickListener(fVar);
        Context context2 = this.yu;
        String str2 = this.pr;
        ux uxVar = new ux(context2, meVar, str2, wv.c(str2));
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this);
        uxVar.c(this.xk);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.xv);
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) uxVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(this.gd);
        this.xk.setClickCreativeListener(uxVar);
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.xv;
        if (xvVar != null) {
            xvVar.c(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c, com.bytedance.sdk.openadsdk.ys.w.w.w
    public void c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a.f("splash", "\u5c55\u793a\u5f00\u5c4f\u7684\u5bb9\u5668\u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        this.f33120m = viewGroup;
        if (this.ls.get() && ((c) this).f33080c != null) {
            xv(viewGroup);
        } else {
            this.gb.set(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xv.c, com.bytedance.sdk.openadsdk.ys.w.w.w
    public View c() {
        return ((c) this).f33080c;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void c(int i4, int i5) {
        this.f33083i = false;
    }
}
